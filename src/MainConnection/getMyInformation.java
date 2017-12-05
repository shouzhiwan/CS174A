package MainConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class getMyInformation {
	private Connection connection = null;
	private Statement statement = null;
	
	public getMyInformation() {
		try {
			//String HOST = "jdbc:mysql://127.0.0.1:3306/ShouzhiwanDB";
			String HOST = "jdbc:mysql://cs174a.engr.ucsb.edu:3306/jinfaDB?autoReconnect=true&useSSL=false";
			String USER = "jinfa";
			String PWD  = "901";
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
	public String[] getBasicInformations(String username) {
		String[] information = new String[8];
		try {
			String QUERY = "SELECT * FROM Customers WHERE Username = " + "'" +username + "'" +";";
			ResultSet resultSet = statement.executeQuery(QUERY);
			int userExist = resultSet.last() ? resultSet.getRow() : 0;
			System.out.println(QUERY);
			if(userExist == 1) {
				information[0] = resultSet.getString("Name");
				information[1] = resultSet.getString("Email");
				information[2] = resultSet.getString("TaxID");
				information[3] = resultSet.getString("State");
				information[4] = resultSet.getString("Phone");
				information[5] = resultSet.getString("Password");
				information[6] = resultSet.getString("Address");
				information[7] = resultSet.getString("SSN");
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return information;
	}
	
	public Boolean UpdateInformation(String[] information, String user) {
		try {
			String QUERY = "UPDATE Customers SET NAME ='" + information[0] + "', Email='" + information[1] + "', TaxID='" +
					information[2] + "', State='" + information[3] + "', Phone='" + information[4] + "', SSN='" + information[5] + "', Address='" + information[6] + 
					"' WHERE Username = " + "'" + user + "'" + ";";
			System.out.println(QUERY);
			statement.executeUpdate(QUERY);
			return true;
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		
		return false;
	}
	public Boolean UpdatePassword(String newpassword, String user) {
		// TODO Auto-generated method stub
		try {
			String QUERY = "UPDATE Customers SET Password ='" + newpassword + 
					"' WHERE Username = " + "'" + user + "'" +";";
			System.out.println(QUERY);
			statement.executeUpdate(QUERY);
			return true;
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return false;
	}
}
