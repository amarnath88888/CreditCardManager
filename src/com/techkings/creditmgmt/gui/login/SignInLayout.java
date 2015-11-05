package com.techkings.creditmgmt.gui.login;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.techkings.creditmgmt.gui.userwindow.MainWindowLayout;
import com.techkings.creditmgmt.index.RecallHomePage;
import com.techkings.creditmgmt.process.login.UserValidation;

public class SignInLayout extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3985271869559674904L;
	private JPanel buttonPanel;
	private JPanel inputPanel;
	private JButton login;
	private JLabel labelPassword;
	private JLabel labelUsername;
	private JPasswordField textPassword;
	private JTextField textUsername;
	private Container pane;

	public SignInLayout() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				RecallHomePage.onClose();
			}
		});
		setTitle("Sign In");
		pane = getContentPane();
		pane.setLayout(new BorderLayout());
		buttonPanel = new JPanel();
		inputPanel = new JPanel();
		login = new JButton("Login");
		labelPassword = new JLabel("Password");
		labelUsername = new JLabel("Username");
		textPassword = new JPasswordField(10);
		textUsername = new JTextField(10);
		buttonPanel.setLayout(new GridLayout(1, 1));
		inputPanel.setLayout(new GridLayout(2, 2));
		buttonPanel.add(login, BorderLayout.CENTER);
		inputPanel.add(labelUsername);
		inputPanel.add(textUsername);
		inputPanel.add(labelPassword);
		inputPanel.add(textPassword);
		pane.add(inputPanel, BorderLayout.NORTH);
		pane.add(buttonPanel, BorderLayout.SOUTH);
		login.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String userName = textUsername.getText();
		String password = new String(textPassword.getPassword());

		UserValidation userValidation = new UserValidation(userName, password);
		if (userValidation.isValidUser()) {
			this.setVisible(false);
			MainWindowLayout mainWindowLayout = new MainWindowLayout(
					userValidation.getUserDetail());
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			final int HEIGHT = 800;
			final int WIDTH = 600;
			mainWindowLayout.setBounds(((screenSize.width / 2) - (WIDTH / 2)),
					((screenSize.height / 2) - (HEIGHT / 2)), WIDTH, HEIGHT);
			mainWindowLayout.setVisible(true);
			setVisible(false);
		} else {
			JOptionPane.showMessageDialog(pane,
					"Invalid userid or password. Please try again.");
			textUsername.setText("");
			textPassword.setText("");
		}
	}

}