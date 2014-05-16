package regularTech.GUI;

import java.awt.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 15:10
 */
public class AdminGUI extends AbstractGUI {

    public AdminGUI(String capture) {
        super(capture);
        this.menubar = new AdminMenuBar();

        add(menubar, BorderLayout.NORTH);
    }
}
