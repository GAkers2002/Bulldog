import java.util.ArrayList;
import java.util.Scanner;

public class Bulldog {

	/********************************************************/
	/* Method: main                                         */
	/* Purpose: Entry point of the game                     */
	/* Parameters:                                          */
	/*   String[] args: command-line arguments (unused)     */
	/********************************************************/
	public static void main(String[] args) {
		// Create list of available player types
		ArrayList<Player> players = new ArrayList<>();
		
		// Prompt user for number of players and types
		ArrayList<Player> userPlayers = playerPrompt();
		
		// Start the game with selected players
		playGame(userPlayers);
	}

	/********************************************************/
	/* Method: playerPrompt                                 */
	/* Purpose: Prompt user for number of players and types */
	/* Returns:                                            */
	/*   ArrayList<Player> - List of chosen players        */
	/********************************************************/
	public static ArrayList<Player> playerPrompt() {
		ArrayList<Player> inGame = new ArrayList<>();
		Scanner input = new Scanner(System.in);

		// Ask for number of players
		System.out.println("How many players will be playing?");
		int numPlayers = input.nextInt();

		// Loop to add players based on user choice
		for (int i = 0; i < numPlayers; i++) {
			boolean validChoice = false;
			while (!validChoice) {
				System.out.println("Choose a player type: \n"
						+ "\tHuman \n"
						+ "\tFifteen \n"
						+ "\tRandom \n"
						+ "\tUnique \n"
						+ "\tAIUnique \n"
						+ "\tWimp");
				String choice = input.next().toLowerCase();

				switch (choice) {
					case "human":
						inGame.add(new HumanPlayer());
						validChoice = true;
						break;
					case "fifteen":
						inGame.add(new FifteenPlayer());
						validChoice = true;
						break;
					case "random":
						inGame.add(new RandomPlayer());
						validChoice = true;
						break;
					case "unique":
						inGame.add(new UniquePlayer());
						validChoice = true;
						break;
					case "aiunique":
						inGame.add(new AIUniquePlayer());
						validChoice = true;
						break;
					case "wimp":
						inGame.add(new WimpPlayer());
						validChoice = true;
						break;
					default:
						System.out.println("Invalid choice. Please enter a valid player type.");
				}
			}
		}
		return inGame;
	}

	/********************************************************/
	/* Method: playGame                                     */
	/* Purpose: Runs the main game loop                    */
	/* Parameters:                                          */
	/*   ArrayList<Player> players - List of active players */
	/********************************************************/
	public static void playGame(ArrayList<Player> players) {
		final int MAX_SCORE = 104;
		boolean gameOver = false;

		System.out.println("\nGame Start!");

		while (!gameOver) {
			for (Player player : players) {
				int turnScore = player.play();
				int newScore = player.getScore() + turnScore;
				player.setScore(newScore);

				System.out.println("   Player " + player.getName() + " now has " + newScore + " points.\n");

				// Check for winning condition
				if (newScore >= MAX_SCORE) {
					System.out.println("\nGame Over! " + player.getName() + " wins with a score of " + newScore + "!");
					gameOver = true;
					break; // End the game immediately
				}
			}
		}
	}
}
