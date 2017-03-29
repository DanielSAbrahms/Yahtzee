/**
 * @author Daniel Abrahms
 * @version 1.0
 * Launches the GUI for Yahtzee
 */
public class YahtzeeApplication {
    public static void main (String [] args) {
        YahtzeeGUI frame = new YahtzeeGUI("Yahtzee");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(1280, 760);
        frame.setVisible(true);
    }
}
