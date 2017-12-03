package MainConnection;
import java.time.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class getManagerData {
	private Connection connection = null;
	private Statement statement = null;
	
	public getManagerData() {
		try {
			//String HOST = "jdbc:mysql://127.0.0.1:3306/ShouzhiwanDB";
			String HOST = "jdbc:mysql://localhost:3306/jinfaDB?autoReconnect=true&useSSL=false";
			String USER = "root";
			String PWD  = "81822188";
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

	public String getDate(String theUser) {
		
		Date Date=null;
		try {
			String Query = "SELECT Date FROM Manager WHERE Username='admin';";
			ResultSet resultSet = statement.executeQuery(Query);
			while(resultSet.next())
				Date = resultSet.getDate("Date");
			System.out.println(Date.toString());
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return Date.toString();
	}
	public int getNumusr(){
		try {
			String Query = "SELECT Username, Balance FROM Market_Account_Have;";
			ResultSet resultSet = statement.executeQuery(Query);
			return resultSet.last() ? resultSet.getRow() : 0;
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return 0;
		
	}
	public boolean RecordBalance(String date) {
		int numUsers = getNumusr();
		String [] Username = new String[numUsers];
		Double [] Balance = new Double[numUsers];
		try {
			String Query = "SELECT Username, Balance FROM Market_Account_Have;";
			ResultSet resultSet = statement.executeQuery(Query);
			int i=0;
			while(resultSet.next()) {
				Username[i] = resultSet.getString("Username");
				Balance[i] = resultSet.getDouble("Balance");
				System.out.println(Username[i]+" " +Balance[i]);
				i++;
			}
				
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		try {
			for(int i=0;i<numUsers;i++) {
				String Query = "INSERT INTO Daily_Balance VALUES ( '" + Username[i] +"', " + Balance[i] + ", '" + date +"');" ;
				statement.executeUpdate(Query);
			}
			return true;
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		return false;
	}
	public boolean addDate(String thedate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c = Calendar.getInstance();
		c.setTime(sdf.parse(thedate));
		c.add(Calendar.DATE, 1); 
		java.sql.Date date =new java.sql.Date (c.getTimeInMillis());
		System.out.println(date);
		try {
			String Query = "UPDATE Manager SET Date = '" + date + "' ;" ;
			statement.executeUpdate(Query);
			return true;
		}
		catch(Exception exc) {
			exc.printStackTrace();
		}
		
		return false;
		
	}
}
