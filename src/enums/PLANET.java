package enums;

public enum PLANET {
	EARTH, MARS;
	
	public String toString()
	{
		switch(this)
		{
			case EARTH: return "Earth";
			case MARS: return "Mars";
			default: return "Unknown";
		}
	}
}
