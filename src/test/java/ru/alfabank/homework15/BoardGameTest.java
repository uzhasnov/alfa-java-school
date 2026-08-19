package ru.alfabank.homework15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты для BoardGame")
public class BoardGameTest {

    static BoardGame game;

    @BeforeAll
    static void setup() {
        game = new BoardGame("Монополия", 6, 300);
    }

    @Test
    @DisplayName("Настольная игра имеет ожидаемое название после инициализации")
    void shouldBeInitializedWithExpectedName() {
        String expectedResult = "Монополия";
        String actualResult = game.getName();
        String assertErrorMessage = "Название настольной игры не совпадает с ожидаемым";

        Assertions.assertEquals(expectedResult, actualResult, assertErrorMessage);
    }

    @Test
    @DisplayName("Настольная игра имеет ожидаемый минимальный возраст после инициализации")
    void shouldBeInitializedWithExpectedMinimalAge() {
        int expectedResult = 6;
        int actualResult = game.getMinimalAge();
        String assertErrorMessage = "Минимальный возраст не совпадает с ожидаемым";

        Assertions.assertEquals(expectedResult, actualResult, assertErrorMessage);
    }

    @Test
    @DisplayName("Настольная игра имеет ожидаемую стоимость аренды после инициализации")
    void shouldBeInitializedWithExpectedDailyRentalCost() {
        int expectedResult = 300;
        int actualResult = game.getDailyRentCost();
        String assertErrorMessage = "Стоимость аренды за день не совпадает с ожидаемой";

                Assertions.assertEquals(expectedResult, actualResult, assertErrorMessage);
    }

    @Test
    @DisplayName("Настольная игра доступна для аренды после инициализации")
    void shouldBeAvailableForRentAfterInitialization() {
        boolean expectedResult = false;
        boolean actualResult = game.isRented();
        String assertErrorMessage = "Игра не доступна для аренды после инициализации";

        Assertions.assertEquals(expectedResult, actualResult, assertErrorMessage);
    }

    @Test
    @DisplayName("Настольная игра может быть арендована, если возраст подходит")
    void canBeRentedByOldEnoughPerson() {
        boolean expectedResult = true;
        boolean actualResult = game.canBeRentedBy(7);
        String assertErrorMessage = "Настольная игра не может быть арендована клиентом с подходящим возрастом";

        Assertions.assertEquals(expectedResult, actualResult, assertErrorMessage);
    }

    @Test
    @DisplayName("Настольная игра не может быть арендована, если возраст не подходит")
    void cantBeRentedByNotOldEnoughPerson() {
        boolean expectedResult = false;
        boolean actualResult = game.canBeRentedBy(5);
        String assertErrorMessage = "Настольная игра может быть арендована клиентом с неподходящим возрастом";

        Assertions.assertEquals(expectedResult, actualResult, assertErrorMessage);
    }

    @Test
    @DisplayName("Должно выбрасываться исключение для null названия настольной игры")
    void shouldThrowExpectedExceptionForNullName() {
        IllegalArgumentException expectedException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new BoardGame(null, 0, 0));
        String expectedExceptionMessage = "Название не может иметь значение null";
        String actualExceptionMessage = expectedException.getMessage();
        String assertErrorMessage = "Сообщение, генерируемое исключением не соответствует ожидаемому";

        Assertions.assertEquals(IllegalArgumentException.class, expectedException.getClass());
        Assertions.assertEquals(expectedExceptionMessage, actualExceptionMessage, assertErrorMessage);
    }

    @Test
    @DisplayName("Должно выбрасываться исключение для пустого названия настольной игры")
    void shouldThrowExpectedExceptionForEmptyName() {
        IllegalArgumentException expectedException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new BoardGame("", 0, 0));
        String expectedExceptionMessage = "Название не может быть пустым";
        String actualExceptionMessage = expectedException.getMessage();
        String assertErrorMessage = "Сообщение, генерируемое исключением не соответствует ожидаемому";

        Assertions.assertEquals(IllegalArgumentException.class, expectedException.getClass());
        Assertions.assertEquals(expectedExceptionMessage, actualExceptionMessage, assertErrorMessage);
    }

    @Test
    @DisplayName("Должно выбрасываться исключение для отрицательного минимального возраста")
    void shouldThrowExpectedExceptionForInvalidAge() {
        IllegalArgumentException expectedException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new BoardGame("Монополия", -1, 0));
        String expectedExceptionMessage = "Возраст не должен быть отрицательным";
        String actualExceptionMessage = expectedException.getMessage();
        String assertErrorMessage = "Сообщение, генерируемое исключением не соответствует ожидаемому";

        Assertions.assertEquals(IllegalArgumentException.class, expectedException.getClass());
        Assertions.assertEquals(expectedExceptionMessage, actualExceptionMessage, assertErrorMessage);
    }

    @Test
    @DisplayName("Должно выбрасываться исключение для стоимости аренды меньшей или равной 0")
    void shouldThrowExpectedExceptionForInvalidRentalPrice() {
        IllegalArgumentException expectedException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new BoardGame("Монополия", 10, 0));
        String expectedExceptionMessage = "Стоимость аренды должна быть положительной";
        String actualExceptionMessage = expectedException.getMessage();
        String assertErrorMessage = "Сообщение, генерируемое исключением не соответствует ожидаемому";

        Assertions.assertEquals(IllegalArgumentException.class, expectedException.getClass());
        Assertions.assertEquals(expectedExceptionMessage, actualExceptionMessage, assertErrorMessage);
    }
}
