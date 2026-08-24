package ru.alfabank.homework19.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.То;
import ru.alfabank.homework19.pages.HomePage;
import ru.alfabank.homework19.pages.LoginPage;

public class LoginSteps {

    private HomePage homePage;
    private LoginPage loginPage;

    @Дано("открыта главная страница the-internet.herokuapp.com")
    public void openHomePage() {
        homePage = HomePage.open();
    }

    @И("я перехожу по ссылке {string}")
    public void openFormAuthentication(String linkText) {
        loginPage = homePage.clickFormAuthentication();
    }

    @То("заголовок страницы содержит текст {string}")
    public void checkHeading(String headingText) {
        loginPage.shouldHaveLoginPageHeading();
    }

    @То("внизу страницы присутствует ссылка {string}")
    public void checkBottomLink(String linkText) {
        loginPage.shouldContainElementalSeleniumLink();
    }

    @И("я ввожу в поле {string} значение {string}")
    public void fillField(String fieldName, String value) {
        if ("Username".equals(fieldName)) {
            loginPage.setUsername(value);
        } else if ("Password".equals(fieldName)) {
            loginPage.setPassword(value);
        } else {
            throw new IllegalArgumentException("Неизвестное поле: " + fieldName);
        }
    }

    @И("я нажимаю кнопку {string}")
    public void clickButton(String buttonText) {
        if ("Login".equals(buttonText)) {
            loginPage.clickLogin();
        } else if ("Logout".equals(buttonText)) {
            loginPage.clickLogout();
        } else {
            throw new IllegalArgumentException("Неизвестная кнопка: " + buttonText);
        }
    }

    @И("на странице присутствует кнопка {string}")
    public void assertButtonVisible(String buttonText) {
        loginPage.shouldHaveLogoutButton();
    }

    @То("сообщение результата содержит текст {string}")
    public void checkResultMessage(String expectedMessage) {
        loginPage.shouldShowMessage(expectedMessage);
    }
}