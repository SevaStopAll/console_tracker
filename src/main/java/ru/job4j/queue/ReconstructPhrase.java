package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder rsl = new StringBuilder();
        while (evenElements.size() != 0) {
            rsl.append(evenElements.pollFirst());
            evenElements.remove();
        }
        return rsl.toString();
    }

    private String getDescendingElements() {
        StringBuilder rsl = new StringBuilder();
        while (descendingElements.size() != 0) {
            rsl.append(descendingElements.pollLast());
        }
        return rsl.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
