package com.company;

public class BlackjackDealerHand extends Hand {
    private boolean isDealerTurn;   // variable to assign wither dealer turn is true or false
    private int dealerIteration = 1;     // 1 = not dealer turn; 0 = dealer turn - used to handle to where to start
                                    // iteration of for loop for toString and getValue methods

    // do I need to add dealerTurn as an argument?
    public BlackjackDealerHand(int maxCards) {
        super(maxCards);
    }

    // getter for isDealerTurn - may not be necessary for this game but created
    // to help me check my codes
    public boolean getDealerTurn() {
        return isDealerTurn;
    }

    // boolean to set whether dealer turn is true or false
    //      client code assigns this method as true --> wouldn't
    public void setDealerTurn(boolean dealerTurn) {
        isDealerTurn = dealerTurn;
    }

    @Override
    public int getValue() {
        int value = 0;   // place holder to store value of hand
        int numAce = 0;  // place holder to keep track of number of aces in hand

        // if true; re-assign dealerTurn to 0 to begin loop iteration to 0
        if (isDealerTurn) {
            dealerIteration = 0;
        }

        // loop through hand and handle each type of card and how to add to value
        //      for dealer hand, start iteration at 1 and get value to only include cards 2+
        for (int i = dealerIteration; i < getNumCards(); i++) {
            // System.out.println(i + " " + value);     this is extra code to see the iterations for coding

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
            //      if there is an ace, add a tally
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

    @Override
    public String toString() {
        String str = ""; // Initialize str with the empty String.

        // if true; re-assign dealerTurn to 0 to begin loop iteration to 0
        if (isDealerTurn) {
            dealerIteration = 0;
        }

        // if dealerTurn is 1 (not dealer turn), cover dealer's first card with 'XX'
        if (dealerIteration == 1) {
            str = "XX  " + str;
        }

        if (getNumCards() > 0) {
            // block off the first card with 'XX' and start loop at card 2 (iteration 1)
            for (int i = dealerIteration; i < getNumCards(); i++) {
                str += (getCard(i)); // Concatenate the card in position i to str,
                // implicitly calling the toString method in the Card class.

                if (i < getNumCards() - 1) { // If we're not at the last Card in the Hand,
                    str += "  "; // then concatenate a space to prepare for printing the next Card.
                }
            }
        }

        str += "  (value = " + getValue() + ")";

        return str;
    }
}


/*
Create a class for the dealer's hand.

The BlackjackHand class isn't exactly right for the dealer's hand, because we want to be able to hide the dealer's first
card when the hand is printed -- displaying the String "XX" instead of the card's usual string. This first card should be
hidden until the player's turn is done, at which point it should be revealed.

Create a new class for the dealer's hand, giving it the name BlackjackDealerHand. It should be a subclass of one of the
existing classes -- you'll need to figure out which one makes the most sense to extend. Your new class will inherit the
fields and methods of the class that it extends. You will need to decide whether your class needs any additional fields
or methods (it's possible that it won't), and which of the inherited methods should be overridden.

One field and method that you will need are a field that keeps track of whether or not the first card is currently being
hidden and a method that allows you to change the value of that field. Use appropriate names for both the field and the
method. In addition, you should override the toString method so that the dealer's hand will be printed correctly both during
and after the player's turn. Note that the total value of the dealer's hand should not be printed until after the first
card is revealed.

Once you have defined your BlackjackDealerHand class, modify the second line of the playHand method so that it uses the
new subclass for the dealer's hand. In addition, you will need to add whatever lines are needed to "reveal" the dealer's
first card after the player's turn is over. Compile and run the program to test the changes that you made for this task,
and make any additional changes as needed.
 */