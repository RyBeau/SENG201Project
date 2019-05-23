package Main;
/**
 * This class extends FoodItem.<br>
 * A Banana is an item used to decrease a crew members hunger within the game.
 * @author Daniel Porter
 * 
 */
public class Banana extends FoodItem{
	/**
	 * This is a constructor for a Banana item.<br>
	 * It passes the amount of hunger that gets decreased and the cost of the item respectively.
	 */
	public Banana() {
		super(35, 70, "Banana");
	}
	/**
	 * This method receives the Crew for the game, then creates a new instance of Banana
	 * and then sends the new instance and the Crew the the parent constructor in FoodItem.
	 * @param crew The Crew for the game.
	 */
	public void purchase(Crew crew) {
		super.purchase(new Banana(), crew);
	}

}