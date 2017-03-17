import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;


/**
 * Created by irish on 3/16/2017.
 */
public class YahtzeeGUI extends JFrame{

    private JPanel panel;
    private JTable scTable;
    private JLabel dice1;
    private JLabel dice2;
    private JLabel dice3;
    private JLabel dice4;
    private JLabel dice5;
    private JButton rollButton;
    private JCheckBox keepDice1;
    private JCheckBox keepDice2;
    private JCheckBox keepDice3;
    private JCheckBox keepDice4;
    private JCheckBox keepDice5;

    // Size Constants for Components
    private static final int DICE_WIDTH = 150;
    private static final int DICE_HEIGHT = 150;
    private static final int BUTTON_HEIGHT = 50;
    private static final int BUTTON_WIDTH = 300;
    private static final int CHECKBOX_WIDTH = 20;
    private static final int CHECKBOX_HEIGHT = 20;
    private static final int TABLE_WIDTH = 1030;
    private static final int TABLE_HEIGHT = 379;

    // Location Constants for Components
    private static final int DICE_X_COOR = 119;
    private static final int DICE_Y_COOR = 44;
    private static final int BUTTON_X_COOR = 491;
    private static final int BUTTON_Y_COOR = 656;
    private static final int CHECKBOX_X_COOR = 185;
    private static final int CHECKBOX_Y_COOR = 216;
    private static final int TABLE_X_COOR = 119;
    private static final int TABLE_Y_COOR = 258;

    // User Directory to Locate Source Images
    private static final String USER_DIR = "C:/Users/irish/Desktop/Yahtzee/YahtzeeProject/src";

    public YahtzeeGUI(String title) {
        super(title); // Assigns JFrame title

        // Initializes Images
        BufferedImage diceSide1_raw = null;
        Image diceSide1 = null;
        BufferedImage diceSide2_raw = null;
        Image diceSide2 = null;
        BufferedImage diceSide3_raw = null;
        Image diceSide3 = null;
        BufferedImage diceSide4_raw = null;
        Image diceSide4 = null;
        BufferedImage diceSide5_raw = null;
        Image diceSide5 = null;
        BufferedImage diceSide6_raw = null;
        Image diceSide6 = null;
        BufferedImage unknownDice_raw = null;
        Image unknownDice = null;
        BufferedImage background = null;

        // Loads Images
        try {
            diceSide1_raw = ImageIO.read(new File(USER_DIR + "/diceSide1.png"));
            diceSide1 = diceSide1_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
            diceSide2_raw = ImageIO.read(new File(USER_DIR + "/diceSide2.png"));
            diceSide2 = diceSide2_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
            diceSide3_raw = ImageIO.read(new File(USER_DIR + "/diceSide3.png"));
            diceSide3 = diceSide3_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
            diceSide4_raw = ImageIO.read(new File(USER_DIR + "/diceSide4.png"));
            diceSide4 = diceSide4_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
            diceSide5_raw = ImageIO.read(new File(USER_DIR + "/diceSide5.png"));
            diceSide5 = diceSide5_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
            diceSide6_raw = ImageIO.read(new File(USER_DIR + "/diceSide6.png"));
            diceSide6 = diceSide6_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
            unknownDice_raw = ImageIO.read(new File(USER_DIR + "/unknownDice.png"));
            unknownDice = unknownDice_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
            background = ImageIO.read(new File(USER_DIR + "/background.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        setLayout(null);

        this.setContentPane(new JLabel(new ImageIcon(background)));
        Container c = getContentPane();

        c.setBackground(Color.WHITE);


        rollButton = new JButton();
        rollButton.setText("Roll Hand");
        rollButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        rollButton.setLocation(BUTTON_X_COOR, BUTTON_Y_COOR);
        c.add(rollButton);

        dice1 = new JLabel(new ImageIcon(unknownDice));
        dice1.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice1.setLocation(DICE_X_COOR + (0*220), DICE_Y_COOR);
        c.add(dice1);

        dice2 = new JLabel(new ImageIcon(unknownDice));
        dice2.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice2.setLocation(DICE_X_COOR + (1*220), DICE_Y_COOR);
        c.add(dice2);

        dice3 = new JLabel(new ImageIcon(unknownDice));
        dice3.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice3.setLocation(DICE_X_COOR + (2*220), DICE_Y_COOR);
        c.add(dice3);

        dice4 = new JLabel(new ImageIcon(unknownDice));
        dice4.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice4.setLocation(DICE_X_COOR + (3*220), DICE_Y_COOR);
        c.add(dice4);

        dice5 = new JLabel(new ImageIcon(unknownDice));
        dice5.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice5.setLocation(DICE_X_COOR + (4*220), DICE_Y_COOR);
        c.add(dice5);

        keepDice1 = new JCheckBox();
        keepDice1.setSize(CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
        keepDice1.setLocation(CHECKBOX_X_COOR + (0*220), CHECKBOX_Y_COOR);
        c.add(keepDice1);

        keepDice2 = new JCheckBox();
        keepDice2.setSize(CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
        keepDice2.setLocation(CHECKBOX_X_COOR + (1*220), CHECKBOX_Y_COOR);
        c.add(keepDice2);

        keepDice3 = new JCheckBox();
        keepDice3.setSize(CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
        keepDice3.setLocation(CHECKBOX_X_COOR + (2*220), CHECKBOX_Y_COOR);
        c.add(keepDice3);

        keepDice4 = new JCheckBox();
        keepDice4.setSize(CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
        keepDice4.setLocation(CHECKBOX_X_COOR + (3*220), CHECKBOX_Y_COOR);
        c.add(keepDice4);

        keepDice5 = new JCheckBox();
        keepDice5.setSize(CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
        keepDice5.setLocation(CHECKBOX_X_COOR + (4*220), CHECKBOX_Y_COOR);
        c.add(keepDice5);

        scTable = new JTable();
        scTable.setSize(TABLE_WIDTH, TABLE_HEIGHT);
        scTable.setLocation(TABLE_X_COOR, TABLE_Y_COOR);
        c.add(scTable);





    }

}
