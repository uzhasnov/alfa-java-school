package ru.alfabank.homework17;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.*;
import ru.alfabank.homework17.models.Usuario;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ServeRestTest {

    private static String userId;
    private static String userEmail;
    private static String authToken;

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "https://serverest.dev";
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    @Order(0)
    void shouldGetAllUsers() {
         given()
         .when()
                .get("/usuarios")
         .then()
                 .statusCode(200)
                 .contentType(ContentType.JSON)
                 .body("quantidade", greaterThan(0))
                 .body("usuarios", not(empty()));
    }

    @Test
    @Order(1)
    void shouldFindUserByEmail() {
        String firstUserEmail =
                given()
                .when()
                    .get("/usuarios")
                .then()
                    .extract()
                    .path("usuarios[0].email");

        given()
            .queryParam("email", firstUserEmail)
        .when()
            .get("/usuarios")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("quantidade", is(1))
            .body("usuarios[0].email", equalTo(firstUserEmail));
    }

    @Test
    @Order(2)
    void shouldCreateNewUser() {
        userEmail = "spy_" + System.currentTimeMillis() + "@qa.com";

        String requestBody = """
                {
                  "nome": "Тайный Покупатель",
                  "email": "%s",
                  "password": "secret123",
                  "administrador": "true"
                }
                """.formatted(userEmail);

        userId = given()
                    .contentType(ContentType.JSON)
                    .body(requestBody)
                .when()
                    .post("/usuarios")
                .then()
                    .statusCode(201)
                    .contentType(ContentType.JSON)
                    .body("message", equalTo("Cadastro realizado com sucesso"))
                    .body("_id", not(emptyOrNullString()))
                    .extract()
                    .path("_id");
    }

    @Test
    @Order(3)
    void shouldUpdateUser() {
        Assertions.assertNotNull(userId, "userId не должен быть null. Запустите сначала тест создания пользователя.");

        userEmail = "spy_updated_" + System.currentTimeMillis() + "@qa.com";

        String requestBody = """
                {
                  "nome": "Обновлённый Покупатель",
                  "email": "%s",
                  "password": "secret123",
                  "administrador": "false"
                }
                """.formatted(userEmail);

        given()
            .contentType(ContentType.JSON)
            .pathParam("id", userId)
            .body(requestBody)
        .when()
            .put("/usuarios/{id}")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("message", equalTo("Registro alterado com sucesso"));
    }

    @Test
    @Order(4)
    void shouldLogin() {
        Assertions.assertNotNull(userEmail, "userEmail не должен быть null. Запустите сначала тест создания пользователя.");

        String loginBody = """
                {
                  "email": "%s",
                  "password": "secret123"
                }
                """.formatted(userEmail);

        authToken =
                given()
                    .contentType(ContentType.JSON)
                    .body(loginBody)
                .when()
                    .post("/login")
                .then()
                    .statusCode(200)
                    .contentType(ContentType.JSON)
                    .body("message", equalTo("Login realizado com sucesso"))
                    .body("authorization", not(emptyOrNullString()))
                    .extract()
                    .path("authorization");
    }

    @Test
    @Order(5)
    void shouldDeleteUser() {
        Assertions.assertNotNull(userId, "userId не должен быть null.");
        Assertions.assertNotNull(authToken, "authToken не должен быть null.");

        given()
            .header("Authorization", authToken)
            .pathParam("id", userId)
        .when()
            .delete("/usuarios/{id}")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("message", equalTo("Registro excluído com sucesso"));

        given()
            .pathParam("id", userId)
        .when()
            .get("/usuarios/{id}")
        .then()
            .statusCode(400)
            .contentType(ContentType.JSON)
            .body("message", equalTo("Usuário não encontrado"));
    }

    @Test
    void shouldGetAllProducts() {
        String realProductName =
                given()
                .when()
                    .get("/produtos")
                .then()
                    .extract()
                    .path("produtos[0].nome");


        given()
        .when()
            .get("/produtos")
        .then()
            .statusCode(200)
            .contentType(ContentType.JSON)
            .body("quantidade", greaterThan(0))
            .body("produtos.preco", everyItem(greaterThan(0)))
            .body("produtos.nome", everyItem(not(emptyOrNullString())))
            .body("produtos.nome", hasItem(realProductName));
    }

    @Test
    void shouldCreateUserFromDto() {
        String dtoEmail = "dto_spy_" + System.currentTimeMillis() + "@qa.com";

        Usuario newUser = new Usuario(
                "Тайный Покупатель DTO",
                dtoEmail,
                "secret123",
                "true"
        );

        userId =
                given()
                    .contentType(io.restassured.http.ContentType.JSON)
                    .body(newUser)
                .when()
                    .post("/usuarios")
                .then()
                    .statusCode(201)
                    .contentType(io.restassured.http.ContentType.JSON)
                    .body("message", equalTo("Cadastro realizado com sucesso"))
                    .body("_id", not(emptyOrNullString()))
                    .extract()
                    .path("_id");

        userEmail = dtoEmail;
    }
}
