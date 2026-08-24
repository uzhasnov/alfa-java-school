package ru.alfabank.homework19;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.alfabank.homework19.pages.HomePage;

public class LoginTest {

    @BeforeAll
    static void setUp() {
        Configuration.headless = true;
    }

    @AfterEach
    void tearDown() {
        Selenide.closeWebDriver();
    }

    @Test
    @DisplayName("Сценарий 1: успешный вход и выход с использованием правильных учётных данных")
    void shouldLoginAndLogoutSuccessfully() {
        HomePage.open()
                .clickFormAuthentication()
                .shouldHaveLoginPageHeading()
                .setUsername("tomsmith")
                .setPassword("SuperSecretPassword!")
                .clickLogin()
                .shouldShowSuccessMessage()
                .clickLogout()
                .shouldHaveLoginPageHeading();
    }

    @Test
    @DisplayName("Сценарий 2: вход с неверными учётными данными отклоняется")
    void shouldRejectInvalidCredentials() {
        HomePage.open()
                .clickFormAuthentication()
                .shouldHaveLoginPageHeading()
                .shouldContainElementalSeleniumLink()
                .setUsername("admin")
                .setPassword("1234")
                .clickLogin()
                .shouldShowInvalidCredentialsMessage();
    }
}