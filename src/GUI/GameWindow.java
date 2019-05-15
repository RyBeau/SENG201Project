package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;

import Main.Crew;
import Main.CrewMember;
import Main.GameEnvironment;

import java.awt.BorderLayout;
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

public class GameWindow {
	
	private JFrame gameScreen;
	private JPanel crewPanel;
	private JTextPane statusPane;
	private GameEnvironment environment;
	private Crew crew;
	JList<CrewMember> listOfCrew;
	private JPanel topInfoPanel;
	private JPanel bottomActivitiesPanel;
	private JPanel actionsPanel;
	private JButton btnVisitOutpost;
	private JLabel lblDay;
	private JLabel lblShipShieldLevel;
	private JLabel lblTransporterParts;
	private JLabel lblMoney;
	private JButton btnSearchPlanet;
	private JButton btnEatFood;
	private JButton btnSleep;
	private JButton btnRepairShip;
	private JButton btnPilotShip;
	private JButton btnHeal;
	private JButton btnNewButton;
	/**
	 * Create the application.
	 */
	public GameWindow(GameEnvironment incomingEnvironment, Crew incomingCrew) {
		crew = incomingCrew;
		environment = incomingEnvironment;
		initialize();
		gameScreen.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		gameScreen = new JFrame();
		gameScreen.setTitle("Space Explorer");
		gameScreen.setBounds(100, 100, 700, 400);
		gameScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameScreen.getContentPane().setLayout(null);
		
		crewPanel = new JPanel();
		crewPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		crewPanel.setBounds(12, 50, 163, 258);
		gameScreen.getContentPane().add(crewPanel);
		crewPanel.setLayout(null);
		
		listOfCrew = new JList();
		listOfCrew.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				updateCrewMember();
			}
		});
		listOfCrew.setBackground(UIManager.getColor("Button.background"));
		listOfCrew.setBorder(new LineBorder(new Color(0, 0, 0)));
		listOfCrew.setBounds(12, 32, 139, 110);
		crewPanel.add(listOfCrew);
		listOfCrew.setModel(new AbstractListModel<CrewMember>() {
			CrewMember[] values = crew.getCrewList().toArray(new CrewMember[crew.getCrewList().size()]);
			public int getSize() {
				return values.length;
			}
			public CrewMember getElementAt(int index) {
				return values[index];
			}
		});
		JLabel lblCrewName = new JLabel(crew.getCrewName());
		lblCrewName.setBounds(12, 12, 139, 16);
		crewPanel.add(lblCrewName);

		statusPane = new JTextPane();
		statusPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		statusPane.setBackground(UIManager.getColor("Button.background"));
		statusPane.setBounds(12, 154, 139, 92);
		crewPanel.add(statusPane);
		listOfCrew.setSelectedIndex(0);
		
		topInfoPanel = new JPanel();
		topInfoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		topInfoPanel.setBounds(12, 12, 660, 34);
		gameScreen.getContentPane().add(topInfoPanel);
		topInfoPanel.setLayout(null);
		
		lblDay = new JLabel("Day: " + environment.getCurrentDay());
		lblDay.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDay.setBounds(12, 12, 78, 16);
		topInfoPanel.add(lblDay);
		
		lblShipShieldLevel = new JLabel("Ship Shield Level: " + crew.getCrewShip().getShieldLevel());
		lblShipShieldLevel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblShipShieldLevel.setBounds(122, 12, 176, 16);
		topInfoPanel.add(lblShipShieldLevel);
		
		lblTransporterParts = new JLabel("Transporter Parts: " + crew.getPartsFound() + "/" + environment.getPartsToCollect());
		lblTransporterParts.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTransporterParts.setBounds(495, 12, 153, 16);
		topInfoPanel.add(lblTransporterParts);
		
		lblMoney = new JLabel("Money: $" + crew.getMoney());
		lblMoney.setFont(new Font("Dialog", Font.BOLD, 15));
		lblMoney.setBounds(353, 12, 111, 16);
		topInfoPanel.add(lblMoney);
		
		bottomActivitiesPanel = new JPanel();
		bottomActivitiesPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		bottomActivitiesPanel.setBounds(12, 315, 660, 34);
		gameScreen.getContentPane().add(bottomActivitiesPanel);
		bottomActivitiesPanel.setLayout(null);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.setBounds(522, 3, 115, 26);
		bottomActivitiesPanel.add(btnNextDay);
		
		btnVisitOutpost = new JButton("Visit Outpost");
		btnVisitOutpost.setBounds(395, 3, 115, 26);
		bottomActivitiesPanel.add(btnVisitOutpost);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(285, 3, 98, 26);
		bottomActivitiesPanel.add(btnNewButton);
		
		actionsPanel = new JPanel();
		actionsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		actionsPanel.setBounds(187, 50, 485, 258);
		gameScreen.getContentPane().add(actionsPanel);
		actionsPanel.setLayout(null);
		
		btnSearchPlanet = new JButton("Search Planet");
		btnSearchPlanet.setBounds(347, 172, 115, 26);
		actionsPanel.add(btnSearchPlanet);
		
		btnEatFood = new JButton("Eat Food");
		btnEatFood.setBounds(347, 20, 115, 26);
		actionsPanel.add(btnEatFood);
		
		btnSleep = new JButton("Sleep");
		btnSleep.setBounds(347, 96, 115, 26);
		actionsPanel.add(btnSleep);
		
		btnRepairShip = new JButton("Repair Ship");
		btnRepairShip.setBounds(347, 134, 115, 26);
		actionsPanel.add(btnRepairShip);
		
		btnPilotShip = new JButton("Pilot Ship");
		btnPilotShip.setBounds(347, 209, 115, 26);
		actionsPanel.add(btnPilotShip);
		
		btnHeal = new JButton("Heal");
		btnHeal.setBounds(347, 58, 115, 26);
		actionsPanel.add(btnHeal);
	}
	
	private void updateCrewMember() {
		CrewMember member = listOfCrew.getSelectedValue();
		statusPane.setText("Type: " + member.getType() + "\nHealth: " + member.getHealth() +
				"\nHunger: " + member.getHunger() + "\nEnergy: " + member.getEnergy() + "\nActions: " + member.getActions());
	}
}
