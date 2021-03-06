package Window.views;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainConnection.Drive;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;



public class LoginPage extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JButton btnRegister;
	private JButton btnLogIn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Login();
	}
	public static void Login() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		initComponents();
		createEvent();
		
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setTitle("Welcome to STARSRUS System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		usernameField = new JTextField();
		usernameField.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		
		btnRegister = new JButton("Register");
		
		btnLogIn = new JButton("Log In");

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginPage.class.getResource("/Window/recourses/STARSRUS.png")));
		
		JLabel lblNewLabel_1 = new JLabel("");

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(64, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(btnRegister)
									.addGap(18)
									.addComponent(btnLogIn))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblUsername)
										.addComponent(lblPassword))
									.addGap(45)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel))))
							.addGap(139))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(40))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(31)
					.addComponent(lblNewLabel)
					.addGap(34)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUsername)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(4)
					.addComponent(lblNewLabel_1)
					.addGap(13)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRegister)
						.addComponent(btnLogIn))
					.addContainerGap(43, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		getRootPane().setDefaultButton(btnLogIn);
		
	}
	private void createEvent() {
		// TODO Auto-generated method stub
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterPage rg = new RegisterPage();
				rg.Register();
				setInvisible();
			}
		});
		
		btnLogIn.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				 if(e.getKeyCode() == KeyEvent.VK_ENTER)
				 {
						String  urn = usernameField.getText();
						String pwd = new String(passwordField.getPassword());

						if(urn.equals("") || pwd.equals("")) {
							JOptionPane.showMessageDialog(null, "Invalid Input");			
						}
						else {
							Drive d = new Drive();
							String information = d.getInfo(urn, pwd);
							if(information.equals("correct")) {
								AfterLoginPage alp = new AfterLoginPage();
								alp.AfterLogin(urn);
								setInvisible();
							}
							else if (information.equals("manager")) {
								JOptionPane.showMessageDialog(null, "Hello Manager");		
								ManagerPage mg = new ManagerPage();
								mg.Manager(urn);
								setInvisible();
							}
						}
						//JOptionPane.showMessageDialog(null, information);
					}
			}
		});
		btnLogIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String  urn = usernameField.getText();
				String pwd = new String(passwordField.getPassword());
				
				//String query = "SELECT * FROM Customers WHERE Username = '" + urn + "' AND Password = '" + pwd + "'";
				//System.out.println(query);
				if(urn.equals("") || pwd.equals("")) {
					JOptionPane.showMessageDialog(null, "Invalid Input");			
				}
				else {
					Drive d = new Drive();
					String information = d.getInfo(urn, pwd);
					if(information.equals("correct")) {
						AfterLoginPage alp = new AfterLoginPage();
						alp.AfterLogin(urn);
						setInvisible();
					}
					else if (information.equals("manager")) {
						JOptionPane.showMessageDialog(null, "Hello Manager");		
						ManagerPage mg = new ManagerPage();
						mg.Manager(urn);
						setInvisible();
					}
				}
				//JOptionPane.showMessageDialog(null, information);
			}
		});
	}
	
	protected void setInvisible() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
}
