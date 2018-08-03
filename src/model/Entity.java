package model;

import enums.PLANET;
import enums.STATUS;

public class Entity {
	private String name;
	private PLANET planet;
	private STATUS status;
	
	public Entity(String name)
	{
		this.name = name;
		planet = PLANET.EARTH;
		status = STATUS.ALIVE;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}

	public PLANET getPlanet() {
		return planet;
	}

	public void setPlanet(PLANET planet) {
		this.planet = planet;
	}

	public STATUS getStatus() {
		return status;
	}

	public void setStatus(STATUS status) {
		this.status = status;
	}
	
	
}
