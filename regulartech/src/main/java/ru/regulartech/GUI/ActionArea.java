package regularTech.GUI;

import regularTech.SQL.OfficeObjectModel;
import regularTech.SQL.ReportDAO;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
    private OfficeObjectModel currentObject;
    private BufferedImage pict;
    private JLabel capture;

    // TODO: change full path to relative
    // JLabel lblImage = new JLabel(new ImageIcon(getClass().getResource("/image.png")));
    static {
        try {
            System.out.println(ActionArea.class.getResource("/regularTech/img/computer.png"));
            System.out.println(ActionArea.class.getResource(""));

            computerImg = ImageIO.read(ActionArea.class.getResource("/regularTech/img/computer.png"));
            tableImg    = ImageIO.read(ActionArea.class.getResource("/regularTech/img/table.png"));
            commonImg   = ImageIO.read(ActionArea.class.getResource("/regularTech/img/common.png"));
            monitorImg  = ImageIO.read(ActionArea.class.getResource("/regularTech/img/monitor.png"));
            laptopImg   = ImageIO.read(ActionArea.class.getResource("/regularTech/img/laptop.png"));
            routerImg   = ImageIO.read(ActionArea.class.getResource("/regularTech/img/router.png"));
            printerImg  = ImageIO.read(ActionArea.class.getResource("/regularTech/img/printer.png"));
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
        c.fill = GridBagConstraints.BOTH;
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
        // TODO: add description from DB
        JTextArea description = new JTextArea("Описание объекта. Здесь должно быть красивое, душевное описание того, что это за объект"); //"Описание объекта. Здесь должно быть красивое, душевное описание того, что это за объект. Возможно, Вы захотите добавить его характеристики и кому он приналежит.");
        description.setSize(new Dimension(200, 100));
        description.setLineWrap(true);
        description.setEnabled(false);
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        add(description, c);

        JButton minBtn = new JButton("Провести операцию");
        c.gridx = 1;
        c.gridy = 3;
        add(minBtn, c);

        final JComboBox operationType = new JComboBox();
        operationType.addItem("покупка");
        operationType.addItem("продажа");
        operationType.addItem("ремонт");
        c.gridx = 2;
        c.gridy = 3;
        add(operationType, c);

        final JTextField inputCosts = new JTextField();
        inputCosts.setPreferredSize(new Dimension(50, 30));
        inputCosts.setToolTipText("Введите сумму операции");
        c.gridx = 3;
        c.gridy = 3;
        add(inputCosts, c);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                final JDialog acceptWindow = new JDialog();
                acceptWindow.setLayout(new FlowLayout());
                Integer listIndex = operationType.getSelectedIndex();
                switch (listIndex){
                    // buy
                    case 1:
                        break;
                    // sell
                    case 2:
                        break;
                    // fix
                    case 3:
                        break;
                }
                Integer costs;
                try {
                    costs = Integer.valueOf(inputCosts.getText());
                } catch (NumberFormatException e){
                    costs = 0;
                    inputCosts.setText("");
                }
                String costTip = "На сумму: " + costs;

                JPanel bottom = new JPanel();
                bottom.setLayout(new FlowLayout());

                JButton agree  = new JButton("Подтвердить");
                JButton cancel = new JButton("Отменить");
                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        acceptWindow.setVisible(false);
                    }
                });

                final Integer finalCosts = costs;
                agree.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        ReportDAO.createNewReport(currentObject, operationType.getSelectedIndex(), finalCosts);
                        inputCosts.setText("");
                        acceptWindow.setVisible(false);
                    }
                });
                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        acceptWindow.setVisible(false);
                    }
                });

                bottom.add(agree);
                bottom.add(cancel);

                acceptWindow.add(new JLabel("Вы хотите совершить операцию '" + operationType.getSelectedItem().toString() + "' над объектом '" + currentObject.getName() + "'"));
                acceptWindow.add(new JLabel(costTip));
                acceptWindow.add(bottom);

                acceptWindow.setBounds(200, 120, 500, 200);
                acceptWindow.setTitle("Подтверждение операции");
                acceptWindow.setModal(true);
                acceptWindow.setVisible(true);
                acceptWindow.setResizable(false);
            }
        };
        inputCosts.addActionListener(actionListener);
        minBtn.addActionListener(actionListener);
    }
    public void setObjectId(Integer objectId) {
        this.objectId = objectId;
        initPanel();
    }

    private void initPanel() {
        this.currentObject = ReportDAO.getOfficeObject(this.objectId);
        String curName = currentObject.getName();
        capture.setText(curName);
        Integer curTypeId = currentObject.getOfficeObjectTypeId();

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
            default:
                break;
        }
        imageLabel.setIcon(new ImageIcon(pict)); //= new JLabel(new ImageIcon(pict));
        repaint();
    }

}
