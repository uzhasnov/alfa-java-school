package ru.alfabank.homework9;

import net.datafaker.Faker;

import java.util.Arrays;
import java.util.Random;

public class Generator {

    private final String[] lastNames;
    private final Random random;
    private final Faker faker;

    public Generator() {
        lastNames = new String[] {
                "Smith",
                "Jones",
                "Roberts",
                "Davidson"
        };
        random = new Random();
        faker = new Faker();
    }

    public String getRandomLastNameFromArray() {
        return lastNames[random.nextInt(lastNames.length)];
    }

    public String getRandomLastName() {
        return faker.name().lastName();
    }

    public String getRandomFullName() {
        return faker.name().fullName();
    }

    public String getRandomPhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }

    public String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public String[] getLastNames() {
        return lastNames;
    }

    @Override
    public String toString() {
        return "Generator{" +
                "lastNames=" + Arrays.toString(lastNames) +
                '}';
    }
}
