package GUI;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import Main.GameEnvironment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/**
 * This is the initial start screen. The player sees this to begin and is returned to it at the end of their game.
 * @author Ryan Beaumont
 *
 */
public class StartWindow {

	private JFrame startScreen;
	private GameEnvironment environment;

	/**
	 * Create the application.
	 */
	public StartWindow(GameEnvironment IncomingEnvironment) {
		environment = IncomingEnvironment;
		initialize();
		startScreen.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		startScreen = new JFrame();
		startScreen.setResizable(false);
		startScreen.setTitle("Space Explorer");
		startScreen.setBounds(100, 100, 450, 400);
		startScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		startScreen.getContentPane().setLayout(null);
		startScreen.setLocationRelativeTo(null);
		
		JLabel lblSpaceExplorer = new JLabel("Space Explorer");
		lblSpaceExplorer.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpaceExplorer.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSpaceExplorer.setBounds(110, 208, 214, 47);
		startScreen.getContentPane().add(lblSpaceExplorer);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(true);
			}
		});
		btnStartGame.setBounds(155, 256, 120, 40);
		startScreen.getContentPane().add(btnStartGame);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				finishedWindow(false);
			}
		});
		btnExit.setBounds(155, 307, 120, 40);
		startScreen.getContentPane().add(btnExit);
		
		//Causing NullPointerException
		JLabel lblImage= new JLabel("");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setIcon(new ImageIcon(StartWindow.class.getResource("/Images/RocketShip.png")));
		lblImage.setBounds(114, 0, 220, 220);
		startScreen.getContentPane().add(lblImage);
	}
	/**
	 * Closes startScreen.
	 */
	public void closeWindow() {
		startScreen.dispose();
	}
	/**
	 * Calls the closeStartScreen method in GameEnvironment.<br>
	 * Called when btnExit or btnStartGame are pressed.
	 * @param start The boolean value of whether to start a game or not.
	 */
	public void finishedWindow(boolean start) {
		environment.closeStartScreen(this, start);
	}
}
