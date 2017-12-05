package Window.views;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import MainConnection.getMovieInformation;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class MoviesPage extends JFrame {
	private JPanel contentPane;
	private JTextField fromField;
	private JTextField toField;
	private JTextField movieField;
	JButton btnActorProfile;
	JButton btnTopMovies;
	JButton btnGetReviews;
	JButton btnGoBack;
	getMovieInformation movieInfo;
	private JTextArea textArea;
	String user;
	public static void pop(String theUser) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MoviesPage frame = new MoviesPage(theUser);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public MoviesPage() {
		movieInfo = new getMovieInformation();
		initComponents();
		createEvent();	
	}
	public MoviesPage(String theUser) {
		user = theUser;
		movieInfo = new getMovieInformation();
		initComponents();
		createEvent();	
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		btnActorProfile = new JButton("Get Actor Profile");
		
		JLabel lblFrom = new JLabel("From");
		
		fromField = new JTextField();
		fromField.setColumns(10);
		
		JLabel lblTo = new JLabel("To");
		
		toField = new JTextField();
		toField.setColumns(10);
		
		btnTopMovies = new JButton("Top Movies");
		
		movieField = new JTextField();
		movieField.setColumns(10);
		
		btnGetReviews = new JButton("Get Reviews");
		
		btnGoBack = new JButton("Go Back");
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(btnActorProfile, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(btnGoBack, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(65)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFrom, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(35)
							.addComponent(fromField, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)))
					.addGap(12)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(24)
							.addComponent(toField, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblTo, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(btnTopMovies, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(54))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(60)
					.addComponent(movieField, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(btnGetReviews, GroupLayout.PREFERRED_SIZE, 117, Short.MAX_VALUE)
					.addGap(140))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(55)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 346, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnActorProfile)
						.addComponent(btnGoBack))
					.addGap(7)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblFrom))
						.addComponent(fromField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(toField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(5)
							.addComponent(lblTo))
						.addComponent(btnTopMovies, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(4)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(movieField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGetReviews, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(19)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
					.addGap(17))
		);
		getContentPane().setLayout(groupLayout);
		
		
	}
	private void createEvent() {
		// TODO Auto-generated method stub
		btnActorProfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String [] actorData = movieInfo.getActorData();
				String s = (String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n","STOCKID", "CURRENTPRICE", "NAME", "DOB","MovieTitle", "Role", "Year", "Contract")).toString();
				textArea.append(s);
				//dlm.addElement(s);
				for(int i = 0; i<(actorData.length-1)/8;i++) {
					s = String.format("%-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s\n",
							actorData[8*i],actorData[8*i+1],actorData[8*i+2],actorData[8*i+3],actorData[8*i+4],actorData[8*i+5],actorData[8*i+6],actorData[8*i+7]);
					//dlm.addElement(s);
					System.out.println(s);
					textArea.append(s);
				}
			}
		});
		btnTopMovies.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				int from = Integer.parseInt(fromField.getText());
				int to = Integer.parseInt(toField.getText());
				String [] topmovies = movieInfo.getTopMovies(from, to);
				String s = (String.format("%-15s %-15s \n", "Title", "Year")).toString();
				textArea.append(s);
				for(int i = 0; i<(topmovies.length-1)/2;i++) {
					s = String.format("%-15s %-15s \n", topmovies[i], topmovies[i+1]);
					System.out.println(s);
					textArea.append(s);
				}
			}
		});
		btnGetReviews.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.setText("");
				String movie = movieField.getText();
				String [] reviews = movieInfo.getReviews(movie);
				String s = (String.format("%-15s %-15s \n", "Author", "Reviews")).toString();
				textArea.append(s);
				for(int i = 0; i<(reviews.length-1)/2;i++) {
					s = String.format("%-15s %-15s \n", reviews[i*2], reviews[i*2+1]);
					System.out.println(s);
					textArea.append(s);
				}
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
