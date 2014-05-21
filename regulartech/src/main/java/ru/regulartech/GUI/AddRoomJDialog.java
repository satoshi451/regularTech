package regularTech.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 25.04.2014
 * TIME: 20:25
 */
public class AddRoomJDialog extends JDialog {

    public JButton addButton;
    private String roomName;
    private JLabel label;
    public JTextField roomNameInput;
    private int width;
    private int height;
    private static Dimension inputDimension;

    static{
        inputDimension = new Dimension(200, 25);
    }

    private int clickedX;
    private int clickedY;

    public AddRoomJDialog() {
        super();
        setLayout(new FlowLayout());
        width = 400;
        height = 100;
        label = new JLabel("Введите название помещения:");
        addButton = new JButton("Добавить помещение");
        roomNameInput = new JTextField();
        roomNameInput.setPreferredSize(AddRoomJDialog.inputDimension);

        setBounds(400, 400, width, height);

        add(label);
        add(roomNameInput);
        add(addButton);

        setModal(true);
        setResizable(false);
        setTitle("Создание помещения");
    }

    public void setClickedX(int clickedX) {
        this.clickedX = clickedX;
    }
    public int getClickedX() {
        return clickedX;
    }

    public void setClickedY(int clickedY) {
        this.clickedY = clickedY;
    }
    public int getClickedY() {
        return clickedY;
    }
}
