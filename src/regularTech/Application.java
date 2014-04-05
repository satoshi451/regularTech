package regularTech;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.*;

public class Application extends JFrame {
	private int width = 800;
	private int height = 300;
	private int x_cord = 200;
	private int y_cord = 150;
	
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
    private String currentUser;
    private StatusBar statusBar;

    public Application(){
		super("Office support [alpha]");
		
		setBounds(x_cord, y_cord, width, height);
		curLayout = new BorderLayout();
		setLayout(curLayout);
		
		appMenu = new ApplicationMenu();
		jPanel = new JPanel();
        statusBar = new StatusBar();

        initLoginPanel();
		
		add(jPanel, BorderLayout.CENTER);
		add(appMenu, BorderLayout.NORTH);
        add(statusBar, BorderLayout.SOUTH);

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
                int l1 = loginInput.getText().length();
                int l2 = (new String(passInput.getPassword())).length();

                if(l1 == 0  || l2 == 0){
                    System.out.println("Empty");
                }
                else
                    if(getAuthorise()){
                       System.out.println("Success connection");
                        currentUser = loginInput.getText();
                    }

            }
        };

        loginInput.addActionListener(connListener);
        passInput.addActionListener(connListener);

        serverInput.setEnabled(false);
        serverInput.setText("localhost");
        jPanel.add(isLocalHost);
        jPanel.add(serverInput);
        jPanel.add(loginInput);
        jPanel.add(passInput);


    }

    private boolean getAuthorise() {
        String serverName = serverInput.getText();
        String login = loginInput.getText();
        String password = new String(passInput.getPassword());
        try {
            boolean connectionStatus = ConnectionManager.getConnection(serverName, login, password);
        }catch(SQLException sqlExeption){
            this.statusBar.setStatus(status.ACCESS_DENIED);
        }

        return false;
    }


}
