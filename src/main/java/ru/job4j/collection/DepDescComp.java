package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1Array = o1.split("/");
        String[] o2Array = o2.split("/");
        int index = o2Array[0].compareTo(o1Array[0]);
        if (index != 0) {
            return index;
        }
        for (int i = 1; i < o2Array.length; i++) {
            if (i == o1Array.length) {
                return -1;
            }
            index = o1Array[i].compareTo(o2Array[i]);
            if (index != 0) {
                return index;
            }
        }

        return index;
    }
}
