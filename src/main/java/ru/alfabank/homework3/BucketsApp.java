package ru.alfabank.homework3;

import java.util.Arrays;

public class BucketsApp {
    public static void main(String[] args) {

        String[] bucketOfPetya = {"курица", "бананы", "творог"};
        String[] bucketOfKolya = {"курица", "бананы", "творог"};
        String[] bucketOfTerentiy = {"пиво", "пельмени", "ласка магия черного"};

        boolean areBucketsOfPetyaAndKolyaHaveTheSameAmountOfProducts =
                bucketOfPetya.length == bucketOfKolya.length;
        boolean areBucketsOfPetyaAndKolyaHaveTheSameProducts =
                Arrays.equals(bucketOfPetya, bucketOfKolya);
        boolean areBucketsOfPetyaAndTerentiyHaveTheSameAmountOfProducts =
                bucketOfPetya.length == bucketOfTerentiy.length;
        boolean areBucketsOfPetyaAndTerentiyHaveTheSameProducts =
                Arrays.equals(bucketOfPetya, bucketOfTerentiy);

        System.out.printf(
                "Количество товаров в Колиной корзине такое же, как и в Петиной: %s\n",
                areBucketsOfPetyaAndKolyaHaveTheSameProducts);

        System.out.printf(
                "Товары в Колиной корзине такие же, как и в Петиной: %s\n",
                areBucketsOfPetyaAndKolyaHaveTheSameAmountOfProducts);

        System.out.printf(
                "Количество товаров корзине Терентия такое же, как и в Петиной: %s\n",
                areBucketsOfPetyaAndTerentiyHaveTheSameAmountOfProducts);

        System.out.printf(
                "Товары в корзине Терентия такие же, как и в Петиной: %s\n",
                areBucketsOfPetyaAndTerentiyHaveTheSameProducts);

        System.out.printf(
                "Товар с самым длинным названием в козине у Пети: %s\n",
                getProductWithMaxNameLength(bucketOfPetya));

        System.out.printf(
                "Товар с самым длинным названием в козине у Коли: %s\n",
                getProductWithMaxNameLength(bucketOfKolya));

        System.out.printf(
                "Товар с самым длинным названием в козине у Терентия: %s\n",
                getProductWithMaxNameLength(bucketOfTerentiy));

        System.out.printf(
                "Товар с самым коротким названием в козине у Пети: %s\n",
                getProductWithMinNameLength(bucketOfPetya));

        System.out.printf(
                "Товар с самым коротким названием в козине у Коли: %s\n",
                getProductWithMinNameLength(bucketOfKolya));

        System.out.printf(
                "Товар с самым коротким названием в козине у Терентия: %s\n",
                getProductWithMinNameLength(bucketOfTerentiy));

        System.out.printf(
                "Средняя длина названия товара в козине у Пети: %s\n",
                averageProductNameLength(bucketOfPetya));

        System.out.printf(
                "Средняя длина названия товара в козине у Коли: %s\n",
                averageProductNameLength(bucketOfKolya));

        System.out.printf(
                "Средняя длина названия товара в козине у Терентия: %s\n",
                averageProductNameLength(bucketOfTerentiy));
    }

    private static String getProductWithMinNameLength(String[] products) {
        String productWithMinNameLength = products[0];
        for (String product : products) {
            if (product.length() < productWithMinNameLength.length()) {
                productWithMinNameLength = product;
            }
        }

        return productWithMinNameLength;
    }

    private static String getProductWithMaxNameLength(String[] products) {
        String productWithMaxNameLength = products[0];
        for (String product : products) {
            if (product.length() > productWithMaxNameLength.length()) {
                productWithMaxNameLength = product;
            }
        }

        return productWithMaxNameLength;
    }

    private static int averageProductNameLength(String[] products) {
        int lengthOfNamesForAllProducts = 0;
        for (String product : products) {
            lengthOfNamesForAllProducts += product.length();
        }

        return lengthOfNamesForAllProducts / products.length;
    }
}
