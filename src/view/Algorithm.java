package view;

import javax.swing.JFrame;
import javax.swing.JTextArea;

public class Algorithm extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	
	public Algorithm()
	{
		setSize(500,500);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
}
