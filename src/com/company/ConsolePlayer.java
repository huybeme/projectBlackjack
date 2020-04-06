package com.company;
import java.util.Scanner;

public class ConsolePlayer extends Player {

    @Override
    public boolean wantsHit(Hand ownHand, Hand opponentHand) {
        Scanner keyboard = new Scanner(System.in);
        String playerInput;

        System.out.println("Would you like to draw another Card?");
        System.out.print("Enter 'Y' to hit. ");
        playerInput = keyboard.next();
        System.out.println();

        return playerInput.charAt(0) == 'Y' || playerInput.charAt(0) == 'y';
    }
}
