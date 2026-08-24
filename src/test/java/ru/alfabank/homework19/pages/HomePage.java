package ru.alfabank.homework19.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$x;

public class HomePage {

    private final SelenideElement loginLink = $x("//a[@href='/login']");

    public static HomePage open() {
        Selenide.open("https://the-internet.herokuapp.com/");

        return new HomePage();
    }

    public LoginPage clickFormAuthentication() {
        loginLink
                .shouldHave(text("Form Authentication"))
                .click();

        return new LoginPage();
    }
}