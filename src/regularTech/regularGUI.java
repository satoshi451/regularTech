package regularTech;

import java.awt.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 16:06
 */
public class regularGUI extends abstractGUI {

    public regularGUI(String capture) {
        super(capture);

        menubar = new regularMenuBar();

        add(menubar, BorderLayout.NORTH);
    }
}
