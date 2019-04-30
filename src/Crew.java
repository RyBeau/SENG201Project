import java.util.ArrayList;

public class Crew {
	private String crewName;
	private Ship crewShip;
	private ArrayList<CrewMember> crewList;
	private ArrayList<Item> crewInventory = new ArrayList<Item>();
	private int crewMoney = 1000;
	
	public Crew(String name, Ship ship, ArrayList<CrewMember> members) {
		crewName = name;
		crewShip = ship;
		crewList = members;
		crewInventory = inventory;
	}
	
	public String getCrewName() {
		return crewName;
	}
	
	public Ship getCrewShip() {
		return crewShip;
	}
	
	public ArrayList<CrewMember> getCrewList(){
		return crewList
	}
	
	public ArrayList<Item> getInventory(){
		return crewInventory;
	}
	
	public void addToInventory(Item) {
		crewInventory.add(Item);
	}
}
