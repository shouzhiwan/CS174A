package Window.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;

public class MyAccountPage extends JFrame {

	private JPanel contentPane;
	private String user;
	private JButton btnMyInformation;
	private JButton btnStockMarket;
	private JButton btnGoBack;

	/**
	 * Launch the application.
	 */
	public static void MyAccount(String theUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyAccountPage frame = new MyAccountPage(theUser);
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
	public MyAccountPage() {
		
		initComponents();
		createEvent();	
		
	}
	
	public MyAccountPage(String theUser) {
		this.user = theUser;
		initComponents();
		createEvent();	
		
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setTitle("The Account for " + this.user);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnMyInformation = new JButton("My Information");
		
		
		btnStockMarket = new JButton("Stock Market");
		
		
		btnGoBack = new JButton("Go Back");
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(btnMyInformation)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnStockMarket)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(225, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnStockMarket)
						.addComponent(btnMyInformation)
						.addComponent(btnGoBack))
					.addGap(14))
		);
		contentPane.setLayout(gl_contentPane);
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
