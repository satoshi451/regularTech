package ru.regulartech.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 30.04.2014
 * TIME: 16:10
 */
public class BuchalteryWindow extends JFrame implements ActionListener {
    private int height;
    private int width;
    private static final ImageIcon reloadIcon = new ImageIcon(BuchalteryWindow.class.getProtectionDomain().getCodeSource().getLocation().getPath() + "img/refresh_icon.png");
    private JBuchTable table;
    private JButton refreshBtn;

    public BuchalteryWindow(String caption){
        super(caption);

        width = 800;
        height = 500;
        setLayout(new FlowLayout());

        table = new JBuchTable();
        refreshBtn = new JButton(reloadIcon);

        refreshBtn.addActionListener(this);
        add(new JScrollPane(table));
        add(refreshBtn);

        setBounds(100, 150, width, height);
        setAlwaysOnTop(true);
    }

    public void updateTable() {
        table = new JBuchTable();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        updateTable();
    }
}
