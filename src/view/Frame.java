package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import enums.PLANET;
import model.Entity;
import model.Model;

public class Frame extends JFrame {
	private static final long serialVersionUID = 1L;

	private JButton about, instructions, walkthrough, quit, transport;
	private JCheckBox human1, human2, cow, lion, grain;
	private JLayeredPane lPane;
	private JPanel sky, planets, things;
	private JLabel human1L, human2L, cowL, lionL, grainL, scientist, stepCount, skyL, earth, mars;
	
	private Walkthrough walkthroughFrame;
	
	private ImagePanel imagePanel;
	
	private ImageIcon rocketEarth, rocketMars;

	private final Point human1Earth = new Point(20,40);
	private final Point human2Earth = new Point(65,5);
	private final Point lionEarth = new Point(130,45);
	private final Point cowEarth = new Point(190,50);
	private final Point grainEarth = new Point(220,75);
	private final Point scientistEarth = new Point(150,80);
	
	private final Point human1Mars = new Point(375,40);
	private final Point human2Mars = new Point(420,5);
	private final Point lionMars = new Point(480,45);
	private final Point cowMars = new Point(540,50);
	private final Point grainMars = new Point(570,75);
	private final Point scientistMars = new Point(230,80);
	
	private ArrayList<JCheckBox> entities;
	private ArrayList<Entity> modelEntities;
	private ArrayList<JLabel> imageEntities;
	
	private Model model;
	private Frame frame;
	private int stepCountInt;
	
	public Frame(Model model)
	{
		super("AUTOMAT Machine Project S18");
		
		this.model = model;
		frame = this;
		
		setLayout(null);
		setSize(1765,750);
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
		
		
		rocketEarth = new ImageIcon("res/rocket_Earth.png");
		rocketMars = new ImageIcon("res/rocket_Mars.png");
		skyL = new JLabel(new ImageIcon("res/sky.png"));
		earth = new JLabel(new ImageIcon("res/earth.png"));
		mars = new JLabel(new ImageIcon("res/mars.png"));
		
		human1L = new JLabel(new ImageIcon("res/human1.png"));
		human2L = new JLabel(new ImageIcon("res/human2.png"));
		lionL = new JLabel(new ImageIcon("res/lion.png"));
		cowL = new JLabel(new ImageIcon("res/cow.png"));
		grainL = new JLabel(new ImageIcon("res/grain.png"));
		scientist = new JLabel(new ImageIcon("res/rocket_Earth.png"));
		
		stepCount = new JLabel("Steps Done: " + stepCountInt);
		
		lPane = new JLayeredPane();
		sky = new JPanel();
		planets = new JPanel();
		things = new JPanel();
		
		entities = new ArrayList<JCheckBox>();
		modelEntities = new ArrayList<Entity>();
		imageEntities = new ArrayList<JLabel>();
		
		walkthroughFrame = new Walkthrough();
		imagePanel = new ImagePanel();
	}
	
	private void initialize()
	{
		add(about);
		add(instructions);
		add(quit);
		
		add(stepCount);
		
		add(human1);
		add(human2);
		add(lion);
		add(cow);
		add(grain);
		add(transport);
		add(walkthrough);

		add(imagePanel);
		
		add(lPane);
		lPane.add(sky, new Integer(0), 0);
		lPane.add(planets, new Integer(1), 0);
		lPane.add(things, new Integer(2), 0);
		
		
		
		sky.setLayout(null);
		sky.add(skyL);
		
		planets.setLayout(null);
		planets.setOpaque(false);
		planets.add(earth);
		planets.add(mars);
		
		things.setLayout(null);
		things.setOpaque(false);
		things.add(human1L);
		things.add(human2L);
		things.add(lionL);
		things.add(grainL);
		things.add(cowL);
		things.add(scientist);
		
		lPane.setBounds(0, 0, 1765, 750);
		imagePanel.setBounds(750, 75, 1015, 500);
		sky.setBounds(0,0,1765,750);
		skyL.setBounds(0,0,1765,750);
		
		
		planets.setBounds(50,200, 660, 300);
		earth.setBounds(50, 100, 200, 200);
		mars.setBounds(400, 100, earth.getWidth(), earth.getHeight());
		
		things.setBounds(30, 170, 680, 300);
		
		scientist.setLocation(scientistEarth);
		human1L.setLocation(human1Earth);
		human2L.setLocation(human2Earth);
		lionL.setLocation(lionEarth);
		cowL.setLocation(cowEarth);
		grainL.setLocation(grainEarth);
		scientist.setSize(300, 300);
		human1L.setSize(100, 150);
		human2L.setSize(100, 150);
		lionL.setSize(100, 100);
		cowL.setSize(100, 100);
		grainL.setSize(100, 100);
		
		
		about.setSize(100,50);
		instructions.setSize(150,50);
		quit.setSize(100,50);
		about.setLocation(30, 20);
		instructions.setLocation(300, 20);
		quit.setLocation(610, 20);

		stepCount.setSize(225,50);
		stepCount.setLocation(295, 80);
	
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
		
		imageEntities.add(human1L);
		imageEntities.add(human2L);
		imageEntities.add(cowL);
		imageEntities.add(lionL);
		imageEntities.add(grainL);
	}
	
	private void configure()
	{
		stepCount.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		stepCount.setForeground(Color.WHITE);
		
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
		
		imagePanel.change("res/Automaton_q0.png");
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
				if(getEntitySelect() != null && getEntitySelect().size() == 0)
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
			imagePanel.change(file);
		}
	}
	private void update()
	{
		for(int i = 0 ; i < modelEntities.size() ; i++)
		{
			Point p = new Point(0,0);
			
			if(modelEntities.get(i).getPlanet().equals(PLANET.EARTH))
			{
				if(modelEntities.get(i).equals(model.getHuman1()))
					p = human1Earth;
				else if(modelEntities.get(i).equals(model.getHuman2()))
					p = human2Earth;
				else if(modelEntities.get(i).equals(model.getCow()))	
					p = cowEarth;
				else if(modelEntities.get(i).equals(model.getGrain()))
					p = grainEarth;
				else if(modelEntities.get(i).equals(model.getLion()))
					p = lionEarth;
			}

			else
			{
				if(modelEntities.get(i).equals(model.getHuman1()))
					p = human1Mars;
				else if(modelEntities.get(i).equals(model.getHuman2()))
					p = human2Mars;
				else if(modelEntities.get(i).equals(model.getCow()))	
					p = cowMars;
				else if(modelEntities.get(i).equals(model.getGrain()))
					p = grainMars;
				else if(modelEntities.get(i).equals(model.getLion()))
					p = lionMars;
			}

			imageEntities.get(i).setLocation(p);
		}

		
		if(model.getUser().getPlanet().equals(PLANET.EARTH))
		{
			scientist.setLocation(scientistEarth);
			scientist.setIcon(rocketEarth);
		}
			
		else
		{
			scientist.setLocation(scientistMars);
			scientist.setIcon(rocketMars);
		}

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
