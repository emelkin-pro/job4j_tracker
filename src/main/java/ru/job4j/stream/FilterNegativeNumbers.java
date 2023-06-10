package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(3, 2, 2, -127, 27, -99, 42, -455, 99, 0, 10, -100);
        List<Integer> positive = numbers.stream().filter(s -> s > 0).collect(Collectors.toList());
        positive.forEach(System.out::println);
    }
}