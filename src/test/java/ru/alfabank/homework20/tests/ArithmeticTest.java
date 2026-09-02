package ru.alfabank.homework20.tests;

import static org.junit.jupiter.api.Assertions.assertThrows;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.alfabank.homework20.steps.CalculatorSteps;

@Epic("Калькулятор")
@Feature("Арифметические операции")
public class ArithmeticTest {

    private final CalculatorSteps steps = new CalculatorSteps();

    @Test
    @Story("Сложение")
    @Severity(SeverityLevel.NORMAL)
    @Owner("3vil")
    @Description("Проверяем базовое сложение двух положительных чисел: 2 + 3 должно дать 5")
    @DisplayName("Сложение двух положительных чисел")
    public void testAddPositiveNumbers() {
        double result = steps.add(2, 3);
        steps.verifyResult(result, 5);
    }

    @Test
    @Story("Сложение")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем сложение отрицательного и положительного числа: -5 + 3 должно дать -2")
    @DisplayName("Сложение с отрицательным числом")
    public void testAddNegativeNumbers() {
        double result = steps.add(-5, 3);
        steps.verifyResult(result, -2);
    }

    @Test
    @Story("Вычитание")
    @Severity(SeverityLevel.NORMAL)
    @Owner("3vil")
    @Description("Проверяем вычитание: 10 - 4 должно дать 6")
    @DisplayName("Вычитание")
    public void testSubtract() {
        double result = steps.subtract(10, 4);
        steps.verifyResult(result, 6);
    }

    @Test
    @Story("Умножение")
    @Severity(SeverityLevel.NORMAL)
    @Description("Проверяем умножение: 7 * 8 должно дать 56")
    @DisplayName("Умножение")
    public void testMultiply() {
        double result = steps.multiply(7, 8);
        steps.verifyResult(result, 56);
    }

    @Test
    @Story("Деление")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("3vil")
    @Description("Проверяем деление: 15 / 3 должно дать 5")
    @DisplayName("Деление")
    public void testDivide() {
        double result = steps.divide(15, 3);
        steps.verifyResult(result, 5);
    }

    @Test
    @Story("Деление")
    @Severity(SeverityLevel.CRITICAL)
    @Link("CALC-1")
    @Description("Проверяем обработку деления на ноль: ожидается ArithmeticException")
    @DisplayName("Деление на ноль выбрасывает исключение")
    public void testDivideByZero() {
        Allure.parameter("делимое", "15");
        Allure.parameter("делитель", "0");
        assertThrows(ArithmeticException.class, () -> steps.divide(15, 0));
    }

    @Test
    @Story("Деление")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Динамический шаг через Allure.step(): проверяем деление с вложением-расчётом")
    @DisplayName("Деление с динамическим шагом Allure")
    public void testDivideWithAllureStep() {
        Allure.parameter("делимое", "100");
        Allure.parameter("делитель", "4");
        Allure.step("Выполняем деление 100 / 4", () -> {
            double result = steps.divide(100, 4);
            Allure.addAttachment("Расчёт", "text/plain", "100 / 4 = " + result);
            steps.verifyResult(result, 25);
        });
    }
}