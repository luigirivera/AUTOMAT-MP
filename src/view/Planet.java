package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Planet extends JPanel {
	private static final long serialVersionUID = 1L;

	public Planet()
	{
		super(null);
	}
	
	@Override
	   protected void paintComponent(Graphics g) {
	      g.setColor(Color.WHITE);
	      g.fillRect(0, 0, 300, 300);
	   }
	
}
