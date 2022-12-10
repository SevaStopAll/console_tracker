package ru.job4j.decorator;

public class GreenSuperHero implements SuperHero {
    @Override
    public String getDescription() {
        return "Зелёный супергерой";
    }

    @Override
    public int getChanceOfSurvival() {
        return 50;
    }
}
