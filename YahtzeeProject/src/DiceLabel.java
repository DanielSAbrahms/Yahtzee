import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


/**
 * Created by irish on 3/24/2017.
 */
public class DiceLabel extends JLabel {
    private Dice d;
    private Image[] images;

    public DiceLabel(Image[] diceImages ) {
        images = diceImages;
        setD(new Dice(6));
        setIcon(new ImageIcon(images[0]));
    }

    public Dice getD() {
        return d;
    }

    public void setD(Dice d) {
        this.d = d;
    }

    public void refresh(){
        setIcon(new ImageIcon(images[d.getValue()]));
    }




}
