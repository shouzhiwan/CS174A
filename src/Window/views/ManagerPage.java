package Window.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainConnection.getManagerData;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManagerPage extends JFrame {

	private JPanel contentPane;
	private JTextField APRField;
	private JTextField userField;
	private JTextField dateField;
	private JButton btnNextDay;
	private JButton btnAddInterests;
	private JButton btnMonthySatement;
	private JButton btnCustomerReport;
	private JButton btnActiveCustomers;
	private JButton btnAllCustomers;
	private JButton btnTaxReports;
	private JButton btnDeleteTransaction;
	private String user;
	private String theDate = "";
	getManagerData md;
	/**
	 * Launch the application.
	 */
	public static void Manager(String theUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManagerPage frame = new ManagerPage(theUser);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ManagerPage() {
		
		initComponents();
		createEvent();		
		
	}
	public ManagerPage(String theUser) {
		this.user = theUser;
		md = new getManagerData();
		theDate = md.getDate(theUser);
		initComponents();
		createEvent();		
		
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnAddInterests = new JButton("Add Interests");
		
		
		APRField = new JTextField();
		APRField.setColumns(10);
		APRField.setText("0.03");
		
		JLabel lblRates = new JLabel("Rates");
		
		btnMonthySatement = new JButton("Monthly Statement");
		
		
		
		JLabel lblUsername = new JLabel(" Username");
		
		userField = new JTextField();
		userField.setColumns(10);
		
		btnActiveCustomers = new JButton("Active Customers");
		
		
		btnAllCustomers = new JButton("All Customers");
		
		
		btnTaxReports = new JButton("Tax Reports");
		
		
		btnCustomerReport = new JButton("Customer Report");
		
		
		btnDeleteTransaction = new JButton("Delete Transaction");
		
		
		dateField = new JTextField();
		dateField.setColumns(10);
		//String td = theDate.toString();
		//System.out.println(td);
		dateField.setText(theDate);
		
		btnNextDay = new JButton("Next Day");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(51)
							.addComponent(lblRates)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(APRField, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnAddInterests, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(82)
							.addComponent(btnCustomerReport))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnActiveCustomers)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblUsername)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(userField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnMonthySatement, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnAllCustomers)
								.addComponent(btnDeleteTransaction)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(dateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNextDay))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(6)
									.addComponent(btnTaxReports)))))
					.addContainerGap(68, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(dateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnNextDay))
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRates)
						.addComponent(APRField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddInterests))
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(userField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMonthySatement))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCustomerReport)
					.addGap(18)
					.addComponent(btnActiveCustomers)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnAllCustomers)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnTaxReports)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDeleteTransaction)
					.addContainerGap(107, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
	private void createEvent() {
		// TODO Auto-generated method stub
		btnAddInterests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMonthySatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnActiveCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnAllCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTaxReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCustomerReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//md.RecordBalance(theDate)==
				if(md.RecordBalance(theDate)==true) {
					try {
						md.addDate(theDate);
						theDate = md.getDate(user);
						dateField.setText(theDate);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
	}

}
