package regularTech.officeObjects;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.04.2014
 * TIME: 22:16
 */
public class PC extends ElectronicObject implements electronicFunctions {


    public PC() {
        super();

    }

    public PC(int x_cord, int y_cord) {
        this();
        setX(x_cord);
        setY(y_cord);

    }

    @Override
    public void doDiagnostic() {
    //TODO: add item to list of queue diagnostic, make record in database, create  table 'diagnostic'

    }

}
