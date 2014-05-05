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
    public AdminMenuBar() {
        super();
        JMenu buchMenu = new JMenu("Бухгалтерия");
        JMenuItem showReport = new JMenuItem("Показать отчетность");

        showReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                 new BuchalteryWindow("Отчетность");
            }
        });
        buchMenu.add(showReport);
        add(buchMenu);
    }
}
