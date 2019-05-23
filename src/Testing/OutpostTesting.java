package Testing;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.AdvancedMedicalKit;
import Main.Apple;
import Main.Banana;
import Main.BasicMedicalKit;
import Main.BeefSteak;
import Main.HighCalorieBar;
import Main.MRE;
import Main.Outpost;
import Main.PlagueCure;
import Main.SpaceSoup;
/**
 * JUnit testing for Outpost class.
 * @author Daniel Porter
 */
class OutpostTesting {
	
	private Outpost testOutpost;
	
	@BeforeEach
	void testSetup() {
		testOutpost = new Outpost();
	}
	/**
	 * Testing the viewFoodItems method returns an array list of all food items
	 */
	@Test
	void testViewFoodItems() {
		assertTrue(testOutpost.viewFoodItems().get(0) instanceof Apple);
		assertTrue(testOutpost.viewFoodItems().get(1) instanceof Banana);
		assertTrue(testOutpost.viewFoodItems().get(2) instanceof HighCalorieBar);
		assertTrue(testOutpost.viewFoodItems().get(3) instanceof SpaceSoup);
		assertTrue(testOutpost.viewFoodItems().get(4) instanceof BeefSteak);
		assertTrue(testOutpost.viewFoodItems().get(5) instanceof MRE);
	}
	/**
	 * Testing the viewFoodItems method returns an array list of all medical items
	 */	
	@Test
	void testViewMedicalItems() {
		assertTrue(testOutpost.viewMedicalItems().get(0) instanceof BasicMedicalKit);
		assertTrue(testOutpost.viewMedicalItems().get(1) instanceof AdvancedMedicalKit);
		assertTrue(testOutpost.viewMedicalItems().get(2) instanceof PlagueCure);
	}
}
