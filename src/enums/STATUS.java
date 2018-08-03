package enums;

public enum STATUS {
	ALIVE, DEAD;
	
	public String toString()
	{
		switch(this) 
		{
			case ALIVE: return "Alive";
			case DEAD: return "Dead";
			default: return "Unknown";
		}
	}
}
