package ru.job4j.condition;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MaxTest {
    @Test
    public void whenMax1To2Then2() {
        int left = 1;
        int right = 2;
        int result = Max.max(left, right);
        int expected = 2;
        assertEquals(result, expected);
    }

    @Test
    public void whenMax3To2Then3() {
        int left = 3;
        int right = 2;
        int result = Max.max(left, right);
        int expected = 3;
        assertEquals(result, expected);
    }

    @Test
    public void whenMax4To4Then4() {
        int left = 4;
        int right = 4;
        int result = Max.max(left, right);
        int expected = 4;
        assertEquals(result, expected);
    }

    @Test
    public void whenMax5To4and4() {
        int first = 4;
        int second = 4;
        int third = 5;
        int result = Max.max(first, second, third);
        int expected = 5;
        assertEquals(result, expected);
    }

    @Test
    public void whenMax7To1and3() {
        int first = 7;
        int second = 1;
        int third = 3;
        int result = Max.max(first, second, third);
        int expected = 7;
        assertEquals(result, expected);
    }

    @Test
    public void whenMax11To2and9() {
        int first = 2;
        int second = 11;
        int third = 9;
        int result = Max.max(first, second, third);
        int expected = 11;
        assertEquals(result, expected);
    }

    @Test
    public void whenMax11To2and9an9() {
        int first = 2;
        int second = 11;
        int third = 9;
        int fourth = 9;
        int result = Max.max(first, second, third, fourth);
        int expected = 11;
        assertEquals(result, expected);
    }

    @Test
    public void whenMax6To1and2an3() {
        int first = 5;
        int second = 1;
        int third = 2;
        int fourth = 3;
        int result = Max.max(first, second, third, fourth);
        int expected = 5;
        assertEquals(result, expected);
    }

}