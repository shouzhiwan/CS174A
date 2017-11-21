package MainConnection;


import java.sql.*;

public class Drive {

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
