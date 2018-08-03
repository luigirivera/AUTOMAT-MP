package model;

import enums.PLANET;
import enums.STATUS;

public class Entity {
	private PLANET planet;
	private STATUS status;
	
	public Entity()
	{
		planet = PLANET.EARTH;
		status = STATUS.ALIVE;
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
