package ru.regulartech.GUI;

import ru.regulartech.graphical.ImageManager;
import ru.regulartech.officeObjects.OfficeObject;

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
    private static BufferedImage router = ImageManager.getRouterImgSmall();
    private static BufferedImage monitor = ImageManager.getMonitorImgSmall();

    private PipedWriter pipedWriter;
    private int objectCount = 0;

    public ObjectTypeSelectorWindow(PipedReader pipedReader) {
        pipedWriter = new PipedWriter();
        try {
            pipedReader.connect(pipedWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setTitle("Выберите тип добавляемого объекта");
        setLayout(new FlowLayout());
        setBounds(500, 500, getCalculatedWidth(), getCalculatedHeight());
        setModal(true);
        setVisible(true);
        setResizable(false);
    }

    private int getCalculatedHeight() {
        return 150;
    }

    private int getCalculatedWidth() {
        return 400;
    }

    @Override
    protected void dialogInit() {
        super.dialogInit();

        addSelectButton(computer, OfficeObject.OFFICE_OBJECT_PC);
        addSelectButton(printer, OfficeObject.OFFICE_OBJECT_PRINTER);
        addSelectButton(laptop, OfficeObject.OFFICE_OBJECT_LAPTOP);
        addSelectButton(monitor, OfficeObject.OFFICE_OBJECT_MONITOR);
        addSelectButton(router, OfficeObject.OFFICE_OBJECT_ROUTER);
        setSize();
    }

    private void setSize() {
        int width = objectCount*(computer.getWidth(null) + 10);
        int height = computer.getHeight(null) + 20;

        setBounds(300, 300, width, height);
    }

    private void addSelectButton(BufferedImage computer, final int OFFICE_OBJECT_TYPE_CONST) {
        JButton newSelectionButton = new JButton(new ImageIcon(computer));
        newSelectionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                writeType(OFFICE_OBJECT_TYPE_CONST);
            }
        });
        add(newSelectionButton);
        incrementObjectCount();
    }

    private void incrementObjectCount() {
        objectCount++;
    }

    private void writeType(int officeObjectType) {
        try {
            pipedWriter.write(officeObjectType);
            pipedWriter.flush();
            setVisible(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
