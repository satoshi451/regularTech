package ru.regulartech.officeObjects;

import ru.regulartech.graphical.ImageManager;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 16.06.2014
 * TIME: 2:28
 */
public class Laptop extends ElectronicObject {
    public Laptop() {
        setObjectImage(ImageManager.getLaptopImgSmall());
    }

    @Override
    public void doDiagnostic() {

    }
}
