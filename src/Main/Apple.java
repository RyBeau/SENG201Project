package Main;
/**
 * This class extends FoodItem.<br>
 * An Apple is an item used to decrease a crew members hunger within the game.
 * @author Daniel Porter
 */
public class Apple extends FoodItem{
	/**
	 * This is a constructor for a Apple item.<br>
	 * It passes the amount of hunger that gets decreased and the cost of the item respectively.
	 */
	public Apple() {
		super(25, 50, "Apple");
	}
	/**
	 * @return A string detailing the items hunger depletion amount and cost.
	 */
	public String itemDescription() {
		return "An Apple lowers hunger by "+super.getFillUpAmount()
		+". It costs $"+super.getItemPrice()+" from the outpost.";
	}
	/**
	 * sends crew to parent class
	 * @param crew
	 */
	public void purchase(Crew crew) {
		super.purchase(new Apple(), crew);
	}
}