package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

enum Value {
    V_6, V_7, V_8
}

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

public class Card {
    private  Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Card{"
               + "suit=" + suit
               + ", value=" + value
               + '}';
    }

    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> new Card(suit, value)))
                .forEach(cards::add);
        cards.forEach(System.out::println);
    }
}



