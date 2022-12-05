package ru.job4j.tracker;

public class StubInput implements Input {

    @Override
    public String ask(String question) {
        return null;
    }

    @Override
    public int askInt(String question) {
        return 0;
    }
}
