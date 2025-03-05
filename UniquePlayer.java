/********************************************************/
/* Gabrielle Akers                                      */ 
/* COS 420, Spring 2025                                 */
/* Programming Assignment 1                             */
/* UniquePlayer class: extends Player class             */
/* UniquePlayer rolls 3 times every round               */
/*      See Kettering University, CS-101, Prog 6        */
/********************************************************/

public class UniquePlayer extends Player {
	/**
     * Default constructor for UniquePlayer.
     * Initializes the player with the name "Unique".
     */
    public UniquePlayer() {
        this("Unique");
    }

    /**
     * Constructs a UniquePlayer with a specified name.
     * 
     * @param name The name of the player.
     */
    public UniquePlayer(String name) {
        super(name);
    }

    /**
     * Simulates a turn for the UniquePlayer.
     * The player rolls a die up to three times unless a 6 is rolled first.
     * Rolling a 6 before the third roll resets the turn score to 0.
     * 
     * @return The total score accumulated in the turn.
     */
	public int play() {
		int counter  = 0;
		int countRoll = 0;
		int roll = 0;
		//Create die
		Dice die = new Dice(6);
		while (roll != 6 && countRoll != 3) {
			roll = die.roll();
			countRoll++;
			counter += roll;
			System.out.print("   Player " + getName() + " rolled " + roll );
			
			//Rolled 6
			if (roll == 6 && countRoll < 3) {
				counter = 0;
				System.out.println(" and scored 0 for the turn.");
			}
			else if (countRoll < 3){
				System.out.println(" and chose to continue rolling.");
			}
		}
		
		//Finished turn
		if(countRoll == 3) {
			System.out.println(" and chose not to continue, scoring " + counter + " for the turn.");
		}
		return counter;
	}
}
