package ru.alfabank.homework15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Тесты на иренду и возврат настольных игр")
public class GameRentalTest {

    @Test
    @DisplayName("Метод rentGame должен выбрасывать исключение, если игра отсутствует в каталоге")
    void shouldThrowExceptionWhenGameNotFound() {
        RentalService service = new RentalService();

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> service.rentGame("Шахматы", 20),
                "Ожидалось исключение, так как игра не найдена");
    }

    @Test
    @DisplayName("Метод rentGame должен возвращать false, если возраст клиента меньше минимального")
    void shouldReturnFalseWhenCustomerIsTooYoung() {
        RentalService service = new RentalService();
        BoardGame adultGame = new BoardGame("Ужас Аркхэма", 14, 500);
        service.addGame(adultGame);

        boolean result = service.rentGame("Ужас Аркхэма", 10);

        Assertions.assertFalse(result, "Игра не должна сдаваться в аренду слишком юному клиенту");
    }

    @Test
    @DisplayName("Метод rentGame должен возвращать false, если игра уже кем-то арендована")
    void shouldReturnFalseWhenGameIsAlreadyRented() {
        RentalService service = new RentalService();
        BoardGame game = new BoardGame("Монополия", 6, 300);
        service.addGame(game);

        game.setRented(true);

        boolean result = service.rentGame("Монополия", 20);

        Assertions.assertFalse(result, "Нельзя арендовать уже занятую игру");
    }

    @Test
    @DisplayName("Метод returnGame должен возвращать false, если игра отсутствует в пункте проката")
    void shouldReturnFalseWhenReturningNonExistentGame() {
        RentalService service = new RentalService();

        boolean result = service.returnGame("Шахматы");

        Assertions.assertFalse(result, "Метод должен вернуть false, если такой игры вообще нет");
    }

    @Test
    @DisplayName("Метод returnGame должен возвращать false, если игра не была предварительно арендована")
    void shouldReturnFalseWhenReturningNotRentedGame() {
        RentalService service = new RentalService();
        BoardGame game = new BoardGame("Монополия", 6, 300);
        service.addGame(game);

        boolean result = service.returnGame("Монополия");

        Assertions.assertFalse(result, "Метод должен вернуть false, если игра и так находится в прокате");
    }

    @Test
    @DisplayName("Метод returnGame должен менять статус игры на доступна и возвращать true при успешном возврате")
    void shouldReturnTrueAndResetStatusWhenReturnIsSuccessful() {
        RentalService service = new RentalService();
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
        RentalService service = new RentalService();
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

        RentalService service = new RentalService();

        Assertions.assertDoesNotThrow(service::reset,
                "Метод reset на пустом каталоге не должен выбрасывать исключений");

        BoardGame game = new BoardGame("Шахматы", 6, 100);
        service.addGame(game);

        Assertions.assertFalse(game.isRented(), "Статус свободной игры не должен измениться");
    }
}
