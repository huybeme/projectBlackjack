package com.company;

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

        Hand player = new BlackjackHand(20);
        Hand player2 = new BlackjackHand( 20);
        Hand player3 = new BlackjackHand(20);
        Hand player4 = new BlackjackHand(20);
        Hand player5 = new BlackjackHand(20);
        Hand player6 = new BlackjackHand(20);
        Hand player7 = new BlackjackHand(20);
        BlackjackDealerHand dealer = new BlackjackDealerHand(20);

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
        dealer.addCard(c8);
        dealer.addCard(c5);
        dealer.setDealerTurn(false);
        System.out.println("dealer: " + dealer + "(" + dealer.getDealerTurn() + ")");
        dealer.setDealerTurn(true);
        System.out.println("dealer: " + dealer + "(" + dealer.getDealerTurn() + ")");
        System.out.println();

        player7.addCard(c2);
        player7.addCard(c3);
        System.out.println(player7);
//        System.out.println(player7.getBlackjack());
//        player7.setBlackjack();
//        System.out.println(player7.getBlackjack());


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
