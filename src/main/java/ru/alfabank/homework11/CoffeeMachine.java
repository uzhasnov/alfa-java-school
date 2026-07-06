package ru.alfabank.homework11;

public class CoffeeMachine {

    public void makeCoffee(int milliliters) {
        if(milliliters < 200) {
            throw new NotEnoughWaterException("Для приготовления кофе недостаточно воды");
        } else {
            System.out.println("Приготовлен кофе");
        }
    }

    public int calculateCups(int milliliters, int cupSize) {
        return milliliters / cupSize;
    }

    public void printCoffeeName(String coffeeName) {
        System.out.println(coffeeName.toUpperCase());
    }
}
