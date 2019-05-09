package Main;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * This is the main controlling class for the game.<br>
 * It implements the logic needed for the game to be played.<br>
 * The main() method is contained within this class.
 * @author Ryan Beaumont
 * @author Daniel Porter
 *
 */
public class GameEnvironment {
	/**
	 * This is the Crew of the game session.
	 */
	private static Crew gameCrew;
	/**
	 * This is the number of days for the game to last.
	 */
	private int gameDays;
	/**
	 * This is the planet the game is currently taking place on.
	 */
	private Planet gamePlanet = new Planet();
	/**
	 * This is the constructor for this class.<br>
	 * Its sets the intial values of the variables for the class.
	 * @param crew The crew created by the player.
	 * @param days The number of days the player has selected for the game to last.
	 */
	public GameEnvironment(Crew crew, int days) {
		gameCrew = crew;
		gameDays = days;
	}
	/**
	 * @return The games Crew. (Object)
	 */
	public static Crew getGameCrew() {
		return gameCrew;
	}
	/**
	 * Visits the outpost, and displays the items purchasable at the outpost.
	 */
	public void visitOutpost() {
		
	}
	/**
	 * This method calls the feed() method of the given CrewMember with the given FoodItem.
	 * @param member The CrewMember that will be consuming the food.
	 * @param food The FoodItem to be consumed.
	 */
	public void feed(CrewMember member, FoodItem food) {
		member.feed(food);
	}
	/**
	 * This method calls the heal() method of the given CrewMember with the given MedicalItem.
	 * @param member The CrewMember that will be healing.
	 * @param item The MedicalItem that will be consumed.
	 */
	public void heal(CrewMember member, MedicalItem item) {
		member.heal(item);
	}
	/**
	 * This method calls the sleep() method of the given CrewMember.<br>
	 * This will increase their energy.
	 * @param member The CrewMember that will be sleeping.
	 */
	public void sleep(CrewMember member) {
		member.sleep();
	}
	/**
	 * This method call the repairShip() method of the given CrewMember.<br>
	 * This will increase the ship's shield level.
	 * @param member The CrewMember that will be repairing the ship.
	 */
	public void repairShip(CrewMember member) {
		member.repairShip(gameCrew.getCrewShip());
	}
	/**
	 * This method calls the searchPlanet() method of the given CrewMember.
	 * @param member The CrewMember that will be searching the planet.
	 */
	public void searchPlanet(CrewMember member) {
		member.searchPlanet();
	}
	/**
	 * This method calls the pilotShip() method of the primaryPilot.<br>
	 * Both primaryPilot and secondaryPilot will have their actions decreased by this method.
	 * @param primaryPilot The first CrewMember selected to pilot the ship. Their pilotShip() method is the one that is called.
	 * @param secondaryPilot The second CrewMember selected to pilot the ship.
	 */
	public void pilotShip(CrewMember primaryPilot, CrewMember secondaryPilot) {
		primaryPilot.pilotShip(secondaryPilot);
	}
	/**
	 * The nextDay method moves the game onto the next day.<br>
	 * It calls all the required nextDay methods of the CrewMembers to decrease their energy and hungerLevel.
	 */
	public void nextDay() {
		ArrayList<CrewMember> crewList = gameCrew.getCrewList();
		for(CrewMember member: crewList) {
			member.nextDay();
		}
	}
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("How Many days should the game last? ");
		int days = reader.nextInt();
		System.out.println("How many crew members? ");
		int numCrew = reader.nextInt();
		ArrayList<CrewMember> members = new ArrayList<CrewMember>();
		for(int x = 0; x < numCrew; x++) {
			System.out.println("Name: ");
			String memberName = reader.next();
			System.out.println("1. Mechanic\n 2. Medic\n3. Scavenger");
			int i = reader.nextInt();
			switch(i) {
			case 1:
				members.add(new Mechanic(memberName));
			break;
			case 2:
				members.add(new Medic(memberName));
			break;
			case 3:
				members.add(new Scavenger(memberName));
			break;
			}
		}
		System.out.println("Enter Crew Name: ");
		String name = reader.next();
		Crew crew = new Crew(name, members);
		GameEnvironment game = new GameEnvironment(crew, days);
		for(CrewMember i: members) {
			System.out.println(i);
			System.out.println();
		}
		reader.close();
		
		PlagueCure cure = new PlagueCure();
		cure.purchase();
		System.out.println(gameCrew);
		
	}
}
