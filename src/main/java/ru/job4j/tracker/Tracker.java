package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] newItems = new Item[items.length];
        int newItemSize = 0;
        for (Item item :
                items) {
            if (item != null) {
                if (key.equals(item.getName())) {
                    newItems[newItemSize] = item;
                    newItemSize++;
                }
            }
        }
        return Arrays.copyOf(newItems, newItemSize);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int itemsId = indexOf(id);
        boolean wasReplaced = false;
        if (itemsId != -1) {
            item.setOldID(item.getId());
            item.setId(id);
            items[itemsId] = item;
            wasReplaced = true;
        }
        return wasReplaced;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean wasDeleted = false;
        if (index != -1) {
            System.arraycopy(items, index + 1, items, index, size - index - 1);
            items[size - 1] = null;
            size--;
            wasDeleted = true;
        }
        return wasDeleted;
    }

}