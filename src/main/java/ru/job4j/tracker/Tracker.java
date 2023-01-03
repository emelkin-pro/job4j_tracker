package ru.job4j.tracker;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items.add(item);
        size++;
        return item;
    }

    public List<Item> findAll() {
        return items;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[size];
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (key.equals(items.get(i).getName())) {
                result[count++] = items.get(i);
            }
        }
        return Arrays.copyOf(result, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        int index = 0;
        for (Item item : items) {
            if (item.getId() == id) {
                rsl = index;
                break;
            }
            index++;
        }
        return rsl;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean replaced = index != -1;
        if (replaced) {
            item.setId(id);
            items.set(index, item);
        }
        return replaced;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean deleted = index != -1;
        if (deleted) {
            items.remove(index);
            size--;
        }
        return deleted;
    }

}