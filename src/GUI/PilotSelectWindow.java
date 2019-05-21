package GUI;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import Main.Crew;
import Main.CrewMember;
import Main.Planet;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalityType;

import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
/**
 * This is the GUI window for selecting the second pilot for piloting the ship to a new planet.
 * @author Ryan Beaumont
 *
 */
public class PilotSelectWindow {

	/**
	 * The Crew for the current game.
	 */
	private Crew crew;
	/**
	 * The GameWindow that the player uses to interact with the game.
	 */
	private GameWindow gameScreen;
	/**
	 * This is the CrewMember that's pilotShip method will be called.
	 */
	private CrewMember primaryPilot;
	/**
	 * This is the Planet object for the game.
	 */
	private Planet planet;
	/**
	 * This is the JDialog holding all the GUI Elements.
	 */
	private JDialog pilotSelectScreen;
	/**
	 * This is the second pilot that the player must select. It is initialised to null to test the no selection case.
	 */
	private CrewMember secondPilot = null;
	/**
	 * This is the list of valid pilot choices. A valid pilot choice is a CrewMember with at least 1 action.
	 */
	private JList<CrewMember> pilotList;
	/**
	 * This method sets the intial values for class variables using the given parameters.
	 * @param incomingCrewMember The CrewMember that was selected by the player when the pressed "Pilot Ship".
	 * @param incomingScreen The GameWindow the player is currently interacting with.
	 * @param incomingCrew The current Crew of the game.
	 * @param incomingPlanet The Planet object for the current game.
	 */
	public PilotSelectWindow(CrewMember incomingCrewMember, GameWindow incomingScreen,
			Crew incomingCrew, Planet incomingPlanet) {
		crew = incomingCrew;
		gameScreen = incomingScreen;
		primaryPilot = incomingCrewMember;
		planet = incomingPlanet;
		initialize();
		pilotSelectScreen.setVisible(true);
	}

	/**
	 * This method initialises the GUI elements.
	 */
	private void initialize() {
		pilotSelectScreen = new JDialog();
		pilotSelectScreen.setBounds(100, 100, 239, 297);
		pilotSelectScreen.setLocationRelativeTo(null);
		pilotSelectScreen.setAlwaysOnTop(true);
		pilotSelectScreen.setModalityType(ModalityType.APPLICATION_MODAL);
		pilotSelectScreen.getContentPane().setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnCancel.setBounds(122, 223, 95, 25);
		pilotSelectScreen.getContentPane().add(btnCancel);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(secondPilot != null) {
					String alertMessage = primaryPilot.pilotShip(secondPilot, planet, crew.getCrewShip());
					new Alert(alertMessage);
					closeWindow();
				}else {
					new Alert("No Second Pilot Selected!");
				}
			}
		});
		btnSelect.setBounds(10, 222, 95, 26);
		pilotSelectScreen.getContentPane().add(btnSelect);
		
		JList<CrewMember> pilotList = new JList<CrewMember>();
		pilotList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				secondPilot = pilotList.getSelectedValue();
			}
		});
		pilotList.setModel(new AbstractListModel() {
			CrewMember[] values = makePilotList();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		pilotList.setBackground(UIManager.getColor("Button.background"));
		pilotList.setBorder(new LineBorder(new Color(0, 0, 0)));
		pilotList.setBounds(10, 46, 208, 166);
		pilotSelectScreen.getContentPane().add(pilotList);
		
		JLabel lblSelectSecondPilot = new JLabel("Select Second Pilot");
		lblSelectSecondPilot.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectSecondPilot.setBounds(10, 12, 184, 32);
		pilotSelectScreen.getContentPane().add(lblSelectSecondPilot);
	}
	/**
	 * This method gets the list of CrewMembers from crew and then removes those who have no actions.
	 * @return An array of CrewMember instances that are valid pilot options.
	 */
	private CrewMember[] makePilotList() {
		ArrayList<CrewMember> crewList = new ArrayList<CrewMember>(crew.getCrewList());
		crewList.remove(primaryPilot);
		for(CrewMember secondPilot: crew.getCrewList()) {
			if(!secondPilot.hasActions()) {
				crewList.remove(secondPilot);
			}
		}
		return crewList.toArray(new CrewMember[crewList.size()]);
	
	}
	
	/**
	 * This method closes the pilotSelectScreen and then calls the refresh() method of the gameScreen.
	 */
	private void closeWindow() {
		pilotSelectScreen.dispose();
		gameScreen.refresh();
	}
}
