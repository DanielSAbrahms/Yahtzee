import javax.swing.*;
import javax.swing.table.DefaultTableModel;


class SCTable extends JTable {

    private ScoreCard sc;
    private int sidesPerDice = 6;

    SCTable(int newSidesPerDice) {
        sidesPerDice = newSidesPerDice;
        sc = new ScoreCard(sidesPerDice);
        reset();
    }

    ScoreCard getSc() {
        return sc;
    }

    public void setSidesPerDice(int sidesPerDice) {
        this.sidesPerDice = sidesPerDice;
    }

    void setSc(ScoreCard sc) {

        this.sc = sc;
    }

    void refresh() {
        String[][] values = new String[sidesPerDice+7][3];
        for (int i = 0; i < sidesPerDice+7; i++){
            ScoreCardLine line = sc.getLine(i);
            String pe;
            if (line.getPointsEarned() == 0) {
                pe = "-";
            } else {
                pe = String.valueOf(line.getPointsEarned());
            }
            String[] a = {line.getName(), String.valueOf(line.getPotentialPoints()), pe};
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
            String[] a = {line.getName(), String.valueOf(0), pe};
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
