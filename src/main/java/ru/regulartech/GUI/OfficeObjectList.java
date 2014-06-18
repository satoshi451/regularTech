package ru.regulartech.GUI;

import ru.regulartech.SQL.ReportDAO;
import ru.regulartech.officeObjects.OfficeObject;

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
    private List<OfficeObject> data;

    public OfficeObjectList() {
        super();
        data = ReportDAO.listAll();
        rebuildList();
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    public void filterList(String pattern){
        data = ReportDAO.listAll();

        if(pattern.equals("")){
            rebuildList();
            return;
        }
        List<OfficeObject> newData = new LinkedList<OfficeObject>();

        for (OfficeObject listElem : data)
            if(listElem.getName().contains(pattern))
                newData.add(listElem);

        this.data = newData;
        rebuildList();
    }
    private void rebuildList(){
        model = new OfficeObjectListModel(data);
        for (OfficeObject listElem : data)
            model.addElement(listElem.getName());

        setModel(model);
        repaint();
    }

    public OfficeObject getByValue(String selectedValue) {
        for(OfficeObject curObj : data){
            if(curObj.getName().equals(selectedValue)){
                return curObj;
            }

        }
        return null;
    }
}
