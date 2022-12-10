package ru.job4j.decorator;

public class SuperPower extends SuperHeroDecorator {

    public SuperPower(SuperHero superHero) {
        super(superHero);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " с суперсилой";
    }

    @Override
    public int getChanceOfSurvival() {
        return super.getChanceOfSurvival() + 4;
    }
}
