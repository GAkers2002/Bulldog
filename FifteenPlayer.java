/********************************************************/
/* Gabrielle Akers                                      */ 
/* COS 420, Spring 2025                                 */
/* Programming Assignment 1                             */
/* FifteenPlayer class: extends Player class            */
/* FifteenPlayer rolls until turn score is at least 15  */
/*      See Kettering University, CS-101, Prog 6        */
/********************************************************/
/**
 * The FifteenPlayer class represents a player who rolls the dice 
 * until their turn score reaches at least 15, unless a roll of 6 resets the turn.
 */
public class FifteenPlayer extends Player {

    /**
     * Default constructor for FifteenPlayer.
     * Initializes the player with the default name "Fifteen".
     */
    public FifteenPlayer() {
        this("Fifteen");
    }

    /**
     * Constructor for FifteenPlayer that allows specifying a custom name.
     * 
     * @param name The name of the player.
     */
    public FifteenPlayer(String name) {
        super(name);
    }

    /**
     * Plays the turn for the FifteenPlayer. The player rolls the dice until 
     * they either roll a 6 (resetting their turn score to 0) or their turn 
     * score reaches at least 15.
     * 
     * @return The total score accumulated in this turn.
     */
	public int play() {
		int counter = 0;
		int roll = (int) (Math.random()*6 + 1);
		System.out.print("   Player " + getName() + " rolled " + roll );
		counter += roll;
		
		//Rolled 6
		if (roll == 6) {
			counter = 0;
			System.out.println(" and scored 0 for the turn.");
		}
		else {
			System.out.println(" and chose to continue rolling.");
		}
		
		//keep rolling condition
		while (counter <= 15 && roll != 6) {
			roll = (int) (Math.random()*6 + 1);
			System.out.print("   Player " + getName() + " rolled " + roll );
			if (roll == 6) {
				counter = 0;
				System.out.println(" and scored 0 for the turn.");
			}
			else {
				counter += roll;
				System.out.println(" and chose to continue rolling.");
			}
		}
		if (counter >= 15) {
			System.out.println(" and chose not to continue, scoring " + counter + " for the turn.");
		}	
		return counter;
	}
}
