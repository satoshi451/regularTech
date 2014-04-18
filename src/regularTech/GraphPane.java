package regularTech;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 06.04.2014
 * TIME: 15:02
 */
public class GraphPane extends JPanel{
    private static Image computer;
    private static Image printer;
    private static Image monitor;
    private static Image router;

    private List objects;
    //TODO: change path to classparth
    static{
        try {
            computer = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\computer.png"));
            printer = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\printer.png"));
            monitor = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\monitor.png"));
            router = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\router.png"));
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public GraphPane() {
        super();

    }

    @Override
    public void paintComponent(Graphics g){

    }
}
