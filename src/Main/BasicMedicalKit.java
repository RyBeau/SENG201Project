package Main;
/**
 * This class extends MedicalItem.<br>
 * BasicMedicalKit is an item used to heal crew members within the game.<br>
 * @author Ryan Beaumont
 *
 */
public class BasicMedicalKit extends MedicalItem{
	/**
	 * This is the constructor for BasicMedicalKit item.<br>
	 * It passes the set healing amount of the item, if the item cure the plague, the price of the item, 
	 * and the name of the item to the parent constructor in MedicalItem.<br>
	 * The BasicMedicalKit does not cure the plague.
	 */
	public BasicMedicalKit(){
		super(35, false, 100, "Basic Medical Kit");
	}
	/**
	 * This method receives the Crew for the game, then creates a new instance of BasicMedicalKit
	 * and then sends the new instance and the Crew the the parent constructor in MedicalItem.
	 * @param crew The Crew for the game.
	 */
	public void purchase(Crew crew) {
		super.purchase(new BasicMedicalKit(), crew);
	}

}
