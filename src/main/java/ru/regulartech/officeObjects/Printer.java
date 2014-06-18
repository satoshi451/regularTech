package ru.regulartech.officeObjects;

import ru.regulartech.graphical.ImageManager;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 16.06.2014
 * TIME: 2:39
 */
public class Printer extends ElectronicObject {

    public Printer() {
        super();
        setObjectImage(ImageManager.getPrinterImgSmall());
    }

    @Override
    public Integer getType() {
        return OFFICE_OBJECT_PRINTER;
    }

    public Printer(Integer id, String name) {
        super(id, name);
        setObjectImage(ImageManager.getPrinterImgSmall());

    }

    @Override
    public void doDiagnostic() {

    }

    @Override
    public void setBroken() {
        super.setBroken();
        setObjectImage(ImageManager.getBrokenPrinterImgSmall());
    }

    @Override
    public void setFixed() {
        super.setFixed();
        setObjectImage(ImageManager.getPrinterImgSmall());
    }
}
