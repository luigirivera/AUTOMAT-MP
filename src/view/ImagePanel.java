package view;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private BufferedImage image;
	
	public ImagePanel()
	{
		try {
			image = ImageIO.read(new File("res/Automaton.jpg"));
		}catch(Exception e) {}
	}
}
