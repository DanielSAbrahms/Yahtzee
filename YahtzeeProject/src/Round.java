import java.util.Scanner;
public class Round {
    private String playerName;
    private ScoreCard playerScoreCard;
    private Hand playerHand;

    public Round(String newPlayerName, ScoreCard newPlayerScoreCard, Hand newPlayerHand) {
        playerHand = newPlayerHand;
        playerScoreCard = newPlayerScoreCard;
        playerName = newPlayerName;
    }

    public void playRound(int rollsPerTurn, int diceRange) {
        Scanner scan = new Scanner(System.in);
        for (int i = 1; i < rollsPerTurn; i++) {


            if (!playerHand.changeHand()) {
                break;
            }
            playerHand.displayHand();
        }

        playerScoreCard.checkScore(playerHand);
        System.out.println("What line would you like to use?");
        String lineUsed = scan.next();
        switch (lineUsed.toLowerCase()) {
            case "3k":
                playerScoreCard.getLine(diceRange + 0).setUsed(true);
                break;
            case "4k":
                playerScoreCard.getLine(diceRange + 1).setUsed(true);
                break;
            case "fh":
                playerScoreCard.getLine(diceRange + 2).setUsed(true);
                break;
            case "ss":
                playerScoreCard.getLine(diceRange + 3).setUsed(true);
                break;
            case "ls":
                playerScoreCard.getLine(diceRange + 4).setUsed(true);
                break;
            case "ya":
                playerScoreCard.getLine(diceRange + 5).setUsed(true);
                break;
            case "ch":
                playerScoreCard.getLine(diceRange + 6).setUsed(true);
                break;

        }
        for (int i = 0; i < diceRange; i++) {
            if ( == 1)

        }

    }
}
