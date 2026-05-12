package ru.alfabank.homework5;

import java.time.LocalDate;
import java.util.Random;

public class MethodsApp {
    public static void main(String[] args) {
        String accessCode = generateAccessCode();
        boolean isCodeValid = isValidCode(accessCode, 8);
        System.out.printf("Access code is valid: %b\n", isCodeValid);
        logEvent("Server protection activated");
        logEvent("Intrusion attempt detected", true);
        String agent1 = generateAgentId("AGENT", 42);
        String agent2 = generateAgentId("AGENT", 77);
        String agent3 = generateAgentId("AGENT", 13);
        System.out.println(agent1);
        System.out.println(agent2);
        System.out.println(agent3);
    }

    public static String generateAccessCode() {
        int currentYear = LocalDate.now().getYear();
        int mathResult = (int) Math.pow(3, 7);

        return String.format("%d-%s", currentYear, mathResult);
    }

    private static boolean isValidCode(String code, int minLength) {
        return code != null && code.length() >= minLength && code.contains("-");
    }

    public static void logEvent(String message) {
        System.out.printf("[INFO] %s\n", message);
    }

    public static void logEvent(String message, boolean isCritical) {
        if (isCritical) {
            System.out.printf("[CRITICAL] %s\n", message);
        } else {
            logEvent(message);
        }
    }

    public static String generateAgentId(String prefix, int seed) {
        Random random = new Random(seed);
        int salt = random.nextInt(1_000, 10_000);

        return String.format("%s-%d", prefix, salt);
    }
}
