package regularTech.GUI;

import javax.swing.*;
import javax.swing.table.TableModel;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 30.04.2014
 * TIME: 16:16
 */
public class JBuchTable extends JTable {
    private TableModel tblModel;

    public JBuchTable() {
        this.tblModel = new buchalteryModel();
    }

    public JBuchTable(TableModel tableModel) {
        super(tableModel);
    }
}
