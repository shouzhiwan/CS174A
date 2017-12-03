package Window.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import MainConnection.getMyAccount;
import MainConnection.getStockInformation;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class StockMarketPage extends JFrame {

	private JPanel contentPane;
	private String user;
	private JButton btnMyInformation;
	private JButton btnGoBack;
	private JLabel lblMarketAccount;
	private JLabel lblYourMoney;
	private JLabel Moneylabel;
	private JLabel lblShares;
	private JTextField YourNumShare;
	private JLabel lblPrice;
	private JTextField YourPrice;
	private JButton btnBuy;
	private JButton btnSell;
	private JLabel lblStockMarket;
	private JComboBox MarketStockcomboBox;
	private JLabel lblShares_1;
	private JTextField NumShare;
	private JLabel lblPrice_1;
	private JTextField MarketPriceField;
	private JList YourStocklist;
	private JButton btnDeposit;
	private JButton btnWithdraw;
	getMyAccount myAcc;
	double MarketBal;
	getStockInformation stockInfo;
	int NumStock;
	private String[] Stocks;
	private String[] yourStocks;
	private String[] MarketStockInfo;
	int yourStockNum;
	private String[] YourStockInfo;
	private JLabel lblStock;
	private JLabel lblShares_2;
	private JLabel lblCurrentprice;
	private JComboBox YourStockcomboBox;
	private JButton btnGetInformation;
	private JLabel lblYourStocks_1;
	private JLabel MarketStock;
	private JLabel lblStock_1;
	private JLabel lblCurrentprice_1;
	private JList MarketStocklist;
	private JButton btnRefresh;
	private JLabel totalValue;
	double yourtotalvalue = 0.00;
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
		myAcc = new getMyAccount();
		MarketBal = myAcc.getMarketAccount(this.user);
		stockInfo = new getStockInformation();
		NumStock = stockInfo.getNum();
		Stocks = new String[NumStock];
		yourStockNum=stockInfo.getyoutStockNum(theUser);
		//System.out.println(yourStockNum);
		yourStocks = new String[yourStockNum];
		YourStockInfo = new String[yourStockNum];
		MarketStockInfo = new String[NumStock];
		yourtotalvalue = stockInfo.getUserTotalPrice(user);
		//stockInfo.getStockSym();
		System.arraycopy(stockInfo.getStockSym(), 0 , Stocks, 0 , NumStock); 
		System.arraycopy(stockInfo.getUserStock(theUser), 0 , yourStocks, 0 , yourStockNum);
		System.arraycopy(stockInfo.getMarketStockInformation(), 0 , MarketStockInfo, 0 , NumStock);
		System.arraycopy(stockInfo.getyourStockInformations(theUser), 0 , YourStockInfo, 0 , yourStockNum);
		initComponents();
		createEvent();	
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setTitle("Welcome to the Market " +this.user);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		btnMyInformation = new JButton("My Information");
		
		
		btnGoBack = new JButton("Go Back");
		
		lblMarketAccount = new JLabel("Market Account");
		
		lblYourMoney = new JLabel("Your Money");
		
		Moneylabel = new JLabel("$ " + MarketBal);
		
		btnDeposit = new JButton("Deposit");
		
		
		btnWithdraw = new JButton("Withdraw");
		
		
		JLabel lblStockAccount = new JLabel("Stock Account");
		
		YourStockcomboBox = new JComboBox();
		
		for (int i =0; i<yourStockNum; i++) {
			YourStockcomboBox.addItem(yourStocks[i]);
		}
		YourStockcomboBox.setSelectedItem(null);
		JLabel lblYourStocks = new JLabel("Your Stocks");
		
		lblShares = new JLabel("Shares");
		
		YourNumShare = new JTextField();
		YourNumShare.setColumns(10);
		
		lblPrice = new JLabel("Price");
		
		YourPrice = new JTextField();
		YourPrice.setColumns(10);
		
		btnBuy = new JButton("Buy");
		
		
		btnSell = new JButton("Sell");
		
		
		lblStockMarket = new JLabel("Stock Market");
		
		MarketStockcomboBox = new JComboBox();
		for (int i =0; i<NumStock; i++) {
			MarketStockcomboBox.addItem(Stocks[i]);
		}
		MarketStockcomboBox.setSelectedItem(null);
		lblShares_1 = new JLabel("Shares");
		
		NumShare = new JTextField();
		NumShare.setColumns(10);
		
		lblPrice_1 = new JLabel("Price");
		
		MarketPriceField = new JTextField();
		MarketPriceField.setColumns(10);
		DefaultListModel dlm = new DefaultListModel();
		YourStocklist = new JList();
		for(int i =0; i<yourStockNum; i++) {
			dlm.addElement(YourStockInfo[i]);
		}
		YourStocklist.setModel(dlm);
		
		lblStock = new JLabel("Stock");
		
		lblShares_2 = new JLabel("Shares");
		
		lblCurrentprice = new JLabel("CurrentPrice");
		
		btnGetInformation = new JButton("Get Information");
		
		lblYourStocks_1 = new JLabel("Your Stocks");
		
		MarketStock = new JLabel("Market Stock");
		
		
		lblStock_1 = new JLabel("Stock");
		
		lblCurrentprice_1 = new JLabel("CurrentPrice");
		DefaultListModel dlm2 = new DefaultListModel();
		MarketStocklist = new JList();
		for(int i =0; i<NumStock; i++) {
			dlm2.addElement(MarketStockInfo[i]);
		}
		MarketStocklist.setModel(dlm2);
		
		btnRefresh = new JButton("Refresh");
		
		totalValue = new JLabel("$ " +yourtotalvalue);
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMarketAccount)
					.addContainerGap(496, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblStockAccount)
					.addGap(120)
					.addComponent(btnGetInformation)
					.addContainerGap(241, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(92)
					.addComponent(btnMyInformation)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnRefresh)
					.addContainerGap(272, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(43)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblYourMoney)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblStock)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(lblShares_2)
											.addGap(18)
											.addComponent(lblCurrentprice))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblYourStocks)
												.addComponent(lblStockMarket))
											.addPreferredGap(ComponentPlacement.RELATED)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(YourStockcomboBox, 0, 112, Short.MAX_VALUE)
												.addComponent(MarketStockcomboBox, 0, 112, Short.MAX_VALUE)))
										.addComponent(YourStocklist, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(31)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblShares_1)
									.addComponent(lblShares))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(Moneylabel)
									.addPreferredGap(ComponentPlacement.RELATED))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(74)
							.addComponent(lblYourStocks_1)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(totalValue)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(20)
									.addComponent(btnDeposit)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(btnWithdraw))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(NumShare, 0, 0, Short.MAX_VALUE)
										.addComponent(YourNumShare, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
									.addPreferredGap(ComponentPlacement.RELATED)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblPrice)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(YourPrice, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
											.addGap(18)
											.addComponent(btnSell))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblPrice_1)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(MarketPriceField, 0, 0, Short.MAX_VALUE)
											.addGap(18)
											.addComponent(btnBuy))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(65)
							.addComponent(MarketStock))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(29)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblStock_1)
									.addGap(71)
									.addComponent(lblCurrentprice_1))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
									.addComponent(MarketStocklist, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)))))
					.addGap(8))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addComponent(lblMarketAccount)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYourMoney)
						.addComponent(btnWithdraw)
						.addComponent(btnDeposit)
						.addComponent(Moneylabel))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStockAccount)
						.addComponent(btnGetInformation))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYourStocks)
						.addComponent(lblShares)
						.addComponent(YourNumShare, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrice)
						.addComponent(YourPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSell)
						.addComponent(YourStockcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnBuy)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblStockMarket)
							.addComponent(lblShares_1)
							.addComponent(NumShare, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblPrice_1)
							.addComponent(MarketPriceField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(MarketStockcomboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblYourStocks_1)
						.addComponent(MarketStock)
						.addComponent(totalValue))
					.addGap(8)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblStock)
						.addComponent(lblShares_2)
						.addComponent(lblStock_1)
						.addComponent(lblCurrentprice_1)
						.addComponent(lblCurrentprice))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(MarketStocklist, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
						.addComponent(YourStocklist, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnMyInformation)
						.addComponent(btnRefresh)
						.addComponent(btnGoBack))
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void createEvent() {
		
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
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Typein = JOptionPane.showInputDialog("Please type the Amount you want to Withdraw");
				double number = -1 * Double.valueOf(Typein);
				myAcc.addRequests(number, user);
				MarketBal = myAcc.getMarketAccount(user);
				stockInfo.AddRecord(user, 0, "", "Withdraw", MarketBal);
				Moneylabel.setText("$ " + MarketBal);
				JOptionPane.showMessageDialog(null, "Withdraw Completed");
			}
		});
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//Need to send requests to the manager to make the transfer
					String Typein = JOptionPane.showInputDialog("Please type the Amount you want to Deposit");
					double number = Double.valueOf(Typein);
					myAcc.addRequests(number, user);
					MarketBal = myAcc.getMarketAccount(user);
					stockInfo.AddRecord(user, 0, "", "Deposit", MarketBal);
					Moneylabel.setText("$ " + MarketBal);
					JOptionPane.showMessageDialog(null, "Deposit Completed");
			}
		});
		btnGetInformation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String symbol = (String) YourStockcomboBox.getSelectedItem();
				double price = stockInfo.getPrice(symbol);
				YourPrice.setText(Double.toString(price));
				int shares = stockInfo.getShare(symbol, user);
				YourNumShare.setText(Integer.toString(shares));
				
			}
		});
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshpage();
			}

		});
		
		btnSell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String symbol = (String) YourStockcomboBox.getSelectedItem();
				double price = Double.parseDouble(YourPrice.getText());
				int shares = Integer.parseInt(YourNumShare.getText());
				if(stockInfo.getShare(symbol, user) < shares) {
					JOptionPane.showMessageDialog(null, "Failed, You don't have that many shares to sell");
				}
				else {
					stockInfo.sellStock(symbol, price,shares,user);
					double amount = price*shares;
					myAcc.addRequests(amount, user);
					MarketBal = myAcc.getMarketAccount(user);
					Moneylabel.setText("$ " + MarketBal);
					stockInfo.AddRecord(user, shares, symbol, "Sell", MarketBal);
					JOptionPane.showMessageDialog(null, "Sell Completed");
					refreshpage();
				}
			}
		});
		
		btnBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String symbol = (String) MarketStockcomboBox.getSelectedItem();
				double price = Double.parseDouble(MarketPriceField.getText());
				int shares = Integer.parseInt(NumShare.getText());
				double amount = price*shares;
				if(myAcc.getMarketAccount(user) < amount) {
					JOptionPane.showMessageDialog(null, "Failed, You don't have that much money to buy");
				}
				else {
					stockInfo.buyStock(symbol, price,shares,user);
					amount = -1 * amount;
					myAcc.addRequests(amount, user);
					MarketBal = myAcc.getMarketAccount(user);
					Moneylabel.setText("$ " + MarketBal);
					stockInfo.AddRecord(user, shares, symbol, "Buy", MarketBal);
					JOptionPane.showMessageDialog(null, "Buy Completed");
					refreshpage();
				}
			}
		});

	}
	
	protected void refreshpage() {
		// TODO Auto-generated method stub
		StockMarketPage smp = new StockMarketPage();
		smp.StockMarket(user);
		setInvisible();
	}

	protected void setInvisible() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}
}
