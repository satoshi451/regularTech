package regularTech.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 14:45
 */
public abstract class AbstractGUI extends JFrame {
    protected AbstractMenuBar menubar;
    protected GraphPane graphPane;

    public AbstractGUI(String capture,
                       final WindowAdapter windowAdapter)
            throws HeadlessException {
        super(capture);
        this.setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.graphPane = new GraphPane();

        add(graphPane, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                System.out.println("Close GUI");
                windowAdapter.windowClosing(windowEvent);
            }

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
                System.out.println("Closing abstract GUI... delegate action to Application...");
                windowAdapter.windowClosing(windowEvent);
            }
        });
        setBounds(150, 100, 800, 600);
        setVisible(true);
    }

}
