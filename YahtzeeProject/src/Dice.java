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
		if (!kept) {
		    int intValue;
            if (isVowel) {
                intValue = ThreadLocalRandom.current().nextInt(1, 7);
            } else {
                intValue = ThreadLocalRandom.current().nextInt(7, 27);
            }
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

	/**
	 * @return Whether or not this object is vowel
	 */
	public boolean getIsVowel() {
		return isVowel;
	}

	/**
	 * @param i The int to be converted to a char
	 * @return The char from the given int
	 */
	private char intToChar(int i){
        if (i == 1 && isVowel) return 'A';
        if (i == 2 && isVowel) return 'E';
        if (i == 3 && isVowel) return 'I';
        if (i == 4 && isVowel) return 'O';
        if (i == 5 && isVowel) return 'U';
        if (i == 6 && isVowel) {
            points = 4;
            return 'Y';
        } if (i == 7 && !isVowel) {
            points = 3;
            return 'B';
        } if (i == 8 && !isVowel) {
            points = 3;
            return 'C';
        } if (i == 9 && !isVowel) {
            points = 2;
            return 'D';
        } if (i == 10 && !isVowel) {
            points = 4;
            return 'F';
        } if (i == 11 && !isVowel) {
            points = 2;
            return 'G';
        } if (i == 12 && !isVowel) {
            points = 4;
            return 'H';
        } if (i == 13 && !isVowel) {
            points = 8;
            return 'J';
        } if (i == 14 && !isVowel) {
            points = 5;
            return 'K';
        } if (i == 15 && !isVowel) return 'L';
        if (i == 16 && !isVowel) {
            points = 3;
            return 'M';
        } if (i == 17 && !isVowel) {
            return 'N';
        } if (i == 18 && !isVowel) {
            points = 3;
            return 'P';
        } if (i == 19 && !isVowel) {
            points = 10;
            return 'Q';
        } if (i == 20 && !isVowel) {
            return 'R';
        } if (i == 21 && !isVowel) {
            return 'S';
        } if (i == 22 && !isVowel) {
            return 'T';
        } if (i == 23 && !isVowel) {
            points = 4;
            return 'V';
        } if (i == 24 && !isVowel) {
            points = 4;
            return 'W';
        } if (i == 25 && !isVowel) {
            points = 8;
            return 'X';
        } if (i == 26 && !isVowel) {
            points = 10;
            return 'Z';
        }
        return '?';
    }

	/**
	 * @param c The char to be converted to an int
	 * @return the int value converted from the given char
	 */
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

