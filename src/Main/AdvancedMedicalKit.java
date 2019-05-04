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
		super(100, false, 500);
	}
	/**
	 * @return A string detailing the item, its price, heal amount and its function.
	 */
	public String toString() {
		return "The Advanced Medical Kit restores" + super.getHealAmount() + " health. It costs $" + super.getPrice() + " from the outpost.";
	}
	
	public void purchase() {
		super.purchase(new AdvancedMedicalKit());
	}


}
