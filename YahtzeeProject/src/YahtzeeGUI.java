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
 *          Creates a custom JFrame with Yahtzee functionality.
 */
class YahtzeeGUI extends JFrame {
    //<editor-fold desc="Size Constants for Components">
    private static final int DICE_WIDTH = 100;
    private static final int DICE_HEIGHT = 100;
    private static final int SPECIAL_DICE_WIDTH = 100;
    private static final int SPECIAL_DICE_HEIGHT = 100;
    private static final int BUTTON_HEIGHT = 50;
    private static final int BUTTON_WIDTH = 300;
    private static final int RESET_WORD_BUTTON_HEIGHT = 50;
    private static final int RESET_WORD_BUTTON_WIDTH = 50;
    private static final int GAME_BUTTON_HEIGHT = 30;
    private static final int GAME_BUTTON_WIDTH = 100;
    private static final int TABLE_WIDTH = 1030;
    private static final int TABLE_HEIGHT = 379;
    private static final int LABEL_WIDTH = 150;
    private static final int LABEL_HEIGHT = 30;
    private static final int WORD_LABEL_WIDTH = 1030;
    private static final int WORD_LABEL_HEIGHT = 50;
    private static final int LETTER_PICKER_WIDTH = 100;
    private static final int LETTER_PICKER_HEIGHT = 30;
    //<editor-fold desc= "Location Constants for Components">
    private static final int SPECIAL_DICE_X_COOR = 1130;
    private static final int SPECIAL_DICE_Y_COOR = 144;
    private static final int DICE_X_COOR = 50;
    private static final int DICE_Y_COOR = 14;
    private static final int BUTTON_X_COOR = 190;
    private static final int BUTTON_Y_COOR = 656;
    private static final int GAME_BUTTON_X_COOR = 1130;
    private static final int GAME_BUTTON_Y_COOR = 100;
    private static final int RESET_WORD_BUTTON_X_COOR = 100;
    private static final int RESET_WORD_BUTTON_Y_COOR = 656;
    private static final int TABLE_X_COOR = 50;
    private static final int TABLE_Y_COOR = 258;
    private static final int LABEL_X_COOR = 1105;
    private static final int LABEL_Y_COOR = 14;
    private static final int WORD_LABEL_X_COOR = 50;

    //</editor-fold>
    private static final int WORD_LABEL_Y_COOR = 144;
    private static final int SCORE_LABEL_X_COOR = 1095;
    private static final int SCORE_LABEL_Y_COOR = 530;
    private static final int ROLLS_LEFT_LABEL_X_COOR = 308;
    private static final int ROLLS_LEFT_LABEL_Y_COOR = 663;
    // User Directory to Locate Source Images
    private static final String USER_DIR = System.getProperty("user.home") + "/Desktop/Yahtzee/YahtzeeProject/src/Images";
    //<editor-fold desc = "Private Variables">
    private SCTable scTable;
    private DiceLabel vowel1Label;
    private DiceLabel vowel2Label;
    private DiceLabel vowel3Label;
    private DiceLabel con1Label;
    private DiceLabel con2Label;
    private DiceLabel con3Label;
    private DiceLabel con4Label;
    private DiceLabel con5Label;
    private DiceLabel con6Label;
    private SpecialDiceLabel specialDiceLabel;
    private String wordString = "";
    //</editor-fold>
    private JLabel wordLabel;
    private JLabel difficultyLabel;
    private JLabel totalScoreLabel;
    private JLabel rollsLeftLabel;
    private JButton rollButton;
    private JButton confirmSelectionButton;
    private JButton resetWordButton;
    private JComboBox difficultyBox;
    private JComboBox letterPicker;
    private JButton newGameButton;
    private JOptionPane gameOverPopup;
    private JOptionPane lineAlreadyUsedPopup;
    private JOptionPane rollWarningPopup;
    private Image unknownDiceImage;
    private int dicePerGameValue = 9;
    private int totalScoreValue = 0;
    private int rollsLeft;
    private int roundsLeft;
    private int rollWarningValue;
    private boolean pause = false;
    //</editor-fold>
    private Hand h;

    YahtzeeGUI(String title) {
        super(title);        // Assigns JFrame title

        roundsLeft = 11;
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
        BufferedImage doubleLetterImage_raw = null;
        BufferedImage doublePointsImage_raw = null;
        BufferedImage blankLetterImage_raw = null;
        BufferedImage forcedHandImage_raw = null;
        BufferedImage unknownDiceImage_raw = null;
        BufferedImage background_raw = null;
        BufferedImage refresh_raw = null;
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
            forcedHandImage_raw = ImageIO.read(new File(USER_DIR + "/forcedHand.png"));
            doubleLetterImage_raw = ImageIO.read(new File(USER_DIR + "/doubleLetter.png"));
            doublePointsImage_raw = ImageIO.read(new File(USER_DIR + "/doublePoints.png"));
            blankLetterImage_raw = ImageIO.read(new File(USER_DIR + "/blankLetter.png"));
            unknownDiceImage_raw = ImageIO.read(new File(USER_DIR + "/unknownDice.png"));
            background_raw = ImageIO.read(new File(USER_DIR + "/backgroundFancy.png"));
            refresh_raw = ImageIO.read(new File(USER_DIR + "/refresh.png"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        unknownDiceImage = unknownDiceImage_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image refresh = refresh_raw.getScaledInstance(RESET_WORD_BUTTON_WIDTH, WORD_LABEL_HEIGHT, Image.SCALE_SMOOTH);
        Image background = background_raw.getScaledInstance(1280, 760, Image.SCALE_SMOOTH);
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
        Image doubleLetterImage = doubleLetterImage_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image doublePointsImage = doublePointsImage_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image blankLetterImage = blankLetterImage_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
        Image forcedHandImage = forcedHandImage_raw.getScaledInstance(DICE_WIDTH, DICE_HEIGHT, Image.SCALE_SMOOTH);
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

        resetWordButton = new JButton();
        resetWordButton.setText("Reset Word");
        resetWordButton.setEnabled(false);
        resetWordButton.setIcon(new ImageIcon(refresh));
        resetWordButton.setSize(RESET_WORD_BUTTON_WIDTH, RESET_WORD_BUTTON_HEIGHT);
        resetWordButton.setLocation(RESET_WORD_BUTTON_X_COOR, RESET_WORD_BUTTON_Y_COOR);
        c.add(resetWordButton);

        confirmSelectionButton = new JButton();
        confirmSelectionButton.setText("Confirm Selection");
        confirmSelectionButton.setEnabled(false);
        confirmSelectionButton.setSize(BUTTON_WIDTH, BUTTON_HEIGHT);
        confirmSelectionButton.setLocation(BUTTON_X_COOR + 450, BUTTON_Y_COOR);
        c.add(confirmSelectionButton);
        //</editor-fold>

        //<editor-fold desc="Dice Label Creation">

        Image[] images = {
                unknownDiceImage,
                diceSideAImage, diceSideBImage, diceSideCImage, diceSideDImage, diceSideEImage, diceSideFImage, diceSideGImage, diceSideHImage,
                diceSideIImage, diceSideJImage, diceSideKImage, diceSideLImage, diceSideMImage, diceSideNImage, diceSideOImage,
                diceSidePImage, diceSideQImage, diceSideRImage, diceSideSImage, diceSideTImage, diceSideUImage, diceSideVImage,
                diceSideWImage, diceSideXImage, diceSideYImage, diceSideZImage,
                diceSideA_LockedImage, diceSideB_LockedImage, diceSideC_LockedImage, diceSideD_LockedImage, diceSideE_LockedImage, diceSideF_LockedImage, diceSideG_LockedImage, diceSideH_LockedImage,
                diceSideI_LockedImage, diceSideJ_LockedImage, diceSideK_LockedImage, diceSideL_LockedImage, diceSideM_LockedImage, diceSideN_LockedImage, diceSideO_LockedImage,
                diceSideP_LockedImage, diceSideQ_LockedImage, diceSideR_LockedImage, diceSideS_LockedImage, diceSideT_LockedImage, diceSideU_LockedImage, diceSideV_LockedImage,
                diceSideW_LockedImage, diceSideX_LockedImage, diceSideY_LockedImage, diceSideZ_LockedImage
        };

        Image[] specialDiceImages = {
                unknownDiceImage, doubleLetterImage, doublePointsImage, blankLetterImage, forcedHandImage
        };

        vowel1Label = new DiceLabel(images, 6);
        vowel1Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        vowel1Label.setLocation(DICE_X_COOR + (0 * 100), DICE_Y_COOR);
        c.add(vowel1Label);

        vowel2Label = new DiceLabel(images, 6);
        vowel2Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        vowel2Label.setLocation(DICE_X_COOR + (1 * 100), DICE_Y_COOR);
        c.add(vowel2Label);

        vowel3Label = new DiceLabel(images, 6);
        vowel3Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        vowel3Label.setLocation(DICE_X_COOR + (2 * 100), DICE_Y_COOR);
        c.add(vowel3Label);

        con1Label = new DiceLabel(images, 20);
        con1Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        con1Label.setLocation(DICE_X_COOR + (4 * 100), DICE_Y_COOR);
        c.add(con1Label);

        con2Label = new DiceLabel(images, 20);
        con2Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        con2Label.setLocation(DICE_X_COOR + (5 * 100), DICE_Y_COOR);
        c.add(con2Label);

        con3Label = new DiceLabel(images, 20);
        con3Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        con3Label.setLocation(DICE_X_COOR + (6 * 100), DICE_Y_COOR);
        c.add(con3Label);

        con4Label = new DiceLabel(images, 20);
        con4Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        con4Label.setLocation(DICE_X_COOR + (7 * 100), DICE_Y_COOR);
        c.add(con4Label);

        con5Label = new DiceLabel(images, 20);
        con5Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        con5Label.setLocation(DICE_X_COOR + (8 * 100), DICE_Y_COOR);
        c.add(con5Label);

        con6Label = new DiceLabel(images, 20);
        con6Label.setSize(DICE_WIDTH, DICE_HEIGHT);
        con6Label.setLocation(DICE_X_COOR + (9 * 100), DICE_Y_COOR);
        c.add(con6Label);

        specialDiceLabel = new SpecialDiceLabel(specialDiceImages);
        specialDiceLabel.setSize(SPECIAL_DICE_WIDTH, SPECIAL_DICE_HEIGHT);
        specialDiceLabel.setLocation(SPECIAL_DICE_X_COOR, SPECIAL_DICE_Y_COOR);
        c.add(specialDiceLabel);

        wordLabel = new JLabel("No Word Created");
        wordLabel.setFont(new Font("Garamond", Font.BOLD, 50));
        wordLabel.setHorizontalAlignment(SwingConstants.CENTER);
        wordLabel.setSize(WORD_LABEL_WIDTH, WORD_LABEL_HEIGHT);
        wordLabel.setLocation(WORD_LABEL_X_COOR, WORD_LABEL_Y_COOR);
        c.add(wordLabel);

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
        scTable.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        scTable.setSize(TABLE_WIDTH, TABLE_HEIGHT);
        scTable.setLocation(TABLE_X_COOR, TABLE_Y_COOR);
        c.add(scTable);
        //</editor-fold>

        //<editor-fold desc="Dice Per Game Menu Creation">
        difficultyLabel = new JLabel();
        difficultyLabel.setFont(new Font("Garamond", Font.PLAIN, 20));
        difficultyLabel.setText("Difficulty");
        difficultyLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        difficultyLabel.setLocation(LABEL_X_COOR, LABEL_Y_COOR);
        c.add(difficultyLabel);


        String[] dicePerGameOptions = {"Easy", "Medium", "Hard"};
        difficultyBox = new JComboBox(dicePerGameOptions);
        difficultyBox.setSelectedIndex(0);
        difficultyBox.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        difficultyBox.setLocation(LABEL_X_COOR, LABEL_Y_COOR + 30);
        c.add(difficultyBox);

        String[] letters = {"A", "B", "C", "D", "E", "F", "G",
                "H", "I", "J", "K", "L", "M", "N", "O", "P",
                "Q", "R", "S", "T", "U", "V",
                "W", "X", "Y", "Z"};
        letterPicker = new JComboBox(letters);
        letterPicker.setSelectedIndex(0);
        letterPicker.setSize(LETTER_PICKER_WIDTH, LETTER_PICKER_HEIGHT);
        letterPicker.setLocation(SPECIAL_DICE_X_COOR, SPECIAL_DICE_Y_COOR + 120);
        c.add(letterPicker);
        //</editor-fold>


        newGameButton = new JButton();
        newGameButton.setText("New Game");
        newGameButton.setSize(GAME_BUTTON_WIDTH, GAME_BUTTON_HEIGHT);
        newGameButton.setLocation(GAME_BUTTON_X_COOR, GAME_BUTTON_Y_COOR);
        c.add(newGameButton);


        //<editor-fold desc = "Score Labels">

        totalScoreLabel = new JLabel();
        totalScoreLabel.setFont(new Font("Garamond", Font.BOLD, 20));
        totalScoreLabel.setText("Total: " + String.valueOf(totalScoreValue));
        totalScoreLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT * 2);
        totalScoreLabel.setLocation(SCORE_LABEL_X_COOR, SCORE_LABEL_Y_COOR + 120);
        c.add(totalScoreLabel);

        //</editor-fold>

        //<editor-fold desc = "Rolls Left Label Creation">
        rollsLeftLabel = new JLabel();
        rollsLeftLabel.setFont(new Font("Garamond", Font.BOLD, 20));
        rollsLeftLabel.setForeground(Color.BLACK);
        rollsLeftLabel.setText("Rolls Left: " + String.valueOf(rollsLeft));
        rollsLeftLabel.setSize(LABEL_WIDTH, LABEL_HEIGHT);
        rollsLeftLabel.setLocation(ROLLS_LEFT_LABEL_X_COOR + 200, ROLLS_LEFT_LABEL_Y_COOR);
        c.add(rollsLeftLabel);
        //</editor-fold>


        DiceLabel[] hand = {vowel1Label, vowel2Label, vowel3Label, con1Label, con2Label, con3Label, con4Label, con5Label, con6Label};
        h = new Hand(hand);


        //<editor-fold desc = "Action Listeners">
        newGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset(true);
                rollButton.setEnabled(true);
                newGameButton.setBackground(null);
            }
        });

        resetWordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                wordString = "";
                vowel1Label.getD().setKept(false);
                vowel2Label.getD().setKept(false);
                vowel3Label.getD().setKept(false);
                con1Label.getD().setKept(false);
                con2Label.getD().setKept(false);
                con3Label.getD().setKept(false);
                con4Label.getD().setKept(false);
                con5Label.getD().setKept(false);
                con6Label.getD().setKept(false);
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
                if (rollsLeft <= 0 || pause) {
                    resetWordButton.setEnabled(true);
                    confirmSelectionButton.setEnabled(true);
                    rollButton.setEnabled(false);
                    rollButton.setText("No Rolls Left");
                    vowel1Label.getD().setKept(false);
                    vowel2Label.getD().setKept(false);
                    vowel3Label.getD().setKept(false);
                    con1Label.getD().setKept(false);
                    con2Label.getD().setKept(false);
                    con3Label.getD().setKept(false);
                    con4Label.getD().setKept(false);
                    con5Label.getD().setKept(false);
                    con6Label.getD().setKept(false);
                    refreshDice();
                    pause = true;
                    if (rollWarningValue >= 4) {
                        rollWarningPopup = new JOptionPane();
                        rollWarningPopup.showMessageDialog(null,
                                "You have no rolls left this round. \n To end this round select a line on the ScoreCard and press \"Confirm Selection|\"");
                    } else rollWarningValue++;
                } else {
                    if (rollsLeft == 3) {
                        specialDiceLabel.getSd().roll();
                        refresh();
                    }
                    resetWordButton.setEnabled(false);
                    vowel1Label.getD().roll();
                    vowel2Label.getD().roll();
                    vowel3Label.getD().roll();
                    con1Label.getD().roll();
                    con2Label.getD().roll();
                    con3Label.getD().roll();
                    con4Label.getD().roll();
                    con5Label.getD().roll();
                    con6Label.getD().roll();
                    refreshDice();
                    rollsLeft--;
                    rollsLeftLabel.setText("Rolls Left: " + String.valueOf(rollsLeft));
                    if (rollsLeft == 0) rollButton.doClick();
                }

            }
        });

        difficultyBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reset(true);
                removeLabels(c);
                rollButton.setEnabled(false);
                confirmSelectionButton.setEnabled(false);
                newGameButton.setBackground(Color.YELLOW);
                if (difficultyBox.getSelectedItem().equals("Easy")) {
                    dicePerGameValue = 9;
                    c.add(vowel1Label);
                    c.add(vowel2Label);
                    c.add(vowel3Label);
                    c.add(con1Label);
                    c.add(con2Label);
                    c.add(con3Label);
                    c.add(con4Label);
                    c.add(con5Label);
                    c.add(con6Label);
                    repaint();
                } else if (difficultyBox.getSelectedItem().equals("Medium")) {
                    dicePerGameValue = 8;
                    c.add(vowel1Label);
                    c.add(vowel2Label);
                    c.add(vowel3Label);
                    c.add(con1Label);
                    c.add(con2Label);
                    c.add(con3Label);
                    c.add(con4Label);
                    c.add(con5Label);
                    repaint();
                } else if (difficultyBox.getSelectedItem().equals("Hard")) {
                    dicePerGameValue = 6;
                    c.add(vowel1Label);
                    c.add(vowel2Label);
                    c.add(con1Label);
                    c.add(con2Label);
                    c.add(con3Label);
                    c.add(con4Label);
                    repaint();
                }
            }
        });

        specialDiceLabel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (specialDiceLabel.getSd() == null) return;
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
                rollsLeft = 0;
                confirmSelectionButton.setEnabled(false);
                rollButton.setEnabled(true);
                pause = false;
                ScoreCardLine lineUsed = scTable.getSc().getLine(getSelectedLine());
                lineUsed.setUsed(true);
                lineUsed.setPointsEarned(scTable.getSc().checkScore(wordString));
                lineUsed.setWordScored(wordString);
                wordString = "";
                refresh();
                reset(false);
                if (scTable.getSc().howManyLeft() <= 0) {
                    gameOverPopup = new JOptionPane();
                    gameOverPopup.showMessageDialog(null, "Game Over \n   Final Score: " + String.valueOf(totalScoreValue));
                    System.exit(0);
                }
            }
        });

        //<editor-fold desc = "Dice Checkboxes Listeners">
        vowel1Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vowel1Label.getD() == null) return;
                if (vowel1Label.isSelected()) {
                    if (pause && !vowel1Label.getD().getKept()) {
                        wordString += vowel1Label.getD().getValue();
                    }
                    vowel1Label.getD().setKept(true);
                } else {
                    if (!pause) {
                        vowel1Label.getD().setKept(false);
                    }
                }
                vowel1Label.refresh();
                refreshWordLabel();
            }
        });

        vowel2Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vowel2Label.getD() == null) return;
                if (vowel2Label.isSelected()) {
                    if (pause && !vowel2Label.getD().getKept()) {
                        wordString += vowel2Label.getD().getValue();
                    }
                    vowel2Label.getD().setKept(true);
                } else {
                    if (!pause) {
                        vowel2Label.getD().setKept(false);
                    }
                }
                vowel2Label.refresh();
                refreshWordLabel();
            }
        });

        vowel3Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (vowel3Label.getD() == null) return;
                if (vowel3Label.isSelected()) {
                    if (pause && !vowel3Label.getD().getKept()) {
                        wordString += vowel3Label.getD().getValue();
                    }
                    vowel3Label.getD().setKept(true);
                } else {
                    if (!pause) {
                        vowel3Label.getD().setKept(false);
                    }
                }
                vowel3Label.refresh();
                refreshWordLabel();
            }
        });

        con1Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (con1Label.getD() == null) return;
                if (con1Label.isSelected()) {
                    if (pause && !con1Label.getD().getKept()) {
                        wordString += con1Label.getD().getValue();
                    }
                    con1Label.getD().setKept(true);
                } else {
                    if (!pause) {
                        con1Label.getD().setKept(false);
                    }
                }
                con1Label.refresh();
                refreshWordLabel();
            }
        });

        con2Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (con2Label.getD() == null) return;
                if (con2Label.isSelected()) {
                    if (pause && !con2Label.getD().getKept()) {
                        wordString += con2Label.getD().getValue();
                    }
                    con2Label.getD().setKept(true);
                } else {
                    if (!pause) {
                        con2Label.getD().setKept(false);
                    }
                }
                con2Label.refresh();
                refreshWordLabel();
            }
        });

        con3Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (con3Label.getD() == null) return;
                if (con3Label.isSelected()) {
                    if (pause && !con3Label.getD().getKept()) {
                        wordString += con3Label.getD().getValue();
                    }
                    con3Label.getD().setKept(true);
                } else {
                    if (!pause) {
                        con3Label.getD().setKept(false);
                    }
                }
                con3Label.refresh();
                refreshWordLabel();
            }
        });

        con4Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (con4Label.getD() == null) return;
                if (con4Label.isSelected()) {
                    if (pause && !con4Label.getD().getKept()) {
                        wordString += con4Label.getD().getValue();
                    }
                    con4Label.getD().setKept(true);
                } else {
                    if (!pause) {
                        con4Label.getD().setKept(false);
                    }
                }
                con4Label.refresh();
                refreshWordLabel();
            }
        });

        con5Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (con5Label.getD() == null) return;
                if (con5Label.isSelected()) {
                    if (pause && !con5Label.getD().getKept()) {
                        wordString += con5Label.getD().getValue();
                    }
                    con5Label.getD().setKept(true);
                } else {
                    if (!pause) {
                        con5Label.getD().setKept(false);
                    }
                }
                con5Label.refresh();
                refreshWordLabel();
            }
        });

        con6Label.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (con6Label.getD() == null) return;
                if (con6Label.isSelected()) {
                    if (pause && !con6Label.getD().getKept()) {
                        wordString += con6Label.getD().getValue();
                    }
                    con6Label.getD().setKept(true);
                } else {
                    if (!pause) {
                        con6Label.getD().setKept(false);
                    }
                }
                con6Label.refresh();
                refreshWordLabel();
            }
        });


        //</editor-fold>

        //</editor-fold>
    }

    /**
     * @param toBeChanged The JLabel that the image will change
     * @param newImage    The Image that JLabel will change to
     */
    private void changeImage(JToggleButton toBeChanged, Image newImage) {
        toBeChanged.setIcon(new ImageIcon(newImage));
    }

    /**
     * Rests DiceLabels back to unknown Image
     */
    private void resetDice() {
        pause = false;
        vowel1Label.setSelected(false);
        vowel2Label.setSelected(false);
        vowel3Label.setSelected(false);
        con1Label.setSelected(false);
        con2Label.setSelected(false);
        con3Label.setSelected(false);
        con4Label.setSelected(false);
        con5Label.setSelected(false);
        con6Label.setSelected(false);
        vowel1Label.setD(null);
        vowel2Label.setD(null);
        vowel3Label.setD(null);
        con1Label.setD(null);
        con2Label.setD(null);
        con3Label.setD(null);
        con4Label.setD(null);
        con5Label.setD(null);
        con6Label.setD(null);

        JToggleButton[] dice = {vowel1Label, vowel2Label, vowel3Label, con1Label, con2Label, con3Label, con4Label, con5Label, con6Label};
        for (int i = 0; i < dice.length; i++) {
            changeImage(dice[i], unknownDiceImage);
        }
    }

    /**
     * @return Whether or not all dice are kept
     */
    private boolean allKept() {
        DiceLabel[] a = {vowel1Label, vowel2Label, vowel3Label, con1Label, con2Label, con3Label, con4Label, con5Label, con6Label};
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
        if (selected == -1) return 0;
        return selected;
    }

    /**
     * Assigns image to each DiceLabel based on their value
     */
    private void refreshDice() {
        vowel1Label.refresh();
        vowel2Label.refresh();
        vowel3Label.refresh();
        con1Label.refresh();
        con2Label.refresh();
        con3Label.refresh();
        con4Label.refresh();
        con5Label.refresh();
        con6Label.refresh();
        if (dicePerGameValue == 6) {
            DiceLabel[] hand = {vowel1Label, vowel2Label, con1Label, con2Label, con3Label, con4Label};
            h = new Hand(hand);
        } else if (dicePerGameValue == 8) {
            DiceLabel[] hand = {vowel1Label, vowel2Label, vowel3Label, con1Label, con2Label, con3Label, con4Label, con5Label};
            h = new Hand(hand);
        } else {
            DiceLabel[] hand = {vowel1Label, vowel2Label, vowel3Label, con1Label, con2Label, con3Label, con4Label, con5Label, con6Label};
            h = new Hand(hand);
        }
        repaint();
    }

    /**
     * Sets all the Score Labels to the score Values
     */
    private void refreshScores() {
        totalScoreValue = scTable.getSc().getTotalScore();
        totalScoreLabel.setText("Total: " + String.valueOf(totalScoreValue));
        repaint();
    }

    /**
     * Calls on all the refresh methods and resets
     */
    private void refresh() {
        refreshScores();
        scTable.refresh();
        specialDiceLabel.refresh();
        refreshDice();
        rollButton.setText("Roll Hand");
        rollsLeftLabel.setText("Rolls Left: " + rollsLeft);
        refreshWordLabel();

        repaint();
    }

    /**
     * Resets the screen
     *
     * @param fullReset boolean if its a newGame, resets everything
     */
    private void reset(boolean fullReset) {
        rollsLeft = 3;
        refresh();
        resetDice();
        if (fullReset) {
            scTable.reset();
            totalScoreValue = 0;
            refreshScores();
        }
        repaint();
    }

    private void removeLabels(Container c) {
        c.remove(vowel1Label);
        c.remove(vowel2Label);
        c.remove(vowel3Label);
        c.remove(con1Label);
        c.remove(con2Label);
        c.remove(con3Label);
        c.remove(con4Label);
        c.remove(con5Label);
        c.remove(con6Label);
    }

    private void refreshWordLabel() {
        if (wordString == null) {
            wordLabel.setText("No Word Created");
            return;
        }
        String str = wordString.toUpperCase();
        wordLabel.setText(str);
        repaint();
    }
}

class ForcedListSelectionModel extends DefaultListSelectionModel {
    public ForcedListSelectionModel() {
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @Override
    public void clearSelection() {
    }

    @Override
    public void removeSelectionInterval(int index0, int index1) {
    }
}
