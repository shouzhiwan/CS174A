package Window.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MyInformationPage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void MyInformation(String theUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyInformationPage frame = new MyInformationPage();
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



	private void initComponents() {
		// TODO Auto-generated method stub
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}
	
	private void createEvent() {
		// TODO Auto-generated method stub
		
	}
	
	

}
