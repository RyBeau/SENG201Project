package Main;
/**
 * This class extends the CrewMember Class.
 * It is the class for the "Tank" type CrewMember.
 * @author Ryan Beaumont
 *
 */
public class Tank extends CrewMember {
	/**
	 * This is the constructor for the Tank Class.<br>
	 * This passes the name selected by the player and the String "Tank" which is the type to the parent class CrewMember.<br>
	 * It also passes the integer value for the Tank types' increased maximum health level.
	 * @param name Name inputed by the player.
	 */
	public Tank(String name) {
		super(name, "Tank", 175);
	}
	/**
	 * The toString method for CrewMember subclasses provides a short description of the crew member type.
	 * @return A short description of the crew member type.
	 */
	public String toString() {
		return "The Tank type has an increased maximum health level over other types.";
	}
}
