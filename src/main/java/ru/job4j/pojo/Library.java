package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book hobbit = new Book("Hobbit", 260);
        Book conan = new Book("Conan The Barbarian", 400);
        Book dune = new Book("Dune", 460);
        Book cleanCode = new Book("Clean code", 500);
        Book[] library = new Book[4];
        library[0] = hobbit;
        library[1] = conan;
        library[2] = dune;
        library[3] = cleanCode;
        for (Book ourBook : library) {
            System.out.println(ourBook.getName() + " - " + ourBook.getPages());
        }
        Book temp = library[0];
        library[0] = library[3];
        library[3] = temp;
        for (Book ourBook : library) {
            System.out.println(ourBook.getName() + " - " + ourBook.getPages());
        }
        for (Book ourBook : library) {
            if (ourBook.getName().equals("Clean code")) {
                System.out.println(ourBook.getName() + " - " + ourBook.getPages());
            }
        }
    }
}
