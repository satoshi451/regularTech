package regularTech;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 14:45
 */
public abstract class abstractGUI extends JFrame {
    private abstractMenuBar menubar;
    private GraphPane graphPane;

    protected abstractGUI(String capture) throws HeadlessException {
        super(capture);
        this.setLayout(new BorderLayout());

        this.graphPane = new GraphPane();

        add(graphPane, BorderLayout.CENTER);
    }

}
