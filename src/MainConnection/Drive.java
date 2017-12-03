package MainConnection;


import java.sql.*;

import javax.swing.JOptionPane;

public class Drive {
	private Connection connection = null;
	private Statement statement = null;
	
	public Drive() {
		try {
			//String HOST = "jdbc:mysql://127.0.0.1:3306/ShouzhiwanDB";
			String HOST = "jdbc:mysql://localhost:3306/jinfaDb";
			String USER = "root";
			String PWD  = "123456";
			connection = DriverManager.getConnection(HOST, USER, PWD);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
	public Boolean CreateAccount(String[] information){
			
		
		try {
			statement = connection.createStatement();
			//String HOST = "jdbc:mysql://127.0.0.1:3306/STOCK";
			//String USER = "root";
			//String PWD  = "123456";
			//connection = DriverManager.getConnection(HOST, USER, PWD);
			// create statement
			//for (int i = 0; i<6;i++) {
			//	System.out.println(information[i]);
			//}
			//statement = connection.prepareStatement("INSERT INTO Customers ('Username', 'Password', 'Name', 'Email', 'TaxID', 'State') VALUES (?, ?, ?, ?, ?, ?)");
			String Query = "INSERT INTO Customers VALUES ("+
					"'" + information[4] + "', " + "'"+ information[5] + "', " + "'" +information[0] + "', '" + information[1] + "', " + information[2] +", '" + information[3] + "', '"+ information[6]  + "', '"+ information[8] + "', '"+ information[7] +"');";
			//System.out.println(Query);
			
			String count = "SELECT * FROM Market_Account_Have";
			//System.out.println(count);
			ResultSet resultSet = statement.executeQuery(count);
			int  rowcount = resultSet.last() ? resultSet.getRow() : 0;
			rowcount ++;
			String AddAccount = "INSERT INTO Market_Account_Have VALUES ("+
					"'" + rowcount + "', " + "'"+ information[4] + "', " + 0.00 + ", " + 1000 +");";
			statement.executeUpdate(Query);
			System.out.println(AddAccount);
			statement.executeUpdate(AddAccount);
			//statement.setString(1, information[4]);
			//statement.setString(2, information[5]);
			//statement.setString(3, information[0]);
			//statement.setString(4, information[1]);
			//statement.setInt(5, Integer.parseInt(information[2]));
			//statement.setString(6, information[3]);
			
			
			return true;
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return false;
	}
	public String getInfo(String username, String password) {
		// TODO Auto-generated method stub

		//Connection connection = null;	
		//Statement statement = null;
		String information = "";
			try {
				// connection to the database
				//String HOST = "jdbc:mysql://127.0.0.1:3306/STOCK";
				//String USER = "root";
				//String PWD  = "123456";
				//connection = DriverManager.getConnection(HOST, USER, PWD);
				// create statement
				statement = connection.createStatement();
				
				// Execute SQL
				//get value
				String QUERY = "SELECT * FROM Customers WHERE Username = " + "'" +username + "'" +";";
				//String QUERY = "SELECT * FROM Customers WHERE Username = 'shouzhiwan'";
				ResultSet resultSet = statement.executeQuery(QUERY);
				int userExist = resultSet.last() ? resultSet.getRow() : 0;
				if(userExist == 1 && resultSet.getString("Password").equals(password)) {
					information = "correct";	
				}
				if(information=="") {
					JOptionPane.showMessageDialog(null, "Wrong Username/Password Combination");
				}
				    // Perform other operations if needed

			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			return information;
			
	}

}
