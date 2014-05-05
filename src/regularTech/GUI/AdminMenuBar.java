package regularTech.GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 15:16
 */
public class AdminMenuBar extends abstractMenuBar {
    private BuchalteryWindow window;
    public AdminMenuBar() {
        super();
        JMenu buchMenu = new JMenu("Бухгалтерия");
        JMenuItem showReport = new JMenuItem("Показать отчетность");

        window = new BuchalteryWindow("Отчетность");

        showReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                 window.setVisible(true);
            }
        });
        buchMenu.add(showReport);
        add(buchMenu);
    }
}
