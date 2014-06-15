package ru.regulartech.GUI;

import ru.regulartech.graphical.Room;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 15.06.2014
 * TIME: 18:50
 */
public class RightClickMenu extends JPopupMenu{
    private final Room room;

    public RightClickMenu(Room curRoom) {
        super();
        this.room = curRoom;
        JMenuItem addObject = new JMenuItem("add object");
        addObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ObjectTypeSelectorWindow getObjectType = new ObjectTypeSelectorWindow();
                int type = getObjectType.getObjectType();
            }
        });
        add(addObject);
        setLocation(room.getX(), room.getY());
        setVisible(true);
    }
}
