package ru.alfabank.homework15;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RentalCostTest {

    @Test
    @DisplayName("Метод calculateCost должен корректно рассчитывать стоимость аренды")
    void shouldCalculateRentalCostCorrectly() {
        // Arrange
        RentalService service = new RentalService();
        BoardGame game = new BoardGame("Монополия", 6, 300);
        service.addGame(game);

        // Act — рассчитываем стоимость за 5 дней (300 * 5 = 1500)
        int cost = service.calculateCost("Монополия", 5);

        // Assert
        Assertions.assertEquals(1500, cost, "Стоимость аренды рассчитана неверно");
    }

    @Test
    @DisplayName("Метод calculateCost должен выбрасывать исключение, если игра не найдена")
    void shouldThrowExceptionWhenCalculatingCostForNonExistentGame() {
        RentalService service = new RentalService();

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.calculateCost("Шахматы", 3);
        }, "Ожидалось исключение, так как игра отсутствует");
    }

    @Test
    @DisplayName("Метод calculateCost должен выбрасывать исключение, если количество дней меньше или равно 0")
    void shouldThrowExceptionWhenDaysAreZeroOrNegative() {
        // Arrange
        RentalService service = new RentalService();
        BoardGame game = new BoardGame("Монополия", 6, 300);
        service.addGame(game);

        // Act & Assert для 0 дней
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.calculateCost("Монополия", 0);
        }, "Ожидалось исключение для 0 дней аренды");

        // Act & Assert для отрицательных дней
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.calculateCost("Монополия", -2);
        }, "Ожидалось исключение для отрицательного количества дней аренды");
    }
}
