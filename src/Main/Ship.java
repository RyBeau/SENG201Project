package Main;
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

}