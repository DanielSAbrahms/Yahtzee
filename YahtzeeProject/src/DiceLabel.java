import javax.swing.*;
import java.awt.*;


/**
 * @author Daniel Abrahms
 * @version 1.0
 */
public class DiceLabel extends JToggleButton {
    private Dice d;
    private Image[] images;

    /**
     * @param diceImages Array of diceImages, with index 0 corresponding to unknown dice
     */
    public DiceLabel(Image[] diceImages, int newSidesPerDice ) {
        images = diceImages;
        setD(new Dice(newSidesPerDice));
        setIcon(new ImageIcon(images[0]));
        d.setRange(newSidesPerDice);
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
        setIcon(new ImageIcon(images[d.getValue()]));
        if (d.getKept()) {
            setIcon(new ImageIcon(images[d.getValue()+d.getRange()]));
        }
    }




}
