package Main;

import GUI.Alert;

/**
 * This is the parent class for all medical item types.<br>
 * A type of medical item in game extends this class.<br>
 * @author Ryan Beaumont
 *
 */
public class MedicalItem extends PurchasableAdaptor{
	/**
	 * Price of the MedicalItem
	 */
	private int itemPrice;
	/**
	 * The amount the MedicalItem heals.
	 */
	private int healAmount;
	/**
	 * Whether the item cures the space plague.
	 */
	private boolean curesPlague = false;
	/**
	 * The name of the item.
	 */
	private String itemName;
	/**
	 * Constructor for the MedicalItem class.<br>
	 * @param heal The amount the item heals a crew member.
	 * @param cure If the item cures the plague.
	 * @param price Price of the item a the outpost.
	 */
	public MedicalItem(int heal, boolean cure, int price, String name) {
		itemPrice = price;
		healAmount = heal;
		curesPlague = cure;
		itemName = name;
	}
	/**
	 * @return The int variable healAmount.
	 */
	public int getHealAmount() {
		return healAmount;
	}
	/**
	 * @return The int variable price.
	 */
	public int getPrice() {
		return itemPrice;
	}
	/**
	 * @return If the boolean variable curesPlague.
	 */
	public boolean getCure() {
		return curesPlague;
	}
	/**
	 *This method purchases the current MedicalItem.<br>
	 *Before allowing purchase the crewMoney variable is checked to insure the
	 *crew has enough money to buy the item.
	 *@param item This is a new instance of the MedicalItem.
	 */
	public void purchase(MedicalItem item, Crew crew) {
		if(crew.getMoney() > itemPrice) {
			crew.addToMedicalItems(item);
			crew.setMoney(crew.getMoney() - itemPrice);
		}else {
			new Alert("Not Enough Money!");
		}
	}
	/**
	 * @return The item name.
	 */
	public String toString() {
		return itemName;
	}
	/**
	 * @return A string detailing the item, its price, heal amount and its function.
	 */
	public String itemDescription() {
		return "Name: " + itemName + "\nHeal Amount: " + healAmount + "\nCures Plague: " + curesPlague +"\nOutpost Cost: $" + itemPrice;
	}

}
