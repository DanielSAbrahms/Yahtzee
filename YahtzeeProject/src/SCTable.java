import javax.swing.*;
import javax.swing.table.DefaultTableModel;


class SCTable extends JTable {

    private ScoreCard sc;

    SCTable() {
        sc = new ScoreCard(6);
        refresh();
    }

    ScoreCard getSc() {
        return sc;
    }

    void setSc(ScoreCard sc) {
        this.sc = sc;
    }

    void refresh() {
        String[][] values = new String[6+7][3];
        for (int i = 0; i < 6+7; i++){
            ScoreCardLine line = sc.getLine(i);
            String[] a = {line.getName(), String.valueOf(line.getPoints()*line.getMultiplier()), String.valueOf(line.getPointsEarned())};
            values[i] = a;
        }
        String[] names = new String[6+7];
        for (int i = 0; i < 6+7; i++){
            names[i] = String.valueOf(i);
        }
        DefaultTableModel model = new DefaultTableModel(values, names);
        model.setColumnCount(3);
        this.setModel(model);


    }
}
