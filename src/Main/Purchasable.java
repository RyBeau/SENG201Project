package Main;
/**
 * The interface for all items that can be purchased from the outpost.<br>
 * Every item must implement a purchase() and a toString method.<br>
 * @author Ryan Beaumont
 *
 */
public interface Purchasable {
	/**
	 * The implementation of this method should allow the player to purchase this item from the outpost.<br>
	 * The crewMoney variable should be checked if it is greater than the price of the item.<br>
	 * crewMoney should then be decreased by the price and then the item added to its respective list in Crew.
	 */
	void purchase(Crew crew);

	/**
	 * @return General Information about the item, price, healAmount etc.
	 */
	String itemDescription();
}
