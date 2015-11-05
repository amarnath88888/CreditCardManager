package com.techkings.creditmgmt.gui.userwindow;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.techkings.creditmgmt.index.RecallHomePage;
import com.techkings.creditmgmt.process.login.UserDetailBean;

public class MainWindowLayout extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 203444504626879861L;

	private JMenuBar menuBar;
	private JMenu addMenu;
	private JMenu editMenu;
	private JMenu viewMenu;
	private JMenuItem addNewCreditCard;
	private JMenuItem editCreditCard;
	private JMenuItem addExpenseForCard;
	private JMenuItem viewCardStatement;
	private JMenuItem viewCardSummary;
	private Container pane;
	private CardLayout cardLayout;
	private JPanel addNCC;
	private JPanel addExp;
	private JPanel editCard;
	private JPanel viewCC;
	private JPanel viewCS;
	private JPanel menuPanel;

	public MainWindowLayout(UserDetailBean userDetailBean) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				RecallHomePage.onClose();
			}
		});
		setTitle("Credit card management for " + userDetailBean.getFirstName()
				+ " " + userDetailBean.getLastName());
		pane = new JPanel();
		cardLayout = new CardLayout();
		pane.setLayout(cardLayout);

		addNCC = new JPanel();
		addExp = new JPanel();
		editCard = new JPanel();
		viewCC = new JPanel();
		viewCS = new JPanel();

		menuPanel = new JPanel();

		pane.add(addNCC, "1");
		pane.add(addExp, "2");
		pane.add(editCard, "3");
		pane.add(viewCC, "4");
		pane.add(viewCS, "5");

		menuBar = new JMenuBar();
		addMenu = new JMenu("Add");
		editMenu = new JMenu("Edit");
		viewMenu = new JMenu("View");
		addNewCreditCard = new JMenuItem("Add New Card");
		addExpenseForCard = new JMenuItem("Add Expense");
		addNewCreditCard.addActionListener(this);
		addExpenseForCard.addActionListener(this);
		addMenu.add(addNewCreditCard);
		addMenu.add(addExpenseForCard);
		editCreditCard = new JMenuItem("Edit Card");
		editCreditCard.addActionListener(this);
		editMenu.add(editCreditCard);
		viewCardStatement = new JMenuItem("View Card Statement");
		viewCardSummary = new JMenuItem("View Card Summary");
		viewCardStatement.addActionListener(this);
		viewCardSummary.addActionListener(this);
		viewMenu.add(viewCardStatement);
		viewMenu.add(viewCardSummary);
		menuBar.add(addMenu);
		menuBar.add(editMenu);
		menuBar.add(viewMenu);
		this.setJMenuBar(menuBar);

		getContentPane().add(pane, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addMenu) {
			showAddCreditCardGUI();
		}
	}

	public void showAddCreditCardGUI() {

	}
}
