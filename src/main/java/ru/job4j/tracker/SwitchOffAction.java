package ru.job4j.tracker;

public class SwitchOffAction implements UserAction {

    @Override
    public String name() {
        return "Finish application";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return false;
    }
}