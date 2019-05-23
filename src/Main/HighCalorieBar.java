package Main;
/**
 * This class extends FoodItem.<br>
 * A HighCalorieBar is an item used to decrease a crew members hunger within the game.
 * @author Daniel Porter
 * 
 */
public class HighCalorieBar extends FoodItem{
	/**
	 * This is a constructor for a HighCalorieBar item.<br>
	 * It passes the amount of hunger that gets decreased and the cost of the item respectively.
	 */
	public HighCalorieBar() {
		super(60, 90, "High Calorie Bar");
	}
	/**
	 * This method receives the Crew for the game, then creates a new instance of HighCalorieBar
	 * and then sends the new instance and the Crew the the parent constructor in FoodItem.
	 * @param crew The Crew for the game.
	 */
	public void purchase(Crew crew) {
		super.purchase(new HighCalorieBar(), crew);
	}

}
