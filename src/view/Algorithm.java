package view;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Algorithm extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	
	public Algorithm()
	{
		super("AUTOMAT Machine Project S18 - Algorithm");
		
		instantiate();
		setLayout(null);
		initialize();
		setSize(500,500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	
	private void instantiate()
	{
		textArea = new JTextArea();
	}
	
	private void initialize()
	{
		add(textArea);
		textArea.setBounds(0, 0, 500, 500);
		
		textArea.setEditable(false);
	}
}
