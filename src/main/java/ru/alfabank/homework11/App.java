package ru.alfabank.homework11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        CoffeeMachine coffeeMachine = new CoffeeMachine();
        Scanner sc = new Scanner(System.in);

        System.out.println("Введите количество воды:");
        int input;

        try {
            input = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ошибка: нужно было ввести число");
        } finally {
            sc.close();
        }

        try {
            coffeeMachine.makeCoffee(100);
        } catch (NotEnoughWaterException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Проверка кофемашины завершена");
        }

        try {
            coffeeMachine.calculateCups(1000, 0);
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: размер чашки не может быть 0");
        }

        String coffeeName = null;

        try {
            coffeeMachine.printCoffeeName(coffeeName);
        } catch (NullPointerException e) {
            System.out.println("Ошибка: название кофе отсутствует");
        }

    }
}
