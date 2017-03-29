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
 * Creates a custom JFrame with Yahtzee functionality.
 */

class YahtzeeGUI extends JFrame{
    //<editor-fold desc = "Private Variables">
    private SCTable scTable;
    private DiceLabel dice1Label;
    private DiceLabel dice2Label;
    private DiceLabel dice3Label;
    private DiceLabel dice4Label;
    private DiceLabel dice5Label;
    private DiceLabel dice6Label;
    private DiceLabel dice7Label;
    private JLabel dicePerGameLabel;
    private JLabel sidesPerDiceLabel;
    private JLabel totalScoreLabel;
    private JLabel upperTotalLabel;
    private JLabel lowerTotalLabel;
    private JLabel bonusLabel;
    private JLabel rollsLeftLabel;
    private JButton rollButton;
    private JButton confirmSelectionButton;
    /*
    private JCheckBox dice1Label;
    private JCheckBox dice2Label;
    private JCheckBox dice3Label;
    private JCheckBox dice4Label;
    private JCheckBox dice5Label;
    private JCheckBox dice6Label;
    private JCheckBox dice7Label;
    */
    private JComboBox dicePerGameBox;
    private JComboBox sidesPerDiceBox;
    private JButton saveGameButton;
    private JButton newGameButton;
    private JButton loadGameButton;
    private JOptionPane gameOverPopup;

    private int dicePerGameValue = 5;
    private int sidesPerDiceValue = 6;
    private int totalScoreValue = 0;
    private int upperScoreValue = 0;
    private int lowerScoreValue = 0;
    private int bonusValue = 0;
    private int roundsLeft;
    private int rollsLeft;
    private boolean pause = false;
    private Hand h;

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
    private static final int GAME_BUTTON_X_COOR = 1135;
    private static final int GAME_BUTTON_Y_COOR = 330;
    private static final int CHECKBOX_X_COOR = 116;
    private static final int CHECKBOX_Y_COOR = 216;
    private static final int TABLE_X_COOR = 50;
    private static final int TABLE_Y_COOR = 258;
    private static final int LABEL_X_COOR = 1105;
    private static final int LABEL_Y_COOR = 44;
    private static final int SCORE_LABEL_X_COOR = 1095;
    private static final int SCORE_LABEL_Y_COOR = 530;
    private static final int ROLLS_LEFT_LABEL_X_COOR = 308;
    private static final int ROLLS_LEFT_LABEL_Y_COOR = 663;
    //</editor-fold>

    //<editor-fold desc = "Image Constants">
    private final Image unknownDice;
    private final Image diceSide1Image;
    private final Image diceSide2Image;
    private final Image diceSide3Image;
    private final Image diceSide4Image;
    private final Image diceSide5Image;
    private final Image diceSide6Image;
    private final Image diceSide1LockedImage;
    private final Image diceSide2LockedImage;
    private final Image diceSide3LockedImage;
    private final Image diceSide4LockedImage;
    private final Image diceSide5LockedImage;
    private final Image diceSide6LockedImage;
    //</editor-fold>

    // User Directory to Locate Source Images
    private static final String USER_DIR = System.getProperty("user.home") + "/Desktop/Yahtzee/YahtzeeProject/src";



    YahtzeeGUI(String title) {
        super(title);
        roundsLeft = sidesPerDiceValue + 7;
        rollsLeft = 3;

         // Assigns JFrame title

        //<editor-fold desc="Initializes Images">
        BufferedImage diceSide1_raw = null;
        BufferedImage diceSide2_raw = null;
        BufferedImage diceSide3_raw = null;
        BufferedImage diceSide4_raw = null;
        BufferedImage diceSide5_raw = null;
        BufferedImage diceSide6_raw = null;
        BufferedImage diceSide1_Locked_raw = null;
        BufferedImage diceSide2_Locked_raw = null;
        BufferedImage diceSide3_Locked_raw = null;
        BufferedImage diceSide4_Locked_raw = null;
        BufferedImage diceSide5_Locked_raw = null;
        BufferedImage diceSide6_Locked_raw = null;
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
            diceSide1_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSide1_Locked.png"));
            diceSide2_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSide2_Locked.png"));
            diceSide3_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSide3_Locked.png"));
            diceSide4_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSide4_Locked.png"));
            diceSide5_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSide5_Locked.png"));
            diceSide6_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSide6_Locked.png"));
            unknownDice_raw = ImageIO.read(new File(USER_DIR + "/unknownDice.png"));
            background = ImageIO.read(new File(USER_DIR + "/background.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        unknownDice = unknownDice_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide1Image = diceSide1_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide2Image = diceSide2_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide3Image = diceSide3_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide4Image = diceSide4_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide5Image = diceSide5_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide6Image = diceSide6_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide1LockedImage = diceSide1_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide2LockedImage = diceSide2_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide3LockedImage = diceSide3_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide4LockedImage = diceSide4_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide5LockedImage = diceSide5_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        diceSide6LockedImage = diceSide6_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        //</editor-fold>


        this.setContentPane(new JLabel(new ImageIcon(background)));
        Container c = getContentPane();

        //<editor-fold desc = "Component Creation">
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
        Image[] images = {unknownDice, diceSide1Image, diceSide2Image, diceSide3Image, diceSide4Image, diceSide5Image, diceSide6Image,
        diceSide1LockedImage, diceSide2LockedImage, diceSide3LockedImage, diceSide4LockedImage, diceSide5LockedImage, diceSide6LockedImage, };

        dice1Label = new DiceLabel(images, sidesPerDiceValue);
        dice1Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice1Label.setLocation(DICE_X_COOR + (0*225), DICE_Y_COOR);
        c.add(dice1Label);

        dice2Label = new DiceLabel(images, sidesPerDiceValue);
        dice2Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice2Label.setLocation(DICE_X_COOR + (1*225), DICE_Y_COOR);
        c.add(dice2Label);

        dice3Label = new DiceLabel(images, sidesPerDiceValue);
        dice3Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice3Label.setLocation(DICE_X_COOR + (2*225), DICE_Y_COOR);
        c.add(dice3Label);

        dice4Label = new DiceLabel(images, sidesPerDiceValue);
        dice4Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice4Label.setLocation(DICE_X_COOR + (3*225), DICE_Y_COOR);
        c.add(dice4Label);

        dice5Label = new DiceLabel(images, sidesPerDiceValue);
        dice5Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice5Label.setLocation(DICE_X_COOR + (4*225), DICE_Y_COOR);
        c.add(dice5Label);

        dice6Label = new DiceLabel(images, sidesPerDiceValue);
        dice6Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice6Label.setLocation(DICE_X_COOR + (5*225), DICE_Y_COOR);

        dice7Label = new DiceLabel(images, sidesPerDiceValue);
        dice7Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        dice7Label.setLocation(DICE_X_COOR + (6*225), DICE_Y_COOR);

        //</editor-fold>


        //<editor-fold desc="Scorecard Table Creation">
        scTable = new SCTable(sidesPerDiceValue) {
            private static final long serialVersionUID = 1L;
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        scTable.setSelectionModel(new ForcedListSelectionModel());
        scTable.setRowSelectionAllowed(true);
        scTable.setRowHeight(27);
        scTable.setFont(new Font ("Times New Roman", Font.PLAIN , 20));
        scTable.setSize(TABLE_WIDTH, TABLE_HEIGHT);
        scTable.setLocation(TABLE_X_COOR, TABLE_Y_COOR);
        c.add(scTable);
        //</editor-fold>

        //<editor-fold desc="Dice Per Game Menu Creation">
        dicePerGameLabel = new JLabel();
        dicePerGameLabel.setFont(new Font ("Garamond", Font.PLAIN , 20));
        dicePerGameLabel.setText("Dice Per Game");
        dicePerGameLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        dicePerGameLabel.setLocation(LABEL_X_COOR, LABEL_Y_COOR);
        c.add(dicePerGameLabel);


        String[] dicePerGameOptions = {"5", "6", "7"};
        dicePerGameBox = new JComboBox(dicePerGameOptions);
        dicePerGameBox.setSelectedIndex(0);
        dicePerGameBox.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        dicePerGameBox.setLocation(LABEL_X_COOR, LABEL_Y_COOR + 30);
        c.add(dicePerGameBox);
        //</editor-fold>

        //<editor-fold desc="Sides Per Dice Menu Creation">
        sidesPerDiceLabel = new JLabel();
        sidesPerDiceLabel.setFont(new Font ("Garamond", Font.PLAIN , 20));
        sidesPerDiceLabel.setText("Sides Per Dice");
        sidesPerDiceLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        sidesPerDiceLabel.setLocation(LABEL_X_COOR, LABEL_Y_COOR + 100);
        c.add(sidesPerDiceLabel);

        String[] sidesPerDiceOptions = {"6", "8", "12"};
        sidesPerDiceBox = new JComboBox(sidesPerDiceOptions);
        sidesPerDiceBox.setSelectedIndex(0);
        sidesPerDiceBox.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        sidesPerDiceBox.setLocation(LABEL_X_COOR, LABEL_Y_COOR + 130);
        c.add(sidesPerDiceBox);
        //</editor-fold>

        //<editor-fold desc="Game Buttons">
        saveGameButton = new JButton();
        saveGameButton.setText("Save Game");
        saveGameButton.setBackground(Color.RED);
        saveGameButton.setSize(GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
        saveGameButton.setLocation(GAME_BUTTON_X_COOR, GAME_BUTTON_Y_COOR);
        c.add(saveGameButton);

        newGameButton = new JButton();
        newGameButton.setText("New Game");
        newGameButton.setSize(GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
        newGameButton.setLocation(GAME_BUTTON_X_COOR, GAME_BUTTON_Y_COOR+60);
        c.add(newGameButton);

        loadGameButton = new JButton();
        loadGameButton.setText("Load Game");
        loadGameButton.setBackground(Color.RED);
        loadGameButton.setSize(GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
        loadGameButton.setLocation(GAME_BUTTON_X_COOR, GAME_BUTTON_Y_COOR+120);
        c.add(loadGameButton);
        //</editor-fold>

        //<editor-fold desc = "Score Labels">
        lowerTotalLabel = new JLabel();
        lowerTotalLabel.setFont(new Font ("Garamond", Font.BOLD , 20));
        lowerTotalLabel.setText("Lower Total: " + String.valueOf(lowerScoreValue));
        lowerTotalLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT*2);
        lowerTotalLabel.setLocation(SCORE_LABEL_X_COOR, SCORE_LABEL_Y_COOR);
        c.add(lowerTotalLabel);

        upperTotalLabel = new JLabel();
        upperTotalLabel.setFont(new Font ("Garamond", Font.BOLD , 20));
        upperTotalLabel.setText("Upper Total: " + String.valueOf(upperScoreValue));
        upperTotalLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT*2);
        upperTotalLabel.setLocation(SCORE_LABEL_X_COOR, SCORE_LABEL_Y_COOR+40);
        c.add(upperTotalLabel);

        bonusLabel = new JLabel();
        bonusLabel.setFont(new Font ("Garamond", Font.BOLD , 20));
        bonusLabel.setText("Bonus: " + String.valueOf(bonusValue));
        bonusLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT*2);
        bonusLabel.setLocation(SCORE_LABEL_X_COOR, SCORE_LABEL_Y_COOR+80);
        c.add(bonusLabel);

        totalScoreLabel = new JLabel();
        totalScoreLabel.setFont(new Font ("Garamond", Font.BOLD , 20));
        totalScoreLabel.setText("Total: " + String.valueOf(totalScoreValue));
        totalScoreLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT*2);
        totalScoreLabel.setLocation(SCORE_LABEL_X_COOR, SCORE_LABEL_Y_COOR+120);
        c.add(totalScoreLabel);

        //</editor-fold>

        //<editor-fold desc = "Rolls Left Label Creation">
        rollsLeftLabel = new JLabel();
        rollsLeftLabel.setFont(new Font ("Garamond", Font.BOLD , 20));
        rollsLeftLabel.setForeground(Color.BLACK);
        rollsLeftLabel.setText("Rolls Left: " + String.valueOf(rollsLeft));
        rollsLeftLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        rollsLeftLabel.setLocation(ROLLS_LEFT_LABEL_X_COOR+200, ROLLS_LEFT_LABEL_Y_COOR);
        c.add(rollsLeftLabel);
        //</editor-fold>

        //</editor-fold>

        SaveFile file = new SaveFile(sidesPerDiceValue, dicePerGameValue, 3);

        file.read();
        sidesPerDiceValue = file.getSidesPerDice();
        dicePerGameValue = file.getDiceInGame();
        DiceLabel[] hand = {dice1Label, dice2Label, dice3Label, dice4Label, dice5Label, dice6Label};
        h = new Hand(hand, dicePerGameValue, sidesPerDiceValue);
        

        //<editor-fold desc = "Action Listeners">
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset();
            }
        });

        saveGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                file.write(sidesPerDiceValue, dicePerGameValue, 3);
                file.writeScoreCard(scTable.getSc(), h);
            }
        });

        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                file.read();
                file.readScoreCard(scTable.getSc());
                reset();
            }
        });

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (rollsLeft <= 0 || pause){
                    rollButton.setText("No Rolls Left");
                    checkScorePotential();
                    pause = true;
                    rollsLeft = 3;
                } else {
                    dice1Label.getD().roll();
                    dice2Label.getD().roll();
                    dice3Label.getD().roll();
                    dice4Label.getD().roll();
                    dice5Label.getD().roll();
                    dice6Label.getD().roll();
                    dice7Label.getD().roll();
                    refreshDice();
                    rollsLeft--;
                    rollsLeftLabel.setText("Rolls Left: " + String.valueOf(rollsLeft));
                }

            }
        });

        dicePerGameBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGameButton.doClick();
                int LABEL_SPACER;
                if (dicePerGameBox.getSelectedItem().equals("5")){
                    dicePerGameValue = 5;
                    LABEL_SPACER = 225;
                    c.remove(dice7Label);
                    c.remove(dice6Label);
                    dice5Label.setLocation(DICE_X_COOR + (4*LABEL_SPACER), DICE_Y_COOR);
                    dice4Label.setLocation(DICE_X_COOR + (3*LABEL_SPACER), DICE_Y_COOR);
                    dice3Label.setLocation(DICE_X_COOR + (2*LABEL_SPACER), DICE_Y_COOR);
                    dice2Label.setLocation(DICE_X_COOR + (1*LABEL_SPACER), DICE_Y_COOR);
                    dice1Label.setLocation(DICE_X_COOR + (0*LABEL_SPACER), DICE_Y_COOR);
                    repaint();
                }
                else if (dicePerGameBox.getSelectedItem().equals("6")){
                    dicePerGameValue = 6;
                    LABEL_SPACER = 180;
                    c.remove(dice7Label);
                    c.add(dice6Label);
                    dice6Label.setLocation(DICE_X_COOR + (5*LABEL_SPACER), DICE_Y_COOR);
                    dice5Label.setLocation(DICE_X_COOR + (4*LABEL_SPACER), DICE_Y_COOR);
                    dice4Label.setLocation(DICE_X_COOR + (3*LABEL_SPACER), DICE_Y_COOR);
                    dice3Label.setLocation(DICE_X_COOR + (2*LABEL_SPACER), DICE_Y_COOR);
                    dice2Label.setLocation(DICE_X_COOR + (1*LABEL_SPACER), DICE_Y_COOR);
                    dice1Label.setLocation(DICE_X_COOR + (0*LABEL_SPACER), DICE_Y_COOR);
                    repaint();
                } else if (dicePerGameBox.getSelectedItem().equals("7")){
                    dicePerGameValue = 7;
                    LABEL_SPACER = 150;
                    c.add(dice7Label);
                    c.add(dice6Label);
                    dice7Label.setLocation(DICE_X_COOR + (6*LABEL_SPACER), DICE_Y_COOR);
                    dice6Label.setLocation(DICE_X_COOR + (5*LABEL_SPACER), DICE_Y_COOR);
                    dice5Label.setLocation(DICE_X_COOR + (4*LABEL_SPACER), DICE_Y_COOR);
                    dice4Label.setLocation(DICE_X_COOR + (3*LABEL_SPACER), DICE_Y_COOR);
                    dice3Label.setLocation(DICE_X_COOR + (2*LABEL_SPACER), DICE_Y_COOR);
                    dice2Label.setLocation(DICE_X_COOR + (1*LABEL_SPACER), DICE_Y_COOR);
                    dice1Label.setLocation(DICE_X_COOR + (0*LABEL_SPACER), DICE_Y_COOR);
                    repaint();
                }
            }
        });

        sidesPerDiceBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGameButton.doClick();
                if (sidesPerDiceBox.getSelectedItem().equals("6")) {
                    sidesPerDiceValue = 6;
                    scTable.setRowHeight(29);
                } else if ((sidesPerDiceBox.getSelectedItem().equals("8"))) {
                    sidesPerDiceValue = 8;
                    scTable.setRowHeight(25);
                } else if ((sidesPerDiceBox.getSelectedItem().equals("12"))) {
                    sidesPerDiceValue = 12;
                    scTable.setRowHeight(20);
                }
                scTable.setSc(new ScoreCard(sidesPerDiceValue));
                scTable.setSidesPerDice(sidesPerDiceValue);
                scTable.refresh();
            }
        });

        confirmSelectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (scTable.getSc().getLine(getSelectedLine()).getUsed() == true) return;
                pause = false;
                rollsLeftLabel.setText("Rolls Left: " + String.valueOf(rollsLeft));
                rollButton.setText("Roll Hand");
                scTable.getSc().getLine(getSelectedLine()).setUsed(true);
                scTable.getSc().getLine(getSelectedLine()).setMultiplier(h.sum());
                for (int i = 0; i < 12; i++) {
                    if (scTable.getSc().getLine(getSelectedLine()).getName().equalsIgnoreCase(String.valueOf(i))) {
                        scTable.getSc().getLine(getSelectedLine()).setMultiplier(scTable.getSc().totalOfNum(i, h));
                    }
                }
                scTable.getSc().getLine(getSelectedLine()).setPointsEarned(scTable.getSc().getLine(getSelectedLine()).getPotentialPoints());
                scTable.refresh();
                scTable.getSc().showScoreCard(sidesPerDiceValue);
                refresh();
                if (scTable.getSc().howManyLeft() <= 0) {
                    gameOverPopup = new JOptionPane();
                    gameOverPopup.showMessageDialog(null, "Game Over \n Final Score: " + String.valueOf(totalScoreValue));
                    System.exit(0);
                }
            }
        });

        //<editor-fold desc = "Dice Checkboxes Listeners">
        dice1Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dice1Label.isSelected()) {
                    dice1Label.getD().setKept(true);
                } else {
                    dice1Label.getD().setKept(false);
                }
                dice1Label.refresh();
            }
        });

        dice2Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dice2Label.isSelected()) {
                    dice2Label.getD().setKept(true);
                } else {
                    dice2Label.getD().setKept(false);
                }
                dice2Label.refresh();
            }
        });

        dice3Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dice3Label.isSelected()) {
                    dice3Label.getD().setKept(true);
                } else {
                    dice3Label.getD().setKept(false);
                }
                dice3Label.refresh();
            }
        });

        dice4Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dice4Label.isSelected()) {
                    dice4Label.getD().setKept(true);
                } else {
                    dice4Label.getD().setKept(false);
                }
                dice4Label.refresh();
            }
        });

        dice5Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dice5Label.isSelected()) {
                    dice5Label.getD().setKept(true);
                } else {
                    dice5Label.getD().setKept(false);
                }
                dice5Label.refresh();
            }
        });

        dice6Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dice6Label.isSelected()) {
                    dice6Label.getD().setKept(true);
                } else {
                    dice6Label.getD().setKept(false);
                }
                dice6Label.refresh();
            }
        });

        dice7Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dice7Label.isSelected()) {
                    dice7Label.getD().setKept(true);
                } else {
                    dice7Label.getD().setKept(false);
                }
                dice7Label.refresh();
            }
        });

        //</editor-fold>

        //</editor-fold>
    }

    /**
     * @param toBeChanged The JLabel that the image will change
     * @param newImage The Image that JLabel will change to
     */
    private void changeImage(JToggleButton toBeChanged, Image newImage) {
        toBeChanged.setIcon(new ImageIcon(newImage));
    }

    /**
     * Rests DiceLabels back to unknown Image
     */
    private void resetDice(){
        pause = false;
        dice1Label.getD().setKept(false);
        dice2Label.getD().setKept(false);
        dice3Label.getD().setKept(false);
        dice4Label.getD().setKept(false);
        dice5Label.getD().setKept(false);
        dice6Label.getD().setKept(false);
        dice7Label.getD().setKept(false);
        JToggleButton[] dice = {dice1Label, dice2Label, dice3Label, dice4Label, dice5Label, dice6Label, dice7Label};
        for (int i = 0; i < dice.length; i++){
            changeImage(dice[i], unknownDice);
        }
    }

    /**
     * Calls of the ScoreCards method and refreshes Table
     */
    private void checkScorePotential(){
        scTable.getSc().checkScore(h);
        scTable.refresh();
    }

    /**
     * @return Integer value of which row in the scTable is selected
     */
    private int getSelectedLine() {
        int selected = scTable.getSelectedRow();
        assert(selected > -1 && selected < (sidesPerDiceValue + 7));
        return selected;
    }

    /**
     * Assigns image to each DiceLabel based on their value
     */
    private void refreshDice(){
        dice1Label.refresh();
        dice2Label.refresh();
        dice3Label.refresh();
        dice4Label.refresh();
        dice5Label.refresh();
        dice6Label.refresh();
        dice7Label.refresh();
        if (dicePerGameValue == 5) {
            DiceLabel[] hand = {dice1Label, dice2Label, dice3Label, dice4Label, dice5Label};
            h = new Hand(hand, dicePerGameValue, sidesPerDiceValue);
        } else if (dicePerGameValue == 6) {
            DiceLabel[] hand = {dice1Label, dice2Label, dice3Label, dice4Label, dice5Label, dice6Label};
            h = new Hand(hand, dicePerGameValue, sidesPerDiceValue);
        } else {
            DiceLabel[] hand = {dice1Label, dice2Label, dice3Label, dice4Label, dice5Label, dice6Label, dice7Label};
            h = new Hand(hand, dicePerGameValue, sidesPerDiceValue);
        }

    }

    /**
     * Sets all checkboxes to un-selected
     */
    private void resetCheckBoxes() {
        dice1Label.setSelected(false);
        dice2Label.setSelected(false);
        dice3Label.setSelected(false);
        dice4Label.setSelected(false);
        dice5Label.setSelected(false);
        dice6Label.setSelected(false);
        dice7Label.setSelected(false);
    }

    /**
     * Sets all the Score Labels to the score Values
     */
    private void refreshLabels() {
        lowerTotalLabel.setText("Lower Total: " + String.valueOf(lowerScoreValue));
        upperTotalLabel.setText("Upper Total: " + String.valueOf(upperScoreValue));
        totalScoreLabel.setText("Total: " + String.valueOf(totalScoreValue));
        bonusLabel.setText("Bonus: " + String.valueOf(bonusValue));
        repaint();
    }

    /**
     * Assigns the values of the scores based on ScoreCard
     */
    private void refreshScores() {
        upperScoreValue = 0;
        lowerScoreValue = 0;
        totalScoreValue = 0;
        bonusValue = 0;
        for (int i = 0; i < sidesPerDiceValue + 7; i++) {
            if (i < sidesPerDiceValue) upperScoreValue+=scTable.getSc().getLine(i).getPointsEarned();
            if (i == sidesPerDiceValue) {
                if (scTable.getSc().calculateBonus(sidesPerDiceValue)){
                    bonusValue = 35;
                }
            }
            if (i >= sidesPerDiceValue) lowerScoreValue+=scTable.getSc().getLine(i).getPointsEarned();
            scTable.getSc().getLine(i).printUsed();
            if (i == sidesPerDiceValue +6) {
                totalScoreValue = lowerScoreValue+upperScoreValue+bonusValue;
            }
        }
    }

    private void refresh() {
        refreshLabels();
        resetCheckBoxes();
        refreshScores();
        scTable.refresh();
        refreshDice();
        repaint();
    }

    private void reset() {
        rollsLeft = 3;
        totalScoreValue = 0;
        lowerScoreValue = 0;
        upperScoreValue = 0;
        bonusValue = 0;
        refresh();
        resetDice();
        scTable.reset();
        repaint();
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
