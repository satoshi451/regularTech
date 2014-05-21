package regularTech.GUI;

import javax.swing.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 14:57
 */
public class AbstractMenuBar extends JMenuBar {
    public AbstractMenuBar() {
        JMenu fileMenu = new JMenu("Файл");
        add(fileMenu);
    }
}
