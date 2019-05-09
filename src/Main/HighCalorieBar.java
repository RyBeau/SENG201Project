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
		super(50, 100);
	}
	/**
	 * @return A string detailing the items hunger depletion amount and cost.
	 */
	public String toString() {
		return "A High Calorie Bar lowers hunger by "+super.getFillUpAmount()
		+". It costs $"+super.getItemPrice()+" from the outpost.";
	}
	public void purchase() {
		super.purchase(new Banana());
	}

}