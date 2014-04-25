package regularTech.officeObjects;

import regularTech.officeObjects.electronicFunctions;
import regularTech.officeObjects.electronicObject;

import java.awt.*;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.04.2014
 * TIME: 22:16
 */
public class PC extends electronicObject implements electronicFunctions {
    private Image pict;

    public PC(Image pict) {
        this.pict = pict;
    }

    public PC(Image pict, int x_cord, int y_cord) {
        this(pict);
        setX(x_cord);
        setY(y_cord);

    }

    @Override
    public void doDiagnostic() {
    //TODO: add item to list of queue diagnostic, make record in database, create  table 'diagnostic'

    }

}
