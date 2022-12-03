package ru.job4j.oop;

public class Ball {
    public void tryRun(boolean condition) {
        if (condition) {
            System.out.println("Ball ran out");
        } else {
            System.out.println("Ball was eaten");
        }
    }
}
