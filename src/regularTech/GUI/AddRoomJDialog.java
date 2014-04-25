package regularTech.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 25.04.2014
 * TIME: 20:25
 */
public class AddRoomJDialog extends JDialog {

    private JLabel label;
    private JTextField roomNameInput;
    private int width;
    private int height;
    private static Dimension inputDimension;

    static{
        inputDimension = new Dimension(200, 25);
    }
    public AddRoomJDialog() {
        super();
        this.setLayout(new FlowLayout());
        this.width = 400;
        this.height = 80;
        this.label = new JLabel("Введите название помещения:");

        this.roomNameInput = new JTextField();
        this.roomNameInput.setPreferredSize(AddRoomJDialog.inputDimension);

        setBounds(400,400, width, height);

        add(label);
        add(roomNameInput);

        setModal(true);
        setResizable(false);
        setTitle("Создание помещения");
    }
}
