package GUI;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import Main.GameEnvironment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This is the first setup screen that appears after start game is selected from StartWindow.<br>
 * This screen is used to received the number of days, number of Crew Members and name of the Crew from the player<br>
 * @author Ryan Beaumont
 */
public class GameSetup {
	/**
	 * The JFrame containing all the GUI elements
	 */
	private JFrame setupScreen;
	/**
	 * The JSlider for selecting the number of crew members.
	 */
	private JSlider numCrew;
	/**
	 * The JSlider for selecting the number of days for the game to last.
	 */
	private JSlider numDays;
	/**
	 * The JTextField for entering name of the crew.
	 */
	private JTextField crewName;
	private GameEnvironment environment;

	/**
	 * Create the application.
	 * @param IncomingEnvironment This is the game environment that has called GameSetup(). Used to pass control back the GameEnvironment.
	 */
	public GameSetup(GameEnvironment IncomingEnvironment) {
		environment = IncomingEnvironment;
		initialize();
		setupScreen.setVisible(true);
	}

	/**
	 * Initialize the contents of the setupScreen.
	 */
	private void initialize() {
		setupScreen = new JFrame();
		setupScreen.setTitle("Space Explorer");
		setupScreen.setResizable(false);
		setupScreen.setBounds(100, 100, 600, 390);
		setupScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setupScreen.getContentPane().setLayout(null);
		setupScreen.setLocationRelativeTo(null);
		
		JPanel titleBorder = new JPanel();
		titleBorder.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		titleBorder.setBounds(10, 11, 561, 55);
		setupScreen.getContentPane().add(titleBorder);
		titleBorder.setLayout(null);
		
		JLabel lblGameSetup = new JLabel("Game Setup");
		lblGameSetup.setBounds(0, 0, 572, 55);
		titleBorder.add(lblGameSetup);
		lblGameSetup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameSetup.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		mainPanel.setBounds(10, 78, 561, 232);
		setupScreen.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		numCrew = new JSlider();
		numCrew.setSnapToTicks(true);
		numCrew.setBounds(281, 84, 218, 50);
		mainPanel.add(numCrew);
		numCrew.setValue(6);
		numCrew.setMinorTickSpacing(1);
		numCrew.setMajorTickSpacing(1);
		numCrew.setMinimum(2);
		numCrew.setMaximum(6);
		numCrew.setPaintTicks(true);
		numCrew.setPaintLabels(true);
		
		numDays = new JSlider();
		numDays.setBounds(281, 11, 218, 50);
		mainPanel.add(numDays);
		numDays.setValue(10);
		numDays.setSnapToTicks(true);
		numDays.setPaintTicks(true);
		numDays.setPaintLabels(true);
		numDays.setMajorTickSpacing(1);
		numDays.setMinorTickSpacing(1);
		numDays.setMinimum(3);
		numDays.setMaximum(10);
		
		crewName = new JTextField();
		crewName.setBounds(281, 165, 218, 35);
		mainPanel.add(crewName);
		crewName.setColumns(10);
		
		JLabel lblNumberOfDays = new JLabel("Number of Days");
		lblNumberOfDays.setBounds(80, 11, 110, 50);
		mainPanel.add(lblNumberOfDays);
		lblNumberOfDays.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNumberOfCrew = new JLabel("Number of Crew");
		lblNumberOfCrew.setBounds(80, 84, 110, 50);
		mainPanel.add(lblNumberOfCrew);
		lblNumberOfCrew.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblCrewName = new JLabel("Crew Name");
		lblCrewName.setBounds(80, 163, 110, 35);
		mainPanel.add(lblCrewName);
		lblCrewName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		btnCancel.setBounds(296, 316, 89, 23);
		setupScreen.getContentPane().add(btnCancel);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(crewName.getText().trim().length() <= 0) { //Checking that a name for the crew has been entered.
					Alert alert = new Alert("Crew Needs a Name!");//Sending alert to inform player of the problem.
				}else {
					continueSetup();
				}
			}
		});
		btnNext.setBounds(197, 316, 89, 23);
		setupScreen.getContentPane().add(btnNext);
	
	}
	
	/**
	 * Closes the setupScreen.
	 */
	public void closeWindow() {
		setupScreen.dispose();
	}
	
	/**
	 * Calls the closeStartScreen method in GameEnvironment.<br>
	 * Called when btnCancel is pressed.<br>
	 * Calls the version of closeSetupScreen that re-launches the Start Screen.
	 */
	public void finishedWindow() {
		environment.closeSetupScreen(this);
	}
	/**
	 * Calls the closeStartScreen method in GameEnvironment.<br>
	 * Called when btnNext is pressed.<br>
	 * Calls the version of closeSetupScreen that continues to crew selection.
	 */
	public void continueSetup() {
		environment.closeSetupScreen(this, crewName.getText(), numDays.getValue(), numCrew.getValue());
	}
}
