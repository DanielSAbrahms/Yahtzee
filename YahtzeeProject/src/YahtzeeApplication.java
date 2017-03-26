import java.awt.EventQueue;
import javax.swing.JFrame;

public class YahtzeeApplication {
    public static void main (String [] args) {
        YahtzeeGUI frame = new YahtzeeGUI("Yahtzee");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setVisible(true);

        int sidesPerDice = 6;
        int diceInGame = 5;
        int rollsPerTurn = 3;

        //SaveFile file = new SaveFile(sidesPerDice, diceInGame, rollsPerTurn);

        //file.read();
        //sidesPerDice = file.getSidesPerDice();
        //diceInGame = file.getDiceInGame();
        //rollsPerTurn = file.getRollsPerTurn();

        //ScoreCard playerOneScoreCard = new ScoreCard(sidesPerDice);

        /*
        for (int i = 0; i < sidesPerDice + 7; i++) {
            Hand playerOneHand = new Hand(diceInGame, rollsPerTurn, sidesPerDice);
            for (int j = 0; j < rollsPerTurn; j++) {
                playerOneHand.changeHand(playerOneScoreCard, frame.getKeepString());
            }
            GUIRound r = new GUIRound("Player 1", playerOneScoreCard, playerOneHand);
            frame.setRound(r);
            r.playRound(rollsPerTurn, sidesPerDice, String.valueOf(frame.getSelectedLine()));


        }
        */

    }
}
