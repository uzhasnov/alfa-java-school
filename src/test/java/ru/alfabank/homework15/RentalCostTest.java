package ru.alfabank.homework15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RentalCostTest {

    private RentalService service;

    @BeforeEach
    void setUp() {
        service = new RentalService();
    }

    @ParameterizedTest(name = "Для игры с ценой {0} за {1} дн. стоимость должна быть {2}")
    @CsvSource({
            "300, 1, 300",
            "300, 3, 900",
            "300, 10, 3000"
    })
    @DisplayName("Параметризованный расчет стоимости аренды")
    void shouldCalculateCostForDifferentDays(int dailyCost, int days, int expectedTotalCost) {
        BoardGame game = new BoardGame("Тестовая Игра", 6, dailyCost);
        service.addGame(game);

        int actualCost = service.calculateCost("Тестовая Игра", days);

        Assertions.assertEquals(expectedTotalCost, actualCost, "Расчет стоимости аренды не совпадает");
    }

    @Test
    @DisplayName("Метод calculateCost должен выбрасывать исключение, если игра не найдена")
    void shouldThrowExceptionWhenCalculatingCostForNonExistentGame() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.calculateCost("Шахматы", 3);
        }, "Ожидалось исключение, так как игра отсутствует");
    }

    @Test
    @DisplayName("Метод calculateCost должен выбрасывать исключение, если количество дней меньше или равно 0")
    void shouldThrowExceptionWhenDaysAreZeroOrNegative() {
        BoardGame game = new BoardGame("Монополия", 6, 300);
        service.addGame(game);

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.calculateCost("Монополия", 0);
        }, "Ожидалось исключение для 0 дней аренды");

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.calculateCost("Монополия", -2);
        }, "Ожидалось исключение для отрицательного количества дней аренды");
    }
}
