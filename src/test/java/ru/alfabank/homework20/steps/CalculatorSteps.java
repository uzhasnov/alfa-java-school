package ru.alfabank.homework20.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import ru.alfabank.homework20.Calculator;

public class CalculatorSteps {

    private final Calculator calculator = new Calculator();

    @Step("Сложить {a} + {b}")
    public double add(double a, double b) {
        double result = calculator.add(a, b);
        attachCalculation(a, "+", b, result);
        return result;
    }

    @Step("Вычесть {a} - {b}")
    public double subtract(double a, double b) {
        double result = calculator.subtract(a, b);
        attachCalculation(a, "-", b, result);
        return result;
    }

    @Step("Умножить {a} * {b}")
    public double multiply(double a, double b) {
        double result = calculator.multiply(a, b);
        attachCalculation(a, "*", b, result);
        return result;
    }

    @Step("Разделить {a} / {b}")
    public double divide(double a, double b) {
        double result = calculator.divide(a, b);
        attachCalculation(a, "/", b, result);
        return result;
    }

    @Step("Возвести {base} в степень {exponent}")
    public double power(double base, double exponent) {
        double result = calculator.power(base, exponent);
        attachCalculation(base, "^", exponent, result);
        return result;
    }

    @Step("Извлечь корень из {value}")
    public double sqrt(double value) {
        double result = calculator.sqrt(value);
        attachSqrt(value, result);
        return result;
    }

    @Step("Проверить результат: ожидалось {expected}, получено {actual}")
    public void verifyResult(double actual, double expected) {
        assertEquals(expected, actual, 1e-9);
    }

    @Attachment(value = "Расчёт", type = "text/plain")
    private String attachCalculation(double a, String op, double b, double result) {
        return a + " " + op + " " + b + " = " + result;
    }

    @Attachment(value = "Промежуточный результат", type = "text/plain")
    private String attachSqrt(double value, double result) {
        return "sqrt(" + value + ") = " + result;
    }
}