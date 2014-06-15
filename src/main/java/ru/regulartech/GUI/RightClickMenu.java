package ru.regulartech.GUI;

import ru.regulartech.graphical.Room;

import javax.swing.*;
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
    private final Room room;

    public RightClickMenu(Room curRoom) {
        super();
        this.room = curRoom;
        JMenuItem addObject = new JMenuItem("add object");
        addObject.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PipedReader pipedReader = new PipedReader();
                ObjectTypeSelectorWindow getObjectType = new ObjectTypeSelectorWindow(pipedReader);
                //getObjectType.setVisible(false);
                int type = 0;
                try {
                    type = pipedReader.read();
                    pipedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(type);
            }
        });
        add(addObject);
        setLocation(room.getX(), room.getY());
        setVisible(true);
    }
}
