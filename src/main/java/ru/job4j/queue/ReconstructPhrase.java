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
        String str = new String();
        for (Iterator iterator = evenElements.iterator(); iterator.hasNext(); ) {
            str = str + evenElements.poll();
            evenElements.poll();
        }
        return str;
    }

    private String getDescendingElements() {
        String str = new String();
        for (Iterator iterator = descendingElements.iterator(); iterator.hasNext(); ) {
            str = str + descendingElements.pollLast();
        }
        return str;
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}
