package regularTech;

import javax.swing.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 15:16
 */
public class AdminMenuBar extends abstractMenuBar {
    public AdminMenuBar() {
        super();
        JMenu buchMenu = new JMenu("Бухгалтерия");

        add(buchMenu);
    }
}
