package Main;
/**
 * This class extends MedicalItem.<br>
 * BasicMedicalKit is an item used to heal crew members within the game.<br>
 * @author Ryan Beaumont
 *
 */
public class BasicMedicalKit extends MedicalItem{
	private int price = 30;
	private int healAmount = 25;
	
	public int getHealAmount() {
		return healAmount;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void purchase() {
		
	}
	
	public String toString() {
		return "The Basic Medical Kit restores 25 health.";
		}
	
public static void main(String[] args) {
	BasicMedicalKit test = new BasicMedicalKit();
	System.out.println(test);
}
}
