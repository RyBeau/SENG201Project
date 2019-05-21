package Main;
/**
 * This class extends CrewMember.<br>
 * It is the class for the Medic type CrewMember.
 * @author Ryan Beaumont
 *
 */
public class Medic extends CrewMember{
	/**
	 * This is the constructor for the Medic Class.<br>
	 * This passes the name selected by the player and the String "Medic" which is the type to the parent class CrewMember.
	 * @param name Name inputed by the player.
	 */
	public Medic(String name) {
		super(name, "Medic");
	}
	/**
	 * This overrides the CrewMember.heal() method.<br>
	 * The override doubles the healingAmount of the MedicalItem being used.<br>
	 * This method heals the crew member using a MedicalItem.<br>
	 * If this MedicalItem heals by some amount then the crew member is healed by this amount.<br>
	 * If this MedicalItem cures the plague then the crew member is cured of the plague.<br>
	 * This is an action so it decreases memberActions by one.
	 * @param item The MedicalItem to be used.
	 */
	public void heal(MedicalItem item, Crew crew) {
		int health = 2 * (item.getHealAmount()) + super.getHealth();
		if(health > 100) {
			health = 100;
		}
		super.setHealth(health);
		super.setActions(super.getActions() - 1);
		crew.removeFromMedicalItems(item);
		if(item.getCure()) {
			super.setPlague(false);
		}
			
	}
}
