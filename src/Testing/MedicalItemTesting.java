package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.AdvancedMedicalKit;
import Main.BasicMedicalKit;
import Main.Crew;
import Main.CrewMember;
import Main.Medic;
import Main.MedicalItem;
import Main.PlagueCure;

class MedicalItemTesting {

	/**
	 * The Crew used for testing.
	 */
	private Crew testCrew;
	/**
	 * The ArrayList of MedicalItems used in testing.
	 */
	private ArrayList<MedicalItem> itemList;
	/**
	 * Setting up the needed items for each test
	 */
	@BeforeEach
	void testSetup() {
		CrewMember testMember = new Medic("Test Medic");
		ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();
		crewList.add(testMember);
		testCrew = new Crew("Test Crew", crewList);
		itemList = new ArrayList<MedicalItem>();
		itemList.add(new AdvancedMedicalKit());
		itemList.add(new BasicMedicalKit());
		itemList.add(new PlagueCure());
	}
	
	/**
	 * Testing that items can be purchased and that it decreases the Crew's money by the correct amount.<br>
	 * Also tests that the an object of the same class as the MedicalItem purchase() is called in is added to the crewMedicalItems.
	 */
	@Test
	void purchaseTest() {
		testCrew.setMoney(10000);
		for(MedicalItem item: itemList) {
			int currentMoney = testCrew.getMoney();
			item.purchase(testCrew);
			assertEquals(testCrew.getMoney(), currentMoney - item.getPrice());
			assertTrue(testCrew.getMedicalItems().get(0).getClass().isAssignableFrom(item.getClass()));
			testCrew.removeFromMedicalItems(testCrew.getMedicalItems().get(0));
		}
	}
	
	/**
	 * Testing that the description of the item returned by itemDescription is correct.<br>
	 * The String expected is the expected string to be returned.<br>
	 * It is compared with the actual String returned by itemDescription.
	 */
	@Test
	void descriptionTest() {
		for(MedicalItem item: itemList) {
			String expected = "The " + item.toString() + " restores " + item.getHealAmount() +
					" health.\nCures Plague: " + item.getCure() +"\nOutpost Cost: $" + item.getPrice();
			assertEquals(item.itemDescription(), expected);
		}
	}
	
	/**
	 * Testing that the item cannot be purchased if the Crew does not have enough money.<br>
	 * It checks that the Crew's money remains the same and no item is added to crewMedicalItems
	 */
	@Test
	void cannotPurchase() {
		testCrew.setMoney(0);
		itemList.get(0).purchase(testCrew);
		assertEquals(testCrew.getMoney(), 0);
		assertTrue(testCrew.getMedicalItems().isEmpty());
	}
}
