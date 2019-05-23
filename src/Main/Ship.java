package Main;

import java.util.Random;

/**
 * This class defines a Ship. It is used by the Crew to travel between Planets in the game.
 * @author Daniel Porter
 *
 */
public class Ship {
	/**
	 * This is the shield level for the ship.<br>
	 * It changes when the ship takes damage or is repaired.
	 */
	private int shieldLevel;
	/**
	 * This is the constructor for Ship.<br>
	 * It initialises the shieldLevel to the starting amount 100.
	 */
	public Ship() {
		shieldLevel = 100;
	}
	/**
	 * This method is the getter for shield level.
	 * @return shieldLevel
	 */
	public int getShieldLevel() {
		return shieldLevel;
	}
	/**
	 * Sets int shieldLevel to int newLevel
	 * @param newLevel
	 */
	public void setShieldLevel(int newLevel) {
		shieldLevel = newLevel;
	}
	
	/**
	 * This method is for the random event "Asteroid field"<br>
	 * It is called if the randomNumberGenerator pick 0-35 in the pilotShip() method.<br>
	 * The damage taken is a random integer from randomNumberGenerator between 0-90 + 10, the + 10 is needed so that the minimum damage is 10
	 * and the maximum damage is 100.<br>
	 * If damage is greater than currentLevel then the shield level is set to 0 and the Ship cannot be used again until it is repaired.
	 * @param ship The Crew's ship.
	 * 
	 * @return A String saying the event has occurred and the damage it caused.
	 */
	public String asteroidField() {
		int currentLevel = shieldLevel;
		Random randomNumberGenerator = new Random();
		int damage = randomNumberGenerator.nextInt(90) + 10;
		if(damage > currentLevel) {
			shieldLevel = 0;
		}else {
			shieldLevel = currentLevel - damage;
		}
		return "\nWhilst travelling to the new planet the ship went through and asteroid field. The Shields took " + damage + " damage.";
	}

}