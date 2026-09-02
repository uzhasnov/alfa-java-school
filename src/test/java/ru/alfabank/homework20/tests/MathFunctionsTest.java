package ru.alfabank.homework20.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.alfabank.homework20.steps.CalculatorSteps;

@Epic("Калькулятор")
@Feature("Математические функции")
public class MathFunctionsTest {

    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @Story("Возведение в степень")
    @Severity(SeverityLevel.NORMAL)
    @Owner("3vil")
    @Description("Проверяем возведение в степень: 2^10 должно дать 1024")
    @DisplayName("Возведение в степень")
    public void testPower() {
        double result = steps.power(2, 10);
        steps.verifyResult(result, 1024);
    }

    @Test
    @Story("Квадратный корень")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Проверяем извлечение корня из положительного числа: sqrt(81) должно дать 9")
    @DisplayName("Квадратный корень из положительного числа")
    public void testSqrtPositive() {
        double result = steps.sqrt(81);
        steps.verifyResult(result, 9);
    }

    @Test
    @Story("Квадратный корень")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("3vil")
    @Description("Проверяем обработку корня из отрицательного числа: ожидается ArithmeticException")
    @DisplayName("Квадратный корень из отрицательного числа")
    public void testSqrtNegative() {
        assertThrows(ArithmeticException.class, () -> steps.sqrt(-1));
    }
}