import java.util.*;
/**
 * @author: Daniel Abrahms
 * Last Edited: 2/14/17
 * Class: CPSC 224-02
 * Class: Dice
 * Description: This is the Dice Class. It visualizes a die and its ability to randomly roll within a specified range.
 */
public class Dice {
	int range;
	int value;
	boolean kept;


	/**
	 * Dice object has been created with random value within range
	 * @param sides- The number of sides for the Dice
 	 */
	public Dice(int sides){
		range = sides;
		kept = false;
		Random rand = new Random();
		value = rand.nextInt((range - 1) + 1) + 1;
	}

	/**
	 * Value attribute is assigned a random value within range
 	 */

	public void roll(){
		Random rand = new Random();
		value = rand.nextInt((range - 1) + 1) + 1;
	}

	/**
	 * @param newRange- the int for range attribute to be set to
	 */

	public void setRange(int newRange) {
		range = newRange;
	}

	/**
	 * @return returns the range attribute

	 */
	public int getRange() {
		return range;
	}

	/**
	 * @param newValue- the int for value attribute to be set to
	 */
	public void setValue(int newValue) {
		value = newValue;
	}

	/**
	 * @return returns the value attribute
	*/
	public int getValue() {
		return value;
	}

	/**
	 * @param newKept- the boolean for kept attribute to be set to
 	 */
	public void setKept(boolean newKept) {
		kept = newKept;
	}

	/**
	 * @return @return returns the kept attribute
	 */
	public boolean getKept() {
		return kept;
	}
	
}
