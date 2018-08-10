package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Automaton extends JFrame {
	private static final long serialVersionUID = 1L;

	private ImagePanel imagePanel;
	private JPanel highlightPanel;
	
	public Automaton()
	{
		super("AUTOMAT Machine Project S18");
		
		setResizable(false);
		setSize(1010,590);
		setLayout(null);
		
		
		instantiate();
		initialize();
		
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	private void instantiate()
	{
		imagePanel = new ImagePanel();
		highlightPanel = new JPanel();
	}
	
	private void initialize()
	{
		add(imagePanel);
		add(highlightPanel);
		
		imagePanel.setBounds(0, 0, 1010, 568);
		highlightPanel.setBounds(imagePanel.getBounds());
	}
}
