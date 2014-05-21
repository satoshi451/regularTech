package regularTech.GUI;

import regularTech.SQL.ReportDAO;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 30.04.2014
 * TIME: 16:22
 */
public class BuchalteryModel extends AbstractTableModel {
    private int rowCount;
    private int columnCount;
    private String[] headers = {"Office object", "Type", "Deal", "Cost", "Date"};

    private List<Object[]> data;

    public BuchalteryModel() {
        data = ReportDAO.listReportObject();
        this.columnCount = 5;
        this.rowCount = data.size();
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
        return Object.class;//getValueAt(0, i).getClass();
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

}
