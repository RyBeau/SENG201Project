package GUI;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Alert extends JDialog implements ActionListener{
	/**
	 * Create the dialog.
	 */
	public Alert(String text) {
		setAlwaysOnTop(true);
		setTitle("Alert!");
		setBounds(100, 100, 340, 230);
		setLocationRelativeTo(null);
		setModalityType(ModalityType.APPLICATION_MODAL);
		
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
	
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
}
