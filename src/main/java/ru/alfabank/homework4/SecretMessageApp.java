package ru.alfabank.homework4;

import java.util.Scanner;

public class SecretMessageApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String messagePart;

        for (int i = 0; i < 5; i++) {
            System.out.print("Введите часть закодированного сообщения: ");
            messagePart = input.nextLine();
            if (messagePart.equalsIgnoreCase("NULL")) {
                sb.append("XX");
            } else {
                sb.append(messagePart);
            }
            if (i == 4) {
                break;
            }
            sb.append('#');
        }
        System.out.printf("Расшифрованное послание: %s", sb);
    }
}
