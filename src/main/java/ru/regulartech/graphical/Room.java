package ru.regulartech.graphical;


import ru.regulartech.GUI.RightClickMenu;
import ru.regulartech.SQL.ReportDAO;
import ru.regulartech.officeObjects.OfficeObject;

import java.awt.*;
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

    private RightClickMenu rightClickMenu;
    private Component parentComponent;

    public Room() {
        objects = new LinkedList<OfficeObject>();
        rightClickMenu = new RightClickMenu(this);
    }

    @Deprecated
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
        officeObject.setOfficeObjectTypeId(officeObject.getType());
        officeObject.setOfficeObjectStatusId(OfficeObject.ALL_IS_OK);
        officeObject.getNameDialog();
        officeObject.setId(ReportDAO.getUniqueId());
        ReportDAO.createOfficeObject(officeObject);
        this.objects.add(officeObject);
    }

    public void drawObjects(Graphics g) {
        if(objects.size() == 0)
            return;
        int cntX = 0;
        int cntY = 0;
        int maxCntX = getImageWidth()/(110 + 20);
        int maxCntY = getImageHeight()/(110 + 20);

        for (OfficeObject curObject : objects) {
            if(cntX >= maxCntX){
                cntX = 0;
                cntY++;
                System.out.println("New line of objects");
            }
            if(cntY >= maxCntY){
                System.out.println("End od free space in room");
                //JOptionPane.showMessageDialog(null, "[WARNING] Not all object was draw");
                return;
            }

            int h_gap = 20;
            int v_gap = 10;
            int child_y = getY() + cntY*(curObject.getObjectImage().getHeight(null) + v_gap) + 20;
            int child_x = getX() + cntX++*(curObject.getObjectImage().getWidth(null) + h_gap) + 20;

            curObject.setX(child_x);
            curObject.setY(child_y);

            if(child_x >= getImageWidth()) {
                cntY++;
                cntX = 0;
            }
            drawObject(curObject, g, child_x, child_y);
        }
    }

    private void drawObject(OfficeObject curObject, Graphics g, int x, int y) {
        g.drawImage(curObject.getObjectImage(), x, y, null);
        g.drawString(curObject.getName(), x, y + curObject.getObjectImage().getHeight(null) + 10);
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

    public OfficeObject getOfficeObject(int x_cord, int y_cord){
        if(objects.size() == 0)
            return null;

        for (OfficeObject curObject : objects){
            if(x_cord > curObject.getX() && x_cord < curObject.getX() + curObject.getObjectImage().getWidth(null)
                    && y_cord > curObject.getY() && y_cord  < curObject.getY() + curObject.getObjectImage().getHeight(null)){
                System.out.println("found office object: " + curObject.getClass().getSimpleName());
                return curObject;
            }
        }
        return null;
    }

    public void hideRightClickMenu() {
        rightClickMenu.setVisible(false);
    }

    public void showRightClickMenu(int x_coord, int y_coord) {
        rightClickMenu.setVisible(true);
        rightClickMenu.setLocation(x_coord, y_coord);
    }

    public void setParentComponent(Component parentComponent) {
        this.parentComponent = parentComponent;
        rightClickMenu.setComponent(parentComponent);
    }

    public void hideOfficeObjectMenu() {
        for (OfficeObject curObject : objects){
            curObject.hideObjectRightClickMenu();
        }
    }
}
