import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
        for (int i = 0; i < 13; i++) {
            DefaultTableModel model = (DefaultTableModel) getModel();
            Object[] row = {sc.getLine(i).getName(), sc.getLine(i).getPoints(), sc.getLine(i).getPointsEarned()};
            model.addRow(row);
        }
        //this.get
    }
}
