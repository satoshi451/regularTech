package ru.regulartech.GUI;

import ru.regulartech.SQL.OfficeObjectModel;
import ru.regulartech.graphical.ImageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 15.06.2014
 * TIME: 19:29
 */
public class ObjectTypeSelectorWindow extends JDialog{
    private static BufferedImage computer = ImageManager.getComputerImgSmall();
    private static BufferedImage printer = ImageManager.getPrinterImgSmall();
    private static BufferedImage laptop = ImageManager.getLaptopImgSmall();

    private int selectedTtype;

    private PipedWriter pipedWriter;

    public ObjectTypeSelectorWindow(PipedReader pipedReader) {
        pipedWriter = new PipedWriter();
        try {
            pipedReader.connect(pipedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTitle("Выберите тип добавляемого объекта");
        setLayout(new FlowLayout());
        setBounds(500, 500, 400, 100);
        setModal(true);
        setVisible(true);

    }

    @Override
    protected void dialogInit() {
        super.dialogInit();

        JButton computerButton = new JButton(new ImageIcon(computer));
        computerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                writeType(OfficeObjectModel.OFFICE_OBJECT_PC);

            }
        });
        JButton laptopButton = new JButton(new ImageIcon(laptop));
        laptopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                writeType(OfficeObjectModel.OFFICE_OBJECT_LAPTOP);
            }
        });
        JButton printerButton = new JButton(new ImageIcon(printer));
        printerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                writeType(OfficeObjectModel.OFFICE_OBJECT_PRINTER);
            }
        });
        add(computerButton);
        add(laptopButton);
        add(printerButton);
    }

    private void writeType(int officeObjectType) {
        try {
            pipedWriter.write(officeObjectType);
            pipedWriter.flush();
            //pipedWriter.close();
            setVisible(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getObjectType(){
        return selectedTtype;
    }
}
