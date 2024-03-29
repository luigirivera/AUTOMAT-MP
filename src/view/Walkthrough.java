package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import automat_new.Automaton;
import automat_new.DFS;
import automat_new.Transition;

public class Walkthrough extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private DFS algo;
	private int shortest;
	ArrayList<ArrayList<Transition>> solutions;
	private JButton through1, through2, through3, through4;
	private JPanel steps, sky;
	private JLabel stepsL, skyL;
	private ImagePanel imagePanel;
	
	public Walkthrough()
	{
		super("AUTOMAT Machine Project S18 - Walkthrough");
		setSize(1265,778);
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
		
		steps = new JPanel();
		stepsL = new JLabel();
		
		sky = new JPanel();
		skyL = new JLabel(new ImageIcon("res/sky_through.png"));
		imagePanel = new ImagePanel();
		
		textArea = new JTextArea();
		algo = new DFS(new Automaton());
		solutions = new ArrayList<>();
	}
	
	private void initialize()
	{
		
		add(through1);
		add(through2);
		add(through3);
		add(through4);
		
		add(textArea);
		textArea.setBounds(0, 528, 600, 250);
		
		add(steps);
		steps.setLayout(null);
		steps.setOpaque(false);
		steps.add(stepsL);
		
		add(imagePanel);
		
		add(sky);
		sky.add(skyL);
		sky.setBounds(0, 0, 1265, 778);
		skyL.setBounds(0,0,1265, 778);

		
		imagePanel.setBounds(250, 0, 1015, 500);
		
		steps.setBounds(0, 250, 250, 200);
		stepsL.setBounds(20, 20, 250, 200);
		
		through1.setBounds(70, 10, 100, 50);
		through2.setBounds(70, 70, 100, 50);
		through3.setBounds(70, 130, 100, 50);
		through4.setBounds(70, 190, 100, 50);
	}
	
	private void configure()
	{
		
		stepsL.setForeground(Color.WHITE);
		
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
		
		textArea.setEditable(false);
		
		shortest = algo.getShortest();
		
        ArrayList<Transition> temp = new ArrayList<>();
        for(ArrayList<Transition> t : algo.getSolutionTransitions())
        {
        	if(t.size() == shortest)
        	{
            	solutions.add(temp);
            	temp = new ArrayList<>();
        	}
        }
        

        
        textArea.setText("Performing Algorithm...\n");
        textArea.setText(textArea.getText().concat("Found " + solutions.size() + " solutions with " + shortest + " steps\n"));
        int j=1;
        for(int i = 0; i < algo.getSolutionTransitions().size(); i++) {
        	temp.addAll(algo.getSolutionTransitions().get(i)); 
        	if(temp.size() == shortest)
        	{
        		textArea.setText(textArea.getText().concat("Solution " + j + ": "));
                for(Transition t : temp)
                	textArea.setText(textArea.getText().concat(" -> " + t.getName()));
                textArea.setText(textArea.getText().concat("\n"));
                j++;
        	}

            temp.clear();
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
			
			String file = "res/Automaton_Blank.png";
			if(arg0.getSource().equals(through4))
			{
				file = "res/Automaton_Sol1.png";
				stepsL.setText("<html>Step 1: Bring Lion and Cow to Mars<br>Step 2: Bring Cow to Earth<br>Step 3: Bring Cow and Grain to Mars<br>Step 4: Bring Cow to Earth<br>Step 5: Bring both humans to Mars<br>Step 6: Bring Lion to Earth<br>Step 7: Bring Lion and Cow to Mars</html>");
			}
				
			else if(arg0.getSource().equals(through3))
			{
				file = "res/Automaton_Sol2.png";
				stepsL.setText("<html>Step 1: Bring Lion and Cow to Mars<br>Step 2: Bring Lion to Earth<br>Step 3: Bring Lion and Grain to Mars<br>Step 4: Bring Cow to Earth<br>Step 5: Bring both humans to Mars<br>Step 6: Bring Lion to Earth<br>Step 7: Bring Lion and Cow to Mars</html>");
			}
				
			else if(arg0.getSource().equals(through1))
			{
				file = "res/Automaton_Sol3.png";
				stepsL.setText("<html>Step 1: Bring Lion and Cow to Mars<br>Step 2: Bring Lion to Earth<br>Step 3: Bring both humans to Mars<br>Step 4: Bring Cow to Earth<br>Step 5: Bring Lion and Grain to Mars<br>Step 6: Bring Lion to Earth<br>Step 7: Bring Lion and Cow to Mars</html>");
			}
				
			else if(arg0.getSource().equals(through2))
			{
				stepsL.setText("<html>Step 1: Bring Lion and Cow to Mars<br>Step 2: Bring Lion to Earth<br>Step 3: Bring both humans to Mars<br>Step 4: Bring Cow to Earth<br>Step 5: Bring Cow and Grain to Mars<br>Step 6: Bring Cow to Earth<br>Step 7: Bring Lion and Cow to Mars</html>");
				file = "res/Automaton_Sol4.png";
			}
				
			
			imagePanel.change(file);
			
		}
		
	}
	
}
