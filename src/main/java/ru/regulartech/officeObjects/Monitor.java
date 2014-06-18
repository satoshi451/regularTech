package ru.regulartech.officeObjects;

import ru.regulartech.graphical.ImageManager;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.06.2014
 * TIME: 4:41
 */
public class Monitor extends ElectronicObject {
    public Monitor() {
        setObjectImage(ImageManager.getMonitorImg());
    }

    @Override
    public Integer getType() {
        return OFFICE_OBJECT_MONITOR;
    }

    public Monitor(Integer id, String name) {
        setObjectImage(ImageManager.getMonitorImg());
        setId(id);
        setName(name);
    }

    @Override
    public void setBroken() {
        super.setBroken();
        setObjectImage(ImageManager.getBrokenMonitorImgSmall());
    }

    @Override
    public void setFixed() {
        super.setFixed();
        setObjectImage(ImageManager.getMonitorImgSmall());
    }

    @Override
    public void doDiagnostic() {

    }
}
