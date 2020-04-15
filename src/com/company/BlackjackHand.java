package com.company;

public class BlackjackHand extends Hand {
    public boolean blackjack;

    public BlackjackHand() {
        super(20);    // inherit maxCards from superclass
    }

    // this will only be true when the setBlackjack method is called by client code
    public boolean getBlackjack() {
        return blackjack;
    }

    // when this method is called in the client code, it will return true otherwise its false by default
    public void setBlackjack() {
        blackjack = true;
    }


    @Override
    public int getValue() {
        int value = 0;   // place holder to store value of hand
        int numAce = 0;  // place holder to keep track of number of aces in hand

        // loop through hand and handle each type of card and how to add to value based on card
        for (int i = 0; i < getNumCards(); i++) {
            // System.out.println(i + " " + value);     this is extra code to see the iterations for coding - delete if requested by professor

            // if there is a face card, add 10
            if (getCard(i).isFaceCard()){
                value = value + 10;
            }

            // if it is not a face card or an ace, keep the original value
            else if (!getCard(i).isAce() && !getCard(i).isFaceCard()) {
                value = value + getCard(i).getDefaultValue();
            }

            // determine how many aces are in hand and multiply by 11.
            //      we should assume ace is high unless it'll make us bust
            //      if there is an ace, add a tally to numAce
            else if (getCard(i).isAce()) {
                value = value + 11;
                numAce++;
            }
        }

        // if you have an ace and bust, cut the value by 10 (reducing value of ace to 1)
        //      if you still bust and have another ace, keep cutting the value by 10
        //      numAce allows control for while loop to only iterate for every ace
        //      is in hand
        for (int i = 0; i < getNumCards(); i++) {
            while (value > 21 && getCard(i).isAce() && numAce != 0) {
                numAce--;
                value = value - 10;
            }
        }
        return value;
    }

}


/* Task 2

Your BlackjackHand class will inherit the fields and methods of the Hand class. You will need to decide whether your class
needs any additional fields or methods (it's possible that it won't), and which of the inherited methods should be overridden.
One method that must be overridden is the getValue method. The inherited method uses the default values of the cards (see the
 description of the Card class above). You will need to write a new version of the method that uses the Blackjack-specific
 values to the cards. One tricky aspect of this method is handling any Aces that may be present in the hand, since these cards
 may have a value of 11 or 1, and the value of a given Ace depends on the values of the rest of the cards in the hand.
 Hint: if there is more than one Ace in the hand, at most one of them can have a value of 11.

Don't forget that any new methods that you define will not have direct access to the fields in the superclass. For example,
methods in the subclass cannot directly access the cards array from the superclass. Instead, they will need to make use of
the getCard method to access the cards in that array.

In addition to overriding one or more methods, you will also need to define a constructor for your subclass. This constructor
does not need any parameters of its own, and it should invoke the superclass constructor so that the superclass constructor
can initialize the fields defined in the superclass. Use a value of 20 for the parameter of the superclass constructor, which
will create a hand that can hold up to 20 cards.

Once you have defined your BlackjackHand class, modify the two lines at the beginning of the playHand method in Blackjack.java
so that they create objects using your new subclass instead of the Hand class. Compile and run the program, and check to make
sure that the values given for the hands are now correct. Make any corrections that are needed to produce the correct values.
 */