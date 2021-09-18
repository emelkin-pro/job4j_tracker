package ru.job4j.condition;

public class Max {
    public static int max(int left, int right) {
        return left > right ? left : right;
    }

    public static int max(int first, int second, int third) {
        return first > second ? (first > third ? first : third) : (second > third ? second : third);
    }
}