package regularTech.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 05.05.2014
 * TIME: 11:51
 */
public class ReportActionWindow extends JFrame{

    private ActionArea actionArea;
    private JPanel herarhArea;

    public ReportActionWindow(String capture){
        super(capture);

        LayoutManager layout = new BorderLayout();
        setLayout(layout);

        herarhArea = new HerarhArea();
        actionArea = new ActionArea();

        add(herarhArea, BorderLayout.WEST);
        add(actionArea, BorderLayout.EAST);

        setBounds(100, 100, 600, 400);
        setResizable(false);
    }
}
