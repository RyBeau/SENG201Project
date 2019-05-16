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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GameWindow {
	
	private GameEnvironment environment;
	private Crew crew;
	private JFrame gameScreen;
	private JPanel crewPanel;
	private JTextPane statusPane;
	private JList<CrewMember> listOfCrew;
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
		topInfoPanel.setBounds(12, 12, 660, 34);
		gameScreen.getContentPane().add(topInfoPanel);
		topInfoPanel.setLayout(null);
		buildTopInfoPanel();
		
		bottomActivitiesPanel = new JPanel();
		bottomActivitiesPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		bottomActivitiesPanel.setBounds(187, 315, 485, 34);
		gameScreen.getContentPane().add(bottomActivitiesPanel);
		bottomActivitiesPanel.setLayout(null);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nextDay();
			}
		});
		btnNextDay.setBounds(304, 3, 115, 26);
		bottomActivitiesPanel.add(btnNextDay);
		
		btnVisitOutpost = new JButton("Visit Outpost");
		btnVisitOutpost.setBounds(177, 3, 115, 26);
		bottomActivitiesPanel.add(btnVisitOutpost);
		
		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(50, 3, 115, 26);
		bottomActivitiesPanel.add(btnNewButton);
		
		actionsPanel = new JPanel();
		actionsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		actionsPanel.setBounds(187, 50, 485, 258);
		gameScreen.getContentPane().add(actionsPanel);
		actionsPanel.setLayout(null);
		
		btnSearchPlanet = new JButton("Search Planet");
		btnSearchPlanet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewMember member = listOfCrew.getSelectedValue();
				environment.searchPlanet(member);;
				refreshTopInfoPane();
				updateCrewMember();
			}
		});
		btnSearchPlanet.setBounds(347, 172, 115, 26);
		actionsPanel.add(btnSearchPlanet);
		
		btnEatFood = new JButton("Eat Food");
		btnEatFood.setBounds(347, 20, 115, 26);
		actionsPanel.add(btnEatFood);
		
		btnSleep = new JButton("Sleep");
		btnSleep.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewMember member = listOfCrew.getSelectedValue();
				environment.sleep(member);
				updateCrewMember();
			}
		});
		btnSleep.setBounds(347, 96, 115, 26);
		actionsPanel.add(btnSleep);
		
		btnRepairShip = new JButton("Repair Ship");
		btnRepairShip.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrewMember member = listOfCrew.getSelectedValue();
				environment.repairShip(member);
				refreshTopInfoPane();
				updateCrewMember();
			}
		});
		btnRepairShip.setBounds(347, 134, 115, 26);
		actionsPanel.add(btnRepairShip);
		
		btnPilotShip = new JButton("Pilot Ship");
		btnPilotShip.setBounds(347, 209, 115, 26);
		actionsPanel.add(btnPilotShip);
		
		btnHeal = new JButton("Heal");
		btnHeal.setBounds(347, 58, 115, 26);
		actionsPanel.add(btnHeal);
	}
	
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
			CrewMember[] values = crew.getCrewList().toArray(new CrewMember[crew.getCrewList().size()]);
			public int getSize() {
				return values.length;
			}
			public CrewMember getElementAt(int index) {
				return values[index];
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
		lblStatus.setBounds(12, 167, 55, 16);
		crewPanel.add(lblStatus);
	}
	
	private void buildTopInfoPanel() {
		lblDay = new JLabel("Day: " + environment.getCurrentDay());
		lblDay.setFont(new Font("Dialog", Font.BOLD, 15));
		lblDay.setBounds(12, 12, 78, 16);
		topInfoPanel.add(lblDay);
		
		lblShipShieldLevel = new JLabel("Ship Shield Level: " + crew.getCrewShip().getShieldLevel() + "%");
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
	}
	
	
	public void refresh() {
		refreshCrewPane();
		refreshTopInfoPane();
	}
	
	public void closeWindow() {
		gameScreen.dispose();
	}
	
	private void refreshCrewPane() {
		crewPanel.removeAll();
		buildCrewPanel();
		crewPanel.revalidate();
		crewPanel.repaint();
	}
	
	private void refreshTopInfoPane() {
		topInfoPanel.removeAll();
		buildTopInfoPanel();
		topInfoPanel.revalidate();
		topInfoPanel.repaint();
	}
	
	private void nextDay() {
		environment.nextDay(this);
	}
	
	private void updateCrewMember() {
		CrewMember member = listOfCrew.getSelectedValue();
		statusPane.setText(member.viewStatus());
	}
}
