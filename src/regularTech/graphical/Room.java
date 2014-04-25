package regularTech.graphical;

import regularTech.officeObjects.officeObject;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 18.04.2014
 * TIME: 22:21
 */
public class Room extends  graphObject{
    private static Image pict;
    private List<officeObject> objects;
    static{
        try{
            //TODO:change to classpath
            pict = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\bin\\regularTech\\img\\room.png"));
        }catch (IOException e){
         //TODO: change printStackTrace to logger
            e.printStackTrace();
        }
    }

    public Room() {
        objects = new LinkedList<officeObject>();
    }
    public void addObject(officeObject officeObject){
        this.objects.add(officeObject);
    }
}