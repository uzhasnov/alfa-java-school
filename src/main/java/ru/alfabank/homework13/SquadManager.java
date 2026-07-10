package ru.alfabank.homework13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SquadManager {

    public void demonstrateListCreations() {

        ArrayList<String> primeSquad = new ArrayList<>();

        primeSquad.add("Иван");
        primeSquad.add("Олег");
        primeSquad.add("Максим");
        primeSquad.add("Егор");

        List<String> supportSquad = Arrays.asList("Никита", "Пётр", "Дмитрий");

        List<String> eliteSquad = List.of("Добрыня", "Владимир");

        addTrooperToSquad("Святослав", primeSquad);
        removeTrooperFromSquad("Святослав", primeSquad);

        addTrooperToSquad("Джон", supportSquad);
        removeTrooperFromSquad("Джон", supportSquad);

        addTrooperToSquad("Билл", eliteSquad);
        removeTrooperFromSquad("Билл", eliteSquad);
    }

    public List<String> filterOutCowards(List<String> squad) {

        System.out.println(squad);

        Iterator<String> iterator = squad.iterator();
        while (iterator.hasNext()) {
            String squadName = iterator.next();
            if (squadName.startsWith("Трус")) {
                iterator.remove();
            }
        }

        System.out.println(squad);

        return squad;
    }

    public List<String> enhancedFilterOutCowards(List<String> squad) {

        System.out.println(squad);

        squad.removeIf(trooper -> trooper.startsWith("Трус"));

        System.out.println(squad);

        return squad;
    }

    private List<String> addTrooperToSquad(String trooperName, List<String> squad) {

        try {
            squad.add(trooperName);
            System.out.println("Штурмовик " + trooperName + " успешно добавлен в список отряда");
        } catch (RuntimeException e) {
            System.out.println(e.getClass().getName() + ": Добавление штурмовика " + trooperName + " в отряд запрещено");
        }

        return squad;
    }

    private List<String> removeTrooperFromSquad(String trooperName, List<String> squad) {

        try {
            squad.add(trooperName);
            System.out.println("Штурмовик " + trooperName + " успешно удалён из списка элитного отряда");
        } catch (RuntimeException e) {
            System.out.println(e.getClass().getName() + ": Удаление штурмовика " + trooperName + " из отряда запрещено");
        }

        return squad;
    }
}