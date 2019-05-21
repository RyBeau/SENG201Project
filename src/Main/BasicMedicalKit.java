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
	 * It passes the set healing amount of the item and the price of the item.<br>
	 * The BasicMedicalKit does not cure the plague.
	 */
	public BasicMedicalKit(){
		super(35, false, 100, "Basic Medical Kit");
	}
	/**
	 * @return A string detailing the item, its price, heal amount and its function.
	 */
	public String itemDescription() {
		return "The " + super.toString() + " restores " + super.getHealAmount() + " health. It costs $" + super.getPrice() + " from the outpost.";
		}

	public void purchase(Crew crew) {
		super.purchase(new BasicMedicalKit(), crew);
	}

}
