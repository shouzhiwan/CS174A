package Window.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class SellPage extends JFrame {

	private JPanel contentPane;
	private String user;
	private JTextField CurrenttextField;
	/**
	 * Launch the application.
	 */
	public static void SellStock(String theUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SellPage frame = new SellPage(theUser);
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
	public SellPage() {
		initComponents();
		createEvent();
		
	}
	public SellPage(String theUser) {
		this.user = theUser;
		initComponents();
		createEvent();
		
	}

	private void initComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblYourStocks = new JLabel("Your Stocks");
		
		JComboBox YourStockComboBox = new JComboBox();
		
		JLabel lblCurrentPrece = new JLabel("Current Price");
		
		CurrenttextField = new JTextField();
		CurrenttextField.setColumns(10);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblYourStocks)
					.addContainerGap(359, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(29, Short.MAX_VALUE)
					.addComponent(YourStockComboBox, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblCurrentPrece)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(CurrenttextField, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addGap(218))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(17)
					.addComponent(lblYourStocks, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(YourStockComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCurrentPrece)
						.addComponent(CurrenttextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(190, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	private void createEvent() {
		// TODO Auto-generated method stub
		
	}
}
