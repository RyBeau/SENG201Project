
public class CrewMember {
	private String memberName;
	private int memberHealth = 100;
	private int memberHunger = 100;
	private int memberTiredness = 100;
	
	public CrewMember(String name){
		memberName = name;
	}
	
	public void setHealth(int health) {
		memberHealth = health;
	}
	
	public void setHunger(int hunger) {
		memberHunger = hunger;
	}
	
	public void setTiredness(int tiredness) {
		memberTiredness = tiredness;
	}
	
	public String toString() {
		return "Status of Crew Member " + memberName + ":\nHealth Level: " + memberHealth + "\nHunger Level: " + memberHunger + "\nTiredness Level: " + memberTiredness;
	}
	
	public static void main(String[] args) {
		CrewMember test = new CrewMember("Ryan");
		System.out.println(test);
	}
}
