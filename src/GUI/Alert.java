package GUI;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
			JLabel lblAlertText = new JLabel(text);
			lblAlertText.setVerticalAlignment(SwingConstants.TOP);
			lblAlertText.setHorizontalAlignment(SwingConstants.CENTER);
			lblAlertText.setBounds(45, 11, 228, 108);
			getContentPane().add(lblAlertText);
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
