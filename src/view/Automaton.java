package view;

import javax.swing.JFrame;

public class Automaton extends JFrame {
	private static final long serialVersionUID = 1L;

	private ImagePanel imagePanel;
	private HighlightPanel highlightPanel;
	
	public Automaton()
	{
		super("AUTOMAT Machine Project S18");
		
		setResizable(false);
		setSize(1010,550);
		setLayout(null);
		
		
		instantiate();
		initialize();
		
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	private void instantiate()
	{
		imagePanel = new ImagePanel();
		highlightPanel = new HighlightPanel();
	}
	
	private void initialize()
	{
		add(imagePanel);
		add(highlightPanel);
		
		imagePanel.setBounds(0, 0, 1010, 500);
		highlightPanel.setBounds(0, 0, 1010, 500);
	}
}
