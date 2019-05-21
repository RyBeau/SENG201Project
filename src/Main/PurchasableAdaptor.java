package Main;
/**
 * This class is an adaptor for the purchasable interface.<br>
 * Purchasable is implemented by two classes: MedicalItem and FoodItem.<br>
 * The two classes need different parameters passed to the purchase() method, thus two methods need to be declared in purchasable.
 * @author Ryan Beaumont
 *
 */
public class PurchasableAdaptor implements Purchasable{
	/**
	 * Blank MedicalItem purchase method. This is overwritten by the purchase method in MedicalItem.
	 */
	public void purchase(MedicalItem item, Crew crew) {
		
	}
	/**
	 * Blank FoodItem purchase method. This is overwritten by the purchase method in FoodItem.
	 */
	public void purchase(FoodItem item, Crew crew) {
		
	}
	
	public String itemDescription() {
		return null;
	}
}
