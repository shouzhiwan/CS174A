package Window.views;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainConnection.getManagerData;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ManagerPage extends JFrame {

	private JPanel contentPane;
	private JTextField APRField;
	private JTextField userField;
	private JButton btnNextDay;
	private JButton btnAddInterests;
	private JButton btnMonthySatement;
	private JButton btnCustomerReport;
	private JButton btnActiveCustomers;
	private JButton btnTaxReports;
	private JButton btnDeleteTransaction;
	private String user;
	private String theDate = "";
	getManagerData md;
	private JLabel lblDate;
	private JButton btnOpenMarket;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	Boolean Market_Status = false; 
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
		Market_Status = md.getMarketStatus();
		initComponents();
		createEvent();		
		
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 435);
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
		
		
		btnTaxReports = new JButton("Tax Reports");
		
		
		btnCustomerReport = new JButton("Customer Report");
		
		
		btnDeleteTransaction = new JButton("Delete Transaction");
		
		btnNextDay = new JButton("Next Day");
		
		lblDate = new JLabel("Date: " + theDate);
		
		
		btnOpenMarket = new JButton("");
		if(Market_Status) {
			btnOpenMarket.setText("Close Market");
		}
		else {
			btnOpenMarket.setText("Open Market");
		}
		scrollPane = new JScrollPane();
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblDate)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNextDay)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDeleteTransaction))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblRates)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(APRField, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnAddInterests, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnOpenMarket)
							.addGap(240))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblUsername)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(userField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnMonthySatement, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addComponent(btnActiveCustomers)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(btnTaxReports)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnCustomerReport))
							.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
								.addGap(6)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 423, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDate)
						.addComponent(btnNextDay)
						.addComponent(btnDeleteTransaction))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblRates)
						.addComponent(APRField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAddInterests)
						.addComponent(btnOpenMarket))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(userField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnMonthySatement))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnActiveCustomers)
						.addComponent(btnTaxReports)
						.addComponent(btnCustomerReport))
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 233, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
	}
	private void createEvent() {
		// TODO Auto-generated method stub
		btnAddInterests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double interest = Double.parseDouble(APRField.getText());
				md.AddInterests(interest);
				JOptionPane.showMessageDialog(null, "Interests added");		
			}
		});
		btnMonthySatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customer = userField.getText();
				//DefaultListModel dlm = new DefaultListModel();
				textArea.setText("");
				String [] customer_report = md.getMonthStatement(customer);
				String information = md.getUserNEmail(customer);
				textArea.append(information);
				String s = (String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s \n","ID", "User", "Shares", "Symbol", "Type", "Amount", "Balance",
						"Date")).toString();
				textArea.append(s);
				//dlm.addElement(s);
				for(int i = 0; i<(customer_report.length-1)/8;i++) {
					s = String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s \n",
							customer_report[8*i],customer_report[8*i+1],customer_report[8*i+2],
							customer_report[8*i+3],customer_report[8*i+4],customer_report[8*i+5],customer_report[8*i+6], customer_report[8*i+7]);
					//dlm.addElement(s);
					System.out.println(s);
					textArea.append(s);
				}
				
			}
		});
		btnActiveCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] user = md.getActiveUser();
				textArea.setText("");
				String s = (String.format("%-15s %-15s \n", "User", "Shares")).toString();
				textArea.append(s);
				//dlm.addElement(s);
				for(int i = 0; i<(user.length-1)/2;i++) {
					s = String.format("%-15s %-15s\n",
							user[2*i],user[2*i+1]);
					//dlm.addElement(s);
					System.out.println(s);
					textArea.append(s);
				}
			}
		});
		btnTaxReports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String s;
				String [] result = md.getTaxReport();
				//dlm.addElement(s);
				for(int i = 0; i<(result.length-1)/4;i++) {
					s = String.format("%-15s %-15s %-15s %-15s\n",
							result[4*i],result[4*i+1],result[4*i+2],result[4*i+3]);
					//dlm.addElement(s);
					System.out.println(s);
					textArea.append(s);
				}
			}
		});
		btnCustomerReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String customer = userField.getText();
				//DefaultListModel dlm = new DefaultListModel();
				
				textArea.setText("");
				String [] customer_report = md.getCustomerReport();
				String s = (String.format("%-15s %-15s \n","ID", "User", "Balance")).toString();
				textArea.append(s);
				//dlm.addElement(s);
				for(int i = 0; i<(customer_report.length-1)/2;i++) {
					s = String.format("%-15s %-15s\n",
							customer_report[2*i],customer_report[2*i+1]);
					//dlm.addElement(s);
					System.out.println(s);
					textArea.append(s);
				}
				//textArea.setModel(dlm);
				
			}
		});
		btnDeleteTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				md.deleteMonthlyRecord();
				JOptionPane.showMessageDialog(null, "Your have Successfully Delete the Records of Last Month");
			}
		});
		btnNextDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//md.RecordBalance(theDate)==
				if(md.RecordBalance(theDate)==true) {
					try {
						md.addDate(theDate);
						theDate = md.getDate(user);
						lblDate.setText("Date: " + theDate);
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					md.setMarketStatus(false);
					btnOpenMarket.setText("Open Market");
				}
			}
		});
		btnOpenMarket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnOpenMarket.getText().equals("Open Market")) {
					md.setMarketStatus(true);
					btnOpenMarket.setText("Close Market");
				}
				else {
					md.setMarketStatus(false);
					btnOpenMarket.setText("Open Market");
				}
			}
		});
	}
}
