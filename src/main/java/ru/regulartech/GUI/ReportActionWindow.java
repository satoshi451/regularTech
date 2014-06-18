package ru.regulartech.GUI;

import ru.regulartech.officeObjects.OfficeObject;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 05.05.2014
 * TIME: 11:51
 */
public class ReportActionWindow extends JFrame{

    private ActionArea actionArea;
    private HerarhArea herarhArea;
    private Object[] currentObject;

    public ReportActionWindow(String capture){
        super(capture);

        LayoutManager layout = new BorderLayout();
        setLayout(layout);

        herarhArea = new HerarhArea();
        actionArea = new ActionArea();

        ListSelectionModel listSelectionModel = herarhArea.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                herarhArea.getCurElem();
                OfficeObject officeObject = herarhArea.getCurrentOfficeObject();
                actionArea.setObject(officeObject);
            }
        });

        add(herarhArea, BorderLayout.WEST);
        add(actionArea, BorderLayout.CENTER);

        setBounds(100, 100, 800, 500);
        setResizable(false);
    }
}
