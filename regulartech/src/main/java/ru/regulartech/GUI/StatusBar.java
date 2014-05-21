package regularTech.GUI;

import regularTech.status;

import javax.swing.*;
import java.awt.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 0:28
 */
public class StatusBar extends JPanel{

    private regularTech.status status;
    private String text;
    private Color textColor;

    public StatusBar() {
        super();
        setStatus(regularTech.status.OK_STATUS);
        System.out.println("[STATUSBAR: width: " + getWidth() + " | height: " + getHeight() + "]");
    }

    public void setStatus(status statusID) {
        this.status = statusID;
        switch(this.status){
            case OK_STATUS:                     text =  "Please, enter login und password";
                                                textColor = new Color(52, 201, 36);
                                                break;
            case ACCESS_DENIED:                 text =  "ACCESS TO DATABASE DENIED";
                                                textColor = new Color(201, 36, 40);
                                                break;
            case SQL_ERROR:                     text = "SQL ERROR";
                                                textColor = new Color(153, 0, 102);
                                                break;
            case EMPTY_LOGIN_OR_PASSWORD:       text = "EMPTY LOGIN OR PASSWORD IS NOT ACCEPT";
                                                textColor = new Color(216, 169, 3);
                                                break;

        }
        repaint();
    }

    public status getStatus() {
        return status;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(this.textColor);
        g.drawString(text, getWidth()/2 - 70, getHeight()/2);
    }

    public void setPreferenceHeight(int height) {
        if (height == 0)
            return;
        setSize(200, height);
        setPreferredSize(new Dimension(getWidth(), height));
    }
}
