public class AIUniquePlayer extends Player {

	/********************************************************/
	/* Constructor: AIUniquePlayer                          */
	/* Purpose: Create a default AIUniquePlayer            */
	/* Parameters:                                          */
	/*   none                                               */
	/********************************************************/
	public AIUniquePlayer() {
		this("AI Unique");
	}

	/********************************************************/
	/* Constructor: AIUniquePlayer                          */
	/* Purpose: Create a new AIUniquePlayer object         */
	/* Parameters:                                          */
	/*   String name:  the name of the Player being created */
	/********************************************************/
	public AIUniquePlayer(String name) {
		super(name);
	}

	/********************************************************/
	/* Method: play                                        */
	/* Purpose: Take one turn for this Player              */
	/*          AIUniquePlayer rolls at least twice        */
	/*          and possibly a third time if score < 12    */
	/* Parameters:                                         */
	/*   none                                              */
	/* Returns:                                           */
	/*   the score earned by the player on this turn,      */
	/*   which will be zero if a six was rolled           */
	/********************************************************/
	public int play() {
		int turnScore = 0;
		boolean rolledSix = false;

		System.out.print("   Player " + getName() + " rolls: ");

		// Roll at least twice
		for (int i = 0; i < 2; i++) {
			int roll = (int) (Math.random() * 6 + 1);
			System.out.print(roll + " ");
			if (roll == 6) {
				rolledSix = true;
				break;
			}
			turnScore += roll;
		}

		// Roll a third time if total so far is < 12
		if (!rolledSix && turnScore < 12) {
			int roll = (int) (Math.random() * 6 + 1);
			System.out.print(roll + " ");
			if (roll == 6) {
				rolledSix = true;
			} else {
				turnScore += roll;
			}
		}

		if (rolledSix) {
			System.out.println("and scored 0 for the turn.");
			return 0;
		} else {
			System.out.println("and scores " + turnScore + " for the turn.");
			return turnScore;
		}
	}
}
