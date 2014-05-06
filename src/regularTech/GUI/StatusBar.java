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
    }

    public void setStatus(status statusID) {
        this.status = statusID;
        switch(this.status){
            case OK_STATUS: text =      "Please, enter login und password :)";
                                        textColor = Color.GREEN;
                                        break;
            case ACCESS_DENIED: text =  "ACCESS TO DATABASE DENIED :(";
                                        textColor = Color.RED;
                                        break;
        }
        repaint();
    }

    public status getStatus() {
        return status;
    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(this.textColor);
        g.drawString(text, getWidth()/2 - 70, getHeight());
    }

}
