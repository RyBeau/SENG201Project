package Main;
/**
 * This class extends MedicalItem.<br>
 * AdvancedMedicalKit is an item used to heal crew members within the game.<br>
 * @author Ryan Beaumont
 *
 */
public class AdvancedMedicalKit extends MedicalItem{
	/**
	 * Price of the AdvancedMedicalKit
	 */
	private int price = 100;
	/**
	 * The amount the AdvancedMedicalKit heals.
	 */
	private int healAmount = 100;
	
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
		return price;
	}

	public void purchase() {
		
	}
	
	public String toString() {
		return "The Advanced Medical Kit restores 100 health.";
	}

	
	public static void main(String[] args) {
		AdvancedMedicalKit test = new AdvancedMedicalKit();
		System.out.println(test);
	}
}
