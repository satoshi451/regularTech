package regularTech.graphical;

import regularTech.officeObjects.OfficeObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.04.2014
 * TIME: 22:21
 */
public class Room extends GraphObject {
    public static Image pict;
    private String name;

    private List<OfficeObject> objects;
    static{
        try{
            pict = ImageIO.read(Room.class.getResource("/regularTech/img/room.png"));
        }catch (IOException e){
         //TODO: change printStackTrace to logger
            e.printStackTrace();
        }
    }

    public Room() {
        objects = new LinkedList<OfficeObject>();
    }

    public Room(String name) {
        this();
        this.setName(name);
        this.x = 100;
        this.y = 100;
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
}
