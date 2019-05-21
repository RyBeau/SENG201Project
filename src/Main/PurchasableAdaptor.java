package Main;
/**
 * This class is an adaptor for the purchasable interface.<br>
 * Purchasable is implemented by two classes: MedicalItem and FoodItem.<br>
 * @author Ryan Beaumont
 *
 */
public class PurchasableAdaptor implements Purchasable{
	/**
	 * Blank Purchase method. This is overridden by the purchase methods in MedicalItem and FoodItem.
	 */
	public void purchase(Crew crew) {
		
	}
	/**
	 * Blank itemDescription method that is overridden by the the itemDescription
	 *  in each of the FoodItem and MedicalItem children classes.
	 */
	public String itemDescription() {
		return null;
	}
}
