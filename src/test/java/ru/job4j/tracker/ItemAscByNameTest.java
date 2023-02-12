package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemAscByNameTest {

    @Test
    public void whenItemAscSortByName() {
        List<Item> items = Arrays.asList(
                new Item("C"),
                new Item("B"),
                new Item("A")
        );
        List<Item> expected = Arrays.asList(
                new Item("A"),
                new Item("B"),
                new Item("C")
        );
        items.sort(new ItemAscByName());
        assertEquals(items.get(0).getName(), expected.get(0).getName());
        assertEquals(items.get(1).getName(), expected.get(1).getName());
        assertEquals(items.get(2).getName(), expected.get(2).getName());
    }
}