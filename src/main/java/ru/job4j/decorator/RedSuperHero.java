package ru.job4j.decorator;

public class RedSuperHero implements SuperHero {
    @Override
    public String getDescription() {
        return "Красный супергерой";
    }

    @Override
    public int getChanceOfSurvival() {
        return 52;
    }
}
