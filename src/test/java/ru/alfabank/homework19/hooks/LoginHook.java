package ru.alfabank.homework19.hooks;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class LoginHook {

    @BeforeAll
    public static void beforeAll() {
        Configuration.headless = true;
    }

    @AfterAll
    public static void afterAll() {
        Selenide.closeWebDriver();
    }
}