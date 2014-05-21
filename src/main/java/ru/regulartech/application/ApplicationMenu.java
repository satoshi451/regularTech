package ru.regulartech.application;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ApplicationMenu extends JMenuBar {
	public ApplicationMenu(){
		super();
		JMenu mi1 = new JMenu("ololo menu");
		JMenu mi2 = new JMenu("menu item2");
		
		mi1.add(new JMenuItem("item1"));
		
		add(mi1);
		add(mi2);
		
	}
}
