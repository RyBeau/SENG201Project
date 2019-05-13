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
	 * If the CrewMember has actions left, this method heals the crew member using a MedicalItem.<br>
	 * If this MedicalItem heals by some amount then the crew member is healed by this amount.<br>
	 * If this MedicalItem cures the plague then the crew member is cured of the plague.<br>
	 * This is an action so it decreases memberActions by one.
	 * @param item The MedicalItem to be used.
	 */
	public void heal(MedicalItem item, Crew crew) {
		if (hasActions()) {
			int healAmount = item.getHealAmount(); //Getting the healing amount.
			healAmount += item.getHealAmount(); //Doubling the healAmount of the selected item.
			super.setHealth((super.getHealth() + healAmount) % 100);
			super.setActions(super.getActions() - 1);
			crew.removeFromMedicalItems(item);
			if(item.getCure()) {
				super.setPlague(false);
			}
			
		}else {
			sendAlert("No actions left for this crew member!");
		}
	}
	/**
	 * The toString method for CrewMember subclasses provides a short description of the crew member type.
	 * @return A short description of the crew member type.
	 */
	public String toString() {
		return "The Medic has increased medical skills. When healing themseleves Medical Items are more effective on this type.";
	}
}
