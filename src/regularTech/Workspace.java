package regularTech;

import java.awt.Graphics;

import javax.swing.JPanel;

public class Workspace extends JPanel {
	public Workspace(){
		
	}
	
	@Override 
	protected void paintComponent(Graphics g){
		g.drawString("Workspace windows", 100, 100);
	}
}
