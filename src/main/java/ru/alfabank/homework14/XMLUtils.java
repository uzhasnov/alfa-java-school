package ru.alfabank.homework14;

public class XMLUtils {

    public static String createEmptyElement(String tagName) {
        if (tagName == null || tagName.isBlank()) {
            return "<invalid/>";
        } else {
            return "<" + tagName + "></" + tagName + ">";
        }
    }
}
