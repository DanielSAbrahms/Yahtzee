import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author Daniel Abrahms
 * @version 1.0
 */
public class SCTable extends JTable {

    private ScoreCard sc;

    SCTable() {
        sc = new ScoreCard();
        reset();
    }

    /**
     * @return sc, the ScoreCard
     */
    ScoreCard getSc() {
        return sc;
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
        String[][] values = new String[11][3];
        for (int i = 0; i < 11; i++){
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
            String word = line.getWordScored();
            String[] a = {name, pe, word};
            values[i] = a;
        }
        String[] names = new String[11];
        for (int i = 0; i < 11; i++){
            names[i] = String.valueOf(i);
        }
        DefaultTableModel model = new DefaultTableModel(values, names);
        model.setColumnCount(3);
        model.setRowCount(11);
        this.setModel(model);
    }



    /**
     * Resets all the values of the table
     */
    void reset() {
        String[][] values = new String[11][3];
        for (int i = 0; i < 11; i++){
            ScoreCardLine line = sc.getLine(i);
            String[] a = {line.getName(), String.valueOf(0), "-" };
            values[i] = a;
        }
        String[] names = new String[11];
        for (int i = 0; i < 11; i++){
            names[i] = String.valueOf(i);
        }
        DefaultTableModel model = new DefaultTableModel(values, names);
        model.setColumnCount(3);
        this.setModel(model);
        for (int i = 0; i < 11; i++){
            ScoreCardLine line = sc.getLine(i);
            line.setPointsEarned(0);
        }
    }

}
