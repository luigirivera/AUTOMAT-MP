package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Walkthrough extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JButton through1, through2, through3, through4;
	private Automaton automaton;
	
	public Walkthrough()
	{
		super("AUTOMAT Machine Project S18 - Walkthrough");
		setSize(250,280);
		setLayout(null);
		
		instantiate();
		initialize();
		addListeners();
		configure();
		
		setVisible(false);
		setResizable(false);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	
	private void instantiate()
	{
		through1 = new JButton("Solution 1");
		through2 = new JButton("Solution 2");
		through3 = new JButton("Solution 3");
		through4 = new JButton("Solution 4");
		
		automaton = new Automaton();
	}
	
	private void initialize()
	{
		
		
		add(through1);
		add(through2);
		add(through3);
		add(through4);
		
		through1.setBounds(70, 10, 100, 50);
		through2.setBounds(70, 70, 100, 50);
		through3.setBounds(70, 130, 100, 50);
		through4.setBounds(70, 190, 100, 50);
		
		automaton.setVisible(false);
		automaton.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	
	private void configure()
	{
		this.getContentPane().setBackground(new Color(100,100,200));
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		
		buttons.add(through1);
		buttons.add(through2);
		buttons.add(through3);
		buttons.add(through4);
		
		for(JButton b : buttons)
		{
			b.setOpaque(false);
			b.setContentAreaFilled(false);
			b.setFocusPainted(false);
			b.setBorder(BorderFactory.createEtchedBorder());
			b.setForeground(Color.WHITE);
		}
	}
	
	private void addListeners()
	{
		through1.addActionListener(new SolutionListener());
		through2.addActionListener(new SolutionListener());
		through3.addActionListener(new SolutionListener());
		through4.addActionListener(new SolutionListener());
	}
	
	class SolutionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(!automaton.isVisible())
				automaton.setVisible(true);
			String file = "res/Automaton_Blank.png";
			if(arg0.getSource().equals(through1))
				file = "res/Automaton_Sol1.png";
			else if(arg0.getSource().equals(through2))
				file = "res/Automaton_Sol2.png";
			else if(arg0.getSource().equals(through3))
				file = "res/Automaton_Sol3.png";
			else if(arg0.getSource().equals(through4))
				file = "res/Automaton_Sol4.png";
			
			automaton.getImagePanel().change(file);
			
		}
		
	}
	
}
