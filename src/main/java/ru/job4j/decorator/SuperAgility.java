package ru.job4j.decorator;

public class SuperAgility extends SuperHeroDecorator {

    public SuperAgility(SuperHero superHero) {
        super(superHero);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " с суперловкостью";
    }

    @Override
    public int getChanceOfSurvival() {
        return super.getChanceOfSurvival() + 3;
    }
}
