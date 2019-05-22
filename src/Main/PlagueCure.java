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
	 * It passes the set healing amount of the item, if the item cure the plague, the price of the item,
	 *  and the name of the item to the parent constructor in MedicalItem.<br>
	 * The plague cure only cures the plague and does not heal the crew member by any amount.
	 */
	public PlagueCure() {
		super(0, true, 250, "Plague Cure");
	}
	/**
	 * This method receives the Crew for the game, then creates a new instance of PlagueCure
	 * and then sends the new instance and the Crew the the parent constructor in MedicalItem.
	 * @param crew The Crew for the game.
	 */
	public void purchase(Crew crew) {
		super.purchase(new PlagueCure(), crew);
	}
}
