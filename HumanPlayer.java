/********************************************************/
/* Gabrielle Akers                                      */ 
/* COS 420, Spring 2025                                 */
/* Programming Assignment 1                             */
/* HumanPlayer class: extends Player class              */
/* HumanPlayer prompts for user input to control turn   */
/*      See Kettering University, CS-101, Prog 6        */
/********************************************************/

import java.util.Scanner;

/**
 * The HumanPlayer class represents a player who manually decides 
 * whether to continue rolling based on user input.
 */
public class HumanPlayer extends Player {

    /**
     * Default constructor for HumanPlayer.
     * Initializes the player with the default name "Human".
     */
    public HumanPlayer() {
        this("Human");
    }

    /**
     * Constructor for HumanPlayer that allows specifying a custom name.
     * 
     * @param name The name of the player.
     */
    public HumanPlayer(String name) {
        super(name);
    }

    /**
     * Plays the turn for the HumanPlayer. The player rolls a die and is 
     * prompted to decide whether to roll again. The turn ends if they choose 
     * to stop rolling or roll a 6, which resets their turn score to 0.
     * 
     * @return The total score accumulated in this turn.
     */
	public int play() {
		int counter = 0;
		//Roll first time
		int roll = (int) (Math.random()*6 + 1);
		System.out.println("You rolled a " + roll );
		
		if (roll != 6) {
			//Ask user if they want to roll again
			Scanner askUser = new Scanner(System.in);
			System.out.println("Would you like to roll again? (Y/N): ");
			String goAgain = askUser.next();
			counter += roll;
			
			//Roll while conditions are met
			while (roll != 6 && !goAgain.equals("N")) {
				roll = (int) (Math.random()*6 + 1);
				System.out.println("You rolled a " + roll );
				counter += roll;
				if (roll != 6) {
					askUser = new Scanner(System.in);
					System.out.println("Would you like to roll again? (Y/N): ");
					goAgain = askUser.next();
				}
			}
			
			//Choose to stop rolling
			if (goAgain.equals("N")) {
				System.out.println("You chose not to continue and scored " + counter + " for the turn.");
			}
			
			//Rolled 6
			if (roll == 6) {
				System.out.println("You scored 0 for the turn.");
				counter = 0;
			}
		}
		return counter;
	}
}
