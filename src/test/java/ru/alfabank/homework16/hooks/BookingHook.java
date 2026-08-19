package ru.alfabank.homework16.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class BookingHook {

    @Before
    public void before(Scenario scenario) {
        System.out.println("Название сценария из хука @Before: " + scenario.getName());
    }

    @After
    public void after(Scenario scenario) {
        System.out.println("Результат сценария из хука @After: " +
                (scenario.isFailed() ? "сценарий завершился с ошибкой" : "сценарий завершился успешно"));
    }
}
