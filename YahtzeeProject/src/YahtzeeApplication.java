import javax.swing.*;
import java.io.OutputStream;
import java.io.PrintStream;


/**
 * @author Daniel Abrahms
 * @version 1.0
 * Overrides the Stream Class to prevent console output
 */
class NullOutputStream extends OutputStream {
    @Override
    public void write(int b){
        return;
    }
    @Override
    public void write(byte[] b){
        return;
    }
    @Override
    public void write(byte[] b, int off, int len){
        return;
    }
    public NullOutputStream(){
    }
}
/**
 * @author Daniel Abrahms
 * @version 1.0
 * Launches the GUI for Yahtzee
 */
public class YahtzeeApplication {
    public static void main (String [] args) {
        System.setOut(new PrintStream(new NullOutputStream()));
        YahtzeeGUI frame = new YahtzeeGUI("WORDZEE GOTY");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(1280, 760);
        frame.setIconImage(new ImageIcon(System.getProperty("user.home")
                + "/Desktop/Yahtzee/YahtzeeProject/src//Icon.png").getImage());
        frame.setVisible(true);
    }
}
