package view;

import java.awt.Graphics;
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
			image = ImageIO.read(new File("res/Automaton_q0.png"));
		}catch(Exception e) {}
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
    
    public void change(String file)
    {
    	try {
    		image = ImageIO.read(new File(file));
    	}catch(Exception e) {}
    	
    	repaint();
    }
}
