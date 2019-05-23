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
	void testSetup() {
		testPlanet = new Planet();
	}
    /**
     * Testing the constructor for Planet.<br>
     * A Planet must have 1 transporter part on creation.<br>
     * A Planet must have an Outpost instance.
     */
	@Test
	void creationTest() {
		assertEquals(1, testPlanet.getTransporterPartsAmount());//planet has 1 transporter part
		assertTrue(testPlanet.getOutpost() instanceof Outpost);//planet has an outpost
	}
	/**
	 * Testing that the newPlanet method resets the amount of transporter parts to 1.
	 */
	@Test
	void testNewPlanet() {
		testPlanet.newPlanet();
		assertEquals(1, testPlanet.getTransporterPartsAmount());
	}
	/**
	 * Testing that the setTransporterParts method sets the amount of
	 * transporter parts on the planet to a desired int
	 */
	@Test
	void testSetTransporterParts() {
		testPlanet.setTransporterParts(0);
		assertEquals(0, testPlanet.getTransporterPartsAmount());
		testPlanet.setTransporterParts(1);
		assertEquals(1, testPlanet.getTransporterPartsAmount());
	}
	
	

}
