package regularTech.GUI;

import regularTech.SQL.OfficeObjectModel;
import regularTech.SQL.reportDAO;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Create by Votrin Andrey (votrin.andrey@caesber.ru).
 * DATE: 05.05.2014
 * TIME: 14:10
 */
public class ActionArea extends JPanel{
    private static BufferedImage printerImg;
    private static BufferedImage tableImg;
    private static BufferedImage computerImg;
    private static BufferedImage commonImg;
    private static BufferedImage monitorImg;
    private static BufferedImage laptopImg;
    private static BufferedImage routerImg;

    private JLabel imageLabel;
    private Integer objectId;
    private Object[] curentObject;
    private BufferedImage pict;
    private JLabel capture;

    public ActionArea() {
        super();
        // TODO: change full path to relative
        try {
            this.computerImg = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\computer.png"));
            this.tableImg = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\table.png"));
            this.commonImg = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\common.png"));
            this.monitorImg = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\monitor.png"));
            this.laptopImg = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\laptop.png"));
            this.routerImg = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\router.png"));
            this.printerImg = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\printer.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        capture = new JLabel();
        imageLabel = new JLabel();
        add(capture);
        add(imageLabel);


    }

    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
        initPanel();
    }

    private void initPanel() {
        /**
         * TODO: get type of object
         * paint picture of object
         * add buttons: 'add costs'
         * add drop down list: buy, fix, sell
         */
        this.curentObject = reportDAO.getOfficeObject(this.objectId);
        String curName = String.valueOf(curentObject[0]);
        capture.setText(curName);
        Integer curTypeId = (Integer)curentObject[1];

        switch (curTypeId) {
            case OfficeObjectModel.OFFICE_OBJECT_PC:
                this.pict = ActionArea.computerImg;
                break;
            case OfficeObjectModel.OFFICE_OBJECT_FURNITURE:
                this.pict = ActionArea.tableImg;
                break;
            case OfficeObjectModel.OFFICE_OBJECT_COMMON:
                this.pict = ActionArea.commonImg;
                break;
            case OfficeObjectModel.OFFICE_OBJECT_MONITOR:
                this.pict = ActionArea.monitorImg;
                break;
            case OfficeObjectModel.OFFICE_OBJECT_LAPTOP:
                this.pict = ActionArea.laptopImg;
                break;
            case OfficeObjectModel.OFFICE_OBJECT_ROUTER:
                this.pict = ActionArea.routerImg;
                break;
            case OfficeObjectModel.OFFICE_OBJECT_PRINTER:
                this.pict = ActionArea.printerImg;
                break;
        }
        imageLabel.setIcon(new ImageIcon(pict)); //= new JLabel(new ImageIcon(pict));
        repaint();
    }

}
