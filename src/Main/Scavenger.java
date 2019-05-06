package Main;

/**
 * This class extends CrewMember.<br>
 * It is the class for the Scavenger type CrewMember.
 * @author Ryan Beaumont
 *
 */
public class Scavenger extends CrewMember{
	/**
	 * This is the constructor for the Scavenger Class.<br>
	 * This passes the name selected by the player and the String "Scavenger" which is the type to the parent class CrewMember.
	 * @param name Name inputed by the player.
	 */
	public Scavenger(String name) {
		super(name,"Scavenger");
	}
	/**
	 * This method overrides CrewMember.searchPlanet().<br>
	 * It increases the chances of finding items when searching the planet.<br>
	 * 
	 */
	public void searchPlanet() {
		if(hasActions()) {
			//To be done.
		}else {
			System.out.println("No actions left for this crew member!");
		}
	}
	/**
	 * The toString method for CrewMember subclasses provides a short description of the crew member type.
	 * @return A short description of the crew member type.
	 */
	public String toString() {
		return "The Scavenger has increased luck. When searching the planet a Scavenger is more likely to find items.";
	}
}
