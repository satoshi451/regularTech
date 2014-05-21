package ru.regulartech.GUI;

import ru.regulartech.graphical.ImageManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 05.05.2014
 * TIME: 14:13
 */
public class SearchBar extends JPanel implements ActionListener{
    private static ImageIcon searchIcon;
    static {
         searchIcon = ImageManager.getSearchIcon();
    }

    private JTextField inputSearchText;
    private OfficeObjectList officeObjectList;
    private KeyAdapter keyAdapter;
    private JButton searchButton;

    public SearchBar(OfficeObjectList officeObjectList) {
        super();
        this.officeObjectList = officeObjectList;

        this.keyAdapter = new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent keyEvent) {
                    getFilter();
            }
        };

        setLayout(new BorderLayout());
        Dimension inputTextDimension = new Dimension(220, 40);
        Dimension searchButtonDimension = new Dimension(40, 40);

        searchButton = new JButton(searchIcon);
        inputSearchText = new JTextField();
        inputSearchText.setToolTipText("Введите сюда фильтр");

        inputSearchText.setPreferredSize(inputTextDimension);
        searchButton.setPreferredSize(searchButtonDimension);

        inputSearchText.addActionListener(this);
        searchButton.addActionListener(this);
        inputSearchText.addKeyListener(keyAdapter);

        add(searchButton, BorderLayout.EAST);
        add(inputSearchText, BorderLayout.WEST);

    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        getFilter();
    }
    private void getFilter(){
        String filterText = inputSearchText.getText();
        this.officeObjectList.filterList(filterText);
    }
}
