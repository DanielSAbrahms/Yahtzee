/* 
 * Author: Daniel Abrahms
 * Last Edited: 2/6/17
 * Class: CPSC 224-02
 * Class: ScoreCard
 * Description: This is the ScoreCard Class. It has an array of ScoreCardLines. 
 * 				It allows the main file to check the score of a given hand, and prints the possible plays. 
 */
public class ScoreCard {

	// the arrays of ScoreCardLines
	ScoreCardLine line[];
	
	// Constructor for ScoreCard
	// instantiates the array of scorecardlines
	public ScoreCard(int sidesPerDice) {
		line = new ScoreCardLine[7+sidesPerDice];

        for (int i = 0; i < sidesPerDice; i++) {
            line[i] = new ScoreCardLine(String.valueOf(i+1), i+1, false);
        }

		line[sidesPerDice + 0] = new ScoreCardLine("3 of a Kind", 1, false);
		line[sidesPerDice + 1] = new ScoreCardLine("4 of a Kind", 1, false);
		line[sidesPerDice + 2] = new ScoreCardLine("Full House", 25, false);
		line[sidesPerDice + 3] = new ScoreCardLine("Small Straight", 30, false);
		line[sidesPerDice + 4] = new ScoreCardLine("Large Straight", 40, false);
		line[sidesPerDice + 5] = new ScoreCardLine("Yahtzee", 50, false);
		line[sidesPerDice + 6] = new ScoreCardLine("Chance", 1, false);



		 
	}
	
	// Checks score using private methods
	public void checkScore(Hand hand) {
		hand.sortHand();
		int sidesPerDice = hand.getDiceRange();
		
		boolean threeOfKindPrinted = false;
		boolean fourOfKindPrinted = false;
		boolean yahtzeePrinted = false;

		
		System.out.println("Upper Section");
		for (int i = 0; i < sidesPerDice; i++) {
			line[i].print(totalOfNum(i+1, hand));
		}
		
		System.out.println("Lower Section");
		for (int i = 1; i <= sidesPerDice; i++) {
			if (isThreeOfKind(i, hand)){
				line[sidesPerDice + 0].print(hand.sum());
				threeOfKindPrinted = true;
				break;
			}
		}
		
		if (!threeOfKindPrinted) {
			line[sidesPerDice + 0].print(0);
		}
		
		for (int i = 1; i <= sidesPerDice; i++) {
			if (isFourOfKind(i, hand)){
				line[sidesPerDice + 1].print(hand.sum());
				fourOfKindPrinted = true;
				break;
			}
		}
		
		if (!fourOfKindPrinted) {
			line[sidesPerDice + 1].print(0);
		}
		if (isFullHouse(hand)) {
			line[sidesPerDice + 2].print(1);
		} else {
			line[sidesPerDice + 2].print(0);
		}
		if (isSmallStraight(hand)) {
			line[sidesPerDice + 3].print(1);
		} else {
			line[sidesPerDice + 3].print(0);
		}
		if (isLargeStraight(hand)) {
			line[sidesPerDice - 2].print(1);
		} else {
			line[sidesPerDice + 4].print(0);
		}
		for (int i = 1; i <= sidesPerDice; i++) {
			if (isYahtzee(i, hand)){
				line[sidesPerDice + 5].print(1);
				yahtzeePrinted = true;
				break;
			}
		}
		if (!yahtzeePrinted) {
			line[sidesPerDice + 5].print(0);
		}
		line[sidesPerDice + 6].print(hand.sum());

	}
	
	// returns the total of given number in given hand
	private int totalOfNum(int num, Hand hand) {
		int sum = 0;
		for (int i = 0; i < hand.getDiceNumber(); i++) {
			if (hand.getDice(i).getValue() == num) {
				sum++;
			}
		}
		return sum;
	}

	private int maxStraight(Hand hand) {
	    int maxFound = 0;
	    hand.sortHand();
		for (int i = 1; i <= hand.getDiceRange(); i++){
		    int maxFoundTemp = 0;
		    for (int j = 0; j < hand.getDiceNumber(); j++) {
		        if (hand.getDice(j).getValue() == i+j) {
                    maxFoundTemp++;
                }
            }
            maxFound = Math.max(maxFound, maxFoundTemp);
        }
        return maxFound;
	}

	// returns if given hand contains three of kind of given num
	private boolean isThreeOfKind(int num, Hand hand) {
		if (totalOfNum(num, hand) >= 3) {
			return true;
		} 
		return false;
	}
	// returns if given hand contains four of kind of given num
	private boolean isFourOfKind(int num, Hand hand) {
		if (totalOfNum(num, hand) >= 4) {
			return true;
		}
		return false;
	}
	// returns if given hand contains five of kind of given num
	private boolean isYahtzee(int num, Hand hand) {
		if (totalOfNum(num, hand) >= 5) {
			return true;
		}
		return false;
	}
	// returns if given hand contains a small straight
	// @pre: hand is sorted lowest->highest
	private boolean isSmallStraight(Hand hand) {
		if (maxStraight(hand) > 3) {
		    return true;
        }
        return false;
	}
	// returns if given hand contains a large straight
	// @pre: hand is sorted lowest->highest
	private boolean isLargeStraight(Hand hand) {
		if (maxStraight(hand) > 4) {
		    return true;
        }
        return false;
	}
	// returns if given hand contains a full house
	private boolean isFullHouse(Hand hand) {
		if (hand.getDice(0).getValue() == hand.getDice(1).getValue() && hand.getDice(1).getValue() == hand.getDice(2).getValue()
				&& hand.getDice(3).getValue() == hand.getDice(4).getValue() && hand.getDice(2).getValue() != hand.getDice(3).getValue()) {
			return true;
		}
		if (hand.getDice(2).getValue() == hand.getDice(3).getValue() && hand.getDice(3).getValue() == hand.getDice(4).getValue()
				&& hand.getDice(0).getValue() == hand.getDice(1).getValue() && hand.getDice(1).getValue() != hand.getDice(2).getValue()) {
			return true;
		}
		return false; 
	}
}
