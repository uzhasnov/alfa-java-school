package ru.alfabank.homework7.arena.heroes;

public class Mage extends Hero {

    private int mana;

    public Mage(String name, int health, int mana) {
        super(name, health);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public void attack() {
        System.out.println("Маг запускает огненный шар!");
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nМана героя: " + mana;
    }
}
