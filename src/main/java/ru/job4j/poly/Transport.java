package ru.job4j.poly;

public interface Transport {
    public void go();

    public void enter(int passangers);

    public double refill(double fuel);
}
