package Main;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * This is the main controlling class for the game.<br>
 * It implements the logic needed for the game to be played.<br>
 * The main() method is contained within this class.
 * @author Ryan Beaumont
 * @author Daniel Porter
 *
 */
public class GameEnvironment {
	/**
	 * This is the Crew of the game session.
	 */
	private static Crew gameCrew;
	/**
	 * This is the number of days for the game to last.
	 */
	private int gameDays;
	/**
	 * This is the planet the game is currently taking place on.
	 */
	private Planet gamePlanet = new Planet();
	/**
	 * This is the constructor for this class.<br>
	 * Its sets the intial values of the variables for the class.
	 * @param crew The crew created by the player.
	 * @param days The number of days the player has selected for the game to last.
	 */
	public GameEnvironment(Crew crew, int days) {
		gameCrew = crew;
		gameDays = days;
	}
	/**
	 * @return The games Crew. (Object)
	 */
	public static Crew getGameCrew() {
		return gameCrew;
	}
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		System.out.println("How Many days should the game last? ");
		int days = reader.nextInt();
		System.out.println("How many crew members? ");
		int numCrew = reader.nextInt();
		ArrayList<CrewMember> members = new ArrayList<CrewMember>();
		for(int x = 0; x < numCrew; x++) {
			System.out.println("Name: ");
			String memberName = reader.next();
			members.add(new CrewMember(memberName));
		}
		System.out.println("Enter Crew Name: ");
		String name = reader.next();
		Crew crew = new Crew(name, members);
		GameEnvironment game = new GameEnvironment(crew, days);
		for(CrewMember i: members) {
			System.out.println(i);
			System.out.println();
		reader.close();
		
		PlagueCure cure = new PlagueCure();
		cure.purchase();
		System.out.println(gameCrew);
		}
		
	}
}
