package Main;
/**
 * This class defines a Ship.
 * @author Daniel Porter
 *
 */
public class Ship {
	/**
	 * Ship has a shield level that decreases when
	 * the ship has taken damage.<br>
	 * Shield increases (cap of 100) upon repair.
	 * 
	 */
	private int shieldLevel;
	/**
	 * The ship starts with the max shieldLevel, 100.
	 */
	public Ship() {
		shieldLevel = 100;
	}
	/**
	 * @return shieldLevel
	 */
	public int getShieldLevel() {
		return shieldLevel;
	}
	/**
	 * sets int shieldLevel to int newLevel
	 * @param newLevel
	 */
	public void setShieldLevel(int newLevel) {
		shieldLevel = newLevel;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}