package ru.alfabank.homework9;

import com.github.lalyos.jfiglet.FigletFont;

import java.io.IOException;

public class Printer {

    private final static char AMPERSAND_SYMBOL = '&';
    private final Generator generator;

    public Printer() {
        this.generator = new Generator();
    }

    public void printLogo() throws IOException {
        System.out.println(FigletFont.convertOneLine(generator.getRandomLastNameFromArray()));
        System.out.println(FigletFont.convertOneLine(String.valueOf(AMPERSAND_SYMBOL)));
        System.out.println(FigletFont.convertOneLine(generator.getRandomLastName()));
    }

    public void printInfo() {
        System.out.println(generator.getRandomAddress());
        System.out.println(generator.getRandomPhoneNumber());
        System.out.println(generator.getRandomFullName());
    }
}
