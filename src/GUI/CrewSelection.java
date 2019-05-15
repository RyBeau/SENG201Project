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
/**
 * This is screen that appears after the first setup screen.<br>
 * It is used to receive a name and CrewMember type from the player for each Crew Member they wanted to create.
 * @author Ryan Beaumont
 *
 */
public class CrewSelection {
	
	/**
	 * The JFrame containing all the GUI elements
	 */
	private JFrame selectionWindow;
	/**
	 * The name of the crew.
	 */
	private String crewName;
	/**
	 * The number of crew members.
	 */
	private int numCrew;
	/**
	 * The GameEnvironment controlling the game.
	 */
	private GameEnvironment environment;
	/**
	 * The list of labels for each Crew Member to be selected.
	 */
	private ArrayList<JLabel> labelList = new ArrayList<JLabel>();
	/**
	 * The list of text fields for each Crew Member to be selected.
	 */
	private ArrayList<JTextField> textFieldList = new ArrayList<JTextField>();
	/**
	 * The list of Combo boxs for each Crew Member to be selected.
	 */
	private ArrayList<JComboBox<String>> comboList = new ArrayList<JComboBox<String>>();
	/**
	 * The label displaying the name of the Crew.
	 */
	private JLabel lblCrewName;
	/**
	 * The "Start Game" button.
	 */
	private JButton btnStartGame;
	/**
	 * The "Cancel" button.
	 */
	private JButton BtnCancel;
	
	

	/**
	 * Creates the Window.
	 * @param IncomingEnvironment The GameEnvironment that called CrewSelection().
	 * @param name The name for the crew selected by the player.
	 * @param nCrew The number of Crew Members wanted by the player.
	 */
	public CrewSelection(GameEnvironment IncomingEnvironment, String name, int nCrew) {
		environment = IncomingEnvironment;
		crewName = name;
		numCrew = nCrew;
		initialize();
		selectionWindow.setVisible(true);
	}

	/**
	 * This method initialises the basic content of the frame that will not channge depending on user input.<br>
	 * It the calls setupCrewSelection() which sets up the elements that change depending upon previous user input.
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
		
		btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldList.stream().allMatch(x -> x.getText().trim().length() > 0)) { //Checks that each name is not just whitespace.
					crewSelected();
				}else {
					Alert alert = new Alert("All Crew Members require a name!");//Sends alert if a name hasn't been enter for each CrewMember.
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
		
		setupCrewSelection();
	}
/**
 * This method sets up the elements that change depending upon the users previous input.<br>
 * It uses list and a for loop to create the correct number of Labels, text fields and combo boxes.
 */
	public void setupCrewSelection() {
		JPanel autoPanel = new JPanel();
		autoPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		autoPanel.setBounds(18, 51, 394, numCrew * 50);
		selectionWindow.getContentPane().add(autoPanel);
		autoPanel.setLayout(new GridLayout(numCrew, 3, 20, 20));
		
		for(int i = 0; i < numCrew; i++) {//This loops through numCrew times.
			labelList.add(makeLabel(i, autoPanel));//Adds the label to the list of labels
			textFieldList.add(makeTextField(i, autoPanel));//Adds the text field to the list of text fields.
			comboList.add(makeComboBox(i, autoPanel));//Adds the combo box to the list of combo boxes.
		}
	}
	
	/**
	 * This method creates and returns a JLabel with the text "Crew Member " + (i + 1).
	 * @param i The current loop iteration.
	 * @param panel The JPanel that the label is contained within.
	 * @return The created JLabel.
	 */
	public JLabel makeLabel(int i, JPanel panel) {
		JLabel lblCrewMember = new JLabel("Crew Member " + (i + 1));
		lblCrewMember.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblCrewMember);
		return lblCrewMember;
	}
	
	/**
	 * This method creates and returns JTextField.
	 * @param i The current loop iteration.
	 * @param panel The JPanel that the label is contained within.
	 * @return The created JTextField.
	 */
	public JTextField makeTextField(int i, JPanel panel) {
		JTextField nameField = new JTextField();
		nameField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(nameField);
		return nameField;
	}
	
	/**
	 * This method creates and returns JComboBox.
	 * @param i The current loop iteration.
	 * @param panel The JPanel that the label is contained within.
	 * @return The created JComboBox.
	 */
	public JComboBox<String> makeComboBox(int i, JPanel panel) {
		JComboBox<String> typeBox = new JComboBox<String>();
		typeBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		typeBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Medic", "Mechanic", "Marathon", "Scavenger", "Survivalist", "Tank"}));
		panel.add(typeBox);
		return typeBox;
	}
	/**
	 * Closes the CrewSelection Object.
	 */
	public void closeWindow() {
		selectionWindow.dispose();
	}
	/**
	 * Called when the "Cancel" button is pressed.
	 */
	public void finishedWindow() {
		environment.closeCrewSeletion(this);
	}
	
	/**
	 * This method is called with "Start Game" is pressed.<br>
	 * It iterates through numCrew times and adds the entered in the JTextField name into the nameList and the selected type from the JComboBox to typeList.
	 */
	public void crewSelected() {
		ArrayList<String> nameList = new ArrayList<String>();
		ArrayList<String> typeList = new ArrayList<String>();
		for(int i = 0; i < numCrew; i++) {
			nameList.add(textFieldList.get(i).getText()); // Add name from the ith JTextField to the nameList.
			typeList.add(comboList.get(i).getSelectedItem().toString()); // Add the type from the ith JComboBox to the nameList.
		}
		environment.createCrew(this, crewName, nameList, typeList);
	}

}
