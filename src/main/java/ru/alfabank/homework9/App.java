package ru.alfabank.homework9;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {

        Printer printer = new Printer();

        printer.printLogo();
        printer.printInfo();
    }
}
