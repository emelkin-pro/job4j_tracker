package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemDescByNameTest {
    @Test
    public void whenItemDescSortByName() {
        List<Item> items = Arrays.asList(
                new Item("A"),
                new Item("C"),
                new Item("C"),
                new Item("F"),
                new Item("B")
        );
        List<Item> expected = Arrays.asList(
                new Item("F"),
                new Item("C"),
                new Item("C"),
                new Item("B"),
                new Item("A")
        );
        items.sort(new ItemDescByName());
        assertEquals(items, expected);
    }
}