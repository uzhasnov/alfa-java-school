package ru.alfabank.homework19.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private final SelenideElement loginPageHeading = $x("//h2[contains(text(), 'Login Page')]");
    private final SelenideElement elementalSeleniumLink =
            $x("//div[@id='page-footer']//a[contains(text(), 'Elemental Selenium')]");
    private final SelenideElement usernameInput = $x("//input[@id='username']");
    private final SelenideElement passwordInput = $x("//input[@id='password']");
    private final SelenideElement submitButton = $x("//button[@type='submit']");
    private final SelenideElement flashMessage = $x("//div[@id='flash']");
    private final SelenideElement logoutLink = $x("//a[@href='/logout']");

    public LoginPage shouldHaveLoginPageHeading() {
        loginPageHeading
                .shouldHave(text("Login Page"));

        return this;
    }

    public LoginPage shouldContainElementalSeleniumLink() {
        elementalSeleniumLink
                .shouldBe(visible);

        return this;
    }

    public LoginPage setUsername(String username) {
        usernameInput
                .setValue(username);

        return this;
    }

    public LoginPage setPassword(String password) {
        passwordInput
                .setValue(password);

        return this;
    }

    public LoginPage clickLogin() {
        submitButton
                .click();

        return this;
    }

    public LoginPage shouldShowMessage(String expectedText) {
        flashMessage
                .shouldHave(text(expectedText));

        return this;
    }

    public LoginPage shouldShowSuccessMessage() {
        flashMessage
                .shouldHave(text("You logged into a secure area!"));

        return this;
    }

    public LoginPage shouldShowInvalidCredentialsMessage() {
        flashMessage
                .shouldHave(text("Your username is invalid!"));

        return this;
    }

    public LoginPage shouldHaveLogoutButton() {
        logoutLink
                .shouldBe(visible);

        return this;
    }

    public LoginPage clickLogout() {
        logoutLink
                .shouldBe(visible).click();

        return this;
    }
}