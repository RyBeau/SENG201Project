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
	 * This method receives the Crew for the game, then creates a new instance of Apple
	 * and then sends the new instance and the Crew the the parent constructor in FoodItem.
	 * @param crew The Crew for the game.
	 */
	public void purchase(Crew crew) {
		super.purchase(new Apple(), crew);
	}
}