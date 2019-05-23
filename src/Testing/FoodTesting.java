package Testing;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.CrewMember;
import Main.Apple;
import Main.Banana;
import Main.BeefSteak;
import Main.Crew;
import Main.FoodItem;
import Main.HighCalorieBar;
import Main.MRE;
import Main.Medic;
import Main.SpaceSoup;

class FoodTesting {
	
	private Crew testCrew;

	
	@BeforeEach
	void createCrew() {
		CrewMember testMember = new Medic("Test Member");
		ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();
		crewList.add(testMember);
		testCrew = new Crew("Test Crew", crewList);
	}
	/**
	 * testing the getFillUpAmount method with an Apple
	 */
	@Test
	void testGetFillUpAmount() {
		Apple testApple = new Apple();
		assertEquals(testApple.getFillUpAmount(), 25);
		}
	/**
	 * testing the getItemPrice method with an Apple
	 */
	@Test
	void testGetItemPrice() {
		Apple testApple = new Apple();
		assertEquals(testApple.getItemPrice(), 60);
	}
	/**
	 * testing the itemDescription method with an Apple<br>
	 * should display a string detailing the Apple's attributes.
	 */
	@Test
	void testItemDescription() {
		ArrayList<FoodItem> foodItemList = new ArrayList<FoodItem>();
		foodItemList.add(new Apple());
		foodItemList.add(new Banana());
		foodItemList.add(new SpaceSoup());
		foodItemList.add(new HighCalorieBar());
		foodItemList.add(new BeefSteak());
		foodItemList.add(new MRE());
		for(FoodItem item: foodItemList) {
			assertEquals("Name: " + item.toString() +  "\nLowers hunger by: " + item.getFillUpAmount() +"\nOutpost Cost: $" + item.getItemPrice(), item.itemDescription());
		}
		}
	/**
	 * testing the toString method with an Apple<br>
	 * should display "Apple"
	 */
	@Test
	void testToString() {
		Apple testApple = new Apple();
		assertEquals("Apple", testApple.toString());
	}
	/**
	 * testing the purchase method for each food item.<br>
	 * purchase method should decrease the items price from the crewMembers current money<br>
	 * purchase method should add the item to the crewMembers food items
	 */
	@Test
	void purchaseTest() {
		ArrayList<FoodItem> foodItemList = new ArrayList<FoodItem>();
		foodItemList.add(new Apple());
		foodItemList.add(new Banana());
		foodItemList.add(new SpaceSoup());
		foodItemList.add(new HighCalorieBar());
		foodItemList.add(new BeefSteak());
		foodItemList.add(new MRE());
		testCrew.setMoney(10000);
		for(FoodItem food: foodItemList) {
			int currentMoney = testCrew.getMoney();
			food.purchase(testCrew);
			assertEquals(testCrew.getMoney(), currentMoney - food.getItemPrice());
			assertTrue(testCrew.getFoodItems().get(0).getClass().isAssignableFrom(food.getClass()));
			testCrew.removeFromFoodItems(testCrew.getFoodItems().get(0));
		}
	}
	/**
	 * further testing of the purchase method with an Apple.<br>
	 * a crewMember may only purchase an item if they have enough money<br>
	 * if crewMember does not have enough money:<br>
	 *     - item will not be added to crewMembers foodItemList<br>
	 *     - money will not be deducted
	 */
	@Test
	void cantPurchaseTest() {
		testCrew.setMoney(0);
		Apple testApple = new Apple();
		testApple.purchase(testCrew);
		assertEquals(0, testCrew.getMoney());
		assertTrue(testCrew.getFoodItems().isEmpty());
	}
	
		
}	
			
			


