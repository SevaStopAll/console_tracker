package ru.job4j.oop;

public class Error {
    private boolean active;
    private int status;
    private String message;

    public Error() {

    }

    public Error(boolean active, int status, String message) {
        this.active = active;
        this.status = status;
        this.message = message;
    }

    public void printInfo() {
        System.out.println("Is active? " + active);
        System.out.println("Error status: " + status);
        System.out.println("Printed message " + message);
    }

    public static void main(String[] args) {
        Error memory = new Error(true, 65, "Out of memory");
        Error random = new Error();
        Error router = new Error(true, 404, "Your router is switched off");
        memory.printInfo();
        random.printInfo();
        router.printInfo();
    }
}
