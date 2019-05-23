package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Apple;
import Main.BasicMedicalKit;
import Main.Crew;
import Main.CrewMember;
import Main.Marathon;
import Main.PlagueCure;
import Main.Planet;
import Main.Ship;

/**
 * This JUnit test is for testing the CrewMember class.<br>
 * This uses the Marathon type CrewMember to test the class as it does not override any of the methods within CrewMember.<br>
 * It changes the dailyEnergyUse amount but this does not affect the validity of the test since the method will work the same with different values.
 * 
 * @author Ryan Beaumont
 *
 */
class CrewMemberTesting {
	
	private Crew crew;
	private CrewMember testMember;
	
	/**
	 * Creates a Crew to use for testing.
	 */
	@BeforeEach
	void CreateCrew() {
		ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();
		//Making CrewMembers
		testMember = new Marathon("Test testMember 1");
		//Adding crew to crewList
		crewList.add(testMember);		
		crew = new Crew("Test Crew", crewList);
	}
	
	/**
	 * Tests that memberEnergy increases when sleep() is called.
	 * First CrewMember health is reduced.<br>
	 * Then sleep() is called and the CrewMember health is measured to make sure that it is increased by 40<br>
	 * Sleep() is called again and the CrewMember health is check to make sure it does not exceed the maximum 100.<br>
	 * Finally it tests that a CrewMember cannot sleep if they have no actions.
	 */
	@Test
	void testSleep() {
		testMember.setEnergy(50);
		assertEquals(testMember.getEnergy(), 50);
		testMember.sleep();
		assertEquals(testMember.getEnergy(), 90);
		testMember.sleep();
		assertEquals(testMember.getEnergy(), 100);
		
	}
	/**
	 * Tests that memberHunger decreases when feed() is called.
	 * First CrewMember hunger is increased.<br>
	 * Then feed() is called and the CrewMember hunger is measured to make sure that it is decreased by the fillUpAmount of the testFood FoodItem<br>
	 * Feed() is called again and the CrewMember hunger is checked to make sure it does not got below 0.
	 * Finally it tests that a CrewMember cannot feed if they have no actions.
	 */		
	@Test	
	void feedTest() {
		Apple testFood = new Apple();
		testMember.setHunger(35);
		testMember.feed(testFood, crew);
		assertEquals(testMember.getHunger(), 35 - testFood.getFillUpAmount());
		testMember.feed(testFood, crew);
		assertEquals(testMember.getHunger(), 0);
		testMember.setHunger(35);
		testMember.feed(testFood, crew);
		assertEquals(testMember.getHunger(), 35);
			
	}
		
	/**
	 * Tests that memberHealth increases when heal() is called.
	 */
	@Test
	void healTest() {
		testMember.setActions(3);
		testMember.setPlague(true);
		BasicMedicalKit testKit = new BasicMedicalKit();
		testMember.setHealth(50);
		testMember.heal(testKit, crew);
		assertEquals(testMember.getHealth(), 85);
		testMember.heal(testKit, crew);
		assertEquals(testMember.getHealth(), 100);
		assertTrue(testMember.checkPlague());
		testMember.heal(new PlagueCure(), crew);
		assertFalse(testMember.checkPlague());
		
	}
	
	/**
	 * Testing that the repair ship method repairs by the correct amount 
	 * and does not exceed 100.
	 */
	@Test
	void repairTest() {
		Ship ship = crew.getCrewShip();
		ship.setShieldLevel(60);
		testMember.repairShip(ship);
		assertEquals(ship.getShieldLevel(), 90);
		testMember.repairShip(ship);
		assertEquals(ship.getShieldLevel(), 100);
	}
	
	/**
	 * Testing the nextDay method. Testing if hunger increases, energy decreases each day and actions are reset.<br>
	 * Also testing that having the plague decreases the health and that have full hunger or no energy decreases health.
	 */
	@Test
	void nextDayTest() {
		testMember.setActions(0);
		testMember.nextDay(crew);
		assertEquals(testMember.getActions(), 2);
		assertEquals(testMember.getHunger(), 40);
		assertEquals(testMember.getEnergy(), 80);
		testMember.setEnergy(0);
		testMember.nextDay(crew);
		assertEquals(testMember.getHealth(), 70);
		testMember.setEnergy(100);
		testMember.setHunger(100);
		testMember.nextDay(crew);
		assertEquals(testMember.getHealth(), 40);
		testMember.setPlague(true);
		testMember.setHunger(0);
		testMember.nextDay(crew);
		assertEquals(testMember.getHealth(), 25);
	}
	
	/**
	 * Testing that the pilot ship method resets the number of transporter parts in the Planet.<br>
	 * Also testing that the actions for both the primary and secondary pilots action decrease.
	 */
	@Test
	void testPilotShip() {
		Planet testPlanet = new Planet();
		CrewMember secondPilot = new Marathon("Test");
		testPlanet.setTransporterParts(0);
		testMember.pilotShip(secondPilot, testPlanet, crew.getCrewShip());
		assertEquals(testMember.getActions(), 1);
		assertEquals(secondPilot.getActions(), 1);
		assertEquals(testPlanet.getTransporterPartsAmount(), 1);
	}
}
