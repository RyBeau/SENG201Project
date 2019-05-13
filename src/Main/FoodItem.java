package Main;

import GUI.Alert;

/**
 * This is the parent class for all food item types.<br>
 * A type of food item in game extends this class.<br>
 * @author Daniel Porter
 *
 */
public class FoodItem extends PurchasableAdaptor{
	/**
	 * The amount of hunger the FoodItem decreases.
	 */
	private int fillUpAmount;
	/**
	 * The price of the FoodItem.
	 */
	private int itemPrice;
	/**
	 * Constructor for the FoodItem class.<br>
	 * @param fillUp The amount of hunger decreased to a crew member.
	 * @param price Price of the item at the outpost.
	 */
	public FoodItem(int fillUp, int price) {
		fillUpAmount = fillUp;
		itemPrice = price;
	}
	/**
	 * @return fillUpAmount The int variable fillUpAmount.
	 */
	public int getFillUpAmount() {
		return fillUpAmount;
	}
	/**
	 * @return The int variable itemPrice.
	 */
	public int getItemPrice() {
		return itemPrice;
	}
	/**
	 * This method purchases the current FoodItem.<br>
	 * Before allowing purchase, the crewMoney variable is
	 * checked to ensure the crew has enough money to buy the item.<br>
	 * @param item This is a new instance of the FoodItem.
	 */
	public void purchase(FoodItem item, Crew crew) {
		if(crew.getMoney() > itemPrice) {
			crew.addToFoodItems(item);
			crew.setMoney(crew.getMoney() - itemPrice);
		}else {
			new Alert("Not Enough Money!");
		}
	}
}
