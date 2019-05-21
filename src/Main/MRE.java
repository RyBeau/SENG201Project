package Main;
/**
 * This class extends FoodItem.<br>
 * MRE is an item used to decrease a crew members hunger within the game.
 * @author Daniel Porter
 * 
 */
public class MRE extends FoodItem{
	/**
	 * This is a constructor for a MRE item.<br>
	 * It passes the amount of hunger that gets decreased and the cost of the item respectively.
	 */
	public MRE() {
		super(100, 200, "MRE");
	}
	/**
	 * @return A string detailing the items hunger depletion amount and cost.
	 */
	public String itemDescription() {
		return "An MRE lowers hunger by "+super.getFillUpAmount()
		+". It costs $"+super.getItemPrice()+" from the outpost.";
	}
	/**
	 * This method receives the Crew for the game, then creates a new instance of MRE
	 * and then sends the new instance and the Crew the the parent constructor in FoodItem.
	 * @param crew The Crew for the game.
	 */
	public void purchase(Crew crew) {
		super.purchase(new MRE(), crew);
	}

}
