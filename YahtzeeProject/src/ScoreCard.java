/**
 * @author Daniel Abrahms
 * @version 1.0
 * Last Edited- 2/14/17
 * Class- CPSC 224-02
 * Class- ScoreCard
 * This is the ScoreCard Class. It has an array of ScoreCardLines.
 * 				It allows the main file to check the score of a given hand, and prints the possible plays. 
 */
public class ScoreCard {

	ScoreCardLine line[];
	boolean bonusUsed = false;
	private int totalScore = 0;
	private int bonus = 0;


	/**
	@see ScoreCard
	 */
	public ScoreCard() {

		line = new ScoreCardLine[11];

        for (int i = 0; i < 11; i++) {
            line[i] = new ScoreCardLine(String.valueOf(i+1), i+1, false);
        }

		line[0] = new ScoreCardLine("Noun", 1, false);
		line[1] = new ScoreCardLine("Noun", 1, false);
		line[2] = new ScoreCardLine("Verb", 1, false);
		line[3] = new ScoreCardLine("Verb", 1, false);
		line[4] = new ScoreCardLine("Adjective", 1, false);
		line[5] = new ScoreCardLine("Adjective", 1, false);
		line[6] = new ScoreCardLine("Pronoun", 1, false);
		line[7] = new ScoreCardLine("Adverb", 1, false);
		line[8] = new ScoreCardLine("Preposition", 1, false);
		line[9] = new ScoreCardLine("Name", 1, false);
		line[10] = new ScoreCardLine("Chance", 1, false);

	}

	/**
	 * @return totalScore value
	 */
	public void calculateTotalScore() {
	    totalScore = 0;
	    for (int i = 0; i < 11; i++) {
	        totalScore += line[i].getPointsEarned();
        }
        calculateBonus();
		totalScore += bonus;
	}

	public int getTotalScore() {
	    return totalScore;
    }

	/**
	 * Every possible score has been printed
     * @param hand- hand object that has been initiated
	**/
	public int checkScore(String str, boolean doublePointsActive) {
		int score = 0;
		for (int i = 0; i < str.length(); i++) {
            score+=letterScorer(str.charAt(i));
        }
        if (doublePointsActive) return (score + str.length())*2;
		else return score + str.length();

	}

	/**
	 * @param c The character to be scored
	 * @return The value of the letter scored
	 */
    private int letterScorer(char c) {
	    if (c == 'D' || c == 'G') return 2;
	    else if (c == 'B' || c == 'C' || c == 'M' || c == 'P') return 3;
	    else if (c == 'F' || c == 'H' || c == 'V' || c == 'W' || c == 'Y') return 4;
	    else if (c == 'K') return 5;
	    else if (c == 'J' || c == 'X') return 8;
	    else if (c == 'Q' || c == 'Z') return 10;
	    else return 1;
    }

    /**
	@return int of how many score card lines havent been used
	@see howManyLeft
	 */
	public int howManyLeft() {
		int count = 0;
		for (int i = 0; i < line.length; i++) {
			if (!line[i].getUsed()) {
			    count++;
            }
		}
		return count;
	}
	/**
	@return scoreCardLine at the index
	@param index- the index you want the scorecardline at
	 */
	public ScoreCardLine getLine(int index) {
		assert(index >= 0 && index < line.length);
	    return line[index];
    }

    /**
    @param diceRange- the int of how many sides are per dice
     Prints the scorecard with titles, uses - for those unused
     */
    public void showScoreCard(int diceRange) {
    	int totalScore = 0;
	    System.out.println("========================");
	    System.out.println("Line            Score    ");
        for (int i = 0; i < 11; i++) {
        	totalScore+=line[i].getPointsEarned();
        }
    }
	/**
	 *  @param num- int value of what number to check total of
	 *  @param hand- hand object that has been initiated
	 *  @return int value of total number of times that num exists in hand
	 */
	public int totalOfNum(int num, Hand hand) {
		int sum = 0;
		for (int i = 0; i < hand.getDiceNumber(); i++) {
			if (hand.getDice(i).getValue() == num) {
				sum++;
			}
		}
		return sum;
	}

	/**
	 * Sets the Bonus value if prerequisits are met
	 */
	public void calculateBonus(){
		int sum = 0;
		for (int i = 0; i < 4; i++){
			sum += line[i].getPointsEarned();
		}
		if(sum >= 30) {
			bonusUsed = true;
			bonus = 15;
		}
	}
}
