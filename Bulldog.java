/********************************************************/
/* Gabrielle Akers                                      */ 
/* COS 420, Spring 2025                                 */
/* Programming Assignment 1                             */
/* Bulldog class:                                       */
/* Main game logic. Starts a game with the              */
/* specified players                                    */
/*      See Kettering University, CS-101, Prog 6        */
/********************************************************/
import java.util.ArrayList;
import java.util.Scanner;

public class Bulldog {
	/**
     * The main method initializes the game by creating players, prompting user input,
     * and starting the game UI.
     * 
     * @param args Command-line arguments (not used)
     */
	public static void main(String[] args) {
		// Create all players
		Player human = new HumanPlayer();
		Player fifteen = new FifteenPlayer();
		Player random = new RandomPlayer();
		Player unique = new UniquePlayer();
		Player wimp = new WimpPlayer();
		
		//Initialize list of players
		ArrayList <Player> players = new ArrayList<>() {{
			add(human);
			add(fifteen);
			add(random);
			add(unique);
			add(wimp);
		}};
		
		Scanner input = new Scanner(System.in);
		System.out.println("How many players will be playing?: ");
		int numPlay = Integer.parseInt(input.next());
		//Prompt for players
		ArrayList<Player> userPlayers = playerPrompt(players, numPlay);
		//Call the UI
		//BulldogUI.startGameUI(userPlayers);
		BulldogUI ui = new BulldogUI(userPlayers);
		playGame(userPlayers, ui);
	}
	
	/**
     * Prompts the user to select players based on the given number.
     * 
     * @param players The list of available player types.
     * @param num The number of players to select.
     * @return A list of selected players.
     */
	public static ArrayList<Player> playerPrompt(ArrayList<Player> players, int num) {
	    ArrayList<Player> inGame = new ArrayList<>();
	    Scanner input = new Scanner(System.in);
	    //Loop until all players are created
	    for (int i = 0; i < num; i++) {
	        boolean validChoice = false;
	        while (!validChoice) {
	            System.out.println("What player would you like? \n"
	                    + "\tHuman \n"
	                    + "\tFifteen \n"
	                    + "\tRandom \n"
	                    + "\tUnique \n"
	                    + "\tWimp");
	            String name = input.next().toLowerCase();

	            switch (name) {
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
	
	/**
     * Executes the turn for a human player, updating and returning the turn score.
     * 
     * @param human The HumanPlayer taking the turn.
     * @return The score from the turn.
     */
	public static int humanTurn(HumanPlayer human) {
		int turn = human.play();
		int score = human.getScore();
		score += turn;
		human.setScore(score);
		return turn;
	}
	/**
     * Executes the turn for a FifteenPlayer, updating and returning the turn score.
     * 
     * @param fif The FifteenPlayer taking the turn.
     * @return The score from the turn.
     */
	public static int fifteenTurn (FifteenPlayer fif) {
		int turn = fif.play();
		int score = fif.getScore();
		score += turn;
		fif.setScore(score);
		return turn;
	}
	 /**
     * Executes the turn for a RandomPlayer, updating and returning the turn score.
     * 
     * @param ran The RandomPlayer taking the turn.
     * @return The score from the turn.
     */
	public static int randomTurn(RandomPlayer ran) {
		int turn = ran.play();
		int score = ran.getScore();
		score += turn;
		ran.setScore(score);
		return turn;
	}
	/**
     * Executes the turn for a UniquePlayer, updating and returning the turn score.
     * 
     * @param uni The UniquePlayer taking the turn.
     * @return The score from the turn.
     */
	public static int uniqueTurn(UniquePlayer uni) {
		int turn = uni.play();
		int score = uni.getScore();
		score += turn;
		uni.setScore(score);
		return turn;
	}
	/**
     * Executes the turn for a WimpPlayer, updating and returning the turn score.
     * 
     * @param wimp The WimpPlayer taking the turn.
     * @return The score from the turn.
     */
	public static int wimpTurn(WimpPlayer wimp) {
		int turn = wimp.play();
		int score = wimp.getScore();
		score += turn;
		wimp.setScore(score);
		return turn;
	}
		
	/**
     * Manages the game loop, handling turns, updating scores, and determining the winner.
     * 
     * @param players The list of players in the game.
     * @param ui The game UI for displaying player progress.
     */
	public static void playGame(ArrayList<Player> players, BulldogUI ui) {
		int maxScore = 104;
		boolean gameOver = false;
		    
		while (!gameOver) {
			for (Player player : players) {
				int score = player.getScore();

		        // Determine which turn method to call based on the player type
		        if (player instanceof HumanPlayer) {
		        	score = humanTurn((HumanPlayer) player);
		        } 
		        else if (player instanceof FifteenPlayer) {
		            score = fifteenTurn((FifteenPlayer) player);
		        } 
		        else if (player instanceof RandomPlayer) {
		            score = randomTurn((RandomPlayer) player);
		        } 
		        else if (player instanceof UniquePlayer) {
		            score = uniqueTurn((UniquePlayer) player);
		        } 
		        else if (player instanceof WimpPlayer) {
		            score = wimpTurn((WimpPlayer) player);
		        }
		        
		        // Update UI with current player's turn information
		        ui.updateCurrentPlayer(player.getName(), score);
                ui.updatePlayerList(players);
		        
		        // Pause for 2 seconds after each player's turn
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

		        // Check if the player has won
		        if (player.getScore() >= maxScore) {
		        	System.out.println(player.getName() + " wins with a score of " + player.getScore());
		            gameOver = true;
		            break; // Exit loop after finding a winner
		        }
		    }
		}
	}	
}
