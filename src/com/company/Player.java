package com.company;

/*
 * Player.java
 *
 * Computer Science 111, Boston University
 *
 * YOU SHOULD NOT MODIFY THIS FILE.
 */

/* An abstract class
 * Abstract classes have a header of the form
 *
 * public abstract class ClassName
 *
 * Abstract classes contain abstract methods
 * Abstract classes cannot be instantiated
 * We cannot use an abstract class to make instances of the class.
 * We cannot use the abstract Player class to make Player objects.
 * An abstract method must serve as a superclass.
 *
 */


public abstract class Player {
    public abstract boolean wantsHit(Hand ownHand, Hand opponentHand);
    /* Abstract methods are defined with the abstract key word.
     * An abstract method has no body
     * The abstract method is a header followed by a semicolon.
     * The abstract method must be overridden in a subclass.
     */
}


/*
Task 4

Create subclasses of Player.

The version of Blackjack.java that we gave you uses RecklessPlayer objects for the two players. This subclass of the abstract
Player superclass has a very simplistic version of the wantsHit method that always returns true -- which is why it produces
reckless behavior by both the player and the dealer.

Create two new subclasses of Player: one for the user of the program (call it ConsolePlayer), and one for the dealer (call
it BlackjackDealer), and give them appropriate implementations of the wantsHit method.

The ConsolePlayer class should have a field for a Scanner object that it will use to read from the console. The Scanner
should be passed in as a parameter to the ConsolePlayer constructor, and the constructor should assign it to the field in
the ConsolePlayer object. (Don't forget to include an import statement for the java.util package at the top of the file
for this class.) The wantsHit method for this class method should ask the user if he/she wants another hit and use the
Scanner to read the user's reply. A reply of "y" should cause the method to return true, and any other reply should cause
the method to return false.

The BlackjackDealer class does not need and should not have a constructor or any additional fields. Its implementation of
the wantsHit method should use the two hands passed in as parameters to determine if the dealer should give herself another
hit, and return true or false accordingly. See the section entitled "Rules of the game" to see when the dealer should take
another hit and when she should hold.

Once you have these subclasses implemented, change the lines in the main method of Blackjack.java that create the two player
objects, and change them so that they create instances of your new subclasses, rather than RecklessPlayer objects. Here again,
you should compile and run the program and make whatever additional changes are needed to make them work correctly.
 */