package Main;
/**
 * This class extends CrewMember.<br>
 * It is the class for the Mechanic type CrewMember.
 * @author Ryan Beaumont
 *
 */
public class Mechanic extends CrewMember{
	/**
	 * This is the constructor for the Mechanic Class.<br>
	 * This passes the name selected by the player and the String "Mechanic" which is the type.
	 * @param name Name inputed by the player.
	 */
	public Mechanic(String name) {
		super(name, "Mechanic");
	}
	/**
	 * This method overrides the CrewMember.repairShip() method.<br>
	 * It doubles the repair amount.<br>
	 * It checks that the amount after repair is not greater than the maximum 100.<br>
	 * If it is it sets it to the maximum 100.
	 * 
	 * @param ship This is the Ship for the current Crew.
	 */
	public void repairShip(Ship ship) {
		int newShieldLevel = ship.getShieldLevel() + 60;
		if(newShieldLevel > 100) {
			newShieldLevel = 100;
		}
		ship.setShieldLevel(newShieldLevel);
		super.setActions(super.getActions() - 1);
	}
}
