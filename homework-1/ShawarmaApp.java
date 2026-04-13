public class ShawarmaApp {
    public static void main(String[] args) {
        String employeeName = "Азизилло";
        String employeePosition = "Мастер над лавашами";
        short shiftPayment = 6000;
        byte shiftCount = 16;
        short bonusReward = 5000;
        short burnedLavashFine = 500;
        short shawarmaCost = 350;
        short shawarmaSoldCount = 680;

        System.out.println("Сотрудник: " + employeeName);
        System.out.println("Должность: " + employeePosition);
        System.out.println("Оплата за смены: " + shiftPayment * shiftCount);
        System.out.println("Премия: " + bonusReward);
        System.out.println("Штраф: " + burnedLavashFine);
        System.out.println("Итоговая зарплата: " + (shiftPayment * shiftCount + bonusReward - burnedLavashFine));
        System.out.println("Шаур-выручка: " + shawarmaCost * shawarmaSoldCount);
    }
}
