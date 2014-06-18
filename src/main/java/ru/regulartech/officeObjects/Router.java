package ru.regulartech.officeObjects;

import ru.regulartech.graphical.ImageManager;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.06.2014
 * TIME: 4:43
 */
public class Router extends OfficeObject {
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
}
