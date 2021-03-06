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


	/**
	 * @param hand Hand object
	 */
	public Hand(DiceLabel[] hand) {
		diceNumber = hand.length;
		rollsLeft = 3;
		die = new Dice[diceNumber];
		for (int i = 0; i < diceNumber; i++) {
			die[i] = hand[i].getD();
		}
	}

	/**
	 * Each dice in hand is rolled if their kept attribute is false
	*/
	public void rollHand() {
		for (int i = 0; i < diceNumber; i++) {
			if (!die[i].getKept()) {
				die[i].roll();
			}
		}
	}

	/**
	 * @return the Dice at a given index
	 * @param index- value between 0-(diceNumber-1)
	 */
	public Dice getDice(int index) {
		return die[index];
	}

	/**
	 * @return the rollsLeft attribute
	 */
	public int getRollsLeft() {
		return rollsLeft;
	}

	/**
	 * @param newRollsLeft- the value of how many rolls are left in the lane
	 */
	public void setRollsLeft(int newRollsLeft) {
		rollsLeft = newRollsLeft;
	}

	/**
	 * @return the diceNumber attribute
	 */
	public int getDiceNumber() {
		return diceNumber;
	}

	/**
	 * @param newDiceNumber- the value of how many dice are in play
	 */
	public void setDiceNumber(int newDiceNumber) {
		diceNumber = newDiceNumber;
	}

	/**
	 * @return the diceRange attribute
	 */
   public int getDiceRange(){
	    return diceRange;
   }

	/**
	 * @param newDiceRange- the value of how many sides per dice
	 */
    public void setDiceRange(int newDiceRange) {
        diceRange = newDiceRange;
    }

	/**
	 * Displays every dice
	 */
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

	/**
	 * Prompts user for which die to keep, sets attributes accordingly
	 * @param scoreCard- scoreHand to receive data from
	 * @return boolean value of whether or not hand has been changed
	 */
	public boolean changeHand(ScoreCard scoreCard) {
		String escapeString = "";
		for (int i = 0; i < diceNumber; i++) {
			escapeString+="y";
		}
		String newHand;
		
		do {
			System.out.print("Y/N for keep (S for Scorecard): ");
			newHand = scan.next();
            if (newHand.equalsIgnoreCase("s")) {
                scoreCard.showScoreCard(diceRange);
                displayHand();
                continue;
            }
		} while ((newHand.length() != diceNumber) || (validStringCheck(newHand)));


		if (newHand.toLowerCase().equals(escapeString)){
			return false;
		}

		for (int i = 0; i < diceNumber; i++){
			if (toLowerCase(newHand.charAt(i)) == 'y'){
				die[i].setKept(true);
			}
		}
		rollHand();
		return true;

	}






	/**
	 * @return the sum of the entire hand's value
	 */
	public int sum() {
		int sum = 0;
		for (int i = 0; i < diceNumber; i++) {
			sum += die[i].getValue();
		}
		return sum;
	}

	/**
	 * @param str- a string value
	 * @return boolean value if str contains just a valid string
	 */
    private boolean validStringCheck(String str) {
	    str = str + "t";
        String[] characters = str.split("[YyNnSs]", 2);
        if (characters.length > 1) {
            return false;
        }
        return true;
    }

	
}
