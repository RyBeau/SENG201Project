package GUI;

import javax.swing.JFrame;
import javax.swing.JList;
import Main.Crew;
import Main.CrewMember;
import Main.GameEnvironment;
import javax.swing.AbstractListModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
/**
 * This is the main GUI window for running the game itself.<br>
 * All aspects of the game are displayed here and player interaction happens with this GUI.
 * @author Ryan Beaumont
 *
 */
public class GameWindow {
	/**
	 * This is the GameEnvironment class that is controlling the game.
	 */
	private GameEnvironment environment;
	/**
	 * This is the Crew for the game.
	 */
	private Crew crew;
	/**
	 * The JFrame containing all the GUI elements
	 */
	private JFrame gameScreen;
	/**
	 * This is the JPanel that contains the CrewMember related elements.
	 */
	private JPanel crewPanel;
	/**
	 * This is the JTextPane within crewPanel that displays the status of the CrewMember selected in listOfCrew.
	 */
	private JTextPane statusPane;
	/**
	 * THis is the JList that the player uses to select a CrewMember to use for an action.
	 */
	private JList<CrewMember> listOfCrew;
	/**
	 * This is the topInfoPanel that contains information about the day, ship shield level, crew money, transporter parts found
	 * and transporter parts to find.
	 */
	private JPanel topInfoPanel;
	
	private JLabel lblPlanetParts;
	/**
 	* This is the constructor for GameWindow
 	* It assigns the variables environment and crew with incomingEnvironment and incomingCrew.
 	* @param incomingEnvironment This is the GameEnvironment class currently controlling the game.
 	* @param incomingCrew This is the Crew for the current game instance.
 	*/
	public GameWindow(GameEnvironment incomingEnvironment, Crew incomingCrew) {
		crew = incomingCrew;
		environment = incomingEnvironment;
		initialize();
		gameScreen.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.<br>
	 * Builds all the GUI elements.<br>
	 * Called when an instance of GameWindow is created.
	 */
	private void initialize() {
		gameScreen = new JFrame();
		gameScreen.setTitle("Space Explorer");
		gameScreen.setBounds(100, 100, 700, 400);
		gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameScreen.setLocationRelativeTo(null);
		gameScreen.getContentPane().setLayout(null);
		
		crewPanel = new JPanel();
		crewPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		crewPanel.setBounds(12, 50, 163, 299);
		gameScreen.getContentPane().add(crewPanel);
		crewPanel.setLayout(null);
		buildCrewPanel();
		
		topInfoPanel = new JPanel();
		topInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		topInfoPanel.setBounds(12, 12, 676, 34);
		gameScreen.getContentPane().add(topInfoPanel);
		topInfoPanel.setLayout(null);
		buildTopInfoPanel();
		
		JPanel bottomActivitiesPanel = new JPanel();
		bottomActivitiesPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		bottomActivitiesPanel.setBounds(187, 315, 501, 34);
		gameScreen.getContentPane().add(bottomActivitiesPanel);
		bottomActivitiesPanel.setLayout(null);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				environment.nextDay();
			}
		});
		btnNextDay.setBounds(260, 3, 130, 26);
		bottomActivitiesPanel.add(btnNextDay);
		
		JButton btnVisitOutpost = new JButton("Visit Outpost");
		btnVisitOutpost.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OutpostScreen(crew, environment.getGamePlanet().getOutpost());
			}
		});
		btnVisitOutpost.setBounds(118, 3, 130, 26);
		bottomActivitiesPanel.add(btnVisitOutpost);
		
		JPanel actionsPanel = new JPanel();
		actionsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		actionsPanel.setBounds(187, 50, 501, 258);
		gameScreen.getContentPane().add(actionsPanel);
		actionsPanel.setLayout(null);
		
		JButton btnSearchPlanet = new JButton("Search Planet");
		btnSearchPlanet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewMember member = listOfCrew.getSelectedValue();
				environment.searchPlanet(member);;
				refreshTopInfoPane();
				updateCrewMember();
			}
		});
		btnSearchPlanet.setBounds(347, 172, 130, 26);
		actionsPanel.add(btnSearchPlanet);
		
		JButton btnEatFood = new JButton("Eat Food");
		btnEatFood.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(crew.getFoodItems().size() > 0) {
					openFoodWindow();
				}else {
					new Alert("You have no food items to eat!");
				}
			}
		});
		btnEatFood.setBounds(347, 20, 130, 26);
		actionsPanel.add(btnEatFood);
		
		JButton btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewMember member = listOfCrew.getSelectedValue();
				environment.sleep(member);
				updateCrewMember();
			}
		});
		btnSleep.setBounds(347, 96, 130, 26);
		actionsPanel.add(btnSleep);
		
		JButton btnRepairShip = new JButton("Repair Ship");
		btnRepairShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewMember member = listOfCrew.getSelectedValue();
				environment.repairShip(member);
				refreshTopInfoPane();
				updateCrewMember();
			}
		});
		btnRepairShip.setBounds(347, 134, 130, 26);
		actionsPanel.add(btnRepairShip);
		
		JButton btnPilotShip = new JButton("Pilot Ship");
		btnPilotShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pilotShip();
			}
		});
		btnPilotShip.setBounds(347, 209, 130, 26);
		actionsPanel.add(btnPilotShip);
		
		JButton btnHeal = new JButton("Heal");
		btnHeal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				openMedicalWindow();
		}
		});
		btnHeal.setBounds(347, 58, 130, 26);
		actionsPanel.add(btnHeal);
		
		lblPlanetParts = new JLabel("Transporter Parts on Current Planet: " + environment.getGamePlanet().getTransporterPartsAmount());
		lblPlanetParts.setBounds(12, 0, 287, 34);
		actionsPanel.add(lblPlanetParts);
		
		JLabel lblplanetImage = new JLabel("");
		lblplanetImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblplanetImage.setIcon(new ImageIcon(GameWindow.class.getResource("/Images/PlanetImage.png")));
		lblplanetImage.setBounds(22, 46, 211, 189);
		actionsPanel.add(lblplanetImage);
	}
	/**
	 * This method creates the GUI elements with the crewPane JPanel.<br>
	 * This seperate method is used as the elements are recreated when crewPane needs to be refreshed.
	 */
	private void buildCrewPanel() {
		listOfCrew = new JList();
		listOfCrew.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				updateCrewMember();
			}
		});
		listOfCrew.setBackground(UIManager.getColor("Button.background"));
		listOfCrew.setBorder(new LineBorder(new Color(0, 0, 0)));
		listOfCrew.setBounds(12, 40, 139, 110);
		crewPanel.add(listOfCrew);
		listOfCrew.setModel(new AbstractListModel<CrewMember>() {
			ArrayList<CrewMember> values = crew.getCrewList();
			public int getSize() {
				return values.size();
			}
			public CrewMember getElementAt(int index) {
				return values.get(index);
			}
		});
		JLabel lblCrewName = new JLabel(crew.getCrewName());
		lblCrewName.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCrewName.setBounds(12, 12, 139, 16);
		crewPanel.add(lblCrewName);

		statusPane = new JTextPane();
		statusPane.setEditable(false);
		statusPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		statusPane.setBackground(UIManager.getColor("Button.background"));
		statusPane.setBounds(12, 195, 139, 92);
		crewPanel.add(statusPane);
		listOfCrew.setSelectedIndex(0);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setFont(new Font("Dialog", Font.BOLD, 14));
		lblStatus.setBounds(12, 167, 139, 16);
		crewPanel.add(lblStatus);
	}
	/**
	 * This method creates the GUI elements with the topInfoPane JPanel.<br>
	 * This separate method is used as the elements are recreated when topInfoPane needs to be refreshed.
	 */
	private void buildTopInfoPanel() {
		JLabel lblDay = new JLabel("Day: " + environment.getCurrentDay());
		lblDay.setVerticalAlignment(SwingConstants.BOTTOM);
		lblDay.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDay.setBounds(12, 0, 83, 28);
		topInfoPanel.add(lblDay);
		
		JLabel lblShipShieldLevel = new JLabel("Ship Shield Level: " + crew.getCrewShip().getShieldLevel() + "%");
		lblShipShieldLevel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblShipShieldLevel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblShipShieldLevel.setBounds(107, 0, 219, 28);
		topInfoPanel.add(lblShipShieldLevel);
		
		JLabel lblTransporterParts = new JLabel("Transporter Parts: " + crew.getPartsFound() + "/" + environment.getPartsToCollect());
		lblTransporterParts.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTransporterParts.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTransporterParts.setBounds(471, 0, 193, 28);
		topInfoPanel.add(lblTransporterParts);
		
		JLabel lblMoney = new JLabel("Money: $" + crew.getMoney());
		lblMoney.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMoney.setFont(new Font("Dialog", Font.BOLD, 15));
		lblMoney.setBounds(327, 0, 146, 28);
		topInfoPanel.add(lblMoney);
	}
	
	/**
	 * This method is called by the GameEnvironment class to "refresh" GUI elements after a change to 
	 * their value has occurred.<br>
	 * It calls the methods refreshCrewPane() and refreshInfoPane() to refresh each of the JPanels that contain changing information.
	 */
	public void refresh() {
		refreshCrewPane();
		refreshTopInfoPane();
	}
	/**
	 * This closes the GameWindow Instance.
	 */
	public void closeWindow() {
		gameScreen.dispose();
	}
	/**
	 * This method refreshes all GUI elements within the crewPane JPanel.
	 * It removes all elements within the crewPane, then calls the buildCrewPane() method to recreate them.<br>
	 * After this it is revalidated and the repainted to display all the new elements.
	 */
	private void refreshCrewPane() {
		crewPanel.removeAll();
		buildCrewPanel();
		crewPanel.revalidate();
		crewPanel.repaint();
	}
	/**
	 * This method refreshes all GUI elements within the topInfoPane JPanel.
	 * It removes all elements within the topInfoPane, then calls the buildTopInfoPane() method to recreate them.<br>
	 * After this it is revalidated and the repainted to display all the new elements.
	 */
	private void refreshTopInfoPane() {
		topInfoPanel.removeAll();
		buildTopInfoPanel();
		topInfoPanel.revalidate();
		topInfoPanel.repaint();
		lblPlanetParts.setText("Transporter Parts on Current Planet: " + environment.getGamePlanet().getTransporterPartsAmount());
	}
	/**
	 * This method refreshes the statusPane JTextPane text to display the status of the currently selected CrewMember in the 
	 * listOfCrew JList.
	 */
	public void updateCrewMember() {
		CrewMember member = listOfCrew.getSelectedValue();
		statusPane.setText(member.viewStatus());
	}
	/**
	 * This method opens the FoodItem version of the UseItemWindow.<br>
	 * It checks that the crew actually has a FoodItem to use before opening the UseItemWindow.<br>
	 * If they do not then it sends and alert to the player.
	 */
	private void openFoodWindow() {
		if(crew.getFoodItems().size() > 0) {
			new UseItemWindow(environment, this, crew, listOfCrew.getSelectedValue(), "FoodItem");
		}else {
			new Alert("You have no food items to eat!");
		}
	}
	/**
	 * This method opens the MedicalItem version of the UseItemWindow.<br>
	 * It checks that the crew actually has a MedicalItem to use before opening the UseItemWindow.<br>
	 * If they do not then it sends and alert to the player.
	 */
	private void openMedicalWindow() {
		if(crew.getMedicalItems().size() > 0) {
			new UseItemWindow(environment, this, crew, listOfCrew.getSelectedValue(), "MedicalItem");
		}else {
			new Alert("You have no Medical Items to Use!");
	}
	}
	private void pilotShip() {
		environment.pilotShip(listOfCrew.getSelectedValue(), this);
	}
}
