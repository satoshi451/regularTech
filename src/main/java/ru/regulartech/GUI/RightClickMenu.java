package ru.regulartech.GUI;

import ru.regulartech.graphical.Room;
import ru.regulartech.officeObjects.*;

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
                //System.out.println(type);

                switch (type){
                    case OfficeObject.OFFICE_OBJECT_PC:
                        curRoom.addObject(new PC());
                        break;

                    case OfficeObject.OFFICE_OBJECT_LAPTOP:
                        curRoom.addObject(new Laptop());
                        break;

                    case OfficeObject.OFFICE_OBJECT_PRINTER:
                        curRoom.addObject(new Printer());
                        break;

                    case OfficeObject.OFFICE_OBJECT_ROUTER:
                        curRoom.addObject(new Router());
                        break;

                    case OfficeObject.OFFICE_OBJECT_MONITOR:
                        curRoom.addObject(new Monitor());
                        break;
                    //TODO: add more types object
                }
                parentComponent.repaint();

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
