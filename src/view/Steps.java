package view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Steps extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JLabel steps;
	
	public Steps()
	{
		setSize(250,280);
		setLayout(null);
		
		instantiate();
		initialize();
		configure();
		
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	
	private void instantiate()
	{
		steps = new JLabel("HELLO");
	}
	
	private void initialize()
	{
		add(steps);
		steps.setBounds(20, 20, 250, 200);
	}
	
	private void configure()
	{
		this.getContentPane().setBackground(new Color(100,100,200));
		steps.setForeground(Color.WHITE);
	}

	public JLabel getSteps() {
		return steps;
	}

	public void setSteps(JLabel steps) {
		this.steps = steps;
	}
	

}
