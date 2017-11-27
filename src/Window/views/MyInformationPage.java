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

public class MyInformationPage extends JFrame {

	private JPanel contentPane;
	private String user;
	private JButton btnMyAccount;
	private JButton btnStockMarket;
	private JButton btnGoBack;

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
		initComponents();
		createEvent();	
	}



	private void initComponents() {
		// TODO Auto-generated method stub
		setTitle("The Information for null");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnMyAccount = new JButton("My Account");
		btnStockMarket = new JButton("Stock Market");
		btnGoBack = new JButton("Go Back");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(btnMyAccount)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStockMarket)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(31, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(221, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMyAccount)
						.addComponent(btnStockMarket)
						.addComponent(btnGoBack))
					.addGap(18))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void createEvent() {
		// TODO Auto-generated method stub
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
