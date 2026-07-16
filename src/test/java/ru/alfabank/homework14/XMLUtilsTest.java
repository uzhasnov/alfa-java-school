package ru.alfabank.homework14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class XMLUtilsTest {

    @Test
    public void shouldReturnInvalidTagWithNullTagValueGiven() {

        String tagValue = null;
        String expectedResult = "<invalid/>";
        String errorMessage = "Значение результата отличается от ожидаемого";

        String actualResult = XMLUtils.createEmptyElement(tagValue);

        Assertions.assertEquals(expectedResult, actualResult, errorMessage);
    }

    @Test
    public void shouldReturnInvalidTagWithEmptyTagValueGiven() {

        String tagValue = "";
        String expectedResult = "<invalid/>";
        String errorMessage = "Значение результата отличается от ожидаемого";

        String actualResult = XMLUtils.createEmptyElement(tagValue);

        Assertions.assertEquals(expectedResult, actualResult, errorMessage);
    }

    @Test
    public void shouldReturnValidTagWithValidTagValueGiven() {

        String tagValue = "dependency";
        String expectedResult = "<dependency></dependency>";
        String errorMessage = "Значение результата отличается от ожидаемого";

        String actualResult = XMLUtils.createEmptyElement(tagValue);

        Assertions.assertEquals(expectedResult, actualResult, errorMessage);
    }
}
