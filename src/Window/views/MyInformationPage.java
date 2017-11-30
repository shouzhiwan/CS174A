package Window.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import MainConnection.getMyInformation;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyInformationPage extends JFrame {

	private JPanel contentPane;
	private String user;
	private JButton btnMyAccount;
	private JButton btnStockMarket;
	private JButton btnGoBack;
	private JTextField NameField;
	private JTextField EmailField;
	private JTextField TaxField;
	private JTextField PhoneField;
	private JTextField StateField;
	private JButton btnEditInformation;
	private JButton btnChangePassword;
	private String[] information = new String[8];
	getMyInformation myInfo;
	private JLabel lblSsn;
	private JTextField SSNField;
	private JLabel lblAddress;
	private JTextField AddressField;
	/**
	 * Launch the application.
	 */
	public static void MyInformation(String theUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyInformationPage frame = new MyInformationPage(theUser);
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
	public MyInformationPage() {
		initComponents();
		createEvent();	
	}
	
	public MyInformationPage(String theUser) {
		this.user = theUser;
		//getMyInformation 
		myInfo = new getMyInformation();
		System.arraycopy(myInfo.getBasicInformations(this.user), 0 , information, 0 , 8 ); 
		initComponents();
		createEvent();	
	}



	private void initComponents() {
		// TODO Auto-generated method stub
		setTitle("The Information for " + this.user);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnMyAccount = new JButton("My Account");
		btnStockMarket = new JButton("Stock Market");
		btnGoBack = new JButton("Go Back");
		
		JLabel lblName = new JLabel("Name");
		
		NameField = new JTextField();
		NameField.setColumns(10);
		NameField.setText(information[0]);
		
		JLabel lblEmail = new JLabel("Email");
		
		EmailField = new JTextField();
		EmailField.setColumns(10);
		EmailField.setText(information[1]);
		
		JLabel lblTaxid = new JLabel("TaxID");
		
		TaxField = new JTextField();
		TaxField.setColumns(10);
		TaxField.setText(information[2]);
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		
		PhoneField = new JTextField();
		PhoneField.setColumns(10);
		PhoneField.setText(information[4]);
		
		StateField = new JTextField();
		StateField.setColumns(10);
		StateField.setText(information[3]);
		JLabel lblState = new JLabel("State");
		
		btnEditInformation = new JButton("Update");
		
		
		btnChangePassword = new JButton("Change Password");
		
		lblSsn = new JLabel("SSN");
		
		SSNField = new JTextField();
		SSNField.setColumns(10);
		SSNField.setText(information[7]);
		lblAddress = new JLabel("Address");
		
		AddressField = new JTextField();
		AddressField.setColumns(10);
		AddressField.setText(information[6]);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(27)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblEmail)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(EmailField, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblName)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(NameField, GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblSsn)
									.addGap(18)
									.addComponent(SSNField, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblTaxid)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(TaxField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblAddress)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(AddressField, GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(28)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnChangePassword, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnEditInformation, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPhoneNumber)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(PhoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblState)
									.addGap(18)
									.addComponent(StateField, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnMyAccount)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnStockMarket)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(btnGoBack, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)))))
					.addGap(72))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(NameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(EmailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSsn)
						.addComponent(SSNField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(TaxField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblTaxid))
					.addGap(10)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(AddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhoneNumber)
						.addComponent(PhoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblState)
						.addComponent(StateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnChangePassword)
						.addComponent(btnEditInformation))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMyAccount)
						.addComponent(btnStockMarket)
						.addComponent(btnGoBack))
					.addGap(59))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void createEvent() {
		// TODO Auto-generated method stub
		btnEditInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String [] informations = new String[5];
				informations[0] = NameField.getText();
				informations[1] = EmailField.getText();
				informations[2] = TaxField.getText();
				informations[3] = StateField.getText();
				informations[4] = PhoneField.getText();
				informations[5] = SSNField.getText();
				informations[6] = AddressField.getText();
				Boolean result = myInfo.UpdateInformation(informations, user);
				if (result) {
					JOptionPane.showMessageDialog(null, "Update your information Succeed!!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Update your information Failed!!");
				}
			}
		});
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldpassword = JOptionPane.showInputDialog("Please type your old password");
				if(oldpassword.equals(information[5])) {
					String newpassword = JOptionPane.showInputDialog("Please type your new password");
					String Checknew = JOptionPane.showInputDialog("Please retype your new password");
					if(newpassword.equals(Checknew)) {
						Boolean result = myInfo.UpdatePassword(newpassword, user);
						information[5] = newpassword;
						if(result) {
							JOptionPane.showMessageDialog(null, "New Password Updated");
						}
						else {
							JOptionPane.showMessageDialog(null, "failed to Update your Password");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Passwords Need to be Matched");
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "Wrong Password");
				}
			}
		});
		btnMyAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyAccountPage map = new MyAccountPage();
				map.MyAccount(user);
				setInvisible();
			}
		});
		
		btnStockMarket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StockMarketPage smp = new StockMarketPage();
				smp.StockMarket(user);
				setInvisible();
			}
		});
		
		btnGoBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AfterLoginPage alp = new AfterLoginPage();
				alp.AfterLogin(user);
				setInvisible();
			}
		});
		
		
	}
	protected void setInvisible() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
}
