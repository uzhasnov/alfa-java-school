package ru.alfabank.homework15;

import java.util.ArrayList;
import java.util.List;

public class RentalService {

    private final List<BoardGame> inventory = new ArrayList<>();

    public void addGame(BoardGame game) {
        if (game == null) {
            throw new IllegalArgumentException("Игра не может быть null");
        }

        for (BoardGame existingGame : inventory) {
            if (existingGame.getName().equalsIgnoreCase(game.getName())) {
                throw new IllegalArgumentException("Игра с таким названием уже существует в пункте проката");
            }
        }

        inventory.add(game);
    }

    public BoardGame findGameByName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Название для поиска не может быть пустым");
        }

        for (BoardGame game : inventory) {
            if (game.getName().equalsIgnoreCase(name.trim())) {
                return game;
            }
        }

        return null;
    }

    public boolean rentGame(String name, int customerAge) {
        BoardGame targetGame = findGameByName(name);

        if (targetGame == null) {
            throw new IllegalArgumentException("Игра с таким названием не найдена");
        }

        if (!targetGame.canBeRentedBy(customerAge)) {
            return false;
        }

        if (targetGame.isRented()) {
            return false;
        }

        targetGame.setRented(true);
        return true;
    }

    public boolean returnGame(String name) {
        BoardGame targetGame = findGameByName(name);

        if (targetGame == null) {
            return false;
        }

        if (!targetGame.isRented()) {
            return false;
        }

        targetGame.setRented(false);

        return true;
    }

    public int calculateCost(String name, int days) {
        if (days <= 0) {
            throw new IllegalArgumentException("Количество дней должно быть больше нуля");
        }

        BoardGame targetGame = findGameByName(name);
        if (targetGame == null) {
            throw new IllegalArgumentException("Игра с таким названием не найдена");
        }

        return targetGame.getDailyRentCost() * days;
    }

    public void reset() {
        for (BoardGame game : inventory) {
            game.setRented(false);
        }
    }
}
