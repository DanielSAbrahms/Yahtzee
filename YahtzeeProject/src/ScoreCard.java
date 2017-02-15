/* 
 * @author Daniel Abrahms
 * Last Edited: 2/14/17
 * Class: CPSC 224-02
 * Class: ScoreCard
 * Description: This is the ScoreCard Class. It has an array of ScoreCardLines. 
 * 				It allows the main file to check the score of a given hand, and prints the possible plays. 
 */
public class ScoreCard {

	ScoreCardLine line[];
	
	/*
	@pre ScoreCard object is null
	@post ScoreCard object has been created
	@param sidesPerDice: the number of sides per dice
	 */
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
	
	// @print: Every possible score has been printed
    // @param hand: hand object that has been initiated
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
			line[sidesPerDice + 4].print(1);
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
	
	/* @param num: int value of what number to check total of
	   @param hand: hand object that has been initiated
	   @return int value of total number of times that num exists in hand
	 */
	private int totalOfNum(int num, Hand hand) {
		int sum = 0;
		for (int i = 0; i < hand.getDiceNumber(); i++) {
			if (hand.getDice(i).getValue() == num) {
				sum++;
			}
		}
		return sum;
	}

    /*
       @param hand: hand object that has been initiated
       @return int the longest straight that exists within hand
     */
	private int maxStraight(Hand hand) {
        int maxFound = 1;
        int maxFoundTemp = 1;
        for(int i = 0; i < hand.getDiceNumber()-1; i++)
        {
            if ((hand.getDice(i).getValue()) + 1 == hand.getDice(i + 1).getValue()) {
                maxFoundTemp++;
            } else if ((hand.getDice(i).getValue() + 1) < (hand.getDice(i+1).getValue())) {
            maxFoundTemp = 1;
        }
            maxFound = Math.max(maxFound, maxFoundTemp);
        }
        return maxFound;
	}

    /* @param num: int value of what number to check
       @param hand: hand object that has been initiated
       @return boolean value of whether a three of num exists in hand
     */
	private boolean isThreeOfKind(int num, Hand hand) {
		if (totalOfNum(num, hand) >= 3) {
			return true;
		} 
		return false;
	}
	/* @param num: int value of what number to check
       @param hand: hand object that has been initiated
       @return boolean value of whether a four of num exists in hand
     */
	private boolean isFourOfKind(int num, Hand hand) {
		if (totalOfNum(num, hand) >= 4) {
			return true;
		}
		return false;
	}

    /* @param num: int value of what number to check
       @param hand: hand object that has been initiated
       @return boolean value of whether a five of num exists in hand
     */
	private boolean isYahtzee(int num, Hand hand) {
		if (totalOfNum(num, hand) >= 5) {
			return true;
		}
		return false;
	}
	// @return boolean value if given hand contains a small straight
	// @pre: hand is sorted lowest->highest
	private boolean isSmallStraight(Hand hand) {
		if (maxStraight(hand) > 3) {
		    return true;
        }
        return false;
	}
    // @return boolean value if given hand contains a large straight
    // @pre: hand is sorted lowest->highest
	private boolean isLargeStraight(Hand hand) {
		if (maxStraight(hand) > 4) {
		    return true;
        }
        return false;
	}

	 /*
	 @pre Hand is sorted
     @post Hand is unchanged
     @param hand, a custom Hand class object
     @return boolean value on whether hand contains a Full House
     @see isFullHouse
     */
     private boolean isFullHouse(Hand hand) {
         boolean fullHouseFound = false;
         boolean threeFound = false;
         boolean twoFound = false;
         int counter ;
         for (int i = 1; i <=hand.getDiceRange(); i++) {
             counter = 0;
             for (int j = 0; j < hand.getDiceNumber(); j++)
             {
                 if (hand.getDice(j).getValue() == i)
                     counter++;
             }
             if (counter == 2)
                 twoFound = true;
             if (counter == 3)
                 threeFound = true;
         }
         if (twoFound && threeFound) {
             fullHouseFound = true;
         }
         return fullHouseFound;
     }
}
