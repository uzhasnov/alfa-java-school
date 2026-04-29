package ru.alfabank.homework4;

public class NightQaShiftApp {
    public static void main(String[] args) {

        int criticalTestCount = 0;
        int bugTestCount = 0;
        int flakyTestCount = 0;
        int passTestCount = 0;

        boolean showOnlyIssues = false;
        boolean isTooManyCriticalBugs = false;

        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.printf("Тест #%d: Critical!\n", i);
                criticalTestCount++;
                if (isTooManyCriticalBugs && criticalTestCount >= 3) {
                    System.out.println("\uD83D\uDEA8 Слишком много критических багов — будим тимлида!");
                    break;
                }
            } else if (i % 5 == 0) {
                System.out.printf("Тест #%d: Bug\n", i);
                bugTestCount++;
            } else if (i % 3 == 0) {
                System.out.printf("Тест #%d: Flaky\n", i);
                flakyTestCount++;
            } else if (showOnlyIssues) {
                passTestCount++;
            } else {
                System.out.printf("Тест #%d: Pass\n", i);
                passTestCount++;
            }
        }

        int totalTests = criticalTestCount + bugTestCount + flakyTestCount + passTestCount;

        System.out.printf(
                """
                
                ===== ИТОГИ НОЧНОЙ СМЕНЫ =====
                      Всего тестов:   %d
                      Pass:           %d
                      Flaky:          %d
                      Bug:            %d
                      Critical:       %d
                """,
                totalTests ,
                passTestCount,
                flakyTestCount,
                bugTestCount,
                criticalTestCount);
    }
}
