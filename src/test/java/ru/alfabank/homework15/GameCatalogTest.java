package ru.alfabank.homework15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты на работу с каталогом (добавление, поиск, проверка дубликатов)")
public class GameCatalogTest {

    private RentalService service;

    @BeforeEach
    void setUp() {
        service = new RentalService();
    }

    @Test
    @DisplayName("Метод addGame должен выбрасывать исключение, если передана игра со значением null")
    void shouldThrowExceptionWhenAddingNullGame() {
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> service.addGame(null)
        );

        Assertions.assertEquals("Игра не может быть null", exception.getMessage());
    }

    @Test
    @DisplayName("Метод addGame должен выбрасывать исключение при попытке добавить игру с дублирующимся названием")
    void shouldThrowExceptionWhenAddingDuplicateGameName() {
        BoardGame originalGame = new BoardGame("Монополия", 6, 300);
        BoardGame duplicateGame = new BoardGame("монополия", 12, 500);

        service.addGame(originalGame);

        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> service.addGame(duplicateGame),
                "Ожидалось исключение, так как игра с таким названием уже зарегистрирована"
        );

        Assertions.assertEquals("Игра с таким названием уже существует в пункте проката", exception.getMessage());
    }

    @Test
    @DisplayName("Метод findGameByName должен возвращать объект игры, если она найдена (без учета регистра)")
    void shouldReturnBoardGameWhenFoundByName() {
        BoardGame expectedGame = new BoardGame("Мафия", 12, 200);
        service.addGame(expectedGame);

        BoardGame actualGame = service.findGameByName("мафия");

        Assertions.assertNotNull(actualGame, "Игра должна быть найдена");
        Assertions.assertEquals(expectedGame, actualGame, "Должна вернуться именно та игра, которую искали");
    }

    @Test
    @DisplayName("Метод findGameByName должен возвращать null, если игра с таким названием отсутствует")
    void shouldReturnNullWhenGameNotFoundByName() {
        service.addGame(new BoardGame("Мафия", 12, 200));

        BoardGame actualGame = service.findGameByName("Шахматы");

        Assertions.assertNull(actualGame, "Метод должен вернуть null, если игра не найдена");
    }
}
