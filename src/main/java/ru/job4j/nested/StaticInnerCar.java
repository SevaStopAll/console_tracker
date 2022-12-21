package ru.job4j.nested;

public class StaticInnerCar {
    private String brand;
    private String model;
    private static String carManual = "Инструкция к автомобилю";

    public StaticInnerCar(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void startEngine() {
        System.out.println("Двигатель запущен");
    }

    public static TripComputer getTripComputer() {
        StaticInnerCar staticInnerCar = new StaticInnerCar("Марка", "Модель");
        StaticInnerCar.TripComputer tripComputer = staticInnerCar.new TripComputer();
        return tripComputer;
    }

    public class Transmission {

        public void accelerate() {
            System.out.println("Ускорение");
        }

    }

    public class Brakes {

        public void brake() {
            System.out.println("Торможение");
        }

    }

    public class TripComputer {

        public String info = "Бортовой компьютер";
        private String model = "Модель TripComputer";

        public void getInfo() {
            System.out.println("Модель TripComputer: " + this.model);
            System.out.println("Модель Car: " + StaticInnerCar.this.model);
        }

    }

    public static class Manual {
        public static String getManual() {
            return carManual;
        }
    }

}
