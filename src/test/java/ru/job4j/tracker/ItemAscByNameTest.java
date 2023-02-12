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
        assertEquals(items, expected);
    }
}