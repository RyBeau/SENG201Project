package GUI;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
/**
 * This is the Alert dialog.<br>
 * It is used any time the player needs to be informed of something before they continue with the game<br>
 * The player cannot continue until the Alert is closed.
 * @author Ryan Beaumont
 *
 */
public class Alert extends JDialog implements ActionListener{
	/**
	 * Create the dialog and OK button.
	 * @param text This is the text that should be displayed by the alert.
	 */
	public Alert(String text) {
		setAlwaysOnTop(true);
		setTitle("Alert!");
		setBounds(100, 100, 340, 230);
		setLocationRelativeTo(null);
		setModalityType(ModalityType.APPLICATION_MODAL);//Making it so you cannot interact with another window until you close the alert.
		
		getContentPane().setLayout(null);
		{
			JTextPane tpAlertText = new JTextPane();
			tpAlertText.setEditable(false);
			tpAlertText.setText(text);
			tpAlertText.setBackground(UIManager.getColor("InternalFrame.borderColor"));			
			StyledDocument doc = tpAlertText.getStyledDocument();
			SimpleAttributeSet center = new SimpleAttributeSet();
			StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
			doc.setParagraphAttributes(0, doc.getLength(), center, false);
			tpAlertText.setBounds(45, 11, 228, 108);
			getContentPane().add(tpAlertText);
		}
		
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(this);
		btnOK.setBounds(102, 130, 120, 50);
		getContentPane().add(btnOK);
		this.setVisible(true);
	}
	/**
	 * This method closes the Alert once the OK button has been pressed.
	 */
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}
