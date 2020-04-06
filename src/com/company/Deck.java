package com.company;

/*
 * Deck.java
 *
 * Computer Science 111, Boston University
 * modified by: Laura K. Gross, laura.gross@bridgew.edu, November 14, 2018
 *
 * YOU SHOULD NOT MODIFY THIS FILE.
 */

import java.util.*;

public class Deck {
    public static final int NUM_CARDS = 52;

    private Card[] cards;
    private int cardsLeft; // number of cards remaining
    private Random rand; // a random-number generator used when shuffling

    public Deck() {
        cards = new Card[NUM_CARDS]; // Make a NUM_CARDS-element (e.g. 52-element) array called cards.
        int count = 0;

        for (int suit = Card.FIRST_SUIT; suit <= Card.LAST_SUIT; suit++) {  // For each suit
            for (int type = Card.FIRST_TYPE; type <= Card.LAST_TYPE; type++) { // for each type of card
                // make an element in the array be a card with that suit and type.
                cards[count] = new Card(type, suit);
                count++;
            }
        }

        cardsLeft = 52;
        rand = new Random();
    }

    public void reset() {
        cardsLeft = 52;
    }

    public void shuffle() {
        // For each position in the array, swap the Card in that
        // position with the Card in a randomly selected position.
        for (int i = 0; i < 52; i++) {
            int swapWith = rand.nextInt(52);  // generates an index 0–51 inclusive
            Card temp = cards[i];
            cards[i] = cards[swapWith];
            cards[swapWith] = temp;
        }
    }

    public Card dealCard() {
        if (cardsLeft > 0) { // The deck constructor initially sets cardsLeft to be 52.
            cardsLeft--; // Decrement the number of cards left in the deck,
            return cards[cardsLeft]; // and return the last card remaining undealt in the cards array.
        } else { // If there are no cards left in the array after the decrement
            return null; // then return null.
        }
    }

    public boolean isEmpty() {
        return (cardsLeft == 0);
    }

    public int getCardsLeft() {
        return cardsLeft;
    }
}
