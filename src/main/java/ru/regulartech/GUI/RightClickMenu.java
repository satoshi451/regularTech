package ru.regulartech.GUI;

import ru.regulartech.SQL.OfficeObjectModel;
import ru.regulartech.graphical.Room;
import ru.regulartech.officeObjects.Laptop;
import ru.regulartech.officeObjects.PC;
import ru.regulartech.officeObjects.Printer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PipedReader;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 15.06.2014
 * TIME: 18:50
 */
public class RightClickMenu extends JPopupMenu{
    private Room curRoom;
    private Component parentComponent;

    public RightClickMenu() {
        super();
        JMenuItem addObject = new JMenuItem("add object");
        addObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PipedReader pipedReader = new PipedReader();
                ObjectTypeSelectorWindow getObjectType = new ObjectTypeSelectorWindow(pipedReader);

                int type = 0;
                try {
                    type = pipedReader.read();
                    pipedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(type);

                switch (type){
                    case OfficeObjectModel.OFFICE_OBJECT_PC:
                        curRoom.addObject(new PC());
                        parentComponent.repaint();
                        break;

                    case OfficeObjectModel.OFFICE_OBJECT_LAPTOP:
                        curRoom.addObject(new Laptop());
                        parentComponent.repaint();
                        break;

                    case OfficeObjectModel.OFFICE_OBJECT_PRINTER:
                        curRoom.addObject(new Printer());
                        parentComponent.repaint();
                        break;
                    //TODO: add more types object
                }

                if(curRoom != null || parentComponent != null) {
                    setLocation(curRoom.getX() + 300, curRoom.getY() + 300);
                    setVisible(false);
                }
                else
                    setVisible(false);
            }
        });
        add(addObject);

    }

    public RightClickMenu(Room room) {
        this();
        setRoom(room);
    }

    public void setComponent(Component component){
        parentComponent = component;
    }
    public void setRoom(Room room){
        curRoom = room;
    }
}
