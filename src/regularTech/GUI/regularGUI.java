package regularTech.GUI;

import java.awt.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 16:06
 */
public class RegularGUI extends AbstractGUI {

    public RegularGUI(String capture) {
        super(capture);
        menubar = new RegularMenuBar();
        add(menubar, BorderLayout.NORTH);
    }
}
