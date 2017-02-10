/* 
 * Author: Daniel Abrahms
 * Last Edited: 2/3/17
 * Class: CPSC 224-02
 * Class: YahtzeeProject
 * Description: This is the main file. It plays one round of the game using the included function. It will eventually be migrated into another class. 
 */

public class YahtzeeProject {
	public static void main(String[] args) {
		
		final int rollsPerTurn = 3;
		final int diceInGame = 5;
		final int sidesPerDice = 6;
		
		Hand playerOneHand = new Hand(diceInGame, rollsPerTurn, sidesPerDice);
		playerOneHand.displayHand();
		ScoreCard playerOneScoreCard = new ScoreCard();
		
		for (int i = 1; i < rollsPerTurn; i++) {
			
			playerOneHand.changeHand();
			playerOneHand.displayHand();
		}
		
		playerOneScoreCard.checkScore(playerOneHand);
		
		System.out.println("Game Over");
	}

}
