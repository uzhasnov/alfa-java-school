package ru.alfabank.homework3;

import java.util.Arrays;

public class BucketsApp {
    public static void main(String[] args) {

        String[] bucketOfPetya = {"курица", "бананы", "творог"};
        String[] bucketOfKolya = {"курица", "бананы", "творог"};
        String[] bucketOfTerentiy = {"пиво", "пельмени", "ласка магия черного"};

        boolean areBucketsOfPetyaAndKolyaHaveTheSameAmountOfProducts =
                bucketOfPetya.length == bucketOfKolya.length;
        boolean areBucketsOfPetyaAndTerentiyHaveTheSameAmountOfProducts =
                bucketOfPetya.length == bucketOfTerentiy.length;

        System.out.printf(
                "Количество товаров в Колиной корзине такое же, как и в Петиной: %s\n",
                areBucketsOfPetyaAndKolyaHaveTheSameAmountOfProducts);
        System.out.printf(
                "Количество товаров корзине Терентия такое же, как и в Петиной: %s\n",
                areBucketsOfPetyaAndTerentiyHaveTheSameAmountOfProducts);

        boolean areBucketsOfPetyaAndKolyaHaveTheSameProducts =
                Arrays.equals(bucketOfPetya, bucketOfKolya);
        boolean areBucketsOfPetyaAndTerentiyHaveTheSameProducts =
                Arrays.equals(bucketOfPetya, bucketOfTerentiy);

        System.out.printf(
                "Товары в Колиной корзине такие же, как и в Петиной: %s\n",
                areBucketsOfPetyaAndKolyaHaveTheSameProducts);
        System.out.printf(
                "Товары в корзине Терентия такие же, как и в Петиной: %s\n",
                areBucketsOfPetyaAndTerentiyHaveTheSameProducts);

        String[] arrayOfProductsWithTheLongestNameLength = {
                getProductWithTheLongestNameLength(bucketOfPetya),
                getProductWithTheLongestNameLength(bucketOfKolya),
                getProductWithTheLongestNameLength(bucketOfTerentiy)
        };
        String[] arrayOfProductsWithTheShortestNameLength = {
                getProductWithTheShortestNameLength(bucketOfPetya),
                getProductWithTheShortestNameLength(bucketOfKolya),
                getProductWithTheShortestNameLength(bucketOfTerentiy)
        };
        int[] arrayOfAverageProductNameLength = {
                getAverageProductNameLength(bucketOfPetya),
                getAverageProductNameLength(bucketOfKolya),
                getAverageProductNameLength(bucketOfTerentiy)
        };

        System.out.printf(
                "Товар с самым длинным названием среди всех товаров: %s\n",
                getProductWithTheLongestNameLength(arrayOfProductsWithTheLongestNameLength));
        System.out.printf(
                "Товар с самым коротким названием среди всех товаров: %s\n",
                getProductWithTheShortestNameLength(arrayOfProductsWithTheShortestNameLength));
        System.out.printf(
                "Средняя длина названия товара среди всех товаров: %s\n",
                getAverageProductNameLengthBetweenAllProducts(arrayOfAverageProductNameLength));
    }

    private static String getProductWithTheShortestNameLength(String[] products) {
        String productWithMinNameLength = products[0];
        for (String product : products) {
            if (product.length() < productWithMinNameLength.length()) {
                productWithMinNameLength = product;
            }
        }

        return productWithMinNameLength;
    }

    private static String getProductWithTheLongestNameLength(String[] products) {
        String productWithMaxNameLength = products[0];
        for (String product : products) {
            if (product.length() > productWithMaxNameLength.length()) {
                productWithMaxNameLength = product;
            }
        }

        return productWithMaxNameLength;
    }

    private static int getAverageProductNameLength(String[] products) {
        int lengthOfNamesForAllProducts = 0;
        for (String product : products) {
            lengthOfNamesForAllProducts += product.length();
        }

        return lengthOfNamesForAllProducts / products.length;
    }

    private static int getAverageProductNameLengthBetweenAllProducts(int[] arrayOfAverageProductLength) {
        int productLengthSum = 0;
        for (int length : arrayOfAverageProductLength) {
            productLengthSum += length;
        }

        return productLengthSum / arrayOfAverageProductLength.length;
    }
}
