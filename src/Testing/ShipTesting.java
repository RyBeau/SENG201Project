package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import Main.*;
/**
 * JUnit testing for the Ship class.
 * @author Daniel Porter
 */
class ShipTesting {
	
	private Ship testShip;
	/**
	 * Testing that the constructor for the Ship class.<br>
	 * Ship must have a shield level of 100.
	 */
	@Test
	public void creationTest() {
		testShip = new Ship();
		assertEquals(100, testShip.getShieldLevel());
	}

}
