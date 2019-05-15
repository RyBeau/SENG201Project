package Main;
import GUI.*;
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
	private Crew gameCrew;
	/**
	 * This is the number of days for the game to last.
	 */
	private int gameDays;
	/**
	 * This is the current day of the game.
	 */
	private int currentDay;
	/**
	 * This is the planet the game is currently taking place on.
	 */
	private Planet gamePlanet = new Planet();
	/**
	 * This the number of transporter parts that the player needs to collect.
	 */
	private int partsToCollect;
	/**
	 * This is the constructor for this class.<br>
	 * Its sets the initial values of the variables for the class.
	 */
	public GameEnvironment() {
		
	}
	/**
	 * @return The games Crew. (Object)
	 */
	public Crew getGameCrew() {
		return gameCrew;
	}
	/**
	 * This is the getter for partsToCollect.
	 * @return partsToCollect
	 */
	public int getPartsToCollect(){
		return partsToCollect;
	}
	/**
	 * This the the getter for currentDay;
	 * @return currentDay
	 */
	public int getCurrentDay() {
		return currentDay;
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
		member.feed(food, gameCrew);
	}
	/**
	 * This method calls the heal() method of the given CrewMember with the given MedicalItem.
	 * @param member The CrewMember that will be healing.
	 * @param item The MedicalItem that will be consumed.
	 */
	public void heal(CrewMember member, MedicalItem item) {
		member.heal(item, gameCrew);
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
		member.searchPlanet(gameCrew, gamePlanet);
	}
	/**
	 * This method calls the pilotShip() method of the primaryPilot.<br>
	 * Both primaryPilot and secondaryPilot will have their actions decreased by this method.
	 * @param primaryPilot The first CrewMember selected to pilot the ship. Their pilotShip() method is the one that is called.
	 * @param secondaryPilot The second CrewMember selected to pilot the ship.
	 */
	public void pilotShip(CrewMember primaryPilot, CrewMember secondaryPilot) {
		primaryPilot.pilotShip(secondaryPilot, gamePlanet);
	}
	/**
	 * The nextDay method moves the game onto the next day.<br>
	 * It calls all the required nextDay methods of the CrewMembers to decrease their energy and hungerLevel.
	 */
	public void nextDay() {
		ArrayList<CrewMember> crewList = gameCrew.getCrewList();
		for(CrewMember member: crewList) {
			member.nextDay(gameCrew);
		}
	}
	/**
	 * This method launches the Start Screen for the game. (StartWindow object)
	 */
	public void launchStartScreen() {
		StartWindow startScreen = new StartWindow(this);
	}
	/**
	 * This method closes the start screen for the game.<br>
	 * If the player has clicked "Start Game" then the boolean start will be true and the setup window will be launched.<br>
	 * Else the game closes.
	 * @param startScreen This is the StartWindow Object to be closed.
	 * @param start	This is the boolean value for whether to continue setup.
	 */
	public void closeStartScreen(StartWindow startScreen, boolean start) {
		startScreen.closeWindow();
		if(start) {
			launchSetupScreen();
		}
	}
	
	/**
	 * This method launches the Setup Screen for the game. (GameSetup Object)
	 */
	public void launchSetupScreen() {
		GameSetup setupScreen = new GameSetup(this);
	}
/**
 * This method closes the setup screen and re-launches the Start Screen.<br>
 * This version of closeSetupScreen is called when the player presses "Cancel" on the Setup Screen.
 * @param setupScreen The GameSetup Object to be closed.
 */
	public void closeSetupScreen(GameSetup setupScreen) {
		setupScreen.closeWindow();
		launchStartScreen();
	}
	/**
	 * This method closes the setup screen and launches the Crew Selection screen.<br>
	 * This version of closeSetupScreen is called when the player presses "Next" on the Setup Screen.
	 * @param setupScreen The GameSetup Object to be closed.
	 * @param crewName The name for the crew entered by the player.
	 * @param days The number of days selected by the player.
	 * @param numCrew The number of crew selected by the player.
	 */
	public void closeSetupScreen(GameSetup setupScreen, String crewName, int days, int numCrew) {
		setupScreen.closeWindow();
		gameDays = days;
		launchCrewSelection(crewName, numCrew);
	}
	/**
	 * This method launches the Crew Selection screen.<br>
	 * It passes crewName and numCrew as they are needed for the construction of GUI.
	 * @param crewName Name of the crew given by the player.
	 * @param numCrew Number of Crew Members selected by the player.
	 */
	public void launchCrewSelection(String crewName, int numCrew){
		CrewSelection selectionScreen = new CrewSelection(this, crewName, numCrew);
	}
	/**
	 * This method closes the setup screen and re-launches the Setup Screen.<br>
	 * @param selectionScreen The CrewSelection object to be closed.
	 */
	public void closeCrewSeletion(CrewSelection selectionScreen) {
		selectionScreen.closeWindow();
		launchSetupScreen();
	}
	
	/**
	 * This method is called by the CrewSelection class after the names and CrewMember types have been selected by the player.<br>
	 * It loops through the lists as the name and type are in the same index in each list.<br>
	 * The switch statement is used to call the correct CrewMember type constructor.
	 * @param selectionScreen The CrewSelection Object that needs to be closed.
	 * @param crewName The name of the Crew given by the player.
	 * @param nameList The list of names for each Crew Member.
	 * @param typeList The list of Crew Member types for each crew member.
	 */
	public void createCrew(CrewSelection selectionScreen, String crewName,ArrayList<String> nameList, ArrayList<String> typeList) {
		selectionScreen.closeWindow(); //Closing the CrewSelection object.
		ArrayList<CrewMember> crewList = new ArrayList<CrewMember>(); //Initialising the list of CrewMembers.
		CrewMember member = null; //Temp variable initialised to null to prevent error.
		for(int i = 0; i < nameList.size(); i++) { //Loops through length of lists
			String type = typeList.get(i);
			switch(type){//Uses switch statement to create each CrewMember using the selected type and name.
			case "Medic":
				member = new Medic(nameList.get(i)); break;
			case "Mechanic":
				member = new Mechanic(nameList.get(i)); break;
			case "Marathon":
				member = new Marathon(nameList.get(i)); break;
			case "Scavenger":
				member = new Scavenger(nameList.get(i)); break;
			case "Survivalist":
				member = new Survivalist(nameList.get(i)); break;
			case "Tank":
				member = new Tank(nameList.get(i)); break;
			}
			crewList.add(member);
		}
		gameCrew = new Crew(crewName, crewList); //Creates the gameCrew.
		setupGame(); //Calls final setup method.
	}
	/**
	 * Sets the number of parts to be collected.<br>
	 * The calls the main game loop.<br>
	 */
	public void setupGame() {
		partsToCollect = (gameDays * 2) / 3;
		currentDay = 1;
		launchGame();
	}
	/**
	 * The main loop for the game.
	 */
	public void launchGame() {
		GameWindow gameWindow = new GameWindow(this, gameCrew);
	}
	
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
		game.launchStartScreen();
	}

}
