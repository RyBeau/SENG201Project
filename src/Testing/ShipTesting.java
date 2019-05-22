package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.*;
/**
 * JUnit testing for the Ship class.
 * @author Daniel Porter
 */
class ShipTesting {
	
	private Ship testShip;
	
	@BeforeEach
	void testSetup() {
		testShip = new Ship();
	}
	/**
	 * Testing that the constructor for the Ship class.<br>
	 * Ship must have a shield level of 100.
	 */
	@Test
	void creationTest() {
		assertEquals(100, testShip.getShieldLevel());
	}
	/**
	 * testing that the setShieldLevel method sets the shield level to
	 *  the desired int
	 */
	@Test
	void testSetShieldLevel() {
		testShip.setShieldLevel(80);
		assertEquals(80, testShip.getShieldLevel());
	}
}
