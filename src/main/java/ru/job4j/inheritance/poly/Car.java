package ru.job4j.inheritance.poly;

public class Car implements Vehicle {

    @Override
    public void move() {
        System.out.println("I am moving fast");
    }

    @Override
    public void sound() {
        System.out.println("Wrum-wrum");
    }
}
