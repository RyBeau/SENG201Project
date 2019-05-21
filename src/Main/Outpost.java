package Main;
import java.util.ArrayList;

/**
 * This class defines an Outpost.
 * @author Daniel Porter
 *
 */
public class Outpost {
	
	private ArrayList<FoodItem> foodItemList;
	
	private ArrayList<MedicalItem> medicalItemList;
	
	public Outpost() {
		//Initialising foodItemList with one of each FoodItem.
		foodItemList = new ArrayList<FoodItem>();
		foodItemList.add(new Apple());
		foodItemList.add(new Banana());
		foodItemList.add(new HighCalorieBar());
		foodItemList.add(new SpaceSoup());
		foodItemList.add(new BeefSteak());
		foodItemList.add(new MRE());
		
		//Intialising medicalItemList with one of each MedicalItem.
		medicalItemList = new ArrayList<MedicalItem>();
		medicalItemList.add(new BasicMedicalKit());
		medicalItemList.add(new AdvancedMedicalKit());
		medicalItemList.add(new PlagueCure());
	}
	/**
	 * @return foodItemList
	 */
	public ArrayList<FoodItem> viewFoodItems() {
		return foodItemList;
	}
	/**
	 * @return medicalItemList
	 */
	public ArrayList<MedicalItem> viewMedicalItems() {
		return medicalItemList;
	}
	
}
