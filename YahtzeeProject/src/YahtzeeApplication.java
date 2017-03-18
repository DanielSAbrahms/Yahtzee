import java.awt.EventQueue;
import javax.swing.JFrame;

public class YahtzeeApplication {
    public static void main (String [] args) {
        YahtzeeGUI frame = new YahtzeeGUI("Yahtzee");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        frame.setVisible(true);
    }
}
