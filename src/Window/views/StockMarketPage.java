package Window.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockMarketPage extends JFrame {

	private JPanel contentPane;
	private String user;
	private JButton btnMyaccount;
	private JButton btnMyInformation;
	private JButton btnGoBack;
	/**
	 * Launch the application.
	 */
	public static void StockMarket(String theUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockMarketPage frame = new StockMarketPage(theUser);
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
	public StockMarketPage() {
		
		initComponents();
		createEvent();	
	}
	
	public StockMarketPage(String theUser) {
		this.user = theUser;
		initComponents();
		createEvent();	
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setTitle("Welcome to the Market " +this.user);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnMyaccount = new JButton("My Account");
		
		
		btnMyInformation = new JButton("My Information");
		
		
		btnGoBack = new JButton("Go Back");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(btnMyaccount)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMyInformation)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnGoBack)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(211, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMyaccount)
						.addComponent(btnMyInformation)
						.addComponent(btnGoBack))
					.addGap(28))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void createEvent() {
		// TODO Auto-generated method stub
		btnMyaccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyAccountPage map = new MyAccountPage();
				map.MyAccount(user);
				setInvisible();
			}
		});
		
		btnMyInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInformationPage mip = new MyInformationPage();
				mip.MyInformation(user);
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
