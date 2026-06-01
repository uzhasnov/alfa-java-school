package ru.alfabank.homework7.arena.heroes;

public class Knight extends Hero {

    private int armor;

    public Knight(String name, int health, int armor) {
        super(name, health);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    @Override
    public void attack() {
        System.out.println("Рыцарь бьёт мечом!");
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nБроня героя: " + armor;
    }
}
