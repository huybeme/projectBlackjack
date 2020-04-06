package com.company;

/*
 * Hand.java
 *
 * Computer Science 111, Boston University
 * modified by: Laura K. Gross, laura.gross@bridgew.edu, November 14, 2018
 *
 * YOU SHOULD NOT MODIFY THIS FILE.
 */

public class Hand {
    private Card[] cards;
    private int numCards;

    public Hand(int maxCards) {
        cards = new Card[maxCards]; // Array of Cards that is ready to hold some maximum number of possible Cards
        numCards = 0; // number of Cards currently in the Hand
    }

    public void addCard(Card c) {
        if (c == null) {
            throw new IllegalArgumentException("parameter must be non-null");
        }
        if (numCards == cards.length) {
            throw new IllegalStateException("no room for more cards in hand");
        }
        cards[numCards] = c; // Note that initially numCards is 0.
        numCards++; // Increment to reflect that the hand now has one additional card.
    }

    public int getValue() {
        int value = 0;
        for (int i = 0; i < numCards; i++) {
            value += cards[i].getDefaultValue();
        }
        return value;
    }

    public int getNumCards() {
        return numCards;
    }

    public Card getCard(int i) { // Get ith card in the hand, as indexed 0 through numCards < maxCards.
        if (i < 0 || i > numCards) {
            throw new IllegalArgumentException("invalid index: " + i);
        }
        return cards[i];
    }

    public String toString() {
        String str = ""; // Initialize str with the empty String.

        for (int i = 0; i < numCards; i++) {
            str += (cards[i]); // Concatenate the card in position i to str,
            // implicitly calling the toString method in the Card class.

            if (i < numCards - 1) { // If we're not at the last Card in the Hand,
                str += "  "; // then concatenate a space to prepare for printing the next Card.
            }
        }

        str += "  (value = " + getValue() + ")";

        return str;
    }

}
