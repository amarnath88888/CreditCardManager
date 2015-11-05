package com.techkings.creditmgmt.index;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.techkings.creditmgmt.gui.login.SignInLayout;
import com.techkings.creditmgmt.gui.login.SignUpLayout;

public class HomePageLayout extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5517197364936817857L;
	private JPanel buttonPanel;
	private JPanel topPanel;
	private JPanel bottomPanel;
	private JButton login;
	private JButton create;
	private JLabel title;
	private Container pane;

	public HomePageLayout() {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setTitle("Credit Management System - Techkings");
		pane = getContentPane();
		pane.setLayout(new FlowLayout());
		buttonPanel = new JPanel();
		topPanel = new JPanel();
		bottomPanel = new JPanel();
		login = new JButton("SignIn");
		create = new JButton("SignUp");
		title = new JLabel("Credit Management");
		title.setFont(new Font("Arial", Font.BOLD, 30));
		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.add(login);
		buttonPanel.add(create);
		topPanel.setLayout(new FlowLayout());
		topPanel.add(title);
		pane.add(topPanel);
		pane.add(buttonPanel);
		pane.add(bottomPanel);
		login.addActionListener(this);
		create.addActionListener(this);
	}

	// ACTION LISTENERS FOR GUI BUTTONS
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == login) {
			SignInLayout signInLayout = new SignInLayout();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			final int HEIGHT = 100;
			final int WIDTH = 300;
			signInLayout.setBounds(((screenSize.width / 2) - (WIDTH / 2)),
					((screenSize.height / 2) - (HEIGHT / 2)), WIDTH, HEIGHT);
			signInLayout.setVisible(true);
			setVisible(false);
		}

		else {
			SignUpLayout signUpLayout = new SignUpLayout();
			Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
			final int HEIGHT = 150;
			final int WIDTH = 300;
			signUpLayout.setBounds(((screenSize.width / 2) - (WIDTH / 2)),
					((screenSize.height / 2) - (HEIGHT / 2)), WIDTH, HEIGHT);
			signUpLayout.setVisible(true);
			setVisible(false);
		}
	}
}
