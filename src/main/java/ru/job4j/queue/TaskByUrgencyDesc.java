package ru.job4j.queue;

import java.util.Comparator;

public class TaskByUrgencyDesc implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        int rsl = 0;
        if (o2.urgency() > o1.urgency()) {
            rsl = 1;
        } else if (o2.urgency() < o1.urgency()) {
            rsl = -1;
        }
        return rsl;
    }
}