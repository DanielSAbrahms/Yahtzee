import javax.swing.*;
import java.awt.*;


/**
 * @author Daniel Abrahms
 * @version 1.0
 */
public class SpecialDiceLabel extends JToggleButton {
    private final String DOUBLE_LETTER = "Double Letter";
    private final String DOUBLE_POINTS = "Double Points";
    private final String BLANK_LETTER = "Blank Letter";
    private final String FORCED_HAND = "Forced Hand";
    private SpecialDice sd;
    private int range = 6;
    private Image[] images;

    /**
     * @param diceImages Array of diceImages, with index 0 corresponding to unknown dice
     */
    public SpecialDiceLabel(Image[] diceImages) {
        images = diceImages;
        range = 4;
        setIcon(new ImageIcon(images[0]));
        refresh();
    }

    /**
     * @return Dice variable
     */
    public SpecialDice getSd() {
        return sd;
    }

    /**
     * @param sd Dice Object to be the private variable
     */
    public void setSd(SpecialDice sd) {
        this.sd = sd;
    }

    /**
     * Sets the icon based on the Dice Value
     */
    public void refresh(){
        if (sd == null) {
            sd = new SpecialDice();
            return;
        }
        if (sd.getValue().equals(DOUBLE_LETTER)) this.setIcon(new ImageIcon(images[1]));
        if (sd.getValue().equals(DOUBLE_POINTS)) this.setIcon(new ImageIcon(images[2]));
        if (sd.getValue().equals(BLANK_LETTER)) this.setIcon(new ImageIcon(images[3]));
        if (sd.getValue().equals(FORCED_HAND)) this.setIcon(new ImageIcon(images[4]));
        repaint();
    }


    public void setRange(int range) {
        this.range = range;
    }


}
