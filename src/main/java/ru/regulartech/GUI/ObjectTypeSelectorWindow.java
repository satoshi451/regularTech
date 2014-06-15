package ru.regulartech.GUI;

import ru.regulartech.graphical.ImageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 15.06.2014
 * TIME: 19:29
 */
public class ObjectTypeSelectorWindow extends JDialog{
    private static BufferedImage computer = ImageManager.getComputerImg();
    private static BufferedImage printer = ImageManager.getPrinterImg();
    private static BufferedImage laptop = ImageManager.getLaptopImg();

    public ObjectTypeSelectorWindow() {
        setLayout(new FlowLayout());
        setBounds(500, 500, 500, 500);
        setModal(true);
        setVisible(true);
    }

    @Override
    protected void dialogInit() {
        super.dialogInit();

        JButton computerButton = new JButton(new ImageIcon(computer));
        JButton laptopButton = new JButton(new ImageIcon(laptop));
        JButton printerButton = new JButton(new ImageIcon(printer));

        add(computerButton);
        add(laptopButton);
        add(printerButton);

    }

    public int getObjectType(){

        return 0;
    }
}
