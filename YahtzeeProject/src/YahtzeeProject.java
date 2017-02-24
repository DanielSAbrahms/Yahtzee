/* 
 * Author: Daniel Abrahms
 * Last Edited: 2/14/17
 * Class: CPSC 224-02
 * Class: YahtzeeProject
 * Description: This is the main file. It plays one round of the game using the included function. It will eventually be migrated into another class. 
 */

import java.util.Scanner;

public class YahtzeeProject {
	public static void main(String[] args) {

	    Scanner scan = new Scanner(System.in);

		int sidesPerDice = 6;
		int diceInGame = 5;
		int rollsPerTurn = 3;
		String changeSettings;

		SaveFile file = new SaveFile(sidesPerDice, diceInGame, rollsPerTurn);

        file.read();
        sidesPerDice = file.getSidesPerDice();
        diceInGame = file.getDiceInGame();
        rollsPerTurn = file.getRollsPerTurn();

        System.out.println("Current Settings: ");
        System.out.println("-Sides per Dice: " + sidesPerDice);
        System.out.println("-Dice in Game: " + diceInGame);
        System.out.println("-rollsPerTurn: " + rollsPerTurn);



		System.out.print("Would you like to change settings? (Y/N): ");
        changeSettings = scan.next();
        if (changeSettings.toLowerCase().equals("y")) {
            System.out.println("How many sides per dice? (1-100): ");
            sidesPerDice = scan.nextInt();
            System.out.println("How many dice in game? (1-100): ");
            diceInGame = scan.nextInt();
            System.out.println("How many rolls per turn? (1-100): ");
            rollsPerTurn = scan.nextInt();
            file.write(sidesPerDice, diceInGame, rollsPerTurn);
        }



		Hand playerOneHand = new Hand(diceInGame, rollsPerTurn, sidesPerDice);
		playerOneHand.displayHand();
		ScoreCard playerOneScoreCard = new ScoreCard(sidesPerDice);

		while (!playerOneScoreCard.finished()) {
            Round r = new Round("Player 1", playerOneScoreCard, playerOneHand);
            r.playRound(rollsPerTurn);
        }
		
		System.out.println("Game Over");
	}

}
