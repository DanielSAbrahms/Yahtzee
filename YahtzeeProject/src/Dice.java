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
	int points;
	char value;
	boolean kept;
	boolean isVowel;


	/**
	 * Dice object has been created with random value within range
	 * @param isVowel- Is the dice a vowel
 	 */
	public Dice(boolean isVowel){
		this.isVowel = isVowel;
		range = 26;
		kept = false;
		int intValue;
		Random rand = new Random();
		if (isVowel) {
			intValue = rand.nextInt((6 - 1) + 1) + 1;
		} else {
			intValue = rand.nextInt((20 - 1) + 1) + 7;
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
		if (isVowel) {
			switch(i) {
				case (1):
					return 'A';
				case (2):
					return 'E';
				case (3):
					return 'I';
				case (4):
					return 'O';
				case (5):
					return 'U';
				case (6):
					return 'Y';
			}
		} else {
			switch(i) {
				case (7):
					return 'B';
				case (8):
					return 'C';
				case (9):
					return 'D';
				case (10):
					return 'F';
				case (11):
					return 'G';
				case (12):
					return 'H';
				case (13):
					return 'J';
				case (14):
					return 'K';
				case (15):
					return 'L';
				case (16):
					return 'M';
				case (17):
					return 'N';
				case (18):
					return 'P';
				case (19):
					return 'Q';
				case (20):
					return 'R';
				case (21):
					return 'S';
				case (22):
					return 'T';
				case (23):
					return 'V';
				case (24):
					return 'W';
				case (25):
					return 'X';
				case (26):
					return 'Z';
			}
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
		return '?';
	}
}

