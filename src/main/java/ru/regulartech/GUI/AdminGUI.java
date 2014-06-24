package ru.regulartech.GUI;

import java.awt.*;
import java.awt.event.WindowAdapter;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 15:10
 */
public class AdminGUI extends AbstractGUI {

    private QueuePanel queuePanel;

    public AdminGUI(String capture, WindowAdapter windowAdapter) {
        super(capture, windowAdapter);
        menubar = new AdminMenuBar();
        queuePanel = new QueuePanel();

        add(menubar, BorderLayout.NORTH);
    }
}
