package ru.alfabank.homework7.arena.app;

import ru.alfabank.homework7.arena.heroes.Archer;
import ru.alfabank.homework7.arena.heroes.Hero;
import ru.alfabank.homework7.arena.heroes.Knight;
import ru.alfabank.homework7.arena.heroes.Mage;

public class ArenaApp {
    public static void main(String[] args) {

        Hero[] heroes = {
                new Knight("Ниф-Ниф", 200, 10),
                new Archer("Наф-Наф", 150, 80),
                new Mage("Нуф-Нуф", 100, 200)
        };

        for (Hero hero : heroes) {
            hero.printInfo();
            hero.attack();
        }

        final Knight knight = new Knight("Добрыня", 300, 20);

        System.out.println(knight);
        knight.setArmor(1000);
        System.out.println(knight);
    }
}
