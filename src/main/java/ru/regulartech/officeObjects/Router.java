package ru.regulartech.officeObjects;

import ru.regulartech.graphical.ImageManager;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.06.2014
 * TIME: 4:43
 */
public class Router extends ElectronicObject {
    public Router() {
        setObjectImage(ImageManager.getRouterImgSmall());
    }

    @Override
    public Integer getType() {
        return OFFICE_OBJECT_ROUTER;
    }

    public Router(Integer id, String name) {
        super(id, name);
    }

    @Override
    public void setBroken() {
        super.setBroken();
        setObjectImage(ImageManager.getBrokeRouterImgSmall());
    }

    @Override
    public void setFixed() {
        super.setFixed();
        setObjectImage(ImageManager.getRouterImgSmall());
    }

    @Override
    public void doDiagnostic() {

    }
}
