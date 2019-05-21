package GUI;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import Main.Crew;
import Main.Outpost;
import Main.PurchasableAdaptor;

import java.awt.Color;
import java.awt.Dialog.ModalityType;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
/**
 * This is the outpost (or shop) window.<br>
 * This screen is used to purchase FoodItem and MedicalItem objects<br>
 * @author Daniel Porter
 */
public class OutpostScreen {
	
	/**
	 * This is the JDialog that contains all the GUI elements.
	 */
	private JDialog frmOutpost;
	/**
	 * This is the Crew for the current game.
	 */
	private Crew crew;
	/**
	 * The Outpost for the game.
	 */
	private Outpost outpost;
	/**
	 * The JList of items that can be purchased from the store.
	 */
	private JList<PurchasableAdaptor> listOfItems;
	/**
	 * This is the GameWindow for the current game.
	 */
	private GameWindow gameScreen;
	
	
	/**
	 * The constructor for the OutpostScreen GUI.<br>
	 * This is called by the GameWindow when the player presses "Visit Outpost"
	 * @param incomingCrew The Crew of the current game.
	 * @param incomingOutpost The Outpost of the current planet.
	 * @param incomingGameScreen The GameWindow for the current game session.
	 */
	public OutpostScreen(Crew incomingCrew, Outpost incomingOutpost, GameWindow incomingGameScreen) {
		outpost = incomingOutpost;
		crew = incomingCrew;
		gameScreen = incomingGameScreen;
		initialize();
		frmOutpost.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.<br>
	 * Builds the GUI elements within the JDialog.<br>
	 * Called when an instance of OutpostScreen is created.
	 */
	private void initialize() {
		frmOutpost = new JDialog();
		frmOutpost.setResizable(false);
		frmOutpost.setTitle("Outpost");
		frmOutpost.setBounds(100, 100, 402, 321);
		frmOutpost.setLocationRelativeTo(null);
		frmOutpost.setModalityType(ModalityType.APPLICATION_MODAL);
		frmOutpost.getContentPane().setLayout(null);

		JLabel lblMoney = new JLabel("$" + String.valueOf(crew.getMoney())); 
		lblMoney.setBounds(305, 15, 92, 26);
		frmOutpost.getContentPane().add(lblMoney);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmOutpost.dispose();
			}
		});
		btnCancel.setBounds(215, 234, 141, 35);
		frmOutpost.getContentPane().add(btnCancel);
		
		JButton btnBuy = new JButton("Buy");
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listOfItems.getSelectedValue().purchase(crew);
				lblMoney.setText("$" + String.valueOf(crew.getMoney()));
				gameScreen.refresh();
			}
		});
		btnBuy.setBounds(40, 234, 141, 35);
		frmOutpost.getContentPane().add(btnBuy);
		

		
		
		ArrayList<PurchasableAdaptor> itemList = new ArrayList<PurchasableAdaptor>();
		itemList.addAll(outpost.viewFoodItems());
		itemList.addAll(outpost.viewMedicalItems());
		
		JLabel lblItemsToBuy = new JLabel("Items To Buy");
		lblItemsToBuy.setBounds(21, 15, 188, 26);
		frmOutpost.getContentPane().add(lblItemsToBuy);
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		textPane.setBackground(UIManager.getColor("Button.background"));
		textPane.setBounds(215, 62, 160, 150);
		frmOutpost.getContentPane().add(textPane);
		
		JScrollPane itemsScrollPane = new JScrollPane();
		itemsScrollPane.setBounds(21, 62, 160, 150);
		frmOutpost.getContentPane().add(itemsScrollPane);
		listOfItems = new JList();
		listOfItems.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				textPane.setText(listOfItems.getSelectedValue().itemDescription());
			}
		});
		itemsScrollPane.setViewportView(listOfItems);
		listOfItems.setBorder(new LineBorder(new Color(0, 0, 0)));
		listOfItems.setBackground(UIManager.getColor("Button.background"));
		listOfItems.setModel(new AbstractListModel<PurchasableAdaptor>() {
			ArrayList<PurchasableAdaptor> values = itemList;
			public int getSize() {
				return values.size();
			}
			public PurchasableAdaptor getElementAt(int index) {
				return values.get(index);
			}
		});
		
		listOfItems.setSelectedIndex(0);
	}
}
