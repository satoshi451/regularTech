package regularTech.GUI;

import regularTech.SQL.OfficeObjectModel;
import regularTech.SQL.reportDAO;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
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

    // TODO: change full path to relative
    // JLabel lblImage = new JLabel(new ImageIcon(getClass().getResource("/image.png")));
    static {
        try {
            computerImg = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\computer.png"));
            tableImg = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\table.png"));
            commonImg = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\common.png"));
            monitorImg = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\monitor.png"));
            laptopImg = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\laptop.png"));
            routerImg = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\router.png"));
            printerImg = ImageIO.read(new File("C:\\Users\\wiseman\\CODE\\regularTech\\src\\regularTech\\img\\printer.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ActionArea() {
        super();
        LayoutManager lm = new GridBagLayout();
        setLayout(lm);
        pict = ActionArea.commonImg;
        GridBagConstraints c = new GridBagConstraints();

        capture = new JLabel("Выберите объект");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 0;
      //  c.gridwidth = 2;
      //  c.gridheight = 1;
        add(capture, c);

        imageLabel = new JLabel();
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 2;
        add(imageLabel, c);

        JTextArea description = new JTextArea("Описание объекта. Здесь должно быть красивое, душевное описание того, что это за объект");//"Описание объекта. Здесь должно быть красивое, душевное описание того, что это за объект. Возможно, Вы захотите добавить его характеристики и кому он приналежит.");
        description.setSize(new Dimension(200, 100));
        description.setLineWrap(true);
        description.setEnabled(false);
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        add(description, c);

        JButton minBtn = new JButton("Провсти операцию");
        c.gridx = 1;
        c.gridy = 3;
        add(minBtn, c);

        JComboBox operationType = new JComboBox();
        operationType.addItem("buy");
        operationType.addItem("sell");
        operationType.addItem("fix");
        c.gridx = 2;
        c.gridy = 3;
        add(operationType, c);

        JTextField inputCosts = new JTextField();
        inputCosts.setPreferredSize(new Dimension(50, 30));
        inputCosts.setToolTipText("Введите сумму операции");
        c.gridx = 3;
        c.gridy = 3;
        add(inputCosts, c);




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
