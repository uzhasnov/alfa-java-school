package ru.alfabank.homework7.arena.heroes;

public abstract class Hero {

    private final String name;
    private int level = 1;
    private int health;
    public static final int MAX_LEVEL = 100;
    private static int heroesCreated;

    public Hero(String name, int health) {
        this.name = name;
        this.health = health;
        heroesCreated++;
    }

    public void printInfo() {
        System.out.println(this);
    }

    public void takeDamage(int damage) {
        if (health > 0) {
            health -= damage;
        }
    }

    public void levelUp() {
        if (level < MAX_LEVEL) {
            level++;
        }
    }

    public void attack() {
        System.out.println("Герой наносит обычный удар.");
    }

    public void attack(String target) {
        System.out.printf("Герой наносит обычный удар. Цель: %s.\n", target);
    }

    public void attack(String target, int times) {
        System.out.printf("Герой атакует цель %s %d раза.\n", target,  times);
    }

    public static void printHeroesCreated() {
        System.out.printf("Всего создано героев: %d.\n", heroesCreated);
    }

    public final void rest() {
        System.out.println("Герой отдыхает и восстанавливает силы.");
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public String toString() {
        return "Имя героя: " + name +
                "\nУровень героя: " + level +
                "\nУровень здоровья героя: " + health;
    }
}
