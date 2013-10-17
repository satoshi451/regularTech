package regularTech;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Application extends JFrame {
	private int width = 800;
	private int height = 600;
	private int x_cord;
	private int y_cord;
	
	private BorderLayout curLayout;
	private Workspace workSpace;
	private ApplicationMenu appMenu;
	  
	public Application(){
		super("Office support [alpha]");
		
		setBounds(x_cord, y_cord, width, height);
		curLayout = new BorderLayout();
		setLayout(curLayout);
		
		appMenu = new ApplicationMenu();
		workSpace = new Workspace();
		
		add(workSpace, BorderLayout.CENTER);
		add(appMenu, BorderLayout.NORTH);
		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	

}
