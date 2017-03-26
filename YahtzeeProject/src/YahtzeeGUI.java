import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;


/**
 * @author Daniel Abrahms
 * @version 1.0
 */

public class YahtzeeGUI extends JFrame{
    //<editor-fold desc = "Private Variables">

    private JPanel panel;
    private SCTable scTable;
    private DiceLabel dice1;
    private DiceLabel dice2;
    private DiceLabel dice3;
    private DiceLabel dice4;
    private DiceLabel dice5;
    private DiceLabel dice6;
    private DiceLabel dice7;
    private JLabel dicePerGame;
    private JLabel sidesPerDice;
    private JButton rollButton;
    private JButton confirmSelectionButton;
    private JCheckBox keepDice1;
    private JCheckBox keepDice2;
    private JCheckBox keepDice3;
    private JCheckBox keepDice4;
    private JCheckBox keepDice5;
    private JCheckBox keepDice6;
    private JCheckBox keepDice7;
    private JComboBox pickDicePerGame;
    private JComboBox pickSidesPerDice;
    private JButton saveGame;
    private JButton newGame;
    private JButton loadGame;

    private GUIRound thisRound;
    private int diceInPlay = 5;
    private int sidesOnADice = 6;
    private int roundsLeft;
    private int rollsLeft;
    private int dice1Value;
    private int dice2Value;
    private int dice3Value;
    private int dice4Value;
    private int dice5Value;
    private int dice6Value;
    private int dice7Value;
    private int selectedLine;
    private String[] scoreCardNames;
    private Object[][] scoreCardValues;

    //</editor-fold>

    //<editor-fold desc="Size Constants for Components">
    private static final int DICE_WIDTH = 150;
    private static final int DICE_HEIGHT = 150;
    private static final int BUTTON_HEIGHT = 50;
    private static final int BUTTON_WIDTH = 300;
    private static final int GAME_BUTTON_HEIGHT = 30;
    private static final int GAME_BUTTON_WIDTH = 100;
    private static final int CHECKBOX_WIDTH = 20;
    private static final int CHECKBOX_HEIGHT = 20;
    private static final int TABLE_WIDTH = 1030;
    private static final int TABLE_HEIGHT = 379;
    private static final int LABEL_WIDTH = 150;
    private static final int LABEL_HEIGHT = 30;
    //</editor-fold>

    //<editor-fold desc= "Location Constants for Components">
    private static final int DICE_X_COOR = 50;
    private static final int DICE_Y_COOR = 44;
    private static final int BUTTON_X_COOR = 190;
    private static final int BUTTON_Y_COOR = 656;
    private static final int GAME_BUTTON_X_COOR = 1115;
    private static final int GAME_BUTTON_Y_COOR = 330;
    private static final int CHECKBOX_X_COOR = 116;
    private static final int CHECKBOX_Y_COOR = 216;
    private static final int TABLE_X_COOR = 50;
    private static final int TABLE_Y_COOR = 258;
    private static final int LABEL_X_COOR = 1105;
    private static final int LABEL_Y_COOR = 44;
    //</editor-fold>

    //<editor-fold desc = "Image Constants">
    private final Image unknownDice;
    private final Image diceSide1;
    private final Image diceSide2;
    private final Image diceSide3;
    private final Image diceSide4;
    private final Image diceSide5;
    private final Image diceSide6;
    //</editor-fold>

    // User Directory to Locate Source Images
    private static final String USER_DIR = "C:/Users/irish/Desktop/Yahtzee/YahtzeeProject/src";

    public YahtzeeGUI(String title) {
        super(title);
        roundsLeft = sidesOnADice + 7;
        rollsLeft = 3;
         // Assigns JFrame title

        //<editor-fold desc="Initializes Images">
        BufferedImage diceSide1_raw = null;
        BufferedImage diceSide2_raw = null;
        BufferedImage diceSide3_raw = null;
        BufferedImage diceSide4_raw = null;
        BufferedImage diceSide5_raw = null;
        BufferedImage diceSide6_raw = null;
        BufferedImage unknownDice_raw = null;
        BufferedImage background = null;
        //</editor-fold>

        //<editor-fold desc = "Loads Images">
        try {
            diceSide1_raw = ImageIO.read(new File(USER_DIR + "/diceSide1.png"));
            diceSide2_raw = ImageIO.read(new File(USER_DIR + "/diceSide2.png"));
            diceSide3_raw = ImageIO.read(new File(USER_DIR + "/diceSide3.png"));
            diceSide4_raw = ImageIO.read(new File(USER_DIR + "/diceSide4.png"));
            diceSide5_raw = ImageIO.read(new File(USER_DIR + "/diceSide5.png"));
            diceSide6_raw = ImageIO.read(new File(USER_DIR + "/diceSide6.png"));
            unknownDice_raw = ImageIO.read(new File(USER_DIR + "/unknownDice.png"));
            background = ImageIO.read(new File(USER_DIR + "/background.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        unknownDice = unknownDice_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide1 = diceSide1_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide2 = diceSide2_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide3 = diceSide3_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide4 = diceSide4_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide5 = diceSide5_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide6 = diceSide6_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        //</editor-fold>

        setLayout(null);

        this.setContentPane(new JLabel(new ImageIcon(background)));
        Container c = getContentPane();

        c.setBackground(Color.GREEN);

        //<editor-fold desc="Bottom Buttons Creation">
        rollButton = new JButton();
        rollButton.setText("Roll Hand");
        rollButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        rollButton.setLocation(BUTTON_X_COOR, BUTTON_Y_COOR);
        c.add(rollButton);

        confirmSelectionButton = new JButton();
        confirmSelectionButton.setText("Confirm Selection");
        confirmSelectionButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        confirmSelectionButton.setLocation(BUTTON_X_COOR+450, BUTTON_Y_COOR);
        c.add(confirmSelectionButton);
        //</editor-fold>

        //<editor-fold desc="Dice Label Creation">
        Image[] images = {unknownDice, diceSide1, diceSide2, diceSide3, diceSide4, diceSide5, diceSide6};

        dice1 = new DiceLabel(images);
        dice1.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice1.setLocation(DICE_X_COOR + (0*225), DICE_Y_COOR);
        c.add(dice1);

        dice2 = new DiceLabel(images);
        dice2.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice2.setLocation(DICE_X_COOR + (1*225), DICE_Y_COOR);
        c.add(dice2);

        dice3 = new DiceLabel(images);
        dice3.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice3.setLocation(DICE_X_COOR + (2*225), DICE_Y_COOR);
        c.add(dice3);

        dice4 = new DiceLabel(images);
        dice4.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice4.setLocation(DICE_X_COOR + (3*225), DICE_Y_COOR);
        c.add(dice4);

        dice5 = new DiceLabel(images);
        dice5.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice5.setLocation(DICE_X_COOR + (4*225), DICE_Y_COOR);
        c.add(dice5);

        dice6 = new DiceLabel(images);
        dice6.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice6.setLocation(DICE_X_COOR + (5*225), DICE_Y_COOR);

        dice7 = new DiceLabel(images);
        dice7.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice7.setLocation(DICE_X_COOR + (6*225), DICE_Y_COOR);

        //</editor-fold>

        //<editor-fold desc="Keep Dice Checkbox Creation">
        keepDice1 = new JCheckBox();
        keepDice1.setSize(CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
        keepDice1.setLocation(CHECKBOX_X_COOR + (0*225), CHECKBOX_Y_COOR);
        c.add(keepDice1);

        keepDice2 = new JCheckBox();
        keepDice2.setSize(CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
        keepDice2.setLocation(CHECKBOX_X_COOR + (1*225), CHECKBOX_Y_COOR);
        c.add(keepDice2);

        keepDice3 = new JCheckBox();
        keepDice3.setSize(CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
        keepDice3.setLocation(CHECKBOX_X_COOR + (2*225), CHECKBOX_Y_COOR);
        c.add(keepDice3);

        keepDice4 = new JCheckBox();
        keepDice4.setSize(CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
        keepDice4.setLocation(CHECKBOX_X_COOR + (3*225), CHECKBOX_Y_COOR);
        c.add(keepDice4);

        keepDice5 = new JCheckBox();
        keepDice5.setSize(CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
        keepDice5.setLocation(CHECKBOX_X_COOR + (4*225), CHECKBOX_Y_COOR);
        c.add(keepDice5);

        keepDice6 = new JCheckBox();
        keepDice6.setSize(CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
        keepDice6.setLocation(CHECKBOX_X_COOR + (5*225), CHECKBOX_Y_COOR);


        keepDice7 = new JCheckBox();
        keepDice7.setSize(CHECKBOX_WIDTH, CHECKBOX_HEIGHT);
        keepDice7.setLocation(CHECKBOX_X_COOR + (6*225), CHECKBOX_Y_COOR);
        //</editor-fold>

        //<editor-fold desc="Scorecard Table Creation">
        scTable = new SCTable() {
            private static final long serialVersionUID = 1L;
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        scTable.setSelectionModel(new ForcedListSelectionModel());
        scTable.setRowSelectionAllowed(true);
        scTable.setRowHeight(27);
        scTable.setFont(new Font ("Times New Roman", Font.PLAIN , 30));
        scTable.setSize(TABLE_WIDTH, TABLE_HEIGHT);
        scTable.setLocation(TABLE_X_COOR, TABLE_Y_COOR);
        c.add(scTable);
        //</editor-fold>

        //<editor-fold desc="Dice Per Game Menu Creation">
        dicePerGame = new JLabel();
        dicePerGame.setFont(new Font ("Garamond", Font.PLAIN , 20));
        dicePerGame.setText("Dice Per Game");
        dicePerGame.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        dicePerGame.setLocation(LABEL_X_COOR, LABEL_Y_COOR);
        c.add(dicePerGame);


        String[] dicePerGameOptions = {"5", "6", "7"};
        pickDicePerGame = new JComboBox(dicePerGameOptions);
        pickDicePerGame.setSelectedIndex(0);
        pickDicePerGame.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        pickDicePerGame.setLocation(LABEL_X_COOR, LABEL_Y_COOR + 30);
        c.add(pickDicePerGame);
        //</editor-fold>

        //<editor-fold desc="Sides Per Dice Menu Creation">
        sidesPerDice = new JLabel();
        sidesPerDice.setFont(new Font ("Garamond", Font.PLAIN , 20));
        sidesPerDice.setText("Sides Per Dice");
        sidesPerDice.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        sidesPerDice.setLocation(LABEL_X_COOR, LABEL_Y_COOR + 100);
        c.add(sidesPerDice);

        String[] sidesPerDiceOptions = {"6", "8", "12"};
        pickSidesPerDice = new JComboBox(sidesPerDiceOptions);
        pickSidesPerDice.setSelectedIndex(0);
        pickSidesPerDice.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        pickSidesPerDice.setLocation(LABEL_X_COOR, LABEL_Y_COOR + 130);
        c.add(pickSidesPerDice);
        //</editor-fold>4

        //<editor-fold desc="Game Buttons">
        saveGame = new JButton();
        saveGame.setText("Save Game");
        saveGame.setSize(GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
        saveGame.setLocation(GAME_BUTTON_X_COOR, GAME_BUTTON_Y_COOR);
        c.add(saveGame);

        newGame = new JButton();
        newGame.setText("New Game");
        newGame.setSize(GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
        newGame.setLocation(GAME_BUTTON_X_COOR, GAME_BUTTON_Y_COOR+100);
        c.add(newGame);

        loadGame = new JButton();
        loadGame.setText("Load Game");
        loadGame.setSize(GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
        loadGame.setLocation(GAME_BUTTON_X_COOR, GAME_BUTTON_Y_COOR+200);
        c.add(loadGame);
        //</editor-fold>

        SaveFile file = new SaveFile(sidesOnADice, diceInPlay, 3);

        file.read();
        sidesOnADice = file.getSidesPerDice();
        diceInPlay = file.getDiceInGame();
        

        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetDice();
                syncDice();
            }
        });

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rollsLeft <= 0){
                    checkScorePotential();
                    rollsLeft = 3;
                } else {
                    dice1.getD().roll();
                    dice2.getD().roll();
                    dice3.getD().roll();
                    dice4.getD().roll();
                    dice5.getD().roll();
                    dice6.getD().roll();
                    dice7.getD().roll();
                    syncDice();
                    rollsLeft--;
                }

            }
        });

        pickDicePerGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetDice();
                int LABEL_SPACER;
                if (pickDicePerGame.getSelectedItem().equals("5")){
                    diceInPlay = 5;
                    LABEL_SPACER = 225;
                    c.remove(dice7);
                    c.remove(keepDice7);
                    c.remove(dice6);
                    c.remove(keepDice6);
                    dice5.setLocation(DICE_X_COOR + (4*LABEL_SPACER), DICE_Y_COOR);
                    dice4.setLocation(DICE_X_COOR + (3*LABEL_SPACER), DICE_Y_COOR);
                    dice3.setLocation(DICE_X_COOR + (2*LABEL_SPACER), DICE_Y_COOR);
                    dice2.setLocation(DICE_X_COOR + (1*LABEL_SPACER), DICE_Y_COOR);
                    dice1.setLocation(DICE_X_COOR + (0*LABEL_SPACER), DICE_Y_COOR);
                    keepDice1.setLocation(CHECKBOX_X_COOR + (0*LABEL_SPACER), CHECKBOX_Y_COOR);
                    keepDice2.setLocation(CHECKBOX_X_COOR + (1*LABEL_SPACER), CHECKBOX_Y_COOR);
                    keepDice3.setLocation(CHECKBOX_X_COOR + (2*LABEL_SPACER), CHECKBOX_Y_COOR);
                    keepDice4.setLocation(CHECKBOX_X_COOR + (3*LABEL_SPACER), CHECKBOX_Y_COOR);
                    keepDice5.setLocation(CHECKBOX_X_COOR + (4*LABEL_SPACER), CHECKBOX_Y_COOR);
                    repaint();
                }
                else if (pickDicePerGame.getSelectedItem().equals("6")){
                    diceInPlay = 6;
                    LABEL_SPACER = 180;
                    c.remove(dice7);
                    c.remove(keepDice7);
                    c.add(dice6);
                    c.add(keepDice6);
                    dice6.setLocation(DICE_X_COOR + (5*LABEL_SPACER), DICE_Y_COOR);
                    dice5.setLocation(DICE_X_COOR + (4*LABEL_SPACER), DICE_Y_COOR);
                    dice4.setLocation(DICE_X_COOR + (3*LABEL_SPACER), DICE_Y_COOR);
                    dice3.setLocation(DICE_X_COOR + (2*LABEL_SPACER), DICE_Y_COOR);
                    dice2.setLocation(DICE_X_COOR + (1*LABEL_SPACER), DICE_Y_COOR);
                    dice1.setLocation(DICE_X_COOR + (0*LABEL_SPACER), DICE_Y_COOR);
                    keepDice1.setLocation(CHECKBOX_X_COOR + (0*LABEL_SPACER), CHECKBOX_Y_COOR);
                    keepDice2.setLocation(CHECKBOX_X_COOR + (1*LABEL_SPACER), CHECKBOX_Y_COOR);
                    keepDice3.setLocation(CHECKBOX_X_COOR + (2*LABEL_SPACER), CHECKBOX_Y_COOR);
                    keepDice4.setLocation(CHECKBOX_X_COOR + (3*LABEL_SPACER), CHECKBOX_Y_COOR);
                    keepDice5.setLocation(CHECKBOX_X_COOR + (4*LABEL_SPACER), CHECKBOX_Y_COOR);
                    keepDice6.setLocation(CHECKBOX_X_COOR + (5*LABEL_SPACER), CHECKBOX_Y_COOR);
                    repaint();
                } else if (pickDicePerGame.getSelectedItem().equals("7")){
                    diceInPlay = 7;
                    LABEL_SPACER = 150;
                    c.add(dice7);
                    c.add(keepDice7);
                    c.add(dice6);
                    c.add(keepDice6);
                    dice7.setLocation(DICE_X_COOR + (6*LABEL_SPACER), DICE_Y_COOR);
                    dice6.setLocation(DICE_X_COOR + (5*LABEL_SPACER), DICE_Y_COOR);
                    dice5.setLocation(DICE_X_COOR + (4*LABEL_SPACER), DICE_Y_COOR);
                    dice4.setLocation(DICE_X_COOR + (3*LABEL_SPACER), DICE_Y_COOR);
                    dice3.setLocation(DICE_X_COOR + (2*LABEL_SPACER), DICE_Y_COOR);
                    dice2.setLocation(DICE_X_COOR + (1*LABEL_SPACER), DICE_Y_COOR);
                    dice1.setLocation(DICE_X_COOR + (0*LABEL_SPACER), DICE_Y_COOR);
                    keepDice1.setLocation(CHECKBOX_X_COOR + (0*LABEL_SPACER), CHECKBOX_Y_COOR);
                    keepDice2.setLocation(CHECKBOX_X_COOR + (1*LABEL_SPACER), CHECKBOX_Y_COOR);
                    keepDice3.setLocation(CHECKBOX_X_COOR + (2*LABEL_SPACER), CHECKBOX_Y_COOR);
                    keepDice4.setLocation(CHECKBOX_X_COOR + (3*LABEL_SPACER), CHECKBOX_Y_COOR);
                    keepDice5.setLocation(CHECKBOX_X_COOR + (4*LABEL_SPACER), CHECKBOX_Y_COOR);
                    keepDice6.setLocation(CHECKBOX_X_COOR + (5*LABEL_SPACER), CHECKBOX_Y_COOR);
                    keepDice7.setLocation(CHECKBOX_X_COOR + (6*LABEL_SPACER), CHECKBOX_Y_COOR);
                    repaint();
                }
            }
        });

        confirmSelectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        keepDice1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keepDice1.isSelected()) {
                    dice1.getD().setKept(true);
                } else {
                    dice1.getD().setKept(false);
                }
            }
        });

        keepDice2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keepDice2.isSelected()) {
                    dice2.getD().setKept(true);
                } else {
                    dice2.getD().setKept(false);
                }
            }
        });

        keepDice3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keepDice3.isSelected()) {
                    dice3.getD().setKept(true);
                } else {
                    dice3.getD().setKept(false);
                }
            }
        });

        keepDice4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keepDice4.isSelected()) {
                    dice4.getD().setKept(true);
                } else {
                    dice4.getD().setKept(false);
                }
            }
        });

        keepDice5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keepDice5.isSelected()) {
                    dice5.getD().setKept(true);
                } else {
                    dice5.getD().setKept(false);
                }
            }
        });

        keepDice6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keepDice6.isSelected()) {
                    dice6.getD().setKept(true);
                } else {
                    dice6.getD().setKept(false);
                }
            }
        });

        keepDice7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keepDice7.isSelected()) {
                    dice7.getD().setKept(true);
                } else {
                    dice7.getD().setKept(false);
                }
            }
        });

    }

    /**
     * @param toBeChanged The JLabel that the image will change
     * @param newImage The Image that JLabel will change to
     */
    private void changeImage(JLabel toBeChanged, Image newImage) {
        toBeChanged.setIcon(new ImageIcon(newImage));
    }

    private void resetDice(){
        JLabel[] dice = {dice1, dice2, dice3, dice4, dice5, dice6, dice7};
        for (int i = 0; i < dice.length; i++){
            changeImage(dice[i], unknownDice);
        }
    }

    private void checkScorePotential(){
        scTable.refresh();
    }

    public void setRound(GUIRound newRound){
        thisRound = newRound;
    }

    public int getSelectedLine() {
        return selectedLine;
    }

    public String getKeepString() {
        String s = "";
        JCheckBox[] a = {keepDice1, keepDice2, keepDice3, keepDice4, keepDice5, keepDice6, keepDice7};
        for (int i = 0; i < diceInPlay; i++){
            if (a[i].isSelected()) s+='y';
            else s+='n';
        }
        return s;
    }

    public void syncDice(){
        dice1.refresh();
        dice2.refresh();
        dice3.refresh();
        dice4.refresh();
        dice5.refresh();
        dice6.refresh();
        dice7.refresh();
    }

}
 class ForcedListSelectionModel extends DefaultListSelectionModel {
    public ForcedListSelectionModel() {
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @Override
    public void clearSelection(){
    }

    @Override
    public void removeSelectionInterval(int index0, int index1) {
    }
}
