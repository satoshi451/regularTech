package ru.regulartech.officeObjects;

import ru.regulartech.graphical.ImageManager;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 16.06.2014
 * TIME: 2:28
 */
public class Laptop extends ElectronicObject {
    public Laptop() {
        super();
        setObjectImage(ImageManager.getLaptopImgSmall());
    }

    @Override
    public Integer getType() {
        return OFFICE_OBJECT_LAPTOP;
    }

    public Laptop(Integer id, String name) {
        this();
        setId(id);
        setName(name);
    }

    @Override
    public void doDiagnostic() {

    }
}
