package ru.alfabank.homework7.arena.heroes;

public class Archer extends Hero {

    private int arrowsCount;

    public Archer(String name, int health, int arrowsCount) {
        super(name, health);
        this.arrowsCount = arrowsCount;
    }

    public int getArrowsCount() {
        return arrowsCount;
    }

    public void setArrowsCount(int arrowsCount) {
        this.arrowsCount = arrowsCount;
    }

    @Override
    public void attack() {
        System.out.println("Лучник выпускает стрелу!");
    }

    @Override
    public String toString() {
        return "Archer{" +
                "arrowsCount=" + arrowsCount +
                ", name='" + name + '\'' +
                ", level=" + level +
                ", health=" + health +
                '}';
    }
}
