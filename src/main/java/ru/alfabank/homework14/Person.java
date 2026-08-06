package ru.alfabank.homework14;

public class Person {

    public String fullName;
    protected int age;
    String passportNumber;
    private double bankBalance;

    public Person() {
        this.fullName = "Неизвестный гражданин";
        this.age = 0;
        this.passportNumber = "0000-000000";
        this.bankBalance = 0.0;
    }

    protected Person(String fullName, int age, String passportNumber, double bankBalance) {
        this.fullName = fullName;
        this.age = age;
        this.passportNumber = passportNumber;
        this.bankBalance = bankBalance;
    }

    public void introduceYourself() {
        System.out.println("Привет! Меня зовут " + fullName);
    }

    protected void celebrateBirthday() {
        this.age++;
        System.out.println(fullName + " празднует день рождения! Возраст: " + age);
    }

    void updatePassport(String newPassportNumber) {
        this.passportNumber = newPassportNumber;
    }

    private boolean hasGoodCreditHistory() {
        return this.bankBalance > 1000.0;
    }
}
