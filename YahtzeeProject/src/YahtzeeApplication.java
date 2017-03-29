import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author Daniel Abrahms
 * @version 1.0
 * Launches the GUI for Yahtzee
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
public class YahtzeeApplication {
    public static void main (String [] args) {
        System.setOut(new PrintStream(new NullOutputStream()));
        YahtzeeGUI frame = new YahtzeeGUI("Yahtzee");
        frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
        frame.setSize(1280, 760);
        frame.setVisible(true);
    }
}
