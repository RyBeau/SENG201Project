package GUI;

import javax.swing.JDialog;
import javax.swing.JList;
import Main.Crew;
import Main.CrewMember;
import Main.FoodItem;
import Main.GameEnvironment;
import Main.MedicalItem;
import Main.PurchasableAdaptor;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalityType;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.AbstractListModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * This is the GUI window for selecting which FoodItem or MedicalItem the player would like to use.<br>
 * It then calls either the heal or feed method in environment with member and the FoodItem or MedicalItem<br>
 * @author Ryan Beaumont
 *
 */
public class UseItemWindow {
	/**
	 * The current Crew for the game.
	 */
	private Crew crew;
	/**
	 * The CrewMember that was selected by the player.
	 */
	private CrewMember member;
	/**
	 * The GameEnvironment controlling the game.
	 */
	private GameEnvironment environment;
	/**
	 * The GameWindow that the player uses to interact with the game.
	 */
	private GameWindow gameScreen;
	/**
	 * The String indicating which action was selected by the player.
	 */
	private String type;
	/**
	 * The JList of items for the player to select from.
	 */
	private JList<PurchasableAdaptor> itemList;
	/**
	 * The JTextPane that shows the description of the currently selected item.
	 */
	private JTextPane infoPane;
	/**
	 * The JDialog holding all of the GUI elements.
	 */
	private JDialog useItemScreen;


	/**
	 * This method initialises each of the variables within the class with the given parameters.<br>
	 * It then calls initialize() that creates all the GUI elements for the window.<br>
	 * Finally it selects the first item in the JList itemList.
	 * 
	 * 
	 * @param incomingEnvironment This incoming controlling GameEnvironment.
	 * @param incomingGameScreen The incoming current GameWindow.
	 * @param incomingCrew The incoming Crew for the game.
	 * @param incomingCrewMember The CrewMember that will be using a selected item.
	 * @param whichType A string "FoodItem" or "MedicalItem" that is used to build the class.
	 */
	public UseItemWindow(GameEnvironment incomingEnvironment, GameWindow incomingGameScreen, Crew incomingCrew, CrewMember incomingCrewMember, String whichType) {
		crew = incomingCrew;
		member = incomingCrewMember;
		environment = incomingEnvironment;
		gameScreen = incomingGameScreen;
		type = whichType;

		initialize();
		useItemScreen.setVisible(true);
		itemList.setSelectedIndex(0);
	}

	/**
	 * Initializes the GUI elements for the window.<br>
	 * Creates the correct itemList by checking the String type.<br>
	 * If "FoodItem" then the action intended is feed() else it is heal().<br>
	 * The same method is used within the ActionListener for btnUse to call the correct method within GameEnvironment.
	 */
	private void initialize() {
		useItemScreen = new JDialog();
		useItemScreen.setTitle("Use Item");
		useItemScreen.setBounds(100, 100, 385, 240);
		useItemScreen.setLocationRelativeTo(null);
		useItemScreen.setModalityType(ModalityType.APPLICATION_MODAL);
		useItemScreen.getContentPane().setLayout(null);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				closeWindow();
			}
		});
		btnCancel.setBounds(206, 168, 163, 23);
		useItemScreen.getContentPane().add(btnCancel);
		
		JLabel lblSelectItemTo = new JLabel("Select Item to use:");
		lblSelectItemTo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSelectItemTo.setBounds(10, 0, 143, 34);
		useItemScreen.getContentPane().add(lblSelectItemTo);
		
		itemList = new JList<PurchasableAdaptor>();
		itemList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				updateInfoPane();
			}
		});
		
		if(type == "FoodItem") {
			makeFoodList();
		}else {
			makeMedicalList();
		}
		
		infoPane = new JTextPane();
		infoPane.setBackground(UIManager.getColor("Button.background"));
		infoPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		infoPane.setEditable(false);
		infoPane.setBounds(206, 35, 163, 122);
		useItemScreen.getContentPane().add(infoPane);
		
		JButton btnUse = new JButton("Use");
		btnUse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(type == "FoodItem") {
					environment.feed(member, (FoodItem) itemList.getSelectedValue());
				}else {
					environment.heal(member, (MedicalItem) itemList.getSelectedValue());
				}
				closeWindow();
			}
		});
		btnUse.setBounds(10, 168, 163, 23);
		useItemScreen.getContentPane().add(btnUse);
	}
	
	/**
	 * This method creates a JList of FoodItems.<br>
	 * Called by initialize() if the player press the "Eat Food" button.
	 */
	private void makeFoodList() {
		itemList.setModel(new AbstractListModel() {
			FoodItem[] values = crew.getFoodItems().toArray(new FoodItem[crew.getFoodItems().size()]);
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		itemList.setBackground(UIManager.getColor("Button.background"));
		itemList.setBorder(new LineBorder(new Color(0, 0, 0)));
		itemList.setBounds(10, 35, 163, 122);
		useItemScreen.getContentPane().add(itemList);
	}
	
	/**
	 * This method creates a JList of MedicalItems.<br>
	 * Called by initialize() if the player press the "Heal" button.
	 */
	private void makeMedicalList() {
		itemList.setModel(new AbstractListModel() {
			MedicalItem[] values = crew.getMedicalItems().toArray(new MedicalItem[crew.getMedicalItems().size()]);
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		itemList.setBackground(UIManager.getColor("Button.background"));
		itemList.setBorder(new LineBorder(new Color(0, 0, 0)));
		itemList.setBounds(10, 35, 163, 122);
		useItemScreen.getContentPane().add(itemList);
	}
	
	
	/**
	 * This updates the infoPane that displays the item description.
	 */
	private void updateInfoPane(){
		infoPane.setText(itemList.getSelectedValue().itemDescription());
	}
	
	/**
	 * This method closes the UseItemWindow and then calls the updateCrewMember() method in GameWindow to show the new
	 * status of the CrewMember.
	 */
	private void closeWindow() {
		useItemScreen.dispose();
		gameScreen.updateCrewMember();
	}
}
