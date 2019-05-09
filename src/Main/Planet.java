package Main;

/**
 * This class defines a Planet.
 * @author Daniel Porter
 * 
 */

public class Planet {
	/**
	 * The amount of transporter parts on the planet.
	 * Can only have 1 or 0.
	 */
	private int planetTransporterParts;
	/**
	 * Every planet has an Outpost.
	 */
	private Outpost planetOutpost;
	
	public Planet() {
		planetOutpost = new Outpost();
		planetTransporterParts = 1;
	}
	/**
	 * Sets planetTransporterParts to 1. <br>
	 * (There will always be 1 transporter part on a new planet.)
	 */
	public void NewPlanet() {
		planetTransporterParts = 1;
	}

}
