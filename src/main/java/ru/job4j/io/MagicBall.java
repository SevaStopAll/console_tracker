package ru.job4j.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Я Великий Оракул! Что ты хочешь узнать?");
        String question = sc.nextLine();
        int answer = new Random().nextInt(3);
        switch (answer) {
            case (0) -> System.out.println("Да");
            case (1) -> System.out.println("Нет");
            default -> System.out.println("Может быть");
        }
        sc.close();
    }
}
