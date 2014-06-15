package ru.regulartech.graphical;


import ru.regulartech.officeObjects.OfficeObject;

import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.List;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.04.2014
 * TIME: 22:21
 */
public class Room extends GraphObject {
    private static BufferedImage pict;
    private String name;

    private List<OfficeObject> objects;
    static {
        pict = ImageManager.getRoomImage();
    }

    public Room() {
        objects = new LinkedList<OfficeObject>();
    }

    public Room(String name) {
        this();
        setName(name);
        setX(100);
        setY(100);
    }

    public Room(int clickedX, int clickedY, String text) {
        this();
        setName(text);
        setX(clickedX);
        setY(clickedY);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void addObject(OfficeObject officeObject){
        this.objects.add(officeObject);
    }

    public void drawObjects() {
    }

    public static BufferedImage getPict() {
        return pict;
    }

    public static int getImageWidth() {
        return pict.getTileWidth();
    }
    public static int getImageHeight(){
        return  pict.getTileHeight();
    }

    public void moveTo(int newX, int newY) {
        setX(getX() + newX);
        setY(getY() + newY);
    }
}
