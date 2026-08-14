package ru.alfabank.homework15;

import java.util.Objects;

public class BoardGame {
    private final String name;
    private final int minimalAge;
    private final int dailyRentalCost;
    private boolean isRented;

    public BoardGame(String name, int minimalAge, int dailyRentalCost) {
        if (name == null) {
            throw new IllegalArgumentException("Название не может иметь значение null");
        } else if (name.isBlank()) {
            throw new IllegalArgumentException("Название не может быть пустым");
        } else {
            this.name = name;
        }

        if (minimalAge < 0) {
            throw new IllegalArgumentException("Возраст не должен быть отрицательным");
        } else {
            this.minimalAge = minimalAge;
        }

        if (dailyRentalCost <= 0) {
            throw new IllegalArgumentException("Стоимость аренды должна быть положительной");
        } else {
            this.dailyRentalCost = dailyRentalCost;
        }

        this.isRented = false;
    }

    public String getName() {
        return name;
    }

    public int getMinimalAge() {
        return minimalAge;
    }

    public int getDailyRentCost() {
        return dailyRentalCost;
    }

    public boolean isRented() {
        return isRented;
    }

    public boolean canBeRentedBy(int minimalAge) {
        return minimalAge >= this.minimalAge;
    }

    public void setRented(boolean rented) {
        isRented = rented;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BoardGame boardGame = (BoardGame) o;
        return minimalAge == boardGame.minimalAge &&
                dailyRentalCost == boardGame.dailyRentalCost &&
                isRented == boardGame.isRented && Objects.equals(name, boardGame.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, minimalAge, dailyRentalCost, isRented);
    }

    @Override
    public String toString() {
        return "BoardGame{" +
                "name='" + name + '\'' +
                ", minimalAge=" + minimalAge +
                ", dailyRentalCost=" + dailyRentalCost +
                ", isRented=" + isRented +
                '}';
    }
}
