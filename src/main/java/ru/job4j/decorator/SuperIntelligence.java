package ru.job4j.decorator;

public class SuperIntelligence extends SuperHeroDecorator {

    public SuperIntelligence(SuperHero superHero) {
        super(superHero);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " с суперинтеллектом";
    }

    @Override
    public int getChanceOfSurvival() {
        return super.getChanceOfSurvival() + 6;
    }
}
