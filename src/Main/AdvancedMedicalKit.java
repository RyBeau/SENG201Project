package Main;

public class AdvancedMedicalKit extends MedicalItem{
	private int price = 100;
	private int healAmount = 100;
	
	
	public int getHealAmount() {
		return healAmount;
	}
	
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
