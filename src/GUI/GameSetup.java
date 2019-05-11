package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalityType;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import Main.GameEnvironment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class GameSetup {

	private JFrame setupScreen;
	private JSlider numCrew;
	private JSlider numDays;
	private JTextField crewName;
	private GameEnvironment environment;

	/**
	 * Create the application.
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
		titleBorder.setBounds(10, 11, 574, 55);
		setupScreen.getContentPane().add(titleBorder);
		titleBorder.setLayout(null);
		
		JLabel lblGameSetup = new JLabel("Game Setup");
		lblGameSetup.setBounds(0, 0, 574, 55);
		titleBorder.add(lblGameSetup);
		lblGameSetup.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameSetup.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		mainPanel.setBounds(10, 73, 574, 232);
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
				if(crewName.getText().isBlank()) { //Checking that a name for the crew has been entered.
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
