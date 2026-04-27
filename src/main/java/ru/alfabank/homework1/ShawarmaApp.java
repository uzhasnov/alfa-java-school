package ru.alfabank.homework1;

public class ShawarmaApp {
    public static void main(String[] var0) {
        String var1 = "Азизилло";
        String var2 = "Мастер над лавашами";
        short var3 = 6000;
        byte var4 = 16;
        short var5 = 5000;
        short var6 = 500;
        short var7 = 350;
        short var8 = 520;
        System.out.println("Сотрудник: " + var1);
        System.out.println("Должность: " + var2);
        System.out.println("Оплата за смены: " + var3 * var4);
        System.out.println("Премия: " + var5);
        System.out.println("Штраф: " + var6);
        System.out.println("Итоговая зарплата: " + (var3 * var4 + var5 - var6));
        System.out.println("Шаур-выручка: " + var7 * var8);
    }
}
