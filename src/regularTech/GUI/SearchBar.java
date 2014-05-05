package regularTech.GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 05.05.2014
 * TIME: 14:13
 */
public class SearchBar extends JPanel{
    private static ImageIcon searchIcon;
    static {
         searchIcon = new ImageIcon ("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\scape_glass.png");
    }

    private JTextField inputSearchText;
    private OfficeObjectList officeObjectList;

    private JButton searchButton;

    public SearchBar(OfficeObjectList officeObjectList) {
        super();
        this.officeObjectList = officeObjectList;

        setLayout(new BorderLayout());
        Dimension inputTextDimension = new Dimension(220, 40);
        Dimension searchButtonDimension = new Dimension(40, 40);

        searchButton = new JButton(searchIcon);
        inputSearchText = new JTextField();

        inputSearchText.setPreferredSize(inputTextDimension);
        searchButton.setPreferredSize(searchButtonDimension);

        add(searchButton, BorderLayout.EAST);
        add(inputSearchText, BorderLayout.WEST);


    }
}
