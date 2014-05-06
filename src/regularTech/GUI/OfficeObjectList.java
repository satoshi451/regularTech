package regularTech.GUI;

import regularTech.SQL.reportDAO;

import javax.swing.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 05.05.2014
 * TIME: 14:15
 */
public class OfficeObjectList extends JList{
    private DefaultListModel model;
    private List<String> data;

    public OfficeObjectList() {
        super();
        data = reportDAO.listAll();
        rebuildList();
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    }

    private void initList() {
        for(String curElem : data) {
            model.addElement(curElem);
        }
    }
    public void filterList(String pattern){
        data = reportDAO.listAll();

        if(pattern.equals("")){
            rebuildList();
            return;
        }
        List<String> newData = new LinkedList<String>();

        for (String listElem : data)
            if(listElem.contains(pattern))
                newData.add(listElem);

        this.data = newData;
        rebuildList();
    }
    private void rebuildList(){
        model = new OfficeObjectListModel(data);
        initList();
        setModel(model);
        repaint();
    }
}
