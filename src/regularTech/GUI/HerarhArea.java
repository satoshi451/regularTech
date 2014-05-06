package regularTech.GUI;

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

    public Integer getCurElemId() {
        String selectedValue = (String) officeObjectList.getSelectedValue();
        Integer id = officeObjectList.getIdByValue(selectedValue);
        return id;
    }
}
