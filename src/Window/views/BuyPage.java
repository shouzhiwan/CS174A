package Window.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import MainConnection.getStockInformation;

import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;

public class BuyPage extends JFrame {

	private JPanel contentPane;
	private String user;
	private JButton btnRefresh;
	private String[] Stocks;
	int NumStock = 0;
	getStockInformation stockInfo;
	private JComboBox StockComboBox;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void BuyStock(String theUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuyPage frame = new BuyPage(theUser);
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
	public BuyPage() {
		initComponents();
		createEvent();
	}
	
	public BuyPage(String theUser) {
		this.user = theUser;
		stockInfo = new getStockInformation();
		NumStock = stockInfo.getNum();
		System.out.println(NumStock);
		//if(NumStock != 0)
		Stocks = new String[NumStock];
		//stockInfo.getStockSym();
		System.arraycopy(stockInfo.getStockSym(), 0 , Stocks, 0 , NumStock); 
		initComponents();
		createEvent();
	}
	
	
	private void initComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 398);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		btnRefresh = new JButton("ReFresh");
		

		StockComboBox = new JComboBox();
		for (int i =0; i<NumStock; i++) {
			StockComboBox.addItem(Stocks[i]);
		}
		
		JLabel lblStock = new JLabel("Stock");
		
		DefaultTableModel tm = new DefaultTableModel();
		table = new JTable(tm);
		table.setModel(new DefaultTableModel(
				new Object[][] {
					
				},
				new String [] {
					"Stock Symbol", "Number of Shares", "Price"
				}
		));

		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(table, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnRefresh)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblStock)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(StockComboBox, GroupLayout.PREFERRED_SIZE, 72, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(226, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnRefresh)
						.addComponent(StockComboBox, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblStock))
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(91, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void createEvent() {
		// TODO Auto-generated method stub
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}
}
