package Testing;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.*;

class MedicTesting {

	private Medic testMedic;
	
	@BeforeEach
	void testSetup() {
		testMedic = new Medic("Test Medic");
	}
	
	/**
	 * Testing that the constructor for Medic correctly passes the name and builds the correct CrewMember type in the CrewMember parent class.
	 * Also tests that the correct toString() is used.
	 */
	@Test
	void creationTest() {
		Medic testMedic = new Medic("Test Medic");
		assertEquals("Status of Crew Member Test Medic:\nType: Medic\nHealth Level: 100\nHunger Level: 0\nEnergy Level: 100", testMedic.viewStatus());
		assertEquals(testMedic.toString(), "The Medic has increased medical skills. When healing themseleves Medical Items are more effective on this type.");
	}
	
	/**
	 * Testing that the Medic heal method works correctly and adds the correct amount of health for each MedicalItem/heals plague.<br>
	 * As the medic class doubles the effectiveness of healing health is set to -150 before each item test.<br>
	 * This is because health work modulo 100, so the maximum health level is 100.<br>
	 * We start at -150 so that the health level is not maxed out, as if it maxes out we cannot check that the correct amount of health is added.
	 */
	@Test
	void healTest(){
		testMedic.setActions(3); //Increase total actions so that the test can run without error from not enough actions.
		ArrayList<MedicalItem> testList = new ArrayList<MedicalItem>();
		testList.add(new AdvancedMedicalKit());
		testList.add(new BasicMedicalKit());
		testList.add(new PlagueCure());
		
		for(MedicalItem item: testList) {
			testMedic.setHealth(-150); //Setting health to -150
			testMedic.setPlague(true);
			testMedic.heal(item);
			assertEquals(testMedic.getHealth(), (-150 + (item.getHealAmount()) * 2) % 100); //Testing that double the heal amount is added to the testMedics health.
			if(item.getCure()) {
				assertFalse(testMedic.checkPlague()); //Tests that items that cure the space plague set hasPlague to false.
			}
		}
		
	}

	/**
	 * Testing that you cannot heal more than the number of actions that the testMedic has.<br>
	 * This test shouldn't allow the testMedic to heal.
	 */
	@Test
	void actionsTest() {
		testMedic.setActions(0);//Setting memberActions to 0
		MedicalItem testItem = new PlagueCure();
		testMedic.setPlague(true);//Setting hasPlague to true.
		testMedic.heal(testItem); //Attempting to heal using testItem.
		assertTrue(testMedic.checkPlague());//Checking that the medic still has the plague as they should not be able to heal.
	}
}
