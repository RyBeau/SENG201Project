package GUI;

import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import Main.GameEnvironment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CrewSelection {

	private JFrame selectionWindow;
	private String crewName;
	private int numCrew;
	private GameEnvironment environment;
	private ArrayList<JLabel> labelList = new ArrayList<JLabel>();
	private ArrayList<JTextField> textFieldList = new ArrayList<JTextField>();
	private ArrayList<JComboBox<String>> comboList = new ArrayList<JComboBox<String>>();
	private JLabel lblCrewName;
	private JButton btnStartGame;
	private JButton BtnCancel;
	
	

	/**
	 * 
	 * @param IncomingEnvironment
	 * @param name
	 * @param crew
	 */
	public CrewSelection(GameEnvironment IncomingEnvironment, String name, int crew) {
		environment = IncomingEnvironment;
		crewName = name;
		numCrew = crew;
		initialize();
		selectionWindow.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		selectionWindow = new JFrame();
		selectionWindow.setResizable(false);
		selectionWindow.setTitle("Space Explorer");
		selectionWindow.setBounds(100, 100, 430, numCrew * 50 + 150);
		selectionWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		selectionWindow.setLocationRelativeTo(null);
		selectionWindow.getContentPane().setLayout(null);
		
		lblCrewName = new JLabel(crewName);
		lblCrewName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		lblCrewName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCrewName.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCrewName.setBounds(18, 12, 394, 29);
		selectionWindow.getContentPane().add(lblCrewName);
		setupCrewSelection();
	}
	
	public void setupCrewSelection() {
		JPanel autoPanel = new JPanel();
		autoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		autoPanel.setBounds(18, 51, 394, numCrew * 50);
		selectionWindow.getContentPane().add(autoPanel);
		autoPanel.setLayout(new GridLayout(numCrew, 3, 20, 20));
		
		btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldList.stream().allMatch(x -> x.getText().trim().length() > 0)) {
					crewSelected();
				}else {
					Alert alert = new Alert("All Crew Members require a name!");
				}
			}
		});
		btnStartGame.setBounds(74, numCrew * 50 + 60, 120, 40);
		selectionWindow.getContentPane().add(btnStartGame);
		
		BtnCancel = new JButton("Cancel");
		BtnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow();
			}
		});
		BtnCancel.setBounds(229, numCrew * 50 + 60, 120, 40);
		selectionWindow.getContentPane().add(BtnCancel);
		for(int i = 0; i < numCrew; i++) {
			labelList.add(makeLabel(i, autoPanel));
			textFieldList.add(makeTextField(i, autoPanel));
			comboList.add(makeComboBox(i, autoPanel));
		}
	}
	
	public JLabel makeLabel(int i, JPanel panel) {
		JLabel lblCrewMember = new JLabel("Crew Member " + (i + 1));
		lblCrewMember.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblCrewMember);
		return lblCrewMember;
	}
	
	public JTextField makeTextField(int i, JPanel panel) {
		JTextField nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(nameField);
		return nameField;
	}
	
	public JComboBox<String> makeComboBox(int i, JPanel panel) {
		JComboBox<String> typeBox = new JComboBox<String>();
		typeBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		typeBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Medic", "Mechanic", "Marathon", "Scavenger", "Survivalist", "Tank"}));
		panel.add(typeBox);
		return typeBox;
	}
	
	public void closeWindow() {
		selectionWindow.dispose();
	}
	
	public void finishedWindow() {
		environment.closeCrewSeletion(this);
	}
	
	public void crewSelected() {
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> typeList = new ArrayList<String>();
		for(int i = 0; i < numCrew; i++) {
			nameList.add(textFieldList.get(i).getText());
			typeList.add(comboList.get(i).getSelectedItem().toString());
		}
		environment.createCrew(this, crewName, nameList, typeList);
	}

}
