package Main;
/**
 * This is the parent class for each of the different types of crew members within the game.<br>
 * Each of type of crew member extends this class.<br>
 * @author Ryan Beaumont
 */
public class CrewMember {
	/**
	 * The name of a crew member.
	 */
	private String memberName;
	/**
	 * The health level of a crew member.
	 */
	private int memberHealth = 100;
	/**
	 * The hunger level of a crew member.
	 */
	private int memberHunger = 100;
	/**
	 * The energy of a crew member.
	 */
	private int memberEnergy = 100;
	/**
	 * Does the crew member have the space plague.
	 */
	private boolean hasPlague = false;
	/**
	 * The default builder for the class.
	 * @param name Name of the crew member given by player.
	 */
	public CrewMember(String name){
		memberName = name;
	}
	/**
	 * Sets the memberHealth variable to a given amount.
	 * @param health The value to set memberHealth to.
	 */
	public void setHealth(int health) {
		memberHealth = health;
	}
	/**
	 * Sets the memberHunger variable to a given amount.
	 * @param hunger The value to set memberHunger to.
	 */
	public void setHunger(int hunger) {
		memberHunger = hunger;
	}
	/**
	 * Sets the memberEnergy variable to a given amount.
	 * @param energy The value to set memberEnergy to.
	 */
	public void setEnergy(int energy) {
		memberEnergy = energy;
	}
	/**
	 * Outputs a string that shows the status of a crew member.<br>
	 * Includes memberName, memberHealth, memberHunger, memberEnergy variables.<br>
	 */
	public String toString() {
		return "Status of Crew Member " + memberName + ":\nHealth Level: " + memberHealth + "\nHunger Level: " + memberHunger + "\nTiredness Level: " + memberEnergy;
	}
	
	public static void main(String[] args) {
		CrewMember test = new CrewMember("Ryan");
		System.out.println(test);
	}
}
