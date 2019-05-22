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
	
	@Test
	void testGetFillUpAmount() {
		Apple testApple = new Apple();
		assertEquals(testApple.getFillUpAmount(), 25);
		}
	@Test
	void testGetItemPrice() {
		Apple testApple = new Apple();
		assertEquals(testApple.getItemPrice(), 50);
	}
	@Test
	void testItemDescription() {
		Apple testApple = new Apple();
		assertEquals("An Apple lowers hunger by 25. It costs $50 from the outpost.", testApple.itemDescription());
	}
	@Test
	void testToString() {
		Apple testApple = new Apple();
		assertEquals("Apple", testApple.toString());
	}
	
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
	@Test
	void cantPurchaseTest() {
		testCrew.setMoney(0);
		Apple testApple = new Apple();
		testApple.purchase(testCrew);
		assertEquals(0, testCrew.getMoney());
		assertTrue(testCrew.getFoodItems().isEmpty());
	}
	
		
}	
			
			


