package Window.views;

import MainConnection.Drive;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegisterPage extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField namefield;
	private JTextField emailField;
	private JTextField taxIdField;
	private JTextField stateField;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JPasswordField retypeField;
	private JButton btnClearAll;
	private JButton btnBack;
	private JButton btnCreateAccount;
	private JLabel lblPhone;
	private JTextField phoneField;
	private JTextField SSNField;
	private JTextField AddressField;

	/**
	 * Launch the application.
	 */
	public static void Register() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegisterPage frame = new RegisterPage();
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
	public RegisterPage() {
		initComponents();
		createEvent();
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setTitle("Create An Account for Me");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 402, 493);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lblEmail = new JLabel("Email");
		
		JLabel lblTaxid = new JLabel("TaxID");
		
		JLabel lblState = new JLabel("State");
		
		JLabel lblUsername = new JLabel("Username");
		
		JLabel lblPassword = new JLabel("Password");
		
		JLabel lblRetypePassword = new JLabel("Retype Password");
		
		namefield = new JTextField();
		namefield.setColumns(10);
		
		emailField = new JTextField();
		emailField.setColumns(10);
		
		taxIdField = new JTextField();
		taxIdField.setColumns(10);
		
		stateField = new JTextField();
		stateField.setColumns(10);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		
		JLabel lblYourInformation = new JLabel("Your Information");
		
		JLabel lblCreateYourAccount = new JLabel("Create Your Account");
		
		retypeField = new JPasswordField();
		retypeField.setColumns(10);
		
		btnClearAll = new JButton("Clear");
		btnBack = new JButton("Back");
		btnCreateAccount = new JButton("Create");
		
		phoneField = new JTextField();
		phoneField.setColumns(10);
		
		lblPhone = new JLabel("Phone");
		
		JLabel lblSsn = new JLabel("SSN");
		
		SSNField = new JTextField();
		SSNField.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		
		AddressField = new JTextField();
		AddressField.setColumns(10);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(177)
							.addComponent(lblYourInformation))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(39)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblName)
										.addComponent(lblEmail))
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(namefield, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
										.addComponent(emailField)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
											.addComponent(lblUsername)
											.addComponent(usernameField, 215, 215, 215)
											.addComponent(lblPassword)
											.addComponent(passwordField, 215, 215, 215)
											.addComponent(lblRetypePassword)
											.addComponent(retypeField, GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE))
										.addGap(18)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
											.addComponent(btnCreateAccount, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnBack, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addComponent(btnClearAll, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblAddress)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(AddressField, GroupLayout.DEFAULT_SIZE, 316, Short.MAX_VALUE))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addComponent(lblTaxid)
										.addGap(18)
										.addComponent(taxIdField, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblSsn)
										.addGap(18)
										.addComponent(SSNField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(lblPhone)
										.addGap(18)
										.addComponent(phoneField, GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)
										.addGap(9)
										.addComponent(lblState)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(stateField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED))))))
					.addGap(89))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(155)
					.addComponent(lblCreateYourAccount)
					.addContainerGap(217, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblYourInformation)
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(namefield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEmail)
						.addComponent(emailField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTaxid)
						.addComponent(taxIdField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSsn)
						.addComponent(SSNField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblAddress)
						.addComponent(AddressField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(16)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblState)
							.addComponent(stateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(phoneField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPhone)))
					.addGap(18)
					.addComponent(lblCreateYourAccount)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblUsername)
					.addGap(2)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPassword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCreateAccount))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblRetypePassword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(retypeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClearAll))
					.addGap(184))
		);
		contentPane.setLayout(gl_contentPane);
		
	}
	
	private void createEvent() {
		// TODO Auto-generated method stub
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (Component c : contentPane.getComponents())
		        {
		            if (c instanceof JTextField)
		            {
		                JTextField j = (JTextField)c;
		                j.setText("");
		            }
		        }
			}
		});
		
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();
				lp.Login();
				setInvisible();
			}

		});
		
		btnCreateAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] informations = new String[9];
				
				int flag = 0;
				for (Component c : contentPane.getComponents())
		        {
		            if (c instanceof JTextField)
		            {
		                JTextField j = (JTextField)c;
		                if(j.getText().equals("")) {
		                		JOptionPane.showMessageDialog(null, "Invalid field Input");
		                		flag = 1;
		                		break;
		                }
		            }
		        }
				String pwd = new String(passwordField.getPassword());
				String pwdCheck = new String(retypeField.getPassword());
				System.out.println(pwd);
				System.out.println("\n");
				System.out.println(pwdCheck);
				if(flag == 0) {
					if(pwd.equals(pwdCheck)) {
						informations[0] = namefield.getText();
						informations[1] = emailField.getText();
						informations[2] = taxIdField.getText();
						informations[3] = stateField.getText();
						informations[4] = usernameField.getText();
						informations[5] = pwd;
						informations[6] = phoneField.getText();
						informations[7] = SSNField.getText();
						informations[8] = AddressField.getText();
						Drive d = new Drive();
						Boolean result = d.CreateAccount(informations);
						if(result == true) {
							JOptionPane.showMessageDialog(null, "Account Created, Click Back to Log In");
						}
						if(result == false){
							JOptionPane.showMessageDialog(null, "Failed to Create, Click Clear to Retry");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "Password Fields Need To Be Mathced");
						passwordField.setText("");
						retypeField.setText("");
					}
				}
			}
		});
	}

	protected void setInvisible() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
}
