package ru.regulartech.officeObjects;

import ru.regulartech.graphical.ImageManager;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.06.2014
 * TIME: 5:26
 */
public class Table extends OfficeObject {
    public Table() {
        super();
        setObjectImage(ImageManager.getTableImg());
    }

    @Override
    public Integer getType() {
        return OFFICE_OBJECT_FURNITURE;
    }

    public Table(Integer id, String name) {
        super(id, name);
        setObjectImage(ImageManager.getTableImg());
    }
}
