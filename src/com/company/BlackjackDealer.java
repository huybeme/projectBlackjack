package com.company;

public class BlackjackDealer extends Player {

    @Override
    public boolean wantsHit(Hand ownHand, Hand opponentHand) {
        // if the opponent hand is less or equal than 21 and higher than own hand then draw
        //      this if the dealer == player, the dealer should not draw to tie the game.
        //      if the dealer has a value of less than 17 then dealer must draw a card
        return opponentHand.getValue() <= 21 && ownHand.getValue() < opponentHand.getValue() || ownHand.getValue() < 17;
    }
}
