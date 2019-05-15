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
	private JPanel bottomNonActionPanel;
	private JPanel actionsPanel;
	private JButton btnVisitOutpost;
	private JLabel lblDay;
	private JLabel lblShipShieldLevel;
	private JLabel lblTransporterParts;
	private JLabel lblMoney;
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
		
		bottomNonActionPanel = new JPanel();
		bottomNonActionPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		bottomNonActionPanel.setBounds(12, 315, 660, 34);
		gameScreen.getContentPane().add(bottomNonActionPanel);
		bottomNonActionPanel.setLayout(null);
		
		JButton btnNextDay = new JButton("Next Day");
		btnNextDay.setBounds(550, 0, 98, 26);
		bottomNonActionPanel.add(btnNextDay);
		
		btnVisitOutpost = new JButton("Visit Outpost");
		btnVisitOutpost.setBounds(431, 0, 107, 26);
		bottomNonActionPanel.add(btnVisitOutpost);
		
		actionsPanel = new JPanel();
		actionsPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		actionsPanel.setBounds(187, 50, 485, 258);
		gameScreen.getContentPane().add(actionsPanel);
		actionsPanel.setLayout(null);
	}
	
	private void updateCrewMember() {
		CrewMember member = listOfCrew.getSelectedValue();
		statusPane.setText("Type: " + member.getType() + "\nHealth: " + member.getHealth() +
				"\nHunger: " + member.getHunger() + "\nEnergy: " + member.getEnergy() + "\nActions: " + member.getActions());
	}
}
