package ru.job4j.nested;

public class Bird {

    public void fly() {
        System.out.println("Птица летит");
    }

    public static void main(String[] args) {
            Bird parrot = new Bird() {
                @Override
                public void fly() {
                    System.out.println("Parrot is flying");
                }
            };
        }
}

