package Main;

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
	
	private boolean curesPlague = false;
	/**
	 * Constructor for the MedicalItem class.<br>
	 * @param heal The amount the item heals a crew member.
	 * @param cure If the item cures the plague.
	 * @param price Price of the item a the outpost.
	 */
	public MedicalItem(int heal, boolean cure, int price) {
		itemPrice = price;
		healAmount = heal;
		curesPlague = cure;
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
	public void purchase(MedicalItem item) {
		Crew crew = GameEnvironment.getGameCrew();
		if(crew.getMoney() > itemPrice) {
			crew.addToMedicalItems(item);
			crew.setMoney(crew.getMoney() - itemPrice);
		}
	}

}
