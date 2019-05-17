package Main;
import GUI.*;
import java.util.Random;
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
	private Planet gamePlanet;
	/**
	 * This the number of transporter parts that the player needs to collect.
	 */
	private int partsToCollect;
	/*
	 * This is the main screen that plays the game.
	 */
	private GameWindow gameWindow;
	/**
	 * This is the randomNumberGenerator used for the Random Event chances.
	 */
	private Random randomNumberGenerator = new Random();
	/**
	 * This is the constructor for this class.<br>
	 * Its sets the initial values of the variables for the class.
	 */
	public GameEnvironment() {
		gamePlanet = new Planet();
		launchStartScreen();
	}
	/**
	 * @return The games Crew. (Object)
	 */
	public Crew getGameCrew() {
		return gameCrew;
	}
	/**
	 * The getter for gamePlanet.
	 * @return gamePlanet
	 */
	public Planet getGamePlanet() {
		return gamePlanet;
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
		member.searchPlanet(gameCrew, gamePlanet, this);
	}
	/**
	 * This method calls the pilotShip() method of the primaryPilot.<br>
	 * Both primaryPilot and secondaryPilot will have their actions decreased by this method.
	 * @param primaryPilot The first CrewMember selected to pilot the ship. Their pilotShip() method is the one that is called.
	 * @param secondaryPilot The second CrewMember selected to pilot the ship.
	 */
	public void pilotShip(CrewMember primaryPilot, CrewMember secondaryPilot) {
		primaryPilot.pilotShip(secondaryPilot, gamePlanet, gameCrew.getCrewShip());
	}
	
	/**
	 * This method is for the Random Event where the gameCrew Contracts the space plague.<br>
	 * It is called by the nextDay() method when the random number generator gives a value from 0-25.<br>
	 * It sets the hasPlague variable in each CrewMember to true as they have now contracted the space plague.<br>
	 * It then sends an alert telling the player what has occurred.
	 */
	public void spacePlague() {
		for(CrewMember member: gameCrew.getCrewList()) {
			member.setPlague(true);
		}
		new Alert("The crew has contracted the space plague! They need the Plague Cure!");
	}
	
	/**
	 * This is the method for the Random Event where space pirates steal a random FoodItem from the gameCrew.<br>
	 * This method is called by the nextDay() method when the random number generator gives a value from 26-38.<br>
	 * Firstly it checks the case that there is only one item in the list, and if true that item is removed.<br>
	 * Otherwise it uses randomNumberGenerator to select a random index in foodList.<br>
	 * The item at that index is then removed.<br>
	 * It then sends an alert telling the player what has occurred.
	 */
	public void spacePirates(ArrayList<FoodItem> foodList) {
		String alertString = "The Space Pirates raided your ship! They stole: ";
		FoodItem itemRemoved;
		if(foodList.size() == 1) {
			itemRemoved = foodList.get(0);
		}else {
			itemRemoved = foodList.get(randomNumberGenerator.nextInt(foodList.size() - 1));
		}
		gameCrew.removeFromFoodItems(itemRemoved);
		new Alert(alertString + itemRemoved);
	}
	
	/**
	 * This is the method for the Random Event where space pirates steal a random MedicalItem from the gameCrew.<br>
	 * This method is called by the nextDay() method when the random number generator gives a value from 38-50.<br>
	 * Firstly it checks the case that there is only one item in the list, and if true that item is removed.<br>
	 * Otherwise it uses randomNumberGenerator to select a random index in medicalList.<br>
	 * The item at that index is then removed.<br>
	 * It then sends an alert telling the player what has occurred.
	 */
	public void spacePirates(MedicalItem[] medicalList) {
		String alertString = "The Space Pirates raided your ship! They stole: ";
		MedicalItem itemRemoved;
		if(medicalList.length == 1) {
			itemRemoved = medicalList[0];
		}else {
			itemRemoved = medicalList[randomNumberGenerator.nextInt(medicalList.length - 1)];
		}
		gameCrew.removeFromMedicalItems(itemRemoved);
		new Alert(alertString + itemRemoved);
	}
	
	/**
	 * The nextDay method moves the game onto the next day.<br>
	 * It firsts sets roll to a random integer from 0-100 using randomNumberGenerator.<br>
	 * If roll is 0-25 then spacePlague() is called.<br>
	 * If roll is 26-38 and crewFoodItems has at least one FoodItem in it then spacePirates(ArrayList<FoodItem> foodList) is called.<br>
	 * If roll is 38-50 and crewMedicalItems has at least one MedicalItem in it then spacePirates(MedicalItem[] medicalList) is called.<br>
	 * The crewMedicalItems ArrayList is converted to an Array so that the spacePirate method can be overloaded.<br>
	 * After that it calls all the required nextDay methods of the CrewMembers to decrease their energy and hungerLevel.<br>
	 * Finally it iterates the currentDay variable and calls checkGameOver() to see if any end conditions have been met.
	 */
	public void nextDay() {
		int roll = randomNumberGenerator.nextInt(100);
		if(roll <= 25) {
			spacePlague();
		}else if(roll <= 38 && gameCrew.getFoodItems().size() > 0) {
			spacePirates(gameCrew.getFoodItems());
		}else if (roll <= 50 && gameCrew.getMedicalItems().size() > 0) {
			spacePirates(gameCrew.getMedicalItems().toArray(new MedicalItem[gameCrew.getMedicalItems().size()]));
		}
		ArrayList<CrewMember> crewList = new ArrayList<CrewMember>(gameCrew.getCrewList());
		for(CrewMember member: crewList) {
			member.nextDay(gameCrew);
		}
		currentDay += 1;
		if(checkGameOver()) {
			gameOver();
		}else {
			gameWindow.refresh();
		}
	}
	/**
	 * This method checks if any of the conditions for the game ending have been met.<br>
	 * Conditions Checked:<br>
	 * currentDay > gameDays -> All days have been completed.<br>
	 * partsToCollect == partsFound -> All parts have been found.<br>
	 * crewList.size() == 0 -> All CrewMembers are dead.<br>
	 * @return
	 */
	public Boolean checkGameOver() {
		Boolean isOver = false;
		if(currentDay > gameDays) {
			isOver = true;
		}else if(partsToCollect == gameCrew.getPartsFound()) {
			isOver = true;
		}else if(gameCrew.getCrewList().size() == 0) {
			isOver = true;
		}
		return isOver;
	}
	
	/**
	 * This method ends the game.
	 */
	public void gameOver() {
		gameWindow.closeWindow();
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
		gameWindow = new GameWindow(this, gameCrew);
	}
	/**
	 * The main method that creates the controlling instance of GameEnvironment.
	 * @param args
	 */
	public static void main(String[] args) {
		GameEnvironment game = new GameEnvironment();
	}

}
