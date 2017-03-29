import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Daniel Abrahms
 * @version 1.0
 */
public class SCTable extends JTable {

    private ScoreCard sc;
    private int sidesPerDice = 6;

    /**
     * @param newSidesPerDice the number of sides per dice
     */
    SCTable(int newSidesPerDice) {
        sidesPerDice = newSidesPerDice;
        sc = new ScoreCard(sidesPerDice);
        reset();
    }

    /**
     * @return sc, the ScoreCard
     */
    ScoreCard getSc() {
        return sc;
    }

    /**
     * @param sidesPerDice the number of sides per dice
     */
    public void setSidesPerDice(int sidesPerDice) {
        this.sidesPerDice = sidesPerDice;
    }

    /**
     * @param sc The ScoreCard variable
     */
    void setSc(ScoreCard sc) {

        this.sc = sc;
    }

    /**
     * Refreshes the table, based on the values of the ScoreCard
     */
    void refresh() {
        String[][] values = new String[sidesPerDice+7][3];
        for (int i = 0; i < sidesPerDice+7; i++){
            ScoreCardLine line = sc.getLine(i);
            String pe;
            if (line.getPointsEarned() == 0 && line.getUsed() == false) {
                pe = "-";
            } else {
                pe = String.valueOf(line.getPointsEarned());
            }
            String name;
            if (line.getUsed()) {
                name = "-";
            } else {
                name = line.getName();
            }
            String[] a = {name, String.valueOf(line.getPotentialPoints()), pe};
            values[i] = a;
        }
        String[] names = new String[sidesPerDice+7];
        for (int i = 0; i < sidesPerDice+7; i++){
            names[i] = String.valueOf(i);
        }
        DefaultTableModel model = new DefaultTableModel(values, names);
        model.setColumnCount(3);
        model.setRowCount(sidesPerDice+7);
        this.setModel(model);
    }

    /**
     * Keeps the ScoreCard and table in tact, but clears the middle column
     */
    void resetColumn1() {
        String[][] values = new String[sidesPerDice+7][3];
        for (int i = 0; i < sidesPerDice+7; i++){
            ScoreCardLine line = sc.getLine(i);
            String pe;
            if (line.getPointsEarned() == 0) {
                pe = "-";
            } else {
                pe = String.valueOf(line.getPointsEarned());
            }
            String name;
            if (line.getUsed()) {
                name = "-";
            } else {
                name = line.getName();
            }
            String[] a = {name, String.valueOf(0), pe};
            values[i] = a;
        }
        String[] names = new String[sidesPerDice+7];
        for (int i = 0; i < sidesPerDice+7; i++){
            names[i] = String.valueOf(i);
        }
        DefaultTableModel model = new DefaultTableModel(values, names);
        model.setColumnCount(3);
        this.setModel(model);
    }

    /**
     * Resets all the values of the table
     */
    void reset() {
        String[][] values = new String[sidesPerDice+7][3];
        for (int i = 0; i < sidesPerDice+7; i++){
            ScoreCardLine line = sc.getLine(i);
            String[] a = {line.getName(), String.valueOf(0), "-" };
            values[i] = a;
        }
        String[] names = new String[sidesPerDice+7];
        for (int i = 0; i < sidesPerDice+7; i++){
            names[i] = String.valueOf(i);
        }
        DefaultTableModel model = new DefaultTableModel(values, names);
        model.setColumnCount(3);
        this.setModel(model);
        for (int i = 0; i < sidesPerDice+7; i++){
            ScoreCardLine line = sc.getLine(i);
            line.setPointsEarned(0);
        }
    }
}
