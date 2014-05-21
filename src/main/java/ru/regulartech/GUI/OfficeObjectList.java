package ru.regulartech.GUI;

import ru.regulartech.SQL.ReportDAO;
import ru.regulartech.application.Pair;

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
    private List<Pair<Integer, String>> data;

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
        List<Pair<Integer, String>> newData = new LinkedList<Pair<Integer, String>>();

        for (Pair<Integer, String> listElem : data)
            if(listElem.getSecond().contains(pattern))
                newData.add(listElem);

        this.data = newData;
        rebuildList();
    }
    private void rebuildList(){
        model = new OfficeObjectListModel(data);
        for (Pair<Integer, String> listElem : data)
            model.addElement(listElem.getSecond());

        setModel(model);
        repaint();
    }

    public Integer getIdByValue(String selectedValue) {
        for(Pair<Integer, String> curElem : data)
            if(curElem.getSecond().equals(selectedValue))
                return curElem.getFirst();

        return null;
    }
}
