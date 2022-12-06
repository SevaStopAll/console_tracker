package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("I am flying");
    }

    @Override
    public void sound() {
        System.out.println("Bjjjjjjjj");
    }
}
