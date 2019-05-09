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
		super(100, 200);
	}
	/**
	 * @return A string detailing the items hunger depletion amount and cost.
	 */
	public String toString() {
		return "Beef Steak lowers hunger by "+super.getFillUpAmount()
		+". It costs $"+super.getItemPrice()+" from the outpost.";
	}
	
	public void purchase() {
		super.purchase(new Banana());
	}

}