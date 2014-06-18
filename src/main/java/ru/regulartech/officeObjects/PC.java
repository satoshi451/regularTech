package ru.regulartech.officeObjects;

import ru.regulartech.graphical.ImageManager;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.04.2014
 * TIME: 22:16
 */
public class PC extends ElectronicObject implements electronicFunctions {

    public PC() {
        super();
        setX(0);
        setY(0);
        setObjectImage(ImageManager.getComputerImgSmall());
    }

    public PC(int x_cord, int y_cord) {
        this();
        setX(x_cord);
        setY(y_cord);
    }

    public PC(Integer id, String name) {
        super(id, name);
        setObjectImage(ImageManager.getComputerImgSmall());

    }

    @Override
    public Integer getType() {
        return OFFICE_OBJECT_PC;
    }

    @Override
    public void doDiagnostic() {
    //TODO: add item to list of queue diagnostic, make record in database, create  table 'diagnostic'

    }

}
