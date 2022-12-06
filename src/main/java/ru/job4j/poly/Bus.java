package ru.job4j.poly;

public class Bus implements Transport {
    @Override
    public void go() {
        System.out.println("Wrum-wrum");
    }

    @Override
    public void enter(int passangers) {
        System.out.println("Now we have " + passangers + " passangers on board");
    }

    @Override
    public double refill(double fuel) {
        return fuel * 55;
    }
}
