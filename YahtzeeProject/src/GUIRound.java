/*
 * Author: Daniel Abrahms
 * Last Edited: 2/24/17
 * Class: CPSC 224-02
 * Class: Round
 * Description: Plays a round of yahtzee given player's name, scorecard, and hand
 */

public class GUIRound {
    private int dicePerGame = 5;
    private int sidesPerDice = 6;
    private int dice1Value;
    private int dice2Value;
    private int dice3Value;
    private int dice4Value;
    private int dice5Value;
    private int dice6Value;
    private int dice7Value;
    private String playerName;
    private ScoreCard playerScoreCard;
    private Hand playerHand;


    /**
     * round object has been created and ready to run
     * @param newPlayerName- String of whatever the name of the player will be
     * @param newPlayerScoreCard- the scorecard of the player
     * @param newPlayerHand- the hand of the player
     * @see Round
     */
    public GUIRound(String newPlayerName, ScoreCard newPlayerScoreCard, Hand newPlayerHand) {
        playerHand = newPlayerHand;
        playerScoreCard = newPlayerScoreCard;
        playerName = newPlayerName;
    }

    /**
     @param rollsPerTurn- the number of rolls in a given turn
     @param diceRange- the number of sides per dice
     */
    public void playRound(int rollsPerTurn, int diceRange, String lineUsed) {

        dice1Value = playerHand.getDice(0).getValue();
        dice2Value = playerHand.getDice(1).getValue();
        dice3Value = playerHand.getDice(2).getValue();
        dice4Value = playerHand.getDice(3).getValue();
        dice5Value = playerHand.getDice(4).getValue();
        if (playerHand.getDiceNumber() == 6) {
            dice6Value = playerHand.getDice(5).getValue();
        } else if (playerHand.getDiceNumber() == 7) {
            dice7Value = playerHand.getDice(6).getValue();
        }

        while (true) {
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

    public int getDicePerGame() {
        return dicePerGame;
    }

    public int getSidesPerDice() {
        return sidesPerDice;
    }

    public int getDice1Value() {
        return dice1Value;
    }

    public int getDice2Value() {
        return dice2Value;
    }

    public int getDice3Value() {
        return dice3Value;
    }

    public int getDice4Value() {
        return dice4Value;
    }

    public int getDice5Value() {
        return dice5Value;
    }

    public int getDice6Value() {
        return dice6Value;
    }

    public int getDice7Value() {
        return dice7Value;
    }

    public String getPlayerName() {
        return playerName;
    }

    public ScoreCard getPlayerScoreCard() {
        return playerScoreCard;
    }

    public Hand getPlayerHand() {
        return playerHand;
    }
}
