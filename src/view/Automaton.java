package view;

import javax.swing.JFrame;

public class Automaton extends JFrame {
	private static final long serialVersionUID = 1L;

	private ImagePanel imagePanel;
	
	public Automaton()
	{
		super("AUTOMAT Machine Project S18");
		
		setResizable(false);
		setSize(500,500);
		setLayout(null);
		
		
		instantiate();
		
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	private void instantiate()
	{
		imagePanel = new ImagePanel();
	}
}
