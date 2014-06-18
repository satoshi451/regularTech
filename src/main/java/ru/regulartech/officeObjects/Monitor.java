package ru.regulartech.officeObjects;

import ru.regulartech.graphical.ImageManager;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.06.2014
 * TIME: 4:41
 */
public class Monitor extends OfficeObject {
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
}
