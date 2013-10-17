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
	
	public Application(){
		super("Office support [alpha]");
		
		setBounds(x_cord, y_cord, width, height);
		curLayout = new BorderLayout();
		setLayout(curLayout);
		
		
		workSpace = new Workspace();
		add(workSpace, BorderLayout.CENTER);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	

}
