package com.company;
import java.util.*;

public class Scratch {

    public static void main(String[] args) {
        Card c1 = new Card(4, 1);
        Card c2 = new Card(Card.KING, 1);
        Card c3 = new Card(Card.ACE, 1);
        Card c4 = new Card(Card.ACE, 3);
        Card c5 = new Card(Card.QUEEN, 2);
        Card c6 = new Card(Card.QUEEN, 0);
        Card c7 = new Card(3, 2);
        Card c8 = new Card(6, 1);
        Card c9 = new Card(5, 1);

        Hand player = new BlackjackHand();
        Hand player2 = new BlackjackHand();
        Hand player3 = new BlackjackHand();
        Hand player4 = new BlackjackHand();
        Hand player5 = new BlackjackHand();
        Hand player6 = new BlackjackHand();
        BlackjackHand player7 = new BlackjackHand();
        BlackjackDealerHand dealer = new BlackjackDealerHand();
        BlackjackHand player8 = new BlackjackHand();

        // value = 4 + J
        player.addCard(c1);
        player.addCard(c2);
        player.addCard(c3);
        System.out.println("player 1: " + player);
        System.out.println();

        // value = Ace + Ace        try to make this = to 2 and not 22
        player2.addCard(c3);
        player2.addCard(c4);
        player2.addCard(c3);
        System.out.println("player 2: " + player2);
        System.out.println();

        // value = Q + Q
        player3.addCard(c5);
        player3.addCard(c6);
        player3.addCard(c5);
        player3.addCard(c4);
        player3.addCard(c4);
        System.out.println("player 3: " + player3);
        System.out.println();

        // value = Q + A        try to make this = 21
        player4.addCard(c3);
        player4.addCard(c5);
        System.out.println("player 4: " + player4);
        System.out.println();

        player5.addCard(c1);
        player5.addCard(c1);
        System.out.println("player 5: " + player5);
        System.out.println();

        player6.addCard(c4);
        player6.addCard(c1);
        player6.addCard(c8);
        player6.addCard(c7);
        System.out.println("player 6: " + player6);
        System.out.println();

        System.out.println(c4.isAce());
        System.out.println(c6.isFaceCard());
        System.out.println(player4.getValue());     // want it to return 2 or 21
        System.out.println();

        dealer.addCard(c3);
//        dealer.addCard(c8);
        dealer.addCard(c5);
//        dealer.addCard(c5);
        //dealer.setDealerTurn(false);  // should be false by default
        System.out.println("dealer: " + dealer + "(" + dealer.getDealerTurn() + ")");
        dealer.setDealerTurn(true);
        System.out.println("dealer: " + dealer + "(" + dealer.getDealerTurn() + ")");
        System.out.println();


        player7.addCard(c2);
        player7.addCard(c3);
//        player7.addCard(c9);
        System.out.println("player 7: " + player7);
        System.out.println(player7.getBlackjack());
//        player7.setBlackjack();
        System.out.println(player7.getBlackjack());
        System.out.println();




        System.out.println("Welcome to the game of Blackjack!");
        System.out.println();
        Scanner console = new Scanner(System.in);

        System.out.println(dealer.getBlackjack());
        System.out.println(player7.getBlackjack());


        // Next it's the dealer's turn.
        // if player has blackjack, dealer will not continue to play
        if (player7.getBlackjack()) {
            dealer.setDealerTurn(false);
        }
        else {dealer.setDealerTurn(true);}    // You will need to uncomment this command when you have written
        // the method setDealerTurn in the appropriate class.
        displayHands(dealer, player7); // The dealer reveals her hidden card.


        // Print the outcome of the hand of blackjack.
        printResult(player7, dealer);
    }

    /* The printResult method
     * Modify this method to print the outcome of the hand of blackjack.
     */

    private static void printResult(BlackjackHand playerHand, BlackjackDealerHand dealerHand) {
        int playerScore = playerHand.getValue();
        int dealerScore = dealerHand.getValue();
        boolean blackjackPlayer = playerHand.getBlackjack();

        // if you draw greater than 21, you bust (lose)
        if (playerScore > 21) {
            System.out.println("You Bust!");
            // prompts if dealer also has blackjack but dealer will prompt winning either way
            if (dealerHand.getBlackjack()) {
                System.out.println("Dealer has blackjack!");
            }
            System.out.println("Dealer wins!");
        }
        // Here is how we handle if we get equal values for each player
        else if (playerScore == dealerScore) {
            // if both player and dealer has blackjack, then its a push.
            if (dealerHand.getBlackjack() && playerHand.getBlackjack()) {
                System.out.println("Both player and dealer have blackjack!");
                System.out.println("Push! It's a draw!");
            }
            // if player has 21 and not by a blackjack but dealer has blackjack, dealer wins
            else if (dealerHand.getBlackjack() && playerHand.getValue() == 21 && playerHand.getNumCards() > 2) {
                System.out.println("Dealer has blackjack!");
                System.out.println("Dealer wins!");
            }
            // if its just a outright tie, it's a draw.
            else {
                System.out.println("Push! It's a draw!");
            }
        }
        // Here we begin to determine if player wins or the dealer wins and its not a draw
        //      if player is higher than dealer without going over 21, player wins
        else if (playerScore > dealerScore || dealerScore > 21) {
            if (dealerScore > 21) {
                System.out.println("Dealer bust!");
            }
            System.out.println("You win!");
        }
        //      if dealer is higher than player, dealer wins
        else if (playerScore < dealerScore) {
            if (dealerHand.getBlackjack()) {
                System.out.println("Dealer has blackjack!");
            }
            System.out.println("Dealer wins.");
        }
        System.out.println();

        //System.out.println("You win or lose!");
    }

    /* The displayHands method prints the contents of each player's hand and the corresponding
     *  value.  Note java automatically calls the toString method on a Hand object.
     */
    private static void displayHands(Hand dealerHand, Hand playerHand) {
        System.out.println("dealer: " + dealerHand);
        System.out.println("player: " + playerHand);
        System.out.println();
    }




    // my code
    public static boolean pairAce(Hand h) {
        int i, j;

        if (2 > 1) {
            for (i = 0; i < h.getNumCards(); i++)
                for (j = i + 1; j < h.getNumCards(); j++)
                    if (h.getCard(i).getDefaultValue() == h.getCard(j).getDefaultValue() && h.getCard(i).isAce())
                        return true;
        }
        return false;

    }


}
