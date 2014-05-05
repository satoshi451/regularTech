package regularTech;

import regularTech.GUI.AddRoomJDialog;
import regularTech.graphical.Room;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
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

    private static final String withoutRoom;

    private final AddRoomJDialog addRoomJDialog;

    private List<Room> roomList;
    //TODO: change path to classparth
    static{
        withoutRoom = new String("Нет помещений. Чтобы добавить помещение, щелкните правой кнопкой.");
        try {
            computer = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\computer.png"));
            printer = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\printer.png"));
            monitor = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\monitor.png"));
            router = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\router.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public GraphPane() {
        super();

        this.addRoomJDialog = new AddRoomJDialog();
        roomList = new LinkedList<Room>();

        ActionListener addRoomListener = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                addRoomJDialog.setVisible(false);
                roomList.add(new Room(addRoomJDialog.roomNameInput.getText()));
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
                System.out.println("mouseClicked");
                System.out.println(mouseEvent);

                if (mouseEvent.getButton() == 3) {
                    addRoomJDialog.setVisible(true);
                }
            }
        });
    }

    @Override
    public void paintComponent(Graphics g){
        if (roomList.size() == 0){
            g.drawString(withoutRoom,getWidth()/2 - 170, getHeight()/2);
            return;
        }
        for (Room curRoom : roomList){
            g.drawImage(Room.pict, curRoom.getX(), curRoom.getY(), null);
            curRoom.drawObjects();
        }

    }
}
//[MOUSE_CLICKED,(499,136),absolute(657,289),button=3,modifiers=Meta+Button3,extModifiers=Meta,clickCount=1]