import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;


/**
 * @author Daniel Abrahms
 * @version 1.0
 */
public class DiceLabel extends JToggleButton {
    private Dice d;
    private int range;
    private Image[] images;
    boolean isVowel;

    /**
     * @param diceImages Array of diceImages, with index 0 corresponding to unknown dice
     */
    public DiceLabel(Image[] diceImages, int newSidesPerDice ) {
        range = newSidesPerDice;
        images = diceImages;
        if (newSidesPerDice == 6) isVowel = true;
        else isVowel = false;
        setIcon(new ImageIcon(images[0]));
    }

    /**
     * @return Dice variable
     */
    public Dice getD() {
        return d;
    }

    /**
     * @param d Dice Object to be the private variable
     */
    public void setD(Dice d) {
        this.d = d;
    }

    /**
     * Sets the icon based on the Dice Value
     */
    public void refresh(){
        if (d == null) d = new Dice(isVowel);
        if (d.getKept()) {
            setIcon(new ImageIcon(images[d.charToInt(d.getValue())+26]));
        } else {
            setIcon(new ImageIcon(images[d.charToInt(d.getValue())]));
        }
    }


    public void setRange(int range) {
        this.range = range;
    }


}
