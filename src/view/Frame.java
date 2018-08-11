package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import enums.PLANET;
import model.Entity;
import model.Model;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JButton about, instructions, walkthrough, quit, transport;
	private JCheckBox human1, human2, cow, lion, grain;
	private JLabel location, human1txt, human2txt, cowtxt, liontxt, graintxt, earthtxt, marstxt, stepCount;
	private Automaton automaton;
	private Walkthrough walkthroughFrame;
	
	private Planet earth, mars;
	
	private final String earthLoc = "You are in Earth";
	private final String marsLoc = "You are in Mars";
	
	private final int inEarthX = 175;
	private final int inMarsX = 535;
	
	private ArrayList<JCheckBox> entities;
	private ArrayList<Entity> modelEntities;
	private ArrayList<JLabel> textEntities;
	
	private Model model;
	private Frame frame;
	private int stepCountInt;
	
	public Frame(Model model)
	{
		super("AUTOMAT Machine Project S18");
		
		this.model = model;
		frame = this;
		
		setLayout(null);
		setSize(750,750);
		setResizable(false);
		
		instantiate();
		initialize();
		configure();
		addListeners();

		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	private void instantiate()
	{
		stepCountInt  = 0;
		
		about = new JButton("About");
		instructions = new JButton("Instructions");
		walkthrough = new JButton("Walkthrough");
		quit = new JButton("Quit");
		transport = new JButton("Transport");
		
		human1 = new JCheckBox("Human 1");
		human2 = new JCheckBox("Human 2");
		cow = new JCheckBox("Cow");
		lion = new JCheckBox("Lion");
		grain = new JCheckBox("Grain");
		
		earth = new Planet();
		mars = new Planet();
		
		location = new JLabel(earthLoc);
		earthtxt = new JLabel("Earth");
		marstxt = new JLabel("Mars");
		human1txt = new JLabel("Human 1");
		human2txt = new JLabel("Human 2");
		liontxt = new JLabel("Lion");
		cowtxt = new JLabel("Cow");
		graintxt = new JLabel("Grain");
		stepCount = new JLabel("Steps Done: " + stepCountInt);
		
		entities = new ArrayList<JCheckBox>();
		modelEntities = new ArrayList<Entity>();
		textEntities = new ArrayList<JLabel>();
		
		walkthroughFrame = new Walkthrough();
		automaton = new Automaton();
	}
	
	private void initialize()
	{
		add(about);
		add(instructions);
		add(quit);
		
		add(location);
		add(stepCount);
		
		add(human1);
		add(human2);
		add(lion);
		add(cow);
		add(grain);
		add(transport);
		add(walkthrough);
		
		add(earthtxt);
		add(marstxt);
		
		add(human1txt);
		add(human2txt);
		add(liontxt);
		add(cowtxt);
		add(graintxt);
		
		add(earth);
		add(mars);
		
		about.setSize(100,50);
		instructions.setSize(150,50);
		quit.setSize(100,50);
		about.setLocation(30, 20);
		instructions.setLocation(this.getWidth()/2 - 75, 20);
		quit.setLocation(this.getWidth()-quit.getWidth()-40, 20);
		
		location.setSize(225, 60);
		location.setLocation(this.getWidth()/2 - location.getWidth()/2, 100);
		stepCount.setSize(location.getSize());
		stepCount.setLocation(this.getWidth()/2 - stepCount.getWidth()/2 + 20, 130);
	
		human1.setSize(100, 50);
		human2.setSize(100, 50);
		lion.setSize(100, 50);
		cow.setSize(100, 50);
		grain.setSize(100, 50);
		transport.setSize(100,50);
		walkthrough.setSize(150,50);
		human1.setLocation(30, this.getHeight()-150);
		human2.setLocation(30, this.getHeight()-100);
		lion.setLocation(human1.getX()+human1.getWidth()+30, human1.getY());
		cow.setLocation(human2.getX()+human2.getWidth()+30, human2.getY());
		grain.setLocation(lion.getX()+lion.getWidth()+20, this.getHeight()-125);
		transport.setLocation(grain.getX()+grain.getWidth()+20, grain.getY());
		walkthrough.setLocation(transport.getX()+transport.getWidth()+50, grain.getY());
		
		earth.setBounds(50,200,300,300);
		mars.setBounds(earth.getX()+earth.getWidth()+60, earth.getY(), earth.getWidth(), earth.getHeight());
		
		earthtxt.setSize(200,60);
		earthtxt.setLocation(175, earth.getY());
		marstxt.setSize(200,60);
		marstxt.setLocation(535,mars.getY());
		
		human1txt.setSize(200,60);
		human1txt.setLocation(inEarthX, earthtxt.getY() + 60);
		human2txt.setSize(human1txt.getSize());
		human2txt.setLocation(human1txt.getX(), human1txt.getY() + 40);
		liontxt.setSize(human2txt.getSize());
		liontxt.setLocation(human2txt.getX(), human2txt.getY() + 40);
		cowtxt.setSize(liontxt.getSize());
		cowtxt.setLocation(liontxt.getX(), liontxt.getY() + 40);
		graintxt.setSize(cowtxt.getSize());
		graintxt.setLocation(cowtxt.getX(), cowtxt.getY() + 40);
		
		entities.add(human1);
		entities.add(human2);
		entities.add(cow);
		entities.add(lion);
		entities.add(grain);
		
		modelEntities.add(model.getHuman1());
		modelEntities.add(model.getHuman2());
		modelEntities.add(model.getCow());
		modelEntities.add(model.getLion());
		modelEntities.add(model.getGrain());
		
		textEntities.add(human1txt);
		textEntities.add(human2txt);
		textEntities.add(cowtxt);
		textEntities.add(liontxt);
		textEntities.add(graintxt);
	}
	
	private void configure()
	{
		this.getContentPane().setBackground(new Color(100,100,200));
		
		earth.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mars.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		location.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		location.setForeground(Color.WHITE);
		stepCount.setFont(location.getFont());
		stepCount.setForeground(Color.WHITE);
		
		earthtxt.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		marstxt.setFont(earthtxt.getFont());
		
		human1txt.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
		human2txt.setFont(human1txt.getFont());
		liontxt.setFont(human2txt.getFont());
		cowtxt.setFont(liontxt.getFont());
		graintxt.setFont(cowtxt.getFont());
		
		for(JCheckBox cb : entities)
		{
			cb.setOpaque(false);
			cb.setForeground(Color.WHITE);
		}
		
		ArrayList<JButton> buttons = new ArrayList<JButton>();
		
		buttons.add(about);
		buttons.add(instructions);
		buttons.add(quit);
		buttons.add(transport);
		buttons.add(walkthrough);
		
		for(JButton b : buttons)
		{
			b.setOpaque(false);
			b.setContentAreaFilled(false);
			b.setFocusPainted(false);
			b.setBorder(BorderFactory.createEtchedBorder());
			b.setForeground(Color.WHITE);
		}
		
		automaton.getImagePanel().change("res/Automaton_q0.png");
	}
	

	
	private void addListeners()
	{
		about.addActionListener(new AboutListener());
		instructions.addActionListener(new InstructionsListener());
		quit.addActionListener(new QuitListener());
		transport.addActionListener(new TransportListener());
		walkthrough.addActionListener(new WalkthroughListener());
	}
	
	class AboutListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "<html>This program is for compliance for AUTOMAT S18 Machine Project<br><br>Members:<br>Miguel Llamas<br>Brian Poblete<br>Louie Rivera</html>", "About", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	class InstructionsListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(frame, "<html>The Earth is slowly dying and a scientist wants to help build a new life on Mars.<br>However, he only has a spaceship that was so tiny it could only carry him and two other items.<br>He wants to transport five things that he thought were essential to start a new life on Mars: two humans, one lion, one cow and one bag of grain.<br>Whenever the scientist is not around, either human would kill the lion out of fear or eat the cow out of hunger, the lion will eat the cow, and the cow will eat the grain.<br>Only the scientist knows how to fly the spaceship. How will the scientist transport all the five items to Mars?</html>", "Instructions", JOptionPane.INFORMATION_MESSAGE);
			
		}
		
	}
	class QuitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			
		}
		
	}
	
	class TransportListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(checkEntitySelect())
				moveEntities(getEntitySelect());
			else
				if(getEntitySelect().size() == 0)
					JOptionPane.showMessageDialog(frame, "You must have at least 1 living thing travelling with you", "Empty Ship", JOptionPane.ERROR_MESSAGE);
				else
					JOptionPane.showMessageDialog(frame, "You must have at most 2 living things travelling with you", "Full Ship", JOptionPane.ERROR_MESSAGE);

			update();
		}
		
	}
	
	class WalkthroughListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			walkthroughFrame.setVisible(true);
			
		}
		
	}
	
	private boolean checkEntitySelect()
	{
		int count = 0;
		for(JCheckBox cB : entities)
			if(cB.isSelected())
				count++;
		
		if(count > 2 || count == 0) return false;
		else return true;
	}
	
	private ArrayList<Integer> getEntitySelect()
	{
		ArrayList<Integer> selected = new ArrayList<Integer>();
		
		for(int i = 0; i < entities.size() ; i++)
			if(entities.get(i).isSelected())
				if(modelEntities.get(i).getPlanet().equals(model.getUser().getPlanet()))
					selected.add(i);
				else
				{
					JOptionPane.showMessageDialog(frame, "A living thing you selected is not in the planet you are in.", "Missing Living Thing", JOptionPane.ERROR_MESSAGE);
					return null;
				}
		
		return selected;
	}
	
	private void clearEntitySelect()
	{
		for(JCheckBox cB : entities)
			cB.setSelected(false);
	}
	
	private void moveEntities(ArrayList<Integer> selected)
	{
		if(selected != null)
		{
			if(model.getUser().getPlanet().equals(PLANET.EARTH))
			{
				for(Integer i : selected)
					modelEntities.get(i).setPlanet(PLANET.MARS);
				
				model.getUser().setPlanet(PLANET.MARS);
			}
				
			
			else
			{
				for(Integer i : selected)
					modelEntities.get(i).setPlanet(PLANET.EARTH);
				
				model.getUser().setPlanet(PLANET.EARTH);
			}
			
			stepCountInt++;
			stepCount.setText("Steps Done: " + stepCountInt);
		}
	}
	
	private ArrayList<Entity> getAllInEarth()
	{
		ArrayList<Entity> earthE = new ArrayList<Entity>();
		
		for(Entity e : modelEntities)
			if(e.getPlanet().equals(PLANET.EARTH))
				earthE.add(e);
		
		return earthE;
	}
	
	private ArrayList<Entity> getAllInMars()
	{
		ArrayList<Entity> marsE = new ArrayList<Entity>();
		
		for(Entity e : modelEntities)
			if(e.getPlanet().equals(PLANET.MARS))
				marsE.add(e);
		
		return marsE;
	}
	
	private boolean checkStatus()
	{
		ArrayList<Entity> otherPlanetE;
		boolean pass = true;
		String error = "<html>Mission Failed: ";
		
		if(model.getUser().getPlanet().equals(PLANET.EARTH))
			otherPlanetE = getAllInMars();
		else
			otherPlanetE = getAllInEarth();
		
		if(otherPlanetE.contains(model.getHuman1()) || otherPlanetE.contains(model.getHuman2()))
		{
			if(otherPlanetE.contains(model.getLion()))
			{
				error = error.concat("<br>One of the humans killed the lion");
				pass = false;
			}
				
			if(otherPlanetE.contains(model.getCow()))
			{
				error = error.concat("<br>One of the humans ate the cow");
				pass = false;
			}
				
			if(otherPlanetE.contains(model.getLion()) && otherPlanetE.contains(model.getCow()))
			{
				error = error.concat("<br>The lion ate the cow");
				pass = false;
			}
		}

		
		else if(otherPlanetE.contains(model.getLion()) && otherPlanetE.contains(model.getCow()))
		{
			error = error.concat("<br>The lion ate the cow");
			pass = false;
		}
			
		
		if(otherPlanetE.contains(model.getCow()) && otherPlanetE.contains(model.getGrain()))
		{
			error = error.concat("<br>The cow ate the grain");
			pass = false;
		}
		
		error = error.concat("<html>");
		if(!error.equals("<html>Mission Failed: <html>"))
		{
			JOptionPane.showMessageDialog(frame, error, "Mission Failed", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		return pass;
	}
	
	private boolean containsAHuman(ArrayList<Entity> planet)
	{
		return planet.contains(model.getHuman1()) || planet.contains(model.getHuman2());
	}
	
	private boolean containsBothHuman(ArrayList<Entity> planet)
	{
		return planet.contains(model.getHuman1()) && planet.contains(model.getHuman2());
	}
	
	private void updateAutomaton()
	{
		if(checkStatus())
		{
			ArrayList<Entity> marsA, earthA;
			String file = "res/Automaton_Blank.png";

			marsA = getAllInMars();
			earthA = getAllInEarth();
			
			if(model.getUser().getPlanet().equals(PLANET.MARS))
			{
				if(earthA.isEmpty())
					file = "res/Automaton_q10.png";
				else if(containsBothHuman(earthA) && earthA.contains(model.getGrain()) && marsA.contains(model.getCow())
						&& marsA.contains(model.getLion()))
					file = "res/Automaton_q4.png";
				else if(containsBothHuman(earthA) && marsA.contains(model.getLion()) && marsA.contains(model.getCow())
						&& marsA.contains(model.getGrain()))
					file = "res/Automaton_q21.png";
				else if(containsAHuman(earthA) && containsAHuman(marsA) && marsA.contains(model.getLion()) && earthA.contains(model.getGrain())
						&& marsA.contains(model.getCow()))
					file = "res/Automaton_q22.png";
				else if(containsBothHuman(marsA) && marsA.contains(model.getCow()) && earthA.contains(model.getLion())
						&& earthA.contains(model.getGrain()))
					file = "res/Automaton_q11.png";
				else if(containsBothHuman(marsA) && marsA.contains(model.getCow()) && marsA.contains(model.getGrain())
						&& earthA.contains(model.getLion()))
					file = "res/Automaton_q19.png";
				else if(containsBothHuman(marsA) && marsA.contains(model.getLion()) && marsA.contains(model.getGrain())
						&& earthA.contains(model.getCow()))
					file = "res/Automaton_q8.png";
				else if(containsBothHuman(marsA) && marsA.contains(model.getLion()) && marsA.contains(model.getCow())
						&& earthA.contains(model.getGrain()))
					file = "res/Automaton_q18.png";
				else if(containsAHuman(earthA) && containsAHuman(marsA) && marsA.contains(model.getLion()) && marsA.contains(model.getCow())
						&& marsA.contains(model.getGrain()))
					file = "res/Automaton_q12.png";
			}
			else
			{
				if(marsA.isEmpty())
					file = "res/Automaton_q0.png";
				else if(marsA.contains(model.getCow()) && containsBothHuman(earthA) && earthA.contains(model.getLion())
						&& earthA.contains(model.getGrain()))
					file = "res/Automaton_q1.png";
				else if(marsA.contains(model.getLion()) && containsBothHuman(earthA) && earthA.contains(model.getCow())
						&& earthA.contains(model.getGrain()))
					file = "res/Automaton_q2.png";
				else if(marsA.contains(model.getGrain()) && containsBothHuman(earthA) && earthA.contains(model.getCow())
						&& earthA.contains(model.getLion()))
					file = "res/Automaton_q26.png";
				else if(containsAHuman(earthA) && containsAHuman(marsA) && earthA.contains(model.getLion()) && earthA.contains(model.getCow())
						&& earthA.contains(model.getGrain()))
					file = "res/Automaton_q17.png";
				else if (containsBothHuman(marsA) && earthA.contains(model.getLion()) && earthA.contains(model.getCow())
						&& earthA.contains(model.getGrain()))
					file = "res/Automaton_q16.png";
				else if(containsBothHuman(marsA) && marsA.contains(model.getGrain()) && earthA.contains(model.getCow()) &&
						earthA.contains(model.getLion()))
					file = "res/Automaton_q9.png";
				else if(containsBothHuman(earthA) && earthA.contains(model.getCow()) && marsA.contains(model.getLion())
						&& marsA.contains(model.getGrain()))
					file = "res/Automaton_q7.png";
				else if(containsAHuman(earthA) && containsAHuman(marsA) && marsA.contains(model.getGrain()) && earthA.contains(model.getCow())
						&& earthA.contains(model.getLion()))
					file = "res/Automaton_q20.png";
			}
			automaton.getImagePanel().change(file);
		}
	}
	private void update()
	{
		for(int i = 0 ; i < modelEntities.size() ; i++)
			if(modelEntities.get(i).getPlanet().equals(PLANET.EARTH))
				textEntities.get(i).setLocation(inEarthX, textEntities.get(i).getY());
			else
				textEntities.get(i).setLocation(inMarsX, textEntities.get(i).getY());
		
		if(model.getUser().getPlanet().equals(PLANET.EARTH))
			location.setText(earthLoc);
		else
			location.setText(marsLoc);

		clearEntitySelect();
		
		updateAutomaton();
		if(getAllInMars().size() == 5)
		{
			if(stepCountInt == 7)
				JOptionPane.showMessageDialog(frame, "You have successfully transferred all living things", "Mission Success", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(frame, "<html>You have successfully transferred all living things<br>However, it was performed not on the minimum number of steps</html>", "Mission Somewhat Success", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
	}
}
