package Window.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainConnection.getMyInformation;
import MainConnection.getMyAccount;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextPane;

public class MyAccountPage extends JFrame {

	private JPanel contentPane;
	private String user;
	private JButton btnMyInformation;
	private JButton btnStockMarket;
	private JButton btnGoBack;
	private JLabel lblMarketAccount;
	private JLabel lblStockAccount;
	private JButton btnMToS;
	private JButton btnSToM;
	private JLabel lblBalance;
	private JLabel lblAvailableBalance;
	private JLabel MarketBalance;
	private JButton btnWithdraw;
	private JLabel StockBalance;
	private JButton btnBuy;
	private JButton btnSell;
	private JButton btnDeposit;
	getMyAccount myAcc;
	private String[] information = new String[8];
	double MarketBal;
	double StockBal;
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
		myAcc = new getMyAccount();
		MarketBal = myAcc.getMarketAccount(this.user);
		System.out.println(MarketBal);
		StockBal = myAcc.getStockAccount(this.user);
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
		
		lblMarketAccount = new JLabel("Market Account");
		
		lblStockAccount = new JLabel("Stock Account");
		
		btnMToS = new JButton(new ImageIcon("/Users/shouzhiwan/eclipse-workspace/174Stock/src/Window/recourses/right-arrow.png"));
		
		btnMToS.setBackground(UIManager.getColor("Button.shadow"));
		
		btnSToM = new JButton();
		
		btnSToM.setIcon(new ImageIcon("/Users/shouzhiwan/eclipse-workspace/174Stock/src/Window/recourses/left-arrow.png"));
		
		lblBalance = new JLabel("Available Balance");
		
		lblAvailableBalance = new JLabel("Available Balance");
		
		MarketBalance = new JLabel("$ " + MarketBal);
		
		btnDeposit = new JButton("Deposit");
		
		
		btnWithdraw = new JButton("WithDraw");
		
		if(StockBal == -1) {
			StockBalance = new JLabel("No Stock Account");
		}
		else {
			StockBalance = new JLabel("$ " + StockBal);
		}
		
		
		
		btnBuy = new JButton("Buy");
		
		
		btnSell = new JButton("Sell");
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnMyInformation)
								.addComponent(lblMarketAccount)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(MarketBalance)
									.addComponent(lblBalance)))
							.addGap(6))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(btnDeposit, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnWithdraw, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(23)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnStockMarket)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(btnSToM)
									.addGap(18)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnSell, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnBuy, GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)))
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addComponent(btnMToS)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblStockAccount)
												.addComponent(lblAvailableBalance)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(20)
											.addComponent(StockBalance)))))
							.addPreferredGap(ComponentPlacement.RELATED, 72, Short.MAX_VALUE)))
					.addGap(16))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(44)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblMarketAccount)
						.addComponent(lblStockAccount))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblAvailableBalance)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(StockBalance))
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblBalance)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(MarketBalance))
						.addComponent(btnMToS, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnSToM, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnDeposit)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnWithdraw))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnBuy)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnSell)))
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMyInformation)
						.addComponent(btnStockMarket)
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
		btnMToS.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StockBal == -1) {
					myAcc.CreateStockAccount(user);
					StockBal = myAcc.getStockAccount(user);
					StockBalance.setText("$ " + StockBal);
					JOptionPane.showMessageDialog(null, "You have created a Stock Account");
				}
				String Typein = JOptionPane.showInputDialog("Please type the Amount you want to transfer");
				double number = Double.valueOf(Typein);
				if(MarketBal < number) {
					JOptionPane.showMessageDialog(null, "Insufficent Funds");
				}
				else {
					myAcc.MakeTransfer(number,user);
					StockBal = myAcc.getStockAccount(user);
					StockBalance.setText("$ " + StockBal);
					MarketBal = myAcc.getMarketAccount(user);
					MarketBalance.setText("$ " + MarketBal);
					JOptionPane.showMessageDialog(null, "Transaction Complete");
				}
			}
		});
		btnSToM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StockBal == -1) {
					myAcc.CreateStockAccount(user);
					StockBal = myAcc.getStockAccount(user);
					StockBalance.setText("$ " + StockBal);
					JOptionPane.showMessageDialog(null, "You have created a Stock Account");
				}
				String Typein = JOptionPane.showInputDialog("Please type the Amount you want to transfer");
				double number = Double.valueOf(Typein);
				if(StockBal < number) {
					JOptionPane.showMessageDialog(null, "Insufficent Funds");
				}
				else {
					number = -1 * number;
					myAcc.MakeTransfer(number,user);
					StockBal = myAcc.getStockAccount(user);
					StockBalance.setText("$ " + StockBal);
					MarketBal = myAcc.getMarketAccount(user);
					MarketBalance.setText("$ " + MarketBal);
					JOptionPane.showMessageDialog(null, "Transaction Complete");
				}
			}
		});
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Need to send requests to the manager to make the transfer
				String Typein = JOptionPane.showInputDialog("Please type the Amount you want to Deposit");
				double number = Double.valueOf(Typein);
				myAcc.addRequests(number, user);
				JOptionPane.showMessageDialog(null, "Request Send, Wait for Manager to Comfirm!");
			}
		});
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Need to send request to the manager to make the transfer
				String Typein = JOptionPane.showInputDialog("Please type the Amount you want to Withdraw");
				double number = -1 * Double.valueOf(Typein);
				myAcc.addRequests(number, user);
				JOptionPane.showMessageDialog(null, "Request Send, Wait for Manager to Comfirm!");
			}
		});
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StockBal == -1) {
					myAcc.CreateStockAccount(user);
					StockBal = myAcc.getStockAccount(user);
					StockBalance.setText("$ " + StockBal);
					JOptionPane.showMessageDialog(null, "You have created a Stock Account");
				}
				BuyPage bp = new BuyPage();
				bp.BuyStock(user);
			}
			
		});
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StockBal == -1) {
					myAcc.CreateStockAccount(user);
					StockBal = myAcc.getStockAccount(user);
					StockBalance.setText("$ " + StockBal);
					JOptionPane.showMessageDialog(null, "You have created a Stock Account");
				}
				SellPage sp = new SellPage();
				sp.SellStock(user);
			}
		});
	}
	protected void setInvisible() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
}
