package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        int leftEndCut = 0;
        int rightEndCut = 0;

        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) == '.') {
                leftEndCut = i;
                break;
            }
        }
        for (int i = 0; i < right.length(); i++) {
            if (right.charAt(i) == '.') {
                rightEndCut = i;
                break;
            }
        }

        int newLeft = Integer.parseInt(left.substring(0, leftEndCut));
        int newRight = Integer.parseInt(right.substring(0, rightEndCut));

        return Integer.compare(newLeft, newRight);
    }
}