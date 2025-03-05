/********************************************************/
/* Gabrielle Akers                                      */ 
/* COS 420, Spring 2025                                 */
/* Programming Assignment 5                             */
/* Dice class: 								            */
/* Creates a die of a specified side and returns        */
/* random value            							    */
/********************************************************/
import java.util.Random;

public class Dice {
	private static final Random r = new Random();
	private int sides;
	
	/**
     * Constructs a Dice object with the specified number of sides.
     * 
     * @param sides The number of sides on the dice.
     */
	public Dice(int sides) {
		this.sides = sides;
	}
	
	/**
     * Rolls the dice and returns a random number between 1 and the number of sides.
     * 
     * @return A random integer between 1 and the number of sides.
     */
	public int roll() {
        return r.nextInt(sides) + 1;
    }
}
