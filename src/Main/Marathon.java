package Main;
/**
 * This class extends the CrewMember Class.
 * It is the class for the "Marathon" type CrewMember.
 * @author Ryan Beaumont
 *
 */
public class Marathon extends CrewMember {
	/**
	 * This is the constructor for the Marathon Class.<br>
	 * This passes the name selected by the player and the String "Marathon" which is the type to the parent class CrewMember.<br>
	 * It also passes the integer value for the Marathon types' decreased energy use each day.
	 * @param name Name inputed by the player.
	 */
	public Marathon(String name) {
		super(20, name, "Marathon");
	}
	/**
	 * The toString method for CrewMember subclasses provides a short description of the crew member type.
	 * @return A short description of the crew member type.
	 */
	public String toString() {
		return "The Marathon type has increased endurance, their energy levels decrease less than other types.";
	}
}
