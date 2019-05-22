package Main;
/**
 * This class extends FoodItem.<br>
 * BeefStake is an item used to decrease a crew members hunger within the game.
 * @author Daniel Porter
 * 
 */
public class BeefSteak extends FoodItem{
	/**
	 * This is a constructor for a BeefStake item.<br>
	 * It passes the amount of hunger that gets decreased and the cost of the item respectively.
	 */
	public BeefSteak() {
		super(100, 200, "Beef Steak");
	}
	/**
	 * This method receives the Crew for the game, then creates a new instance of BeefSteak
	 * and then sends the new instance and the Crew the the parent constructor in FoodItem.
	 * @param crew The Crew for the game.
	 */
	public void purchase(Crew crew) {
		super.purchase(new BeefSteak(), crew);
	}

}
