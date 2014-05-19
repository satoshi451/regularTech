package regularTech;

import regularTech.GUI.AbstractGUI;
import regularTech.GUI.AdminGUI;
import regularTech.GUI.RegularGUI;
import regularTech.GUI.StatusBar;
import regularTech.SQL.ConnectionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Application extends JFrame {
	private int width = 800;
	private int height = 300;
	private int x_cord = 200;
	private int y_cord = 150;
	
	private BorderLayout curLayout;
	private JPanel jPanel;
	private ApplicationMenu appMenu;
    public final static Dimension inputDimension;
    public AbstractGUI mainWindows;
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

        final JCheckBox isLocalHost = new JCheckBox();

        isLocalHost.setSelected(true);
        isLocalHost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(isLocalHost.isSelected() == true){
                    serverInput.setText("localhost");
                    serverInput.setEnabled(false);
                } else{
                    serverInput.setText("");
                    serverInput.setEnabled(true);
                }
            }
        });
        serverInput.setPreferredSize(inputDimension);
        loginInput.setPreferredSize(inputDimension);
        passInput.setPreferredSize(inputDimension);

        ActionListener connListener = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int l1 = loginInput.getText().length();
                int l2 = (new String(passInput.getPassword())).length();

                if(l1 == 0  || l2 == 0){
                    System.out.println("Empty");
                }
                else{
                    Pair<Boolean, Boolean> result = getAuthorise();
                    if(result.getFirst() == true){
                        if(result.getSecond() == true)
                            mainWindows = new AdminGUI("Admin main window");
                        else
                            mainWindows = new RegularGUI("Regular user main window");
                    setVisible(false);
                    }
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

    private Pair<Boolean, Boolean> getAuthorise() {
        String serverName = serverInput.getText();
        String login = loginInput.getText();
        String password = new String(passInput.getPassword());
        boolean connectionStatus = false;
        boolean isAdmin = false;

        try {
            isAdmin = ConnectionManager.getConnection(serverName, login, password);
            connectionStatus = true;
        }catch(SQLException sqlExeption){
            this.statusBar.setStatus(status.ACCESS_DENIED);
            this.statusBar.repaint();
            connectionStatus = false;
        }

        return new Pair<Boolean, Boolean>(Boolean.valueOf(connectionStatus), Boolean.valueOf(isAdmin));
    }


}
