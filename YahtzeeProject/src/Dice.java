import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author: Daniel Abrahms
 * Last Edited: 2/14/17
 * Class: CPSC 224-02
 * Class: Dice
 * Description: This is the Dice Class. It visualizes a die and its ability to randomly roll within a specified range.
 */
public class Dice {
	int range;
	int points;
	char value;
	boolean kept;
	boolean isVowel;

	public int getPoints() {
		return points;
	}

	/**
	 * Dice object has been created with random value within range
	 * @param isVowel- Is the dice a vowel
 	 */
	public Dice(boolean isVowel){
		this.isVowel = isVowel;
		if (isVowel) range = 6;
		else range = 20;
		kept = false;
		points = 1;
		int intValue;
		if (isVowel) {
			intValue = ThreadLocalRandom.current().nextInt(1, 7);
		} else {
            intValue = ThreadLocalRandom.current().nextInt(7, 27);
		}
		value = intToChar(intValue);
	}

	/**
	 * Value attribute is assigned a random value within range
 	 */
	public void roll(){
		Random rand = new Random();
		if (!kept) {
			int intValue = rand.nextInt((range - 1) + 1) + 1;
			value = intToChar(intValue);
		}
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
	 * @param newValue - the char for value attribute to be set to
	 */
	public void setValue(char newValue) {
		value = newValue;
	}

	/**
	 * @return returns the value attribute
	*/
	public char getValue() {
		return value;
	}

	/**
	 * @param newKept- the boolean for kept attribute to be set to
 	 */
	public void setKept(boolean newKept) {
		kept = newKept;
	}

	/**
	 * @return returns the kept attribute
	 */
	public boolean getKept() {
		return kept;
	}

	public char intToChar(int i){
        if (i == 1) return 'A';
        if (i == 2) return 'E';
        if (i == 3) return 'I';
        if (i == 4) return 'O';
        if (i == 5) return 'U';
        if (i == 6) {
            points = 4;
            return 'Y';
        } if (i == 7) {
            points = 3;
            return 'B';
        } if (i == 8) {
            points = 3;
            return 'C';
        } if (i == 9) {
            points = 2;
            return 'D';
        } if (i == 10) {
            points = 4;
            return 'F';
        } if (i == 11) {
            points = 2;
            return 'G';
        } if (i == 12) {
            points = 4;
            return 'H';
        } if (i == 13) {
            points = 8;
            return 'J';
        } if (i == 14) {
            points = 5;
            return 'K';
        } if (i == 15) return 'L';
        if (i == 16) {
            points = 3;
            return 'M';
        } if (i == 17) {
            return 'N';
        } if (i == 18) {
            points = 3;
            return 'P';
        } if (i == 19) {
            points = 10;
            return 'Q';
        } if (i == 20) {
            return 'R';
        } if (i == 21) {
            return 'S';
        } if (i == 22) {
            return 'T';
        } if (i == 23) {
            points = 4;
            return 'V';
        } if (i == 24) {
            points = 4;
            return 'W';
        } if (i == 25) {
            points = 8;
            return 'X';
        } if (i == 26) {
            points = 10;
            return 'Z';
        }
        return '?';
    }

	public int charToInt(char c){
		switch(c) {
			case ('A'):
				return 1;
			case ('B'):
				return 2;
			case ('C'):
				return 3;
			case ('D'):
				return 4;
			case ('E'):
				return 5;
			case ('F'):
				return 6;
			case ('G'):
				return 7;
			case ('H'):
				return 8;
			case ('I'):
				return 9;
			case ('J'):
				return 10;
			case ('K'):
				return 11;
			case ('L'):
				return 12;
			case ('M'):
				return 13;
			case ('N'):
				return 14;
			case ('O'):
				return 15;
			case ('P'):
				return 16;
			case ('Q'):
				return 17;
			case ('R'):
				return 18;
			case ('S'):
				return 19;
			case ('T'):
				return 20;
			case ('U'):
				return 21;
			case ('V'):
				return 22;
			case ('W'):
				return 23;
			case ('X'):
				return 24;
			case ('Y'):
				return 25;
			case ('Z'):
				return 26;
		}
		return 0;
	}
}

