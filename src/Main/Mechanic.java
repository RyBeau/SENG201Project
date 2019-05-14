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
	
	public void repairShip(Ship ship) {
		if(hasActions()) {
			ship.setShieldLevel((ship.getShieldLevel() + 60) % 100);
			super.setActions(super.getActions() - 1);
		}else {
			sendAlert("No actions left for this crew member!");
		}
	}
	/**
	 * The toString method for CrewMember subclasses provides a short description of the crew member type.
	 * @return A short description of the crew member type.
	 */
	public String toString() {
		return "The Mechanic has an increased ability to repair the ship.";
	}
}
