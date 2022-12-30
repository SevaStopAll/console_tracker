package ru.job4j.poly;

public class Vehicles {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle coach = new Coach();
        Vehicle plane = new Plane();
        Vehicle car2 = new Car();
        Vehicle coach2 = new Coach();
        Vehicle plane2 = new Plane();
        Vehicle[] array = {car, car2, coach2, coach, plane2, plane};
        for (Vehicle vehicle : array) {
            vehicle.sound();
            vehicle.move();
        }
    }
}
