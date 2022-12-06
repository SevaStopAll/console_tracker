package ru.job4j.poly;

public class Coach implements Vehicle {
    @Override
    public void move() {
        System.out.println("I am moving quite slowly");
    }

    @Override
    public void sound() {
        System.out.println("Beep-beep");

    }
}
