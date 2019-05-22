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
	 * It passes the amount of hunger that gets decreased, the cost of the item, and 
	 * the name of the item to the FoodItem constructor.
	 */
	public SpaceSoup() {
		super(50, 100, "Space Soup");
	}
	/**
	 * This method receives the Crew for the game, then creates a new instance of SpaceSoup
	 * and then sends the new instance and the Crew the the parent constructor in FoodItem.
	 * @param crew The Crew for the game.
	 */
	public void purchase(Crew crew) {
		super.purchase(new SpaceSoup(), crew);
	}

}
