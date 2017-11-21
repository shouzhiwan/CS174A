package Window.views;

import MainConnection.Drive;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

	private JPanel contentPane;
	private JTextField namefield;
	private JTextField emailField;
	private JTextField taxIdField;
	private JTextField stateField;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField retypeField;
	private JButton btnClearAll;
	private JButton btnBack;
	private JButton btnCreateAccount;

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
		setBounds(100, 100, 450, 421);
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
		
		passwordField = new JTextField();
		passwordField.setColumns(10);
		
		JLabel lblYourInformation = new JLabel("Your Information");
		
		JLabel lblCreateYourAccount = new JLabel("Create Your Account");
		
		retypeField = new JTextField();
		retypeField.setColumns(10);
		
		btnClearAll = new JButton("Clear");
		btnBack = new JButton("Back");
		btnCreateAccount = new JButton("Create");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(177)
					.addComponent(lblYourInformation)
					.addContainerGap(156, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(167, Short.MAX_VALUE)
					.addComponent(lblCreateYourAccount)
					.addGap(144))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(39)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword)
						.addComponent(lblRetypePassword)
						.addComponent(lblUsername)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblName)
								.addComponent(lblEmail))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(namefield, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(18)
									.addComponent(emailField))))
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(usernameField, Alignment.LEADING)
									.addComponent(passwordField, Alignment.LEADING)
									.addComponent(retypeField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnClearAll)
									.addComponent(btnBack)
									.addComponent(btnCreateAccount)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(lblTaxid)
								.addGap(18)
								.addComponent(taxIdField, 155, 155, 155)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblState)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(stateField, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE))))
					.addGap(89))
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
						.addComponent(lblState)
						.addComponent(stateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22)
					.addComponent(lblCreateYourAccount)
					.addGap(18)
					.addComponent(lblUsername)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnClearAll))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPassword)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnBack))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblRetypePassword)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(retypeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnCreateAccount))
					.addContainerGap(36, Short.MAX_VALUE))
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
				String[] informations = new String[6];
				
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
				String pwd = passwordField.getText();
				String pwdCheck = retypeField.getText();
				if(flag == 0) {
					if(pwd.equals(pwdCheck)) {
						informations[0] = namefield.getText();
						informations[1] = emailField.getText();
						informations[2] = taxIdField.getText();
						informations[3] = stateField.getText();
						informations[4] = usernameField.getText();
						informations[5] = passwordField.getText();
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
