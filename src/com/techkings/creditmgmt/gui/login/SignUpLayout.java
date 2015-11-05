package com.techkings.creditmgmt.gui.login;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
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

import org.apache.commons.lang3.StringUtils;

import com.techkings.creditmgmt.gui.Dialogs.DialogInfo;
import com.techkings.creditmgmt.index.RecallHomePage;
import com.techkings.creditmgmt.process.login.UserValidation;

public class SignUpLayout extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6304491489509931081L;
	private JPanel buttonPanel;
	private JPanel inputPanel;
	private JButton signup;
	private JButton cancel;
	private JLabel labelPassword;
	private JLabel labelUsername;
	private JLabel labelFirstname;
	private JLabel labelLastname;
	private JPasswordField textPassword;
	private JTextField textUsername;
	private JTextField textFirstname;
	private JTextField textLastname;
	private Container pane;

	public SignUpLayout() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				RecallHomePage.onClose();
			}
		});
		setTitle("Sign Up");
		pane = getContentPane();
		pane.setLayout(new BorderLayout());
		buttonPanel = new JPanel();
		inputPanel = new JPanel();
		signup = new JButton("SignUp");
		cancel = new JButton("Cancel");
		labelPassword = new JLabel("Password");
		labelUsername = new JLabel("Username");
		labelFirstname = new JLabel("First Name");
		labelLastname = new JLabel("Last Name");
		textPassword = new JPasswordField(10);
		textUsername = new JTextField(10);
		textFirstname = new JTextField(15);
		textLastname = new JTextField(15);
		buttonPanel.setLayout(new GridLayout(1, 1));
		inputPanel.setLayout(new GridLayout(4, 4));
		buttonPanel.add(signup, BorderLayout.LINE_START);
		buttonPanel.add(cancel, BorderLayout.LINE_END);
		inputPanel.add(labelUsername);
		inputPanel.add(textUsername);
		inputPanel.add(labelPassword);
		inputPanel.add(textPassword);
		inputPanel.add(labelFirstname);
		inputPanel.add(textFirstname);
		inputPanel.add(labelLastname);
		inputPanel.add(textLastname);
		pane.add(inputPanel, BorderLayout.NORTH);
		pane.add(buttonPanel, BorderLayout.SOUTH);
		signup.addActionListener(this);
		cancel.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancel) {
			this.setVisible(false);
			RecallHomePage.onClose();
		} else if (e.getSource() == signup) {
			String userName = textUsername.getText();
			String password = new String(textPassword.getPassword());
			String firstName = textFirstname.getText();
			String lastName = textLastname.getText();

			if (StringUtils.isNotEmpty(userName)
					&& StringUtils.isNotEmpty(password)
					&& StringUtils.isNotEmpty(firstName)
					&& StringUtils.isNotEmpty(lastName)) {
				UserValidation userValidation = new UserValidation(userName,
						password, firstName, lastName);
				if (userValidation.isUserAvailable()) {
					DialogInfo.showMessageBox(pane,
							"Specified username is already available. ");
				} else {
					if (userValidation.createUser()) {
						DialogInfo.showMessageBox(pane,
								"New user added successfully. ");
						userValidation.resetUserDetail();
						this.setVisible(false);
						RecallHomePage.onClose();
					} else {
						DialogInfo.showMessageBox(pane,
								"There is some problem while creating user. ");
					}
				}
			} else {
				JOptionPane.showMessageDialog(pane,
						"Please provide all the details.");
			}
		}
	}
}
