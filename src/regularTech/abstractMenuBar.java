package regularTech;

import javax.swing.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 14:57
 */
public class abstractMenuBar extends JMenuBar {
    public abstractMenuBar() {
        super();
        JMenu fileMenu = new JMenu("Файл");

        add(fileMenu);
    }
}
