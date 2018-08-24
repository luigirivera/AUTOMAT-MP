package view;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JTextArea;

import automat_new.Automaton;
import automat_new.DFS;
import automat_new.Transition;

public class Algorithm extends JFrame {
	private static final long serialVersionUID = 1L;
	private JTextArea textArea;
	private DFS algo;
	private int shortest;
	
	
	public Algorithm()
	{
		super("AUTOMAT Machine Project S18 - Algorithm");
		
		instantiate();
		setLayout(null);
		initialize();
		setSize(600,250);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
	
	private void instantiate()
	{
		textArea = new JTextArea();
		algo = new DFS(new Automaton());
	}
	
	private void initialize()
	{
		add(textArea);
		textArea.setBounds(0, 0, 600, 250);
		
		textArea.setEditable(false);
		
		shortest = algo.getShortest();
		System.out.println(shortest);
        ArrayList<Transition> temp = new ArrayList<>();
        for(int i = 0; i < algo.getSolutionTransitions().size(); i++) {
        	temp.addAll(algo.getSolutionTransitions().get(i)); 
        	if(temp.size() == shortest)
        	{
	            for(Transition t : temp)
	            	System.out.print( " -> " + t.getName());
	            System.out.println();
        	}

            temp.clear();
        }
	}
}
