package ru.alfabank.homework13;

import java.util.ArrayList;

public class App {

    public static void main(String[] args) {

        System.out.println("Часть 1:");
        ArrayList<Alien> aliens = new ArrayList<>();
        aliens.add(new Alien("Ксаэлия", "Веларис-IV", 1));
        aliens.add(new Alien("Тауромон", "Эребус-Прайм", 2));
        aliens.add(new Alien("Зи’лакс", "Орания", 3));
        aliens.add(new Alien("Кронгар", "Тор-Вулкан", 4));
        aliens.add(new Alien("Тауромон", "Эребус-Прайм", 4));

        for (Alien alien : aliens) {
            System.out.println(alien);
        }

        System.out.println("Часть 2:");
        SquadManager squadManager = new SquadManager();
        squadManager.demonstrateListCreations();

        System.out.println("Часть 3:");
        ArrayList<String> squadWithCowards = new ArrayList<>();
        squadWithCowards.add("Олег");
        squadWithCowards.add("Иван");
        squadWithCowards.add("Пётр");
        squadWithCowards.add("Трус Джонн");
        squadWithCowards.add("Трус Билл");

        System.out.println("Демонстрация удаления трусов через итератор:");
        squadWithCowards = (ArrayList<String>) squadManager.filterOutCowards(squadWithCowards);

        squadWithCowards.add("Трус Уолтер");
        squadWithCowards.add("Трус Дональд");

        System.out.println("Демонстрация удаления трусов через removeIf():");
        squadManager.enhancedFilterOutCowards(squadWithCowards);

        System.out.println("Часть 4:");
        AssaultQueue assaultQueue = new AssaultQueue();

        assaultQueue.addRecruit("Джон");
        assaultQueue.addRecruit("Билл");
        assaultQueue.addRecruit("Иван");
        assaultQueue.addRecruit("Пётр");
        assaultQueue.addRecruit("Егор");

        assaultQueue.printQueue();

        System.out.println(assaultQueue.retireCoward() + " уволен за трусость");
        System.out.println(assaultQueue.retireCoward() + " уволен за трусость");

        assaultQueue.addRecruit("Алексей");
        assaultQueue.addRecruit("Владимир");
        assaultQueue.addRecruit("Максим");

        assaultQueue.printQueue();

        System.out.println("Часть 5:");
        MissionReport report = new MissionReport("Штурм Зоны 51", aliens, 50);

        System.out.println(report);

        MissionReport secondReport = new MissionReport("Штурм Зоны 51", aliens, 50);

        boolean result = report == secondReport;
        System.out.println("Результат сравнения двух одинаковых отчётов через == : " + result);

        result = report.equals(secondReport);
        System.out.println("Результат сравнения двух одинаковых отчётов через equals() : " + result);
    }
}
