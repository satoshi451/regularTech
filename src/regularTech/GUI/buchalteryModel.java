package regularTech.GUI;

import regularTech.SQL.reportDAO;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.List;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 30.04.2014
 * TIME: 16:22
 */
public class buchalteryModel implements TableModel {
    private int rowCount;
    private int columnCount;
    private String[] headers = {"Office object", "Type", "Deal", "Cost", "Date"};

    private List<Object[]> data;

    public buchalteryModel() {
        data = reportDAO.listObjects();
        this.columnCount = data.size();
        this.rowCount = 5;
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public String getColumnName(int i) {
        return headers[i];
    }

    @Override
    public Class getColumnClass(int i) {
        return getValueAt(0, i).getClass();
    }

    @Override
    public boolean isCellEditable(int i, int i2) {
        return false;
    }

    @Override
    public Object getValueAt(int i, int i2) {
        return data.get(i)[i2];
    }

    @Override
    public void setValueAt(Object o, int i, int i2) {

    }

    @Override
    public void addTableModelListener(TableModelListener tableModelListener) {

    }

    @Override
    public void removeTableModelListener(TableModelListener tableModelListener) {

    }
}
