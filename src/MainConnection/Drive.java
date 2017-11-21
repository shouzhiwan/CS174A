package MainConnection;


import java.sql.*;

import com.mysql.jdbc.PreparedStatement;

public class Drive {

	public Boolean CreateAccount(String[] information){
		Connection connection = null;	
		Statement statement = null;
		try {
			String HOST = "jdbc:mysql://127.0.0.1:3306/ShouzhiwanDB";
			String USER = "root";
			String PWD  = "81822188";
			connection = DriverManager.getConnection(HOST, USER, PWD);
			// create statement
			for (int i = 0; i<6;i++) {
				System.out.println(information[i]);
			}
			//statement = connection.prepareStatement("INSERT INTO Customers ('Username', 'Password', 'Name', 'Email', 'TaxID', 'State') VALUES (?, ?, ?, ?, ?, ?)");
			String Query = "INSERT INTO Customers ('Username', 'Password', 'Name', 'Email', 'TaxID', 'State') VALUES ('"+
					information[4] + "', '" + information[5] +"', '" + information[0] +"', '" + information[1]+"', '" + Integer.parseInt(information[2]) +"', '" + information[3] + "');";
			System.out.println(Query);
			//statement.setString(1, information[4]);
			//statement.setString(2, information[5]);
			//statement.setString(3, information[0]);
			//statement.setString(4, information[1]);
			//statement.setInt(5, Integer.parseInt(information[2]));
			//statement.setString(6, information[3]);
			statement = connection.createStatement();
			statement.executeUpdate(Query);
			return true;
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return false;
	}
	public String getInfo(String username, String password) {
		// TODO Auto-generated method stub

		Connection connection = null;	
		Statement statement = null;
		String information = "";
			try {
				// connection to the database
				String HOST = "jdbc:mysql://127.0.0.1:3306/ShouzhiwanDB";
				String USER = "root";
				String PWD  = "81822188";
				connection = DriverManager.getConnection(HOST, USER, PWD);
				// create statement
				statement = connection.createStatement();
				
				// Execute SQL
				//get value
				String QUERY = "SELECT * FROM Customers";
				//String QUERY = "SELECT * FROM Customers WHERE Username = 'shouzhiwan'";
				ResultSet resultSet = statement.executeQuery(QUERY);
				
				while(resultSet.next()) {
					String usr = resultSet.getString("Username");
					String pwd = resultSet.getString("Password");

					if((usr.equals(username)) && (pwd.equals(password))) {
						information = resultSet.getString("Email");
					}
				}
				    // Perform other operations if needed

			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			return information;
			
	}

}
