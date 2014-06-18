package ru.regulartech.GUI;

import ru.regulartech.officeObjects.OfficeObject;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.06.2014
 * TIME: 8:03
 */
public class GetOfficeObjectNameDialog extends JDialog{
    private final OfficeObject officeObject;

    public GetOfficeObjectNameDialog(OfficeObject officeObject) {
        this.officeObject = officeObject;
        setVisible(true);
    }

    @Override
    protected void dialogInit() {
        super.dialogInit();
        setLayout(new FlowLayout());

        final JTextField inputName = new JTextField();
        JButton btn = new JButton("Подтвердить");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                officeObject.setName(inputName.getText());
                setVisible(false);
            }
        };
        inputName.addActionListener(listener);
        inputName.setPreferredSize(new Dimension(100, 30));
        btn.addActionListener(listener);

        add(inputName);
        add(btn);

        setBounds(500, 500, 300, 70);
        setModal(true);
        setResizable(false);
        setTitle("Введите имя для объекта");
    }
}
