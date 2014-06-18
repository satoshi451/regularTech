package ru.regulartech.officeObjects;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.04.2014
 * TIME: 22:04
 */

public abstract class ElectronicObject extends OfficeObject implements electronicFunctions {

    protected ElectronicObject(){
        super();
        setObjectRightClickMenu(new ElectronicObjectRightClickMenu());
    }
    protected ElectronicObject(Integer id, String name) {
        super(id, name);
        setObjectRightClickMenu(new ElectronicObjectRightClickMenu());
    }

    public class ElectronicObjectRightClickMenu extends ObjectRightClickMenu {
        protected ElectronicObjectRightClickMenu() {
            JMenuItem diagnostic = new JMenuItem("поставить диагностику");

            diagnostic.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                }
            });
            add(diagnostic);
        }
    }
}
