package ru.job4j.queue;

import java.util.Queue;

public class ReconstructPhrase {

    private final Queue<Character> descendingElements;

    private final Queue<Character> evenElements;

    public ReconstructPhrase(Queue<Character> descendingElements, Queue<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        return "";
    }

    private String getDescendingElements() {
        return "";
    }

    public String getReconstructPhrase() {
        return getDescendingElements() + getEvenElements();
    }
}
