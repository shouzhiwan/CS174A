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

public class AfterLoginPage extends JFrame {

	private JPanel contentPane;
	private String user;
	private JButton btnMyInformation;
	private JButton btnMyAccounts;
	private JButton btnStockMarket;
	private JButton btnLogOut;
	/**
	 * Launch the application.
	 */
	public static void AfterLogin(String theUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AfterLoginPage frame = new AfterLoginPage();
					frame.user = theUser;
					frame.PageView();
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
	public AfterLoginPage() {
		//this.user = TheUser;
		initComponents();
		createEvent();		

	}
	//public AfterLoginPage() {}
	private void PageView() {
		initComponents();
		createEvent();	
	}


	private void initComponents() {
		// TODO Auto-generated method stub
		setTitle("Welcome! " + this.user);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 442, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 404, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
		
		btnMyInformation = new JButton("My Information");	
		btnMyAccounts = new JButton("My Accounts");
		btnStockMarket = new JButton("Stock Market");
		btnLogOut = new JButton("Log Out");
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(btnMyAccounts, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnMyInformation, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(51)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnLogOut, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnStockMarket, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))
					.addContainerGap(66, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMyInformation)
						.addComponent(btnStockMarket))
					.addGap(52)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMyAccounts)
						.addComponent(btnLogOut))
					.addContainerGap(84, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
	}
	
	private void createEvent() {
		// TODO Auto-generated method stub
		btnMyInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MyInformationPage mip = new MyInformationPage();
				mip.MyInformation(user);
				setInvisible();
			}
		});
		
		btnMyAccounts.addActionListener(new ActionListener() {
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
		
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginPage lp = new LoginPage();
				lp.Login();
				setInvisible();
			}
		});
	}
	protected void setInvisible() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
}
