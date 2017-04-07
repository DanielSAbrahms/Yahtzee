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
    private JComboBox dicePerGameBox;
    private JComboBox sidesPerDiceBox;
    private JButton saveGameButton;
    private JButton newGameButton;
    private JButton loadGameButton;
    private JOptionPane gameOverPopup;
    private JOptionPane lineAlreadyUsedPopup;
    private JOptionPane rollWarningPopup;
    private JTextField saveFileField;
    private Image unknownDiceImage;

    private int dicePerGameValue = 5;
    private int sidesPerDiceValue = 6;
    private int totalScoreValue = 0;
    private int upperScoreValue = 0;
    private int lowerScoreValue = 0;
    private int bonusValue = 0;
    private int roundsLeft;
    private int rollsLeft;
    private int rollWarningValue;
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
    private static final int TABLE_X_COOR = 50;
    private static final int TABLE_Y_COOR = 258;
    private static final int LABEL_X_COOR = 1105;
    private static final int LABEL_Y_COOR = 44;
    private static final int SCORE_LABEL_X_COOR = 1095;
    private static final int SCORE_LABEL_Y_COOR = 530;
    private static final int ROLLS_LEFT_LABEL_X_COOR = 308;
    private static final int ROLLS_LEFT_LABEL_Y_COOR = 663;
    //</editor-fold>

    // User Directory to Locate Source Images
    private static final String USER_DIR = System.getProperty("user.home") + "/Desktop/Yahtzee/YahtzeeProject/src/Images";

    YahtzeeGUI(String title) {
        super(title);        // Assigns JFrame title
        roundsLeft = sidesPerDiceValue + 7;
        rollWarningValue = 0;
        rollsLeft = 3;

        //<editor-fold desc="Initializes Images">
        BufferedImage diceSideA_raw = null;
        BufferedImage diceSideB_raw = null;
        BufferedImage diceSideC_raw = null;
        BufferedImage diceSideD_raw = null;
        BufferedImage diceSideE_raw = null;
        BufferedImage diceSideF_raw = null;
        BufferedImage diceSideG_raw = null;
        BufferedImage diceSideH_raw = null;
        BufferedImage diceSideI_raw = null;
        BufferedImage diceSideJ_raw = null;
        BufferedImage diceSideK_raw = null;
        BufferedImage diceSideL_raw = null;
        BufferedImage diceSideM_raw = null;
        BufferedImage diceSideN_raw = null;
        BufferedImage diceSideO_raw = null;
        BufferedImage diceSideP_raw = null;
        BufferedImage diceSideQ_raw = null;
        BufferedImage diceSideR_raw = null;
        BufferedImage diceSideS_raw = null;
        BufferedImage diceSideT_raw = null;
        BufferedImage diceSideU_raw = null;
        BufferedImage diceSideV_raw = null;
        BufferedImage diceSideW_raw = null;
        BufferedImage diceSideX_raw = null;
        BufferedImage diceSideY_raw = null;
        BufferedImage diceSideZ_raw = null;
        BufferedImage diceSideA_Locked_raw = null;
        BufferedImage diceSideB_Locked_raw = null;
        BufferedImage diceSideC_Locked_raw = null;
        BufferedImage diceSideD_Locked_raw = null;
        BufferedImage diceSideE_Locked_raw = null;
        BufferedImage diceSideF_Locked_raw = null;
        BufferedImage diceSideG_Locked_raw = null;
        BufferedImage diceSideH_Locked_raw = null;
        BufferedImage diceSideI_Locked_raw = null;
        BufferedImage diceSideJ_Locked_raw = null;
        BufferedImage diceSideK_Locked_raw = null;
        BufferedImage diceSideL_Locked_raw = null;
        BufferedImage diceSideM_Locked_raw = null;
        BufferedImage diceSideN_Locked_raw = null;
        BufferedImage diceSideO_Locked_raw = null;
        BufferedImage diceSideP_Locked_raw = null;
        BufferedImage diceSideQ_Locked_raw = null;
        BufferedImage diceSideR_Locked_raw = null;
        BufferedImage diceSideS_Locked_raw = null;
        BufferedImage diceSideT_Locked_raw = null;
        BufferedImage diceSideU_Locked_raw = null;
        BufferedImage diceSideV_Locked_raw = null;
        BufferedImage diceSideW_Locked_raw = null;
        BufferedImage diceSideX_Locked_raw = null;
        BufferedImage diceSideY_Locked_raw = null;
        BufferedImage diceSideZ_Locked_raw = null;
        BufferedImage unknownDiceImage_raw = null;
        BufferedImage background = null;
        //</editor-fold>

        //<editor-fold desc = "Loads Images">
        try {
            diceSideA_raw = ImageIO.read(new File(USER_DIR + "/diceSideA.png"));
            diceSideB_raw = ImageIO.read(new File(USER_DIR + "/diceSideB.png"));
            diceSideC_raw = ImageIO.read(new File(USER_DIR + "/diceSideC.png"));
            diceSideD_raw = ImageIO.read(new File(USER_DIR + "/diceSideD.png"));
            diceSideE_raw = ImageIO.read(new File(USER_DIR + "/diceSideE.png"));
            diceSideF_raw = ImageIO.read(new File(USER_DIR + "/diceSideF.png"));
            diceSideG_raw = ImageIO.read(new File(USER_DIR + "/diceSideG.png"));
            diceSideH_raw = ImageIO.read(new File(USER_DIR + "/diceSideH.png"));
            diceSideI_raw = ImageIO.read(new File(USER_DIR + "/diceSideI.png"));
            diceSideJ_raw = ImageIO.read(new File(USER_DIR + "/diceSideJ.png"));
            diceSideK_raw = ImageIO.read(new File(USER_DIR + "/diceSideK.png"));
            diceSideL_raw = ImageIO.read(new File(USER_DIR + "/diceSideL.png"));
            diceSideM_raw = ImageIO.read(new File(USER_DIR + "/diceSideM.png"));
            diceSideN_raw = ImageIO.read(new File(USER_DIR + "/diceSideN.png"));
            diceSideO_raw = ImageIO.read(new File(USER_DIR + "/diceSideO.png"));
            diceSideP_raw = ImageIO.read(new File(USER_DIR + "/diceSideP.png"));
            diceSideQ_raw = ImageIO.read(new File(USER_DIR + "/diceSideQ.png"));
            diceSideR_raw = ImageIO.read(new File(USER_DIR + "/diceSideR.png"));
            diceSideS_raw = ImageIO.read(new File(USER_DIR + "/diceSideS.png"));
            diceSideT_raw = ImageIO.read(new File(USER_DIR + "/diceSideT.png"));
            diceSideU_raw = ImageIO.read(new File(USER_DIR + "/diceSideU.png"));
            diceSideV_raw = ImageIO.read(new File(USER_DIR + "/diceSideV.png"));
            diceSideW_raw = ImageIO.read(new File(USER_DIR + "/diceSideW.png"));
            diceSideX_raw = ImageIO.read(new File(USER_DIR + "/diceSideX.png"));
            diceSideY_raw = ImageIO.read(new File(USER_DIR + "/diceSideY.png"));
            diceSideZ_raw = ImageIO.read(new File(USER_DIR + "/diceSideZ.png"));
            diceSideA_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideA_Locked.png"));
            diceSideB_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideB_Locked.png"));
            diceSideC_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideC_Locked.png"));
            diceSideD_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideD_Locked.png"));
            diceSideE_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideE_Locked.png"));
            diceSideF_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideF_Locked.png"));
            diceSideG_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideG_Locked.png"));
            diceSideH_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideH_Locked.png"));
            diceSideI_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideI_Locked.png"));
            diceSideJ_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideJ_Locked.png"));
            diceSideK_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideK_Locked.png"));
            diceSideL_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideL_Locked.png"));
            diceSideM_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideM_Locked.png"));
            diceSideN_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideN_Locked.png"));
            diceSideO_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideO_Locked.png"));
            diceSideP_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideP_Locked.png"));
            diceSideQ_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideQ_Locked.png"));
            diceSideR_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideR_Locked.png"));
            diceSideS_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideS_Locked.png"));
            diceSideT_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideT_Locked.png"));
            diceSideU_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideU_Locked.png"));
            diceSideV_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideV_Locked.png"));
            diceSideW_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideW_Locked.png"));
            diceSideX_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideX_Locked.png"));
            diceSideY_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideY_Locked.png"));
            diceSideZ_Locked_raw = ImageIO.read(new File(USER_DIR + "/diceSideZ_Locked.png"));
            unknownDiceImage_raw = ImageIO.read(new File(USER_DIR + "/unknownDice.png"));
            background = ImageIO.read(new File(USER_DIR + "/backgroundFancy.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        unknownDiceImage = unknownDiceImage_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideAImage = diceSideA_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideBImage = diceSideB_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideCImage = diceSideC_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideDImage = diceSideD_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideEImage = diceSideE_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideFImage = diceSideF_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideGImage = diceSideG_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideHImage = diceSideH_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideIImage = diceSideI_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideJImage = diceSideJ_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideKImage = diceSideK_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideLImage = diceSideL_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideMImage = diceSideM_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideNImage = diceSideN_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideOImage = diceSideO_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSidePImage = diceSideP_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideQImage = diceSideQ_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideRImage = diceSideR_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideSImage = diceSideS_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideTImage = diceSideT_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideUImage = diceSideU_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideVImage = diceSideV_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideWImage = diceSideW_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideXImage = diceSideX_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideYImage = diceSideY_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideZImage = diceSideZ_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideA_LockedImage = diceSideA_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideB_LockedImage = diceSideB_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideC_LockedImage = diceSideC_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideD_LockedImage = diceSideD_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideE_LockedImage = diceSideE_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideF_LockedImage = diceSideF_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideG_LockedImage = diceSideG_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideH_LockedImage = diceSideH_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideI_LockedImage = diceSideI_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideJ_LockedImage = diceSideJ_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideK_LockedImage = diceSideK_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideL_LockedImage = diceSideL_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideM_LockedImage = diceSideM_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideN_LockedImage = diceSideN_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideO_LockedImage = diceSideO_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideP_LockedImage = diceSideP_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideQ_LockedImage = diceSideQ_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideR_LockedImage = diceSideR_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideS_LockedImage = diceSideS_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideT_LockedImage = diceSideT_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideU_LockedImage = diceSideU_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideV_LockedImage = diceSideV_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideW_LockedImage = diceSideW_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideX_LockedImage = diceSideX_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideY_LockedImage = diceSideY_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image diceSideZ_LockedImage = diceSideZ_Locked_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);

        //</editor-fold>


        this.setContentPane(new JLabel(new ImageIcon(background)));
        Container c = getContentPane();

        //<editor-fold desc = "Component Creation">
        //<editor-fold desc="Bottom Buttons Creation">
        rollButton = new JButton();
        rollButton.setText("Roll Hand");
        rollButton.setEnabled(false);
        rollButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        rollButton.setLocation(BUTTON_X_COOR, BUTTON_Y_COOR);
        c.add(rollButton);

        confirmSelectionButton = new JButton();
        confirmSelectionButton.setText("Confirm Selection");
        confirmSelectionButton.setEnabled(false);
        confirmSelectionButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        confirmSelectionButton.setLocation(BUTTON_X_COOR+450, BUTTON_Y_COOR);
        c.add(confirmSelectionButton);
        //</editor-fold>

        //<editor-fold desc="Dice Label Creation">

        Image[] images = {
                unknownDiceImage,
                diceSideAImage, diceSideBImage, diceSideCImage,diceSideDImage,diceSideEImage,diceSideFImage,diceSideGImage,diceSideHImage,
                diceSideIImage, diceSideJImage, diceSideKImage,diceSideLImage,diceSideMImage,diceSideNImage,diceSideOImage,
                diceSidePImage, diceSideQImage, diceSideRImage,diceSideSImage,diceSideTImage,diceSideUImage,diceSideVImage,
                diceSideWImage, diceSideXImage, diceSideYImage,diceSideZImage,
                diceSideA_LockedImage, diceSideB_LockedImage, diceSideC_LockedImage,diceSideD_LockedImage,diceSideE_LockedImage,diceSideF_LockedImage,diceSideG_LockedImage,diceSideH_LockedImage,
                diceSideI_LockedImage, diceSideJ_LockedImage, diceSideK_LockedImage,diceSideL_LockedImage,diceSideM_LockedImage,diceSideN_LockedImage,diceSideO_LockedImage,
                diceSideP_LockedImage, diceSideQ_LockedImage, diceSideR_LockedImage,diceSideS_LockedImage,diceSideT_LockedImage,diceSideU_LockedImage,diceSideV_LockedImage,
                diceSideW_LockedImage, diceSideX_LockedImage, diceSideY_LockedImage,diceSideZ_LockedImage
        };

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
        saveGameButton.setEnabled(true);
        saveGameButton.setSize(GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
        saveGameButton.setLocation(GAME_BUTTON_X_COOR, GAME_BUTTON_Y_COOR+60);
        c.add(saveGameButton);

        newGameButton = new JButton();
        newGameButton.setText("New Game");
        newGameButton.setSize(GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
        newGameButton.setLocation(GAME_BUTTON_X_COOR, GAME_BUTTON_Y_COOR);
        c.add(newGameButton);

        loadGameButton = new JButton();
        loadGameButton.setText("Load Game");
        loadGameButton.setEnabled(true);
        loadGameButton.setSize(GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
        loadGameButton.setLocation(GAME_BUTTON_X_COOR, GAME_BUTTON_Y_COOR+120);
        c.add(loadGameButton);

        saveFileField = new JTextField("Save File Name");
        saveFileField.setSize(GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
        saveFileField.setLocation(GAME_BUTTON_X_COOR, GAME_BUTTON_Y_COOR +GAME_BUTTON_HEIGHT + 60);
        saveFileField.setEnabled(false);
        c.add(saveFileField);
        //</editor-fold>

        //<editor-fold desc = "Score Labels">
        upperTotalLabel = new JLabel();
        upperTotalLabel.setFont(new Font ("Garamond", Font.BOLD , 20));
        upperTotalLabel.setText("Upper Total: " + String.valueOf(upperScoreValue));
        upperTotalLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT*2);
        upperTotalLabel.setLocation(SCORE_LABEL_X_COOR, SCORE_LABEL_Y_COOR);
        c.add(upperTotalLabel);

        lowerTotalLabel = new JLabel();
        lowerTotalLabel.setFont(new Font ("Garamond", Font.BOLD , 20));
        lowerTotalLabel.setText("Lower Total: " + String.valueOf(lowerScoreValue));
        lowerTotalLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT*2);
        lowerTotalLabel.setLocation(SCORE_LABEL_X_COOR, SCORE_LABEL_Y_COOR+40);
        c.add(lowerTotalLabel);

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
                reset(true);
                rollButton.setEnabled(true);
                saveFileField.setEnabled(true);
                newGameButton.setBackground(null);
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
                file.readScoreCard(scTable.getSc(), saveFileField.getText());
                refresh();
            }
        });

        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshDice();
                if (allKept()) {
                    rollsLeft = 0;
                    refresh();
                }
                if (rollsLeft <= 0 || pause){
                    rollButton.setText("No Rolls Left");
                    checkScorePotential();
                    pause = true;
                    if (rollWarningValue >= 4) {
                        rollWarningPopup = new JOptionPane();
                        rollWarningPopup.showMessageDialog(null,
                                "You have no rolls left this round. \n To end this round select a line on the ScoreCard and press \"Confirm Selection|\"");
                    }
                    else rollWarningValue++;
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
                    if (rollsLeft == 0) rollButton.doClick();
                }

            }
        });

        dicePerGameBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset(true);
                rollButton.setEnabled(false);
                confirmSelectionButton.setEnabled(false);
                newGameButton.setBackground(Color.YELLOW);
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
                reset(true);
                rollButton.setEnabled(false);
                confirmSelectionButton.setEnabled(false);
                newGameButton.setBackground(Color.YELLOW);
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
                if (scTable.getSc().getLine(getSelectedLine()).getUsed() == true) {
                    lineAlreadyUsedPopup = new JOptionPane();
                    lineAlreadyUsedPopup.showMessageDialog(null, "Line Already Used");
                    return;
                }
                rollWarningValue = 0;
                confirmSelectionButton.setEnabled(false);
                pause = false;
                scTable.getSc().getLine(getSelectedLine()).setUsed(true);
                scTable.getSc().getLine(getSelectedLine()).setMultiplier(h.sum());
                for (int i = 0; i < 12; i++) {
                    if (scTable.getSc().getLine(getSelectedLine()).getName().equalsIgnoreCase(String.valueOf(i))) {
                        scTable.getSc().getLine(getSelectedLine()).setMultiplier(scTable.getSc().totalOfNum(i, h));
                    }
                }
                scTable.getSc().getLine(getSelectedLine()).setPointsEarned(scTable.getSc().getLine(getSelectedLine()).getPotentialPoints());
                scTable.getSc().getLine(getSelectedLine()).setPotentialPoints(0);
                scTable.refresh();
                scTable.getSc().showScoreCard(sidesPerDiceValue);
                reset(false);
                if (scTable.getSc().howManyLeft() <= 0) {
                    gameOverPopup = new JOptionPane();
                    gameOverPopup.showMessageDialog(null, "Game Over \n   Final Score: " + String.valueOf(totalScoreValue));
                    System.exit(0);
                }
            }
        });

        //<editor-fold desc = "Dice Checkboxes Listeners">
        dice1Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dice1Label.getD() == null) return;
                if (dice1Label.isSelected()) {
                    dice1Label.getD().setKept(true);
                } else {
                    dice1Label.getD().setKept(false);
                }
                dice1Label.refresh(true);
            }
        });

        dice2Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dice2Label.getD() == null) return;
                if (dice2Label.isSelected()) {
                    dice2Label.getD().setKept(true);
                } else {
                    dice2Label.getD().setKept(false);
                }
                dice2Label.refresh(true);
            }
        });

        dice3Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dice3Label.getD() == null) return;
                if (dice3Label.isSelected()) {
                    dice3Label.getD().setKept(true);
                } else {
                    dice3Label.getD().setKept(false);
                }
                dice3Label.refresh(true);
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
                dice4Label.refresh(false);
            }
        });

        dice5Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dice5Label.getD() == null) return;
                if (dice5Label.isSelected()) {
                    dice5Label.getD().setKept(true);
                } else {
                    dice5Label.getD().setKept(false);
                }
                dice5Label.refresh(false);
            }
        });

        dice6Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dice6Label.getD() == null) return;
                if (dice6Label.isSelected()) {
                    dice6Label.getD().setKept(true);
                } else {
                    dice6Label.getD().setKept(false);
                }
                dice6Label.refresh(false);
            }
        });

        dice7Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (dice7Label.getD() == null) return;
                if (dice7Label.isSelected()) {
                    dice7Label.getD().setKept(true);
                } else {
                    dice7Label.getD().setKept(false);
                }
                dice7Label.refresh(false);
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
        dice1Label.setSelected(false);
        dice2Label.setSelected(false);
        dice3Label.setSelected(false);
        dice4Label.setSelected(false);
        dice5Label.setSelected(false);
        dice6Label.setSelected(false);
        dice7Label.setSelected(false);
        dice1Label.setD(null);
        dice2Label.setD(null);
        dice3Label.setD(null);
        dice4Label.setD(null);
        dice5Label.setD(null);
        dice6Label.setD(null);
        dice7Label.setD(null);

        JToggleButton[] dice = {dice1Label, dice2Label, dice3Label, dice4Label, dice5Label, dice6Label, dice7Label};
        for (int i = 0; i < dice.length; i++){
            changeImage(dice[i], unknownDiceImage);
        }
    }

    /**
     * Calls of the ScoreCards method and refreshes Table
     */
    private void checkScorePotential(){
        confirmSelectionButton.setEnabled(true);
        scTable.getSc().checkScore(h);
        scTable.refresh();
    }

    /**
     * @return Whether or not all dice are kept
     */
    private boolean allKept() {
        DiceLabel[] a = {dice1Label, dice2Label, dice3Label, dice4Label, dice5Label, dice6Label, dice7Label};
        for (int i = 0; i < dicePerGameValue; i++) {
            if (a[i].getD().getKept() == false) return false;
        }
        return true;
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
        dice1Label.refresh(true);
        dice1Label.setRange(sidesPerDiceValue);
        dice2Label.refresh(true);
        dice2Label.setRange(sidesPerDiceValue);
        dice3Label.refresh(true);
        dice3Label.setRange(sidesPerDiceValue);
        dice4Label.refresh(false);
        dice4Label.setRange(sidesPerDiceValue);
        dice5Label.refresh(false);
        dice5Label.setRange(sidesPerDiceValue);
        dice6Label.refresh(false);
        dice6Label.setRange(sidesPerDiceValue);
        dice7Label.refresh(false);
        dice7Label.setRange(sidesPerDiceValue);
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
     * Sets all the Score Labels to the score Values
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
        lowerTotalLabel.setText("Lower Total: " + String.valueOf(lowerScoreValue));
        upperTotalLabel.setText("Upper Total: " + String.valueOf(upperScoreValue));
        totalScoreLabel.setText("Total: " + String.valueOf(totalScoreValue));
        bonusLabel.setText("Bonus: " + String.valueOf(bonusValue));
        repaint();
    }

    /**
     * Calls on all the refresh methods and resets
     */
    private void refresh() {
        refreshScores();
        scTable.refresh();
        refreshDice();
        rollButton.setText("Roll Hand");
        rollsLeftLabel.setText("Rolls Left: " + rollsLeft);
        repaint();
    }

    /**
     * Resets the screen
     * @param fullReset boolean if its a newGame, resets everything
     */
    private void reset(boolean fullReset) {
        rollsLeft = 3;
        refresh();
        resetDice();
        scTable.resetColumn1();
        if (fullReset) {
            scTable.reset();
            totalScoreValue = 0;
            lowerScoreValue = 0;
            upperScoreValue = 0;
            bonusValue = 0;
            refreshScores();
        }
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
