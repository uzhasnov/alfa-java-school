package ru.alfabank.homework15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

@DisplayName("Тесты на иренду и возврат настольных игр")
public class GameRentalTest {

    private RentalService service;

    @BeforeEach
    void setUp() {
        service = new RentalService();
    }

    static Stream<Arguments> provideAgesForRentTest() {
        return Stream.of(
                Arguments.of(11, false),
                Arguments.of(12, true),
                Arguments.of(15, true)
        );
    }

    @Test
    @DisplayName("Метод rentGame должен выбрасывать исключение, если игра отсутствует в каталоге")
    void shouldThrowExceptionWhenGameNotFound() {
        RentalService service = new RentalService();

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> service.rentGame("Шахматы", 20),
                "Ожидалось исключение, так как игра не найдена");
    }

    @ParameterizedTest(name = "Клиент возраста {0} лет пытается арендовать игру 12+. Ожидаемый результат: {1}")
    @MethodSource("provideAgesForRentTest")
    @DisplayName("Параметризованная проверка возраста при аренде игры")
    void shouldCheckAgeRestrictionsOnRent(int customerAge, boolean expectedResult) {
        BoardGame game = new BoardGame("Мафия", 12, 200);
        service.addGame(game);

        boolean actualResult = service.rentGame("Мафия", customerAge);

        Assertions.assertEquals(expectedResult, actualResult, "Результат проверки возраста не совпадает с ожидаемым");
    }

    @Test
    @DisplayName("Метод rentGame должен возвращать false, если игра уже кем-то арендована")
    void shouldReturnFalseWhenGameIsAlreadyRented() {
        BoardGame game = new BoardGame("Монополия", 6, 300);
        service.addGame(game);

        game.setRented(true);

        boolean result = service.rentGame("Монополия", 20);

        Assertions.assertFalse(result, "Нельзя арендовать уже занятую игру");
    }

    @Test
    @DisplayName("Метод returnGame должен возвращать false, если игра отсутствует в пункте проката")
    void shouldReturnFalseWhenReturningNonExistentGame() {
        boolean result = service.returnGame("Шахматы");

        Assertions.assertFalse(result, "Метод должен вернуть false, если такой игры вообще нет");
    }

    @Test
    @DisplayName("Метод returnGame должен возвращать false, если игра не была предварительно арендована")
    void shouldReturnFalseWhenReturningNotRentedGame() {
        BoardGame game = new BoardGame("Монополия", 6, 300);
        service.addGame(game);

        boolean result = service.returnGame("Монополия");

        Assertions.assertFalse(result, "Метод должен вернуть false, если игра и так находится в прокате");
    }

    @Test
    @DisplayName("Метод returnGame должен менять статус игры на доступна и возвращать true при успешном возврате")
    void shouldReturnTrueAndResetStatusWhenReturnIsSuccessful() {
        BoardGame game = new BoardGame("Монополия", 6, 300);
        service.addGame(game);

        service.rentGame("Монополия", 20);

        boolean result = service.returnGame("Монополия");

        Assertions.assertTrue(result, "Метод должен вернуть true при успешном возврате");
        Assertions.assertFalse(game.isRented(), "Флаг isRented у игры должен снова стать false");
    }

    @Test
    @DisplayName("Метод reset должен переводить все арендованные игры в статус доступных")
    void shouldMakeAllRentedGamesAvailableAfterReset() {
        BoardGame game1 = new BoardGame("Монополия", 6, 300);
        BoardGame game2 = new BoardGame("Каркассон", 7, 250);

        service.addGame(game1);
        service.addGame(game2);

        service.rentGame("Монополия", 20);
        service.rentGame("Каркассон", 20);

        service.reset();

        Assertions.assertFalse(game1.isRented(), "Игра 'Монополия' должна стать доступной");
        Assertions.assertFalse(game2.isRented(), "Игра 'Каркассон' должна стать доступной");
    }

    @Test
    @DisplayName("Метод reset не должен вызывать ошибок, если в каталоге нет игр или они не арендованы")
    void shouldNotThrowExceptionWhenInventoryIsEmptyOrNoGamesRented() {
        Assertions.assertDoesNotThrow(service::reset,
                "Метод reset на пустом каталоге не должен выбрасывать исключений");

        BoardGame game = new BoardGame("Шахматы", 6, 100);
        service.addGame(game);

        Assertions.assertFalse(game.isRented(), "Статус свободной игры не должен измениться");
    }
}
