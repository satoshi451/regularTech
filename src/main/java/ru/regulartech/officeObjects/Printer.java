package ru.regulartech.officeObjects;

import ru.regulartech.graphical.ImageManager;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 16.06.2014
 * TIME: 2:39
 */
public class Printer extends ElectronicObject {

    public Printer() {
        setObjectImage(ImageManager.getPrinterImgSmall());
    }

    @Override
    public void doDiagnostic() {

    }

}
