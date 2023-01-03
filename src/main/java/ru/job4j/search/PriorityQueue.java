package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {

        if (tasks.isEmpty()) {
            this.tasks.add(task);
        } else {
            int index = 0;
            int tasksSize = tasks.size();
            for (Task element : tasks) {
                if (task.getPriority() < element.getPriority() || index == tasksSize) {
                    this.tasks.add(index, task);
                    break;
                }
                index++;
            }
        }
    }

    public Task take() {
        return tasks.poll();
    }
}