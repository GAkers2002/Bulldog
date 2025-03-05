/********************************************************/
/* Gabrielle Akers                                      */ 
/* COS 420, Spring 2025                                 */
/* Programming Assignment 1                             */
/* RandomPlayer class: extends Player class             */
/* RandomPlayer rolls a 2 sided die to determine if		*/
/*  it goes again                                       */
/*      See Kettering University, CS-101, Prog 6        */
/********************************************************/
public class RandomPlayer extends Player{
	/**
     * Default constructor for RandomPlayer.
     * Initializes the player with the name "Random".
     */
    public RandomPlayer() {
        this("Random");
    }

    /**
     * Constructs a RandomPlayer with a specified name.
     * 
     * @param name The name of the player.
     */
    public RandomPlayer(String name) {
        super(name);
    }

    /**
     * Simulates a turn for the RandomPlayer.
     * The player rolls a die and randomly decides whether to continue rolling or stop.
     * Rolling a 6 resets the turn score to 0.
     * 
     * @return The total score accumulated in the turn.
     */
	public int play() {
		int counter = 0;
		Dice die = new Dice(6);
		Dice coin = new Dice(2);
		int roll = die.roll();
		System.out.print("   Player " + getName() + " rolled " + roll );
		
		//create go again condition
		int goAgain = coin.roll();
		
		//stop rolling
		if (goAgain == 1) {
			counter += roll;
			System.out.println(" and chose not to continue, scoring " + counter + " for the turn.");
		}
		
		//rolled 6
		if (roll == 6) {
			roll = 0;
			counter = 0;
			System.out.println(" and scored 0 for the turn.");
		}
		
		//continue rolling
		if (roll != 6 && goAgain == 2) {
			counter += roll;
			while (goAgain == 2 && roll != 0) {
				System.out.println(" and chose to continue rolling.");
				roll = die.roll();
				System.out.print("   Player " + getName() + " rolled " + roll );
				counter += roll;
				//rolled 6
				if (roll == 6) {
					counter = 0;
					System.out.println(" and scored 0 for the turn.");
					return 0;
				}
				else {
					//create go again condition
					goAgain = coin.roll();
					//stop rolling
					if (goAgain == 1) {
						System.out.println(" and chose not to continue, scoring "  + counter + " for the turn.");
					}
				}
			}	
		} 
		return counter;
	}
}
