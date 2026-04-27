package ru.alfabank.homework2;

import java.util.Random;

public class BusinessCoachApp {
    public static void main(String[] var0) {
        Random var1 = new Random();
        int var2 = var1.nextInt(84) + 6;
        double var3 = var1.nextDouble((double)200001.0F) + (double)100.0F;
        boolean var5 = false;
        boolean var6 = false;
        boolean var7 = var2 >= 18;
        boolean var8 = var5 || var3 >= (double)50000.0F;
        boolean var9 = var7 && var8 && !var6;
        System.out.printf("Участник подходит под критерии: %b\n", var9);
        double var10 = var3 * 0.075;
        String var12 = var9 ? "Обязательный добровольный взнос: %.2f" : "Ты не подходишь... с тебя обязательный добровольный взнос: %.2f";
        System.out.printf(var12, var10);
    }
}
