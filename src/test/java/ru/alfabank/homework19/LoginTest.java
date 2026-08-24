package ru.alfabank.homework19;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginTest {

    @Test
    @DisplayName("Сценарий 1: успешный вход и выход с использованием правильных учётных данных")
    void shouldLoginAndLogoutSuccessfully() {
        Selenide.open("https://the-internet.herokuapp.com/");

        $x("//a[@href='/login']").shouldHave(text("Form Authentication")).click();

        $x("//h2[contains(text(), 'Login Page')]").shouldHave(text("Login Page"));

        $x("//input[@id='username']").setValue("tomsmith");
        $x("//input[@id='password']").setValue("SuperSecretPassword!");

        $x("//button[@type='submit']").click();

        $x("//div[@id='flash']").shouldHave(text("You logged into a secure area!"));

        $x("//a[@href='/logout']").shouldBe(visible).click();

        $x("//h2[contains(text(), 'Login Page')]").shouldHave(text("Login Page"));
    }

    @Test
    @DisplayName("Сценарий 2: вход с неверными учётными данными отклоняется")
    void shouldRejectInvalidCredentials() {
        Selenide.open("https://the-internet.herokuapp.com/");

        $x("//a[@href='/login']").shouldHave(text("Form Authentication")).click();

        $x("//div[@id='page-footer']//a[contains(text(), 'Elemental Selenium')]").shouldBe(visible);

        $x("//input[@id='username']").setValue("admin");
        $x("//input[@id='password']").setValue("1234");

        $x("//button[@type='submit']").click();

        $x("//div[@id='flash']").shouldHave(text("Your username is invalid!"));
    }
}
