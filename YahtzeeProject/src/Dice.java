import java.util.*;
/* 
 * Author: Daniel Abrahms
 * Last Edited: 2/1/17
 * Class: CPSC 224-02
 * Class: Dice
 * Description: This is the Dice Class. It virtualizes a die and its ability to randomly roll within a specified range. 
 */
public class Dice {
	// the range of integers that can be rolled
	int range;
	// the current result of rolling the die
	int value;
	// whether of not the dice will be rolled
	boolean kept;
	
	// constructor of Dice
	// sets range attribute
	// rolls Die
	public Dice(int sides){
		range = sides;
		kept = false;
		Random rand = new Random();
		value = rand.nextInt((range - 1) + 1) + 1;
		
	}
	
	// assigns value a new random int according to range 
	public void roll(){
		Random rand = new Random();
		value = rand.nextInt((range - 1) + 1) + 1;
	}
	
	// sets the range attribute
	public void setRange(int newRange) {
		range = newRange;
	}
	
	// returns the range attribute
	public int getRange() {
		return range;
	}
	
	// sets the value attribute
	public void setValue(int newValue) {
		value = newValue;
	}
	
	// returns the value attribute
	public int getValue() {
		return value;
	}
	
	// sets the kept attribute
	public void setKept(boolean newKept) {
		kept = newKept;
	}
	
	// returns the kept attribute
	public boolean getKept() {
		return kept;
	}
	
}
