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
	private Planet earth, mars;
	private JLabel location, human1txt, human2txt, cowtxt, liontxt, graintxt, earthtxt, marstxt;
	
	private final String earthLoc = "You are in Earth";
	private final String marsLoc = "You are in Mars";
	
	private final int inEarthX = 175;
	private final int inMarsX = 535;
	
	private ArrayList<JCheckBox> entities;
	private ArrayList<Entity> modelEntities;
	private ArrayList<JLabel> textEntities;
	
	private Model model;
	private Frame frame;
	
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
		
		entities = new ArrayList<JCheckBox>();
		modelEntities = new ArrayList<Entity>();
		textEntities = new ArrayList<JLabel>();
	}
	
	private void initialize()
	{
		this.getContentPane().setBackground(new Color(100,100,200));
		
		add(about);
		add(instructions);
		add(quit);
		
		add(location);
		
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
		earth.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		mars.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		location.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
		location.setForeground(Color.WHITE);
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
	}
	

	
	private void addListeners()
	{
		about.addActionListener(new AboutListener());
		quit.addActionListener(new QuitListener());
		transport.addActionListener(new TransportListener());
	}
	
	class AboutListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(frame, "<html>This program is for compliance for AUTOMAT S18 Machine Project<br><br>Members:<br>Miguel Llamas<br>Brian Poblete<br>Louie Rivera</html>", "About", JOptionPane.INFORMATION_MESSAGE);
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
					JOptionPane.showMessageDialog(frame, "That living thing is not in the planet you are in.", "Missing Living Thing", JOptionPane.ERROR_MESSAGE);
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
		}
	}
	
	private void update()
	{
		for(int i = 0 ; i < modelEntities.size() ; i++)
		{
			int Y = textEntities.get(i).getY();
			if(modelEntities.get(i).getPlanet().equals(PLANET.EARTH))
				textEntities.get(i).setLocation(inEarthX, Y);
			else
				textEntities.get(i).setLocation(inMarsX, Y);
		}
		
		if(model.getUser().getPlanet().equals(PLANET.EARTH))
			location.setText(earthLoc);
		else
			location.setText(marsLoc);
		
		clearEntitySelect();

	}
}
