package ru.regulartech.GUI;

import ru.regulartech.officeObjects.OfficeObject;

import javax.swing.*;
import java.awt.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 05.05.2014
 * TIME: 14:05
 */
public class HerarhArea extends JPanel{

    private OfficeObjectList officeObjectList;
    private SearchBar searchBar;
    private OfficeObject currentOfficeObject;

    public HerarhArea() {
        super();

        setLayout(new BorderLayout());

        officeObjectList = new OfficeObjectList();
        searchBar = new SearchBar(officeObjectList);

        add(searchBar, BorderLayout.NORTH);
        add(new JScrollPane(officeObjectList), BorderLayout.CENTER);
    }

    public ListSelectionModel getSelectionModel(){
        return officeObjectList.getSelectionModel();
    }

    public OfficeObject getCurrentOfficeObject() {
        return currentOfficeObject;
    }

    public void setCurrentOfficeObject(OfficeObject currentOfficeObject) {
        this.currentOfficeObject = currentOfficeObject;
    }

    public Integer getCurElem() {
        String selectedValue = (String) officeObjectList.getSelectedValue();
        OfficeObject officeObject = officeObjectList.getByValue(selectedValue);
        setCurrentOfficeObject(officeObject);
        return null;
    }

}
