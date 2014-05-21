package ru.regulartech.GUI;

import ru.regulartech.graphical.ImageManager;
import ru.regulartech.graphical.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 15:02
 */
public class GraphPane extends JPanel{
    private static Image computer;
    private static Image printer;
    private static Image monitor;
    private static Image router;
    private static Image laptop;
    private static Image common;

    private static final String withoutRoom;

    private final AddRoomJDialog addRoomJDialog;

    private List<Room> roomList;

    static {
        withoutRoom = "Нет помещений. Чтобы добавить помещение, щелкните правой кнопкой.";

        computer = ImageManager.getComputerImg();
        printer = ImageManager.getPrinterImg();
        monitor = ImageManager.getMonitorImg();
        router = ImageManager.getRouterImg();
        laptop = ImageManager.getLaptopImg();
        common = ImageManager.getCommonImg();

    }
    public GraphPane() {
        super();

        this.addRoomJDialog = new AddRoomJDialog();
        roomList = new LinkedList<Room>();

        final ActionListener addRoomListener = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addRoomJDialog.setVisible(false);

                roomList.add(new Room(addRoomJDialog.getClickedX(), addRoomJDialog.getClickedY(), addRoomJDialog.roomNameInput.getText()));
                addRoomJDialog.roomNameInput.setText("");
                repaint();
            }
        };
        addRoomJDialog.addButton.addActionListener(addRoomListener);
        addRoomJDialog.roomNameInput.addActionListener(addRoomListener);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);

                if (mouseEvent.getButton() == 3) {
                    addRoomJDialog.setClickedX(mouseEvent.getX());
                    addRoomJDialog.setClickedY(mouseEvent.getY());
                    addRoomJDialog.setVisible(true);
                }
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent mouseEvent) {
                if ( SwingUtilities.isLeftMouseButton(mouseEvent)) {
                        System.out.println("[left] X: " + mouseEvent.getX() + " | Y: " + mouseEvent.getY());
                }
                int clickedX = mouseEvent.getX();
                int clickedY = mouseEvent.getY();
                Room  room = getFollowRoom(clickedX, clickedY);
                if (room != null){
                    System.out.println("Dragged " + room.getName());
                    room.setX(clickedX);
                    room.setY(clickedY);
                    repaint();
                }
            }
        });
    }

    private Room getFollowRoom(int x, int y) {
        for(Room curRoom : roomList){
            if(x > curRoom.getX() && x < Room.getImageWidth()
                    && y > curRoom.getY() && y < Room.getImageHeight()){
                return curRoom;
            }
        }
        return null;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if (roomList.size() == 0){
            g.drawString(withoutRoom,getWidth()/2 - 170, getHeight()/2);
            return;
        }

        // TODO: добавить возможность перетаскивания объектов. Помещения должны перетаскиваться вместе со своими объектами
        for (Room curRoom : roomList){
            drawRoom(g, curRoom);

        }
    }

    private void drawRoom(Graphics g, Room room) {
        g.drawImage(Room.getPict(), room.getX(), room.getY(), null);
        g.drawString(room.getName(), room.getX(), room.getY() - 15);
        room.drawObjects();
    }
}
//[MOUSE_CLICKED,(499,136),absolute(657,289),button=3,modifiers=Meta+Button3,extModifiers=Meta,clickCount=1]