package ru.job4j.queue;

import java.util.Deque;
import java.util.Iterator;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        StringBuilder str = new StringBuilder("");
        for (Iterator iterator = evenElements.iterator();
             iterator.hasNext();
        ) {
            str.append(evenElements.poll());
            evenElements.poll();
        }
        return String.valueOf(str);
    }

    private String getDescendingElements() {
        StringBuilder str = new StringBuilder("");
        for (Iterator iterator = descendingElements.iterator();
             iterator.hasNext();
        ) {
            str.append(descendingElements.pollLast());
        }
        return String.valueOf(str);
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
