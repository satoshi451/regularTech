package regularTech.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 30.04.2014
 * TIME: 16:10
 */
public class BuchalteryWindow extends JFrame{
    private int height;
    private int width;
    private JBuchTable table;

    public BuchalteryWindow(String caption){
        super(caption);

        this.width = 800;
        this.height = 500;
        this.setLayout(new FlowLayout());

        table = new JBuchTable();

        add(new JScrollPane(table));
        setBounds(100, 150, width, height);
        setAlwaysOnTop(true);
    }
}
