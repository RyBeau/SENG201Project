package Main;
import java.util.ArrayList;
/**
 * This class implements the crew for the game.<br>
 * All crew information is stored within this class.<br>
 * 
 * @author Ryan Beaumont
 */
public class Crew {
	/**
	 * The name of the crew
	 */
	private String crewName;
	/**
	 * The crew's ship
	 */
	private Ship crewShip = new Ship();
	/**
	 * List of all the living crew members within the crew
	 */
	private ArrayList<CrewMember> crewList;
	/**
	 * List of all the Medical items that the Crew currently has.
	 */
	private ArrayList<MedicalItem> crewMedicalItems = new ArrayList<MedicalItem>();
	/**
	 * List of all Food items that the Crew currently has.
	 */
	private ArrayList<FoodItem> crewFoodItems = new ArrayList<FoodItem>();
	/**
	 * The amount of money that the crew has for spending at the outpost.
	 */
	private int crewMoney = 1000;
	
	
	/**
	 * Initialises the crew.
	 * @param name Name of the crew given by player.
	 * @param members Array list containing each of the crew member objects.
	 */
	public Crew(String name, ArrayList<CrewMember> members) {
		crewName = name;
		crewList = members;
	}
	
	/**
	 * @return The crew's name.
	 */
	
	public String getCrewName() {
		return crewName;
	}
	/**
	 * @return The crew's ship. (Ship object)
	 */
	public Ship getCrewShip() {
		return crewShip;
	}
	/**
	 * @return The list of crew members (CrewMember objects).
	 */
	public ArrayList<CrewMember> getCrewList(){
		return crewList;
	}
	/**
	 * @return The list of the crew's medical items (MedicalItem Objects)
	 */
	public ArrayList<MedicalItem> getMedicalItems(){
		return crewMedicalItems;
	}
	/**
	 * This method adds a given medical item to the crewMedicalItems ArrayList.
	 * @param item A MedicalItem
	 */
	public void addToInventory(MedicalItem item) {
		crewMedicalItems.add(item);
	}
}
