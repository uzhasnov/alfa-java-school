package ru.alfabank.homework3;

public class PasswordsApp {
    public static void main(String[] args) {

        String[] passwords = {">cnfcFktrce", "UhepbntFgtkmcbysz", ",jxrfvb,#"};

        for (String password : passwords) {
            boolean isPasswordValid =
                    password.length() > 8
                    && !password.startsWith("1")
                    && !password.endsWith("z")
                    && !password.contains("1234")
                    && !password.contains("qwerty");

            System.out.printf("Пароль '%s' прошёл проверку: %s\n", password, isPasswordValid);
        }
    }
}
