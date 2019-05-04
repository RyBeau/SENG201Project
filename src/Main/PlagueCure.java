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
		super(0, true, 250);
	}
	/**
	 * @return A string detailing the item, its price, heal amount and its function.
	 */
	public String toString() {
		return "The Plague Cure cures the crew member of the plague." + super.getPrice() + " from the outpost.";
	}
	
	public void purchase() {
		super.purchase(new PlagueCure());
	}
}
