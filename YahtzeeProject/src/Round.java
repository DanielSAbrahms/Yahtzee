/*
 * Author: Daniel Abrahms
 * Last Edited: 2/24/17
 * Class: CPSC 224-02
 * Class: Round
 * Description: Plays a round of yahtzee given player's name, scorecard, and hand
 */

import java.util.Scanner;
public class Round {
    private String playerName;
    private ScoreCard playerScoreCard;
    private Hand playerHand;

    /*
	@pre round object is null
	@post round object has been created and ready to run
	@param newPlayerName: String of whatever the name of the player will be
	@param newPlayerScoreCard: the scorecard of the player
	@param newPlayerHand: the hand of the player
	@see Round
	 */
    public Round(String newPlayerName, ScoreCard newPlayerScoreCard, Hand newPlayerHand) {
        playerHand = newPlayerHand;
        playerScoreCard = newPlayerScoreCard;
        playerName = newPlayerName;
    }

    /*
        @param rollsPerTurn: the number of rolls in a given turn
        @param diceRange: the number of sides per dice
        @see playRound
     */
    public void playRound(int rollsPerTurn, int diceRange) {
        Scanner scan = new Scanner(System.in);
        for (int i = 1; i < rollsPerTurn; i++) {

            System.out.println("Enter S to display ScoreCard");
            if (!playerHand.changeHand(playerScoreCard)) {
                break;
            }
            playerHand.displayHand();
        }

        playerScoreCard.checkScore(playerHand);
        while (true) {
            System.out.println("What line would you like to use?");
            String lineUsed = scan.next();
            System.out.println(lineUsed.toLowerCase());
            switch (lineUsed.toLowerCase()) {
                case "3k":
                    if (playerScoreCard.getLine(diceRange + 0).getUsed() == true) {
                        System.out.println("Line has already been used, please choose another.");
                        continue;
                    }
                    playerScoreCard.getLine(diceRange + 0).setUsed(true);
                    playerScoreCard.getLine(diceRange + 0).setPointsEarned();
                    return;
                case "4k":
                    if (playerScoreCard.getLine(diceRange + 1).getUsed() == true) {
                        System.out.println("Line has already been used, please choose another.");
                        continue;
                    }
                    playerScoreCard.getLine(diceRange + 1).setUsed(true);
                    playerScoreCard.getLine(diceRange + 1).setPointsEarned();
                    return;
                case "fh":
                    if (playerScoreCard.getLine(diceRange + 2).getUsed() == true) {
                        System.out.println("Line has already been used, please choose another.");
                        continue;
                    }
                    playerScoreCard.getLine(diceRange + 2).setUsed(true);
                    playerScoreCard.getLine(diceRange + 2).setPointsEarned();
                    return;
                case "ss":
                    if (playerScoreCard.getLine(diceRange + 3).getUsed() == true) {
                        System.out.println("Line has already been used, please choose another.");
                        continue;
                    }
                    playerScoreCard.getLine(diceRange + 3).setUsed(true);
                    playerScoreCard.getLine(diceRange + 3).setPointsEarned();
                    return;
                case "ls":
                    if (playerScoreCard.getLine(diceRange + 4).getUsed() == true) {
                        System.out.println("Line has already been used, please choose another.");
                        continue;
                    }
                    playerScoreCard.getLine(diceRange + 4).setUsed(true);
                    playerScoreCard.getLine(diceRange + 4).setPointsEarned();
                    return;
                case "ya":
                    if (playerScoreCard.getLine(diceRange + 5).getUsed() == true) {
                        System.out.println("Line has already been used, please choose another.");
                        continue;
                    }
                    playerScoreCard.getLine(diceRange + 5).setUsed(true);
                    playerScoreCard.getLine(diceRange + 5).setPointsEarned();
                    return;
                case "ch":
                    if (playerScoreCard.getLine(diceRange + 6).getUsed() == true) {
                        System.out.println("Line has already been used, please choose another.");
                        continue;
                    }
                    playerScoreCard.getLine(diceRange + 6).setUsed(true);
                    playerScoreCard.getLine(diceRange + 6).setPointsEarned();
                    return;
            }
            try {
                Integer.valueOf(lineUsed);
            } catch (java.lang.NumberFormatException m) {
                System.out.println("Incorrect input data, please try again.");
                continue;
            }
                    for (int i = 0; i < diceRange; i++) {
                        if (Integer.valueOf(lineUsed) == i + 1) {
                            playerScoreCard.getLine(i).setUsed(true);
                            playerScoreCard.getLine(i).setPointsEarned();
                            return;
                        }

                    }
            }

    }
}
