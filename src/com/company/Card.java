package com.company;

/*
 * Card.java
 *
 * Computer Science 111, Boston University
 *
 * YOU SHOULD NOT MODIFY THIS FILE.
 */

public class Card {
    public static final int FIRST_TYPE = 1;
    public static final int LAST_TYPE = 13;
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    private static final String[] TYPE_STRINGS = {"", "A", "2", "3", "4", "5",
            "6", "7", "8", "9", "10", "J", "Q", "K"};

    public static final int FIRST_SUIT = 0;
    public static final int LAST_SUIT = 3;
    public static final int CLUBS = 0;
    public static final int DIAMONDS = 1;
    public static final int HEARTS = 2;
    public static final int SPADES = 3;
    private static final String[] SUIT_STRINGS = {"C", "D", "H", "S"};

    private int type;
    private int suit;

    public Card(int type, int suit) {
        if (type < FIRST_TYPE || type > LAST_TYPE) {
            throw new IllegalArgumentException("invalid type: " + type);
        }
        if (suit < FIRST_SUIT || suit > LAST_SUIT) {
            throw new IllegalArgumentException("invalid suit: " + suit);
        }
        this.type = type;
        this.suit = suit;
    }

    public int getDefaultValue() {
        return type;
    }

    public boolean isAce() {
        return (type == ACE);
    }

    public boolean isFaceCard() {
        return (type == JACK || type == QUEEN || type == KING);
    }

    public String toString() {
        return (TYPE_STRINGS[type] + SUIT_STRINGS[suit]);
    }

}