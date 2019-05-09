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
	public void addToMedicalItems(MedicalItem item) {
		crewMedicalItems.add(item);
	}
	/**
	 * This method removes a given MedicalItem from the crewMedicalItems ArrayList.
	 * @param item The MedicalItem to be removed.
	 */
	public void removeFromMedicalItems(MedicalItem item) {
		crewMedicalItems.remove(item);
	}
	/**
	 * This method adds a given food item to the crewFoodItems ArrayList.
	 * @param food The FoodItem to be added.
	 */
	public void addToFoodItems(FoodItem food) {
		crewFoodItems.add(food);
	}
	/**
	 * This method removes a given food item from the crewFoodItems ArrayList.
	 * @param food The FoodItem to be removed.
	 */
	public void removeFromFoodItems(FoodItem food) {
		crewFoodItems.remove(food);
	}
	/**
	 * 
	 * @return The list of the crew's food items (FoodItem Objects)
	 */
	public ArrayList<FoodItem> getFoodItems(){
		return crewFoodItems;
	}
	/**
	 * This method removes a given crew member from the crew.
	 * @param member The member to be removed from the crew.
	 */
	public void removeCrewMember(CrewMember member) {
		crewList.remove(member);
	}
	/**
	 * @return The int crewMoney variable;
	 */
	public int getMoney() {
		return crewMoney;
	}
	/**
	 * This method sets the crewMoney variable to the given integer amount.
	 * @param money The integer amount for money to be set to.
	 */
	public void setMoney(int money) {
		crewMoney = money;
	}
}
