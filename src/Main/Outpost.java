package Main;
import java.util.ArrayList;

/**
 * This class defines an Outpost.
 * @author Daniel Porter
 *
 */
public class Outpost {
	
	private ArrayList<FoodItem> foodItemList;
	
	private ArrayList<MedicalItem> medItemList;
	
	public Outpost() {
		foodItemList = new ArrayList<FoodItem>(new Apple(), new Banana(), new HighCalorieBar(), new SpaceSoup(), new BeefSteak(), new MRE());
		medItemList = new ArrayList<MedicalItem>(new BasicMedicalKit(), new AdvancedMedicalKit(), new PlagueCure());
		
	}
}
