package MainConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class getMyAccount {
	private Connection connection = null;
	private Statement statement = null;
	
	public getMyAccount() {
		try {
			//String HOST = "jdbc:mysql://127.0.0.1:3306/ShouzhiwanDB";
			String HOST = "jdbc:mysql://localhost:3306/jinfaDb";
			String USER = "root";
			String PWD  = "123456";
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	
	public double getMarketAccount(String theUser) {
		double Balance = 0;
		try {
			String Query = "SELECT * FROM Market_Account_Have WHERE Username = " + "'" + theUser + "'" +";";
			ResultSet resultSet = statement.executeQuery(Query);
			int userExist = resultSet.last() ? resultSet.getRow() : 0;
			if(userExist == 1) {
				Balance = resultSet.getDouble("Balance");
				System.out.println(Balance);
			}
			else {
				Balance = -1;
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return Balance;
	}
	
	public double getStockAccount(String theUser) {
		double Balance = 0;
		try {
			String Query = "SELECT * FROM Stock_Account WHERE Username = " + "'" + theUser + "'" +";";
			ResultSet resultSet = statement.executeQuery(Query);
			int userExist = resultSet.last() ? resultSet.getRow() : 0;
			if(userExist == 1) {
				Balance = resultSet.getDouble("Balance");
			}
			else {
				Balance = -1;
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return Balance;
	}
	public Boolean CreateStockAccount(String theUser) {
		try {
			String count = "SELECT * FROM Stock_Account";
			ResultSet resultSet = statement.executeQuery(count);
			int  rowcount = resultSet.last() ? resultSet.getRow() : 0;
			rowcount ++;
			String AddAccount = "INSERT INTO Stock_Account VALUES ("+
				"'" + rowcount + "', " + 0.00 + ", '" + theUser +"');";
			//System.out.println(AddAccount);
			statement.executeUpdate(AddAccount);
			return true;
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return false;
	}
	public void MakeTransfer(double amount,String theUser) {
		double ToStock = amount;
		double ToMarket = -1 * amount;
		double MarketAmount = getMarketAccount(theUser) + ToMarket;
		double StockAmount = getStockAccount(theUser) + ToStock;
		SetNewBalance(MarketAmount, "Market_Account_Have", theUser);
		SetNewBalance(StockAmount, "Stock_Account", theUser);
	}
	public void addRequests(double amount, String theUser){
		try {
			double MarketAmount = getMarketAccount(theUser) + amount;
			SetNewBalance(MarketAmount, "Market_Account_Have", theUser);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	public void SetNewBalance(double amount, String Type, String theUser) {
		try {
			String QUERY = "UPDATE " + Type +" SET Balance =" + amount + 
					" WHERE Username = " + "'" + theUser + "'" +";";
			//System.out.println(QUERY);
			statement.executeUpdate(QUERY);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}


	
	
}
