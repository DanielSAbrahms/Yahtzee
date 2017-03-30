import javax.swing.*;
import java.awt.*;


/**
 * @author Daniel Abrahms
 * @version 1.0
 */
public class DiceLabel extends JToggleButton {
    private Dice d;
    private int range;
    private Image[] images;

    /**
     * @param diceImages Array of diceImages, with index 0 corresponding to unknown dice
     */
    public DiceLabel(Image[] diceImages, int newSidesPerDice ) {
        range = newSidesPerDice;
        images = diceImages;
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
        if (d == null) d = new Dice(range);
        setIcon(new ImageIcon(images[d.getValue()]));
        if (d.getKept()) {
            setIcon(new ImageIcon(images[d.getValue()+d.getRange()]));
        }
    }


    public void setRange(int range) {
        this.range = range;
    }
}
