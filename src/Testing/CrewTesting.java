package Testing;

import static org.junit.jupiter.api.Assertions.*;
import Main.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
class CrewTesting {

	private ArrayList<CrewMember> crewList;
	private Crew crew;
	
	/**
	 * Creates the crew for each test.
	 */
	@BeforeEach
	void createCrew() {
		crewList = new ArrayList<CrewMember>();
		//Making CrewMembers
		CrewMember member1 = new Medic("Test Member 1");
		CrewMember member2 = new Scavenger("Test Member 2");
		CrewMember member3 = new Marathon("Test Member 3");
		CrewMember member4 = new Tank("Test Member 4");
		CrewMember member5 = new Mechanic("Test Member 5");
		CrewMember member6 = new Survivalist("Test Member 6");
		//Adding crew to crewList
		crewList.add(member1);
		crewList.add(member2);
		crewList.add(member3);
		crewList.add(member4);
		crewList.add(member5);
		crewList.add(member6);
		
		crew = new Crew("Test Crew", crewList);
	}
	
	/**
	 * Testing that the constructor works correctly.
	 */
	@Test
	void crewCreationTest() {
		assertEquals(crewList, crew.getCrewList());
		assertEquals("Test Crew", crew.getCrewName());
	}
	
	/**
	 * Testing that FoodItems can be added to and removed from the crewFoodItems ArrayList.
	 */
	@Test
	void foodInventoryTest() {
		ArrayList<FoodItem> testList = new ArrayList<FoodItem>();
		testList.add(new Apple());
		testList.add(new Banana());
		testList.add(new MRE());
		//Adding each item and checking it is in the ArrayList
		for(FoodItem item: testList) {
			crew.addToFoodItems(item);
			assertTrue(crew.getFoodItems().contains(item));
		}
		//Removing each item and checking it in not in the ArrayList.
		for(FoodItem item: testList) {
			crew.removeFromFoodItems(item);
			assertFalse(crew.getFoodItems().contains(item));
		}
	}
	
	/**
	 * Testing that MedicalItems can be added to and removed from the crewMedicalItems ArrayList.
	 */
	@Test
	void medicalInventoryTest() {
		ArrayList<MedicalItem> testList = new ArrayList<MedicalItem>();
		testList.add(new AdvancedMedicalKit());
		testList.add(new BasicMedicalKit());
		testList.add(new PlagueCure());
		//Adding each item and checking it is in the ArrayList
		for(MedicalItem item: testList) {
			crew.addToMedicalItems(item);
			assertTrue(crew.getMedicalItems().contains(item));
		}
		//Removing each item and checking it in not in the ArrayList.
		for(MedicalItem item: testList) {
			crew.removeFromMedicalItems(item);
			assertFalse(crew.getMedicalItems().contains(item));
		}
	}
	
	/**
	 * Testing that the removeCrewMember method removes a given CrewMember from the crewList.
	 */
	@Test
	void removingCrewTest() {
		ArrayList<CrewMember> startingCrew = new ArrayList<CrewMember>(crew.getCrewList());
		//Removing each of the current CrewMembers from the crew and checking that they are no longer in crewList in Crew.
		for(CrewMember member: startingCrew) {
			crew.removeCrewMember(member);
			assertFalse(crew.getCrewList().contains(member));
		}
	}

	/**
	 * Testing Crew money getter and setter.
	 */
	@Test
	void moneyTest() {
		int startingMoney = crew.getMoney();
		assertEquals(startingMoney, 1000);
		
		startingMoney -= 150;
		crew.setMoney(startingMoney);
		assertEquals(crew.getMoney(), startingMoney);
	}
	
	/**
	 * Testing that the crewShip Ship object exists.
	 */
	@Test
	void shipTest() {
		assertTrue(crew.getCrewShip() instanceof Ship);
	}
}
