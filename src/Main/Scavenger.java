package Main;
import java.util.Random;

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
	private Random RNG = new Random();
	
	public Scavenger(String name) {
		super(name,"Scavenger");
	}
	/**
	 * This method overrides CrewMember.searchPlanet().<br>
	 * It increases the chances of finding transporter parts when searching the planet.<br>
	 * 0-55: Transporter Part if there is one on the planet still.<br>
	 * 56-75: A random MedicalItem or FoodItem. foundItem() called.<br>
	 * 76-100: A random amount of money between 1-500 is found.
	 */
	public void searchPlanet(Crew crew, Planet planet) {
		if(hasActions()) {
			if(hasActions()) {
				String alertMessage = "Whilst Searching the planet" + super.getName() + " found: ";
				int roll = RNG.nextInt(100);
				if(roll <= 55) {//need check planet parts
					crew.setPartsFound(crew.getPartsFound() + 1);
					//Set transporter parts
					alertMessage += "1 Transporter Part";
				}else if(roll <= 75) {
					alertMessage += super.foundItem(crew);
				}else {
					int moneyFound = RNG.nextInt(450) + 50;//50 added as the integer can be 450 is the biggest value as 50 will be added.
					crew.setMoney(crew.getMoney() + moneyFound);
					alertMessage += "$" + moneyFound;
				}
				sendAlert(alertMessage);
			}else {
				sendAlert("No actions left for this crew member!");
			}
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
