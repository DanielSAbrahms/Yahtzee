import javax.swing.*;

/**
 * Created by irish on 3/25/2017.
 */
public class SCTable extends JTable {

    private ScoreCard sc;

    public SCTable() {
        sc = new ScoreCard(6);
        refresh();
    }

    public ScoreCard getSc() {
        return sc;
    }

    public void setSc(ScoreCard sc) {
        this.sc = sc;
    }

    public void refresh() {
        for (int i = 0; i < 12; i++) {
            getModel().setValueAt(sc.getLine(i).getName(), 0, i);
            getModel().setValueAt(sc.getLine(i).getPoints(), 1, i);
            getModel().setValueAt(sc.getLine(i).getPointsEarned(), 2, i);
        }
    }
}
