package ru.job4j.stream;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CardDeck {
    public enum Suit {
        Diamonds, Hearts, Spades, Clubs
    }

    public enum Value {
        V_6, V_7, V_8
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)))
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}
