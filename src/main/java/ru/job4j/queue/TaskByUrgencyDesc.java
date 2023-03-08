package ru.job4j.queue;

import java.util.Comparator;

public class TaskByUrgencyDesc implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
        return Integer.valueOf(o2.urgency()).compareTo(Integer.valueOf(o1.urgency()));
    }
}