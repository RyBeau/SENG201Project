package Testing;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Main.Mechanic;
import Main.Ship;

class MechanicTesting {
	/**
	 * The Mechanic instance used for testing the Mechanic Class
	 */
	private Mechanic testMechanic;
	/**
	 * Creating a Mechanic to be used for each test.
	 */
	@BeforeEach
	void testSetup() {
		testMechanic = new Mechanic("Test");
	}
	
	/**
	 * This tests that the Mechanic.repairShip() method increases the ships shieldLevel by the correct amount.<br>
	 * It also tests that actions decrease and that it does not increase shield level higher than 100.
	 */
	@Test
	void repairShipTest() {
		Ship ship = new Ship();
		ship.setShieldLevel(0);
		testMechanic.repairShip(ship);
		assertEquals(ship.getShieldLevel(), 60);
		assertEquals(testMechanic.getActions(), 1);
		testMechanic.repairShip(ship);
		assertEquals(ship.getShieldLevel(), 100);
		assertEquals(testMechanic.getActions(), 0);
	}

}
