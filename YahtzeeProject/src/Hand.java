import java.util.Scanner;
import java.lang.*;

import static java.lang.Character.toLowerCase;

/* 
 * @author: Daniel Abrahms
 * Last Edited: 2/14/17
 * Class: CPSC 224-02
 * Class: hand
 * Description: This is the Hand Class. It holds an array of Dice and has a counter for number of rolls left. 
 */
public class Hand {
	private Dice[] die;
	private int rollsLeft;
	private int diceNumber;
    private int diceRange;
	private Scanner scan = new Scanner(System.in);

	/*
	@pre Hand object is null
	@post Hand object is created and die attribute is initialized
	@param initialDiceNumber: the number of dice in the game
	@param initialRollsLeft: the number of rolls left in the game
	@param newDiceRange: the number of sides per dice
	 */
	public Hand(int initialDiceNumber, int initialRollsLeft, int newDiceRange) {
		diceNumber = initialDiceNumber;
		rollsLeft = initialRollsLeft;
		diceRange = newDiceRange;
		die = new Dice[diceNumber];
		for (int i = 0; i < diceNumber; i++) {
			die[i] = new Dice(diceRange);
		}
	}
	
	// @pre: hand has been initialized and kept values fot each dice are set
    // @post: each dice in hand is rolled if their kept attribute is false
	public void rollHand() {
		for (int i = 0; i < diceNumber; i++) {
			if (!die[i].getKept()) {
				die[i].roll();
			}
		}
	}
	
	// @return the Dice at a given index
    // @param index: value between 0-(diceNumber-1)
	public Dice getDice(int index) {
		return die[index];
	}

	// @return the rollsLeft attribute
	public int getRollsLeft() {
		return rollsLeft;
	}
	
	// @param newRollsLeft: the value of how many rolls are left in the lane
	public void setRollsLeft(int newRollsLeft) {
		rollsLeft = newRollsLeft;
	}

    // @return the diceNumber attribute
	public int getDiceNumber() {
		return diceNumber;
	}

    // @param newDiceNumber: the value of how many dice are in play
	public void setDiceNumber(int newDiceNumber) {
		diceNumber = newDiceNumber;
	}

    // @return the diceRange attribute
   public int getDiceRange(){
	    return diceRange;
   }

    // @param newDiceRange: the value of how many sides per dice
    public void setDiceRange(int newDiceRange) {
        diceRange = newDiceRange;
    }




    // prints each die
	public void displayHand(){
		System.out.print("Hand: ");
		for (int i = 0; i < diceNumber; i++) {
			System.out.print(die[i].getValue());
			if (i != diceNumber-1) { 
				System.out.print("-");
			}
		}
		System.out.println();
	}
	
	// prompts user for which die to roll
	public void changeHand() {
		
		String newHand;
		
		do {
			System.out.print("Y/N for keep: ");
			newHand = scan.next();
		} while ((newHand.length() != diceNumber) || (validStringCheck(newHand)));

		
		for (int i = 0; i < diceNumber; i++){
			if (toLowerCase(newHand.charAt(i)) == 'y'){
				die[i].setKept(true);
			}
		}
		rollHand();

	}
	
	// sorts hand from lowest -> highest 
	public void sortHand() {
		Dice temp;
		for (int i = 0; i < diceNumber - 1; i++) {
			for (int j = 1; j < diceNumber - i; j++) {
				if (die[j-1].getValue() > die[j].getValue()) {
					temp = die[j - 1];
					die[j - 1] = die[j];
					die[j] = temp;
				}
			}
		}
	}
	
	// returns sum of die's value
	public int sum() {
		int sum = 0;
		for (int i = 0; i < diceNumber; i++) {
			sum += die[i].getValue();
		}
		return sum;
	}

    private boolean validStringCheck(String str) {
	    str = str + "t";
        String[] characters = str.split("[YyNn]", 2);
        if (characters.length > 1) {
            return false;
        }
        return true;
    }

    public boolean doesValueExist(int valueCheck) {
		for (int i = 0; i < diceNumber; i++) {
			if (die[i].getValue() == valueCheck) {
			    return true;
            }
		}
        return false;
	}

	
	
}
