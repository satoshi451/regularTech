package ru.regulartech.GUI;

import java.awt.*;
import java.awt.event.WindowAdapter;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 16:06
 */
public class RegularGUI extends AbstractGUI {

    public RegularGUI(String capture, WindowAdapter windowAdapter) {
        super(capture, windowAdapter);
        menubar = new RegularMenuBar();
        add(menubar, BorderLayout.NORTH);
    }
}
