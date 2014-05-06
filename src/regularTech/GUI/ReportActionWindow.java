package regularTech.GUI;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 05.05.2014
 * TIME: 11:51
 */
public class ReportActionWindow extends JFrame{

    private ActionArea actionArea;
    private HerarhArea herarhArea;

    public ReportActionWindow(String capture){
        super(capture);

        LayoutManager layout = new BorderLayout();
        setLayout(layout);

        herarhArea = new HerarhArea();
        actionArea = new ActionArea();

        ListSelectionModel listSelectionModel = herarhArea.getSelectionModel();
        listSelectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent listSelectionEvent) {
                Integer curElemId = herarhArea.getCurElemId();
                actionArea.setObjectId(curElemId);
            }
        });

        add(herarhArea, BorderLayout.WEST);
        add(actionArea, BorderLayout.EAST);

        setBounds(100, 100, 600, 400);
        setResizable(false);
    }
}
