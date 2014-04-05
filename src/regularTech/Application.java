package regularTech;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Application extends JFrame {
	private int width = 800;
	private int height = 600;
	private int x_cord;
	private int y_cord;
	
	private BorderLayout curLayout;
	private JPanel jPanel;
	private ApplicationMenu appMenu;
    public static Dimension inputDimension;

    static{
        inputDimension = new Dimension(180, 40);
    }

    private JTextField serverInput;
    private JTextField loginInput;
    private JPasswordField passInput;

    public Application(){
		super("Office support [alpha]");
		
		setBounds(x_cord, y_cord, width, height);
		curLayout = new BorderLayout();
		setLayout(curLayout);
		
		appMenu = new ApplicationMenu();
		jPanel = new JPanel();

        initLoginPanel();
		
		add(jPanel, BorderLayout.CENTER);
		add(appMenu, BorderLayout.NORTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

    private void initLoginPanel() {
        serverInput = new JTextField();
        loginInput = new JTextField();
        passInput = new JPasswordField();

        JCheckBox isLocalHost = new JCheckBox();

        isLocalHost.setSelected(true);

        serverInput.setPreferredSize(inputDimension);
        loginInput.setPreferredSize(inputDimension);
        passInput.setPreferredSize(inputDimension);

        isLocalHost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                serverInput.setText("localhost");
                serverInput.setEnabled(false);
            }
        });
        ActionListener connListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(loginInput.getText().equals("") && (new String(passInput.getPassword())).equals("")){
                    System.out.println("Login ok!");
                }
                else
                    System.out.println("Login bad (");

            }
        };
        loginInput.addActionListener(connListener);
        passInput.addActionListener(connListener);
    }


}
