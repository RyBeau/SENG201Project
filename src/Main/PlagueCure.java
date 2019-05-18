package Main;
/**
 * This class extends MedicalItem.<br>
 * PlagueCure is an item used to cure crew members of the space plague within the game.<br>
 * @author Ryan Beaumont
 *
 */
public class PlagueCure extends MedicalItem{
	/**
	 * This is the constructor for AdvancedMedicalKit item.<br>
	 * It passes the set healing amount of the item, if the item cure the plague and the price of the item.<br>
	 * The plague cure only cures the plague and does not heal the crew member by any amount.
	 */
	public PlagueCure() {
		super(0, true, 250, "Plague Cure");
	}
	/**
	 * @return A string detailing the item, its price, heal amount and its function.
	 */
	public String itemDescription() {
		return "The " + super.toString() + " cures the crew member of the plague. It costs $" + super.getPrice() + " from the outpost.";
	}
	
	public void purchase() {
		super.purchase(new PlagueCure());
	}
}
