package ru.job4j.decorator;

public abstract class SuperHeroDecorator implements SuperHero {
    protected final SuperHero superHero;

    public SuperHeroDecorator(SuperHero superHero) {
        this.superHero = superHero;
    }

    @Override
    public String getDescription() {
        return superHero.getDescription();
    }

    @Override
    public int getChanceOfSurvival() {
        return superHero.getChanceOfSurvival();
    }
}
