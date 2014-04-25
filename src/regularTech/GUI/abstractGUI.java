package regularTech.GUI;

import regularTech.GraphPane;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 14:45
 */
public abstract class abstractGUI extends JFrame {
    protected abstractMenuBar menubar;
    protected GraphPane graphPane;

    public abstractGUI(String capture) throws HeadlessException {
        super(capture);
        this.setLayout(new BorderLayout());

        this.graphPane = new GraphPane();

        add(graphPane, BorderLayout.CENTER);

        // TODO: не работает windowsAdapter
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent windowEvent) {
                System.out.println("Close GUI");
            }
        });
        setBounds(150, 100, 800, 600);
        setVisible(true);
    }

}
