package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже пешеходы по лужам...");
        } else if (position == 2) {
            System.out.println("Спокойной ночи, малыши!");
        } else {
            System.out.println("Песня не найдена.");
        }
    }

    public static void main(String[] args) {
        Jukebox walkman = new Jukebox();
        walkman.music(1);
        walkman.music(2);
        walkman.music(3);
    }
}
