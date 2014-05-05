package regularTech.GUI;

import regularTech.SQL.reportDAO;

import javax.swing.*;
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
        model = new OfficeObjectListModel(data);
        setModel(model);
        
        initList();
    }

    private void initList() {
        for(String curElem : data) {
            model.addElement(curElem);
        }
    }
    public void filterList(String pattern){

    }

}
