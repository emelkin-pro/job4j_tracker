package ru.job4j.stream;

public class Card {
    private CardDeck.Suit suit;
    private CardDeck.Value value;

    public Card(CardDeck.Suit suit, CardDeck.Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit=" + suit +
                ", value=" + value +
                '}';
    }
}