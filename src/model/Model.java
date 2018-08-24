package model;

public class Model {
	private User user;
	private Human human1, human2;
	private Cow cow;
	private Lion lion;
	private Grain grain;
	
	public Model()
	{
		user = new User();
		human1 = new Human();
		human2 = new Human();
		lion = new Lion();
		cow = new Cow();
		grain = new Grain();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Human getHuman1() {
		return human1;
	}

	public void setHuman1(Human human1) {
		this.human1 = human1;
	}

	public Human getHuman2() {
		return human2;
	}

	public void setHuman2(Human human2) {
		this.human2 = human2;
	}

	public Cow getCow() {
		return cow;
	}

	public void setCow(Cow cow) {
		this.cow = cow;
	}

	public Lion getLion() {
		return lion;
	}

	public void setLion(Lion lion) {
		this.lion = lion;
	}

	public Grain getGrain() {
		return grain;
	}

	public void setGrain(Grain grain) {
		this.grain = grain;
	}
}
