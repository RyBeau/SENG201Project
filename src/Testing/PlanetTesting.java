package Testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Main.*;
/**
 * JUnit testing for Planet class.
 * @author Daniel Porter
 */

class PlanetTesting {
	
	private Planet testPlanet;
	
	@BeforeEach
	public void testSetup() {
		testPlanet = new Planet();
	}
    /**
     * Testing the constructor for Planet.<br>
     * A Planet must have 1 transporter part on creation.<br>
     * A Planet must have an Outpost instance.
     */
	@Test
	public void creationTest() {
		assertEquals(1, testPlanet.getTransporterPartsAmount());//planet has 1 transporter part
		assertTrue(testPlanet.getOutpost() instanceof Outpost);//planet has an outpost
	}
	/**
	 * Testing that the newPlanet method resets the amount of transporter parts to 1.
	 */
	@Test
	public void testNewPlanet() {
		testPlanet.NewPlanet();
		assertEquals(1, testPlanet.getTransporterPartsAmount());
	}
	
	
	

}
