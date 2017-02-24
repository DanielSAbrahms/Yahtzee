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

    public void playRound(int rollsPerTurn) {
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
    }
}
