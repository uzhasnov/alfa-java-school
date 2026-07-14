package ru.alfabank.homework13;

import java.util.Objects;

public class Alien {

    private final String name;
    private final String planet;
    private final int dangerLevel;

    public Alien(String name, String planet, int dangerLevel) {
        if (name == null || planet == null || name.isBlank() || planet.isBlank() || dangerLevel < 1 || dangerLevel > 10) {
            throw new IllegalArgumentException("Имя пришельца и название планеты не могут быть пустыми, " +
                    "уровень опасности должен быть от 1 до 10");
        } else {
            this.name = name;
            this.planet = planet;
            this.dangerLevel = dangerLevel;
        }
    }

    public String getName() {
        return name;
    }

    public String getPlanet() {
        return planet;
    }

    public int getDangerLevel() {
        return dangerLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Alien alien = (Alien) o;
        return Objects.equals(name, alien.name) && Objects.equals(planet, alien.planet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, planet);
    }

    @Override
    public String toString() {
        return String.format("Имя пришельца: %s. Планета: %s. Уровень опасности: %d",  name, planet, dangerLevel);
    }
}
