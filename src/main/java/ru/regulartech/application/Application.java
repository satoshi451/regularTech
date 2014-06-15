package ru.regulartech.application;

import org.apache.log4j.Logger;
import ru.regulartech.GUI.AbstractGUI;
import ru.regulartech.GUI.AdminGUI;
import ru.regulartech.GUI.RegularGUI;
import ru.regulartech.GUI.StatusBar;
import ru.regulartech.SQL.ConnectionManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;

public class Application extends JFrame {
    private static final String DEFAULT_SERVER_NAME = "localhost";//"smarty-griditup.rhcloud.com";
    private WindowAdapter windowAdapter;
    private int width = 700;
	private int height = 150;
	private int x_cord = 200;
	private int y_cord = 150;

	private BorderLayout curLayout;
	private JPanel jPanel;
	private ApplicationMenu appMenu;
    public final static Dimension inputDimension;
    public AbstractGUI mainWindows;
    static {
        inputDimension = new Dimension(180, 40);
    }

    private final Logger logger = Logger.getLogger(Application.class);
    private JTextField serverInput;
    private JTextField loginInput;
    private JPasswordField passInput;
    private String currentUser;
    private StatusBar statusBar;
    private JCheckBox isLocalHost;

    public Application(){
		super("Office support [alpha] v.2.0");

        windowAdapter = new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                super.windowClosing(windowEvent);
                System.out.println("window closing... now gui will reset...");
                resetGUI();
            }
        };
		setBounds(x_cord, y_cord, width, height);
		curLayout = new BorderLayout();
		setLayout(curLayout);
		
		appMenu = new ApplicationMenu();
		jPanel = new JPanel();
        statusBar = new StatusBar();
        statusBar.setPreferenceHeight(50);

        initLoginPanel();
		
		add(jPanel, BorderLayout.CENTER);
		add(appMenu, BorderLayout.NORTH);
        add(statusBar, BorderLayout.SOUTH);

		setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
		setVisible(true);
	}

    private void resetGUI() {
        currentUser = null;
        resetInputFields();
        mainWindows.setVisible(false);
        setVisible(true);
    }

    private void resetInputFields() {
        System.out.println("resetInputFields");

        serverInput.setText(DEFAULT_SERVER_NAME);
        serverInput.setEnabled(false);
        isLocalHost.setSelected(true);
        loginInput.setText("");
        passInput.setText("");

        statusBar.setStatus(status.OK_STATUS);
    }

    private void initLoginPanel() {
        serverInput = new JTextField();
        loginInput = new JTextField();
        passInput = new JPasswordField();

        isLocalHost = new JCheckBox();

        isLocalHost.setSelected(true);
        isLocalHost.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(isLocalHost.isSelected() == true){
                    serverInput.setText(DEFAULT_SERVER_NAME);
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
                    statusBar.setStatus(status.EMPTY_LOGIN_OR_PASSWORD);
                } else{
                    Pair<Boolean, Boolean> result = getAuthorise();
                    if(result.getFirst() == true){
                        if(result.getSecond() == true)
                            mainWindows = new AdminGUI("Admin main window", windowAdapter);
                        else
                            mainWindows = new RegularGUI("Regular user main window", windowAdapter);
                    setVisible(false);
                    }
                        currentUser = loginInput.getText();
                    }
            }
        };

        loginInput.addActionListener(connListener);
        passInput.addActionListener(connListener);

        serverInput.setEnabled(false);
        serverInput.setText(DEFAULT_SERVER_NAME);
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
        Boolean isAdmin = false;

        try {
            isAdmin = ConnectionManager.getConnection(serverName, login, password);
            if(isAdmin == null){
                connectionStatus = false;
                statusBar.setStatus(status.SQL_ERROR);
            } else {
                connectionStatus = true;
            }
            repaint();
        } catch(SQLException sqlException){
            statusBar.setStatus(status.FATAL_ERROR);
            statusBar.repaint();

            connectionStatus = false;
            return null;
        }

        return new Pair<Boolean, Boolean>(Boolean.valueOf(connectionStatus), Boolean.valueOf(isAdmin));
    }
}
