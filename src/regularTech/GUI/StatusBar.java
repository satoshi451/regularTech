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
    private JLabel text;

    public StatusBar() {
        super();
        setStatus(regularTech.status.OK_STATUS);
        //add(text);
    }

    public void setStatus(status statusID) {
        this.status = statusID;

        switch(this.status){
            case OK_STATUS: text =      new JLabel("<HTML><BODY><a style=\"color: GREEN;\">Please, enter login und password :)</a></BODY></HTML>");
                                        break;
            case ACCESS_DENIED: text =  new JLabel("<HTML><BODY><a style=\"color: RED;\">ACCESS TO DATABASE DENIED :(</a></BODY></HTML>");
                                        break;

        }
        add(text);
    }

    public status getStatus() {
        return status;
    }
/*
    @Override
    public void paintComponent(Graphics g){
        g.drawString(text, 0, 0);
    }
*/
}
