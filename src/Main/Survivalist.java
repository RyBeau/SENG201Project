package Main;
/**
 * This class extends the CrewMember Class.
 * It is the class for the "Survivalist" type CrewMember.
 * @author Ryan Beaumont
 *
 */
public class Survivalist extends CrewMember {
	/**
	 * This is the constructor for the Survivalist Class.<br>
	 * This passes the name selected by the player and the String "Survivalist" which is the type to the parent class CrewMember.<br>
	 * It also passes the integer value for the Survivalist types' decreased hunger use each day.
	 * @param name Name inputed by the player.
	 */
	public Survivalist(String name) {
		super(name, 20, "Survivalist");
	}
}
