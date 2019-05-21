package Main;
/**
 * This class extends FoodItem.<br>
 * SpaceSoup is an item used to decrease a crew members hunger within the game.
 * @author Daniel Porter
 * 
 */
public class SpaceSoup extends FoodItem{
	/**
	 * This is a constructor for SpaceSoup item.<br>
	 * It passes the amount of hunger that gets decreased and the cost of the item respectively.
	 */
	public SpaceSoup() {
		super(50, 100, "Space Soup");
	}
	/**
	 * @return A string detailing the items hunger depletion amount and cost.
	 */
	public String itemDescription() {
		return "Space Soup lowers hunger by "+super.getFillUpAmount()
		+". It costs $"+super.getItemPrice()+" from the outpost.";
	}
	/**
	 * sends crew to parent class
	 * @param crew
	 */
	public void purchase(Crew crew) {
		super.purchase(new SpaceSoup(), crew);
	}

}
