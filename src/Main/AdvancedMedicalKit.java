package Main;
/**
 * This class extends MedicalItem.<br>
 * AdvancedMedicalKit is an item used to heal crew members within the game.<br>
 * @author Ryan Beaumont
 *
 */
public class AdvancedMedicalKit extends MedicalItem{
	/**
	 * This is the constructor for AdvancedMedicalKit item.<br>
	 * It passes the set healing amount of the item, if the item cure the plague and the price of the item.<br>
	 * The AdvancedMedicalKit does not cure the plague.
	 */
	public AdvancedMedicalKit() {
		super(50, false, 500, "Advanced Medical Kit");
	}
	/**
	 * @return A string detailing the item, its price, heal amount and its function.
	 */
	public String itemDescription() {
		return "The " + super.toString() + " restores " + super.getHealAmount() + " health. It costs $" + super.getPrice() + " from the outpost.";
	}
	
	public void purchase(Crew crew) {
		super.purchase(new AdvancedMedicalKit(), crew);
	}
}
