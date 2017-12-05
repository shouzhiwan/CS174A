package MainConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class getStockInformation {
	private Connection connection = null;
	private Statement statement = null;
	
	public getStockInformation() {
		
		try {
			//String HOST = "jdbc:mysql://127.0.0.1:3306/ShouzhiwanDB";
			String HOST = "jdbc:mysql://cs174a.engr.ucsb.edu:3306/jinfaDB?autoReconnect=true&useSSL=false";
			String USER = "jinfa";
			String PWD  = "901";
			//String HOST = "jdbc:mysql://localhost:3306/jinfaDb";
			//String USER = "root";
			//String PWD  = "123456";
			connection = DriverManager.getConnection(HOST, USER, PWD);
			statement = connection.createStatement();
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
	public int getNum() {
		// TODO Auto-generated method stub
		try {
			String count = "SELECT * FROM Stock";
			ResultSet resultSet = statement.executeQuery(count);
			int rowcount = resultSet.last() ? resultSet.getRow() : 0;
			return rowcount;
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return 0;
	}
	public String[] getStockSym() {
		// TODO Auto-generated method stub
		int Num = getNum();
		String[] Stocks = new String[Num];
		try {
			String Query = "SELECT * FROM Stock";
			ResultSet resultSet = statement.executeQuery(Query);
			int i =0;
			while(resultSet.next()) {
				Stocks[i] = resultSet.getString("Stock_Symbol");
				//System.out.println(Stocks[i]);
				i++;
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return Stocks;
	}
	public int getyoutStockNum(String theUser) {
		int TaxId = 0;
		int num = 0;
		try {
			String Query = "SELECT * FROM Customers WHERE Username = " + "'" + theUser + "'" +";";
			System.out.println(Query);
			ResultSet resultSet = statement.executeQuery(Query);
			int userExist = resultSet.last() ? resultSet.getRow() : 0;
			if(userExist == 1) {
				TaxId = resultSet.getInt("TaxID");
			}
			else {
				TaxId = -1;
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		//System.out.println(TaxId);
		try {
			String Query = "SELECT * FROM Stock_Transaction WHERE TaxID = "  + TaxId  +";";
			System.out.println(Query);
			ResultSet resultSet = statement.executeQuery(Query);
			num = resultSet.last() ? resultSet.getRow() : 0; 
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return num;
	}
	public String[] getyourStockInformations(String theUser) {
		int TaxId = 0;
		int num = 0;
		try {
			String Query = "SELECT * FROM Customers WHERE Username = " + "'" + theUser + "'" +";";
			System.out.println(Query);
			ResultSet resultSet = statement.executeQuery(Query);
			int userExist = resultSet.last() ? resultSet.getRow() : 0;
			if(userExist == 1) {
				TaxId = resultSet.getInt("TaxID");
			}
			else {
				TaxId = -1;
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		System.out.println(TaxId);
		try {
			String Query = "SELECT * FROM Stock_Transaction WHERE TaxID = "  + TaxId  +";";
			ResultSet resultSet = statement.executeQuery(Query);
			num = resultSet.last() ? resultSet.getRow() : 0; 
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		if(num == 0)
			return null;
		
		String [] Information = new String[num];
		String [] Symbol = new String[num];
		System.out.println(num);
		try {
			String Query = "SELECT * FROM Stock_Transaction WHERE TaxID = "  + TaxId  +";";
			ResultSet resultSet = statement.executeQuery(Query);
			int i =0;
			while(resultSet.next()) {
				String symbol = resultSet.getString("Stock_Symbol");
				//String PriceQuery = "SELECT * FROM Stock WHERE Stock_Symbol = " + "'" + symbol + "'" +";";
				//ResultSet resultSet2 = statement.executeQuery(Query);
				//int userExist = resultSet.last() ? resultSet.getRow() : 0;
				//if(userExist == 1) {
				//	 resultSet2.getDouble("Current_Price");
				//}
				//double price = getPrice(symbol);
				Symbol[i] = resultSet.getString("Stock_Symbol");
				Information[i] = String.format("%-10s %-10s %3.2f", resultSet.getString("Stock_Symbol"), resultSet.getString("Number_Shares"),resultSet.getDouble("Ave_Price"));
				//System.out.println(Stocks[i]);
				i++;
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		
		return Information;
	}

	public String[] getUserStock(String theUser) {
		int TaxId = 0;
		int num = getyoutStockNum(theUser);
		
		try {
			String Query = "SELECT * FROM Customers WHERE Username = " + "'" + theUser + "'" +";";
			ResultSet resultSet = statement.executeQuery(Query);
			int userExist = resultSet.last() ? resultSet.getRow() : 0;
			if(userExist == 1) {
				TaxId = resultSet.getInt("TaxID");
			}
			else {
				TaxId = -1;
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		//System.out.println(TaxId);
		String[] Stock = new String[num];
		try {
			String Query = "SELECT * FROM Stock_Transaction WHERE TaxID = "  + TaxId  +";";
			ResultSet resultSet = statement.executeQuery(Query);
			//System.out.println(num);
			
			int i = 0;
			while(resultSet.next()) {
				//System.out.println(resultSet.getString("Stock_Symbol"));
				Stock[i] = resultSet.getString("Stock_Symbol");
				i++;
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}

	
		return Stock;
	}

	public double getPrice(String symbol) {
		// TODO Auto-generated method stub
		try {
			String Query = "SELECT * FROM Stock WHERE Stock_Symbol = " + "'" + symbol + "'" +";";
			System.out.println(Query);
			ResultSet resultSet = statement.executeQuery(Query);
			int userExist = resultSet.last() ? resultSet.getRow() : 0;
			if(userExist == 1) {
				 return resultSet.getDouble("Current_Price");
			}

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return 0;
	}
	
	public int getShare(String symbol, String theUser) {
		// TODO Auto-generated method stub
		int TaxId = 0;
		int num = getyoutStockNum(theUser);
		
		try {
			String Query = "SELECT * FROM Customers WHERE Username = " + "'" + theUser + "'" +";";
			ResultSet resultSet = statement.executeQuery(Query);
			int userExist = resultSet.last() ? resultSet.getRow() : 0;
			if(userExist == 1) {
				TaxId = resultSet.getInt("TaxID");
			}
			else {
				TaxId = -1;
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		try {
			String Query = "SELECT * FROM Stock_Transaction WHERE Stock_Symbol = " + "'" + symbol + "'" + "AND TaxID = " + TaxId +";";
			System.out.println(Query);
			ResultSet resultSet = statement.executeQuery(Query);
			int userExist = resultSet.last() ? resultSet.getRow() : 0;
			if(userExist == 1) {
				 return resultSet.getInt("Number_Shares");
			}

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return 0;
	}
	public double getAve_Price(String symbol, String theUser) {
		// TODO Auto-generated method stub
		int TaxId = 0;
		int num = getyoutStockNum(theUser);
		
		try {
			String Query = "SELECT * FROM Customers WHERE Username = " + "'" + theUser + "'" +";";
			ResultSet resultSet = statement.executeQuery(Query);
			int userExist = resultSet.last() ? resultSet.getRow() : 0;
			if(userExist == 1) {
				TaxId = resultSet.getInt("TaxID");
			}
			else {
				TaxId = -1;
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		try {
			String Query = "SELECT * FROM Stock_Transaction WHERE Stock_Symbol = " + "'" + symbol + "'" + "AND TaxID = " + TaxId +";";
			ResultSet resultSet = statement.executeQuery(Query);
			int userExist = resultSet.last() ? resultSet.getRow() : 0;
			if(userExist == 1) {
				 return resultSet.getDouble("Ave_Price");
			}

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		return 0;
	}
	public String[] getMarketStockInformation() {
		// TODO Auto-generated method stub
		int Num = getNum();
		String[] Stocks = new String[Num];
		try {
			String Query = "SELECT * FROM Stock";
			ResultSet resultSet = statement.executeQuery(Query);
			int i =0;
			while(resultSet.next()) {
				Stocks[i] = resultSet.getString("Stock_Symbol") + "                    "+resultSet.getString("Current_Price");
				//System.out.println(Stocks[i]);
				i++;
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return Stocks;
	}
	public double getUserTotalPrice(String theUser) {
		Double YourTotalPrice = 0.00;
		int num = getyoutStockNum(theUser);
		String [] symbol = new String[num];
		System.arraycopy(getUserStock(theUser), 0 , symbol, 0 , num); 
		for (int i=0; i<num; i++) {
			double price = getPrice(symbol[i]);
			int shares = getShare(symbol[i], theUser);
			YourTotalPrice += price * shares;
		}
		
		return YourTotalPrice;
	}
	public double sellStock(String symbol, double price, int shares, String theUser) {
		// TODO Auto-generated method stub
		SetStockPrice(symbol, price);
		int share = getShare(symbol,theUser) - shares;
		double ave_price = getAve_Price(symbol, theUser);
		SetShare(symbol,share, theUser, ave_price);
		double earned = price*shares - shares*ave_price;
		try {
			String Query = "DELETE FROM Stock_Transaction WHERE Number_Shares=0;";
			statement.executeUpdate(Query);			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return earned;
	}
	private void SetShare(String symbol, int shares, String theUser, double price) {
		// TODO Auto-generated method stub
		int TaxId = 0;
		int num = getyoutStockNum(theUser);
		int userExist1 = 0;
		try {
			String Query = "SELECT * FROM Customers WHERE Username = " + "'" + theUser + "'" +";";
			System.out.println(Query);
			ResultSet resultSet = statement.executeQuery(Query);
			int userExist = resultSet.last() ? resultSet.getRow() : 0;
			if(userExist == 1) {
				TaxId = resultSet.getInt("TaxID");
			}
			else {
				TaxId = -1;
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		try {
			String Query = "SELECT * FROM Stock_Transaction WHERE Stock_Symbol = " + "'" + symbol + "'" + "AND TaxID = " + TaxId +";";
			ResultSet resultSet = statement.executeQuery(Query);
			userExist1 = resultSet.last() ? resultSet.getRow() : 0;
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		if(userExist1 == 1) {
			try {
				String QUERY = "UPDATE Stock_Transaction SET Number_Shares = " + shares + " WHERE Stock_Symbol = '" + symbol +"' AND TaxID = '"+ 
					TaxId +"';";
				System.out.println(QUERY);
				statement.executeUpdate(QUERY);
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			try {
				String QUERY = "UPDATE Stock_Transaction SET Ave_Price = " + price + " WHERE Stock_Symbol = '" + symbol +"' AND TaxID = '"+ 
					TaxId +"';";
				System.out.println(QUERY);
				statement.executeUpdate(QUERY);
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
		}
		else {
			int  rowcount = 0;
			try {
				String count = "SELECT * FROM Stock_Transaction";
				//System.out.println(count);
				ResultSet resultSet = statement.executeQuery(count);
				rowcount = resultSet.last() ? resultSet.getRow() : 0;
				rowcount ++;

				String AddAccount = "INSERT INTO Stock_Transaction VALUES ("+
						"'" + rowcount + "', " + TaxId  + ", " + shares + ", '" + symbol  +"'" + price +");";
				statement.executeUpdate(AddAccount);
			}
			catch (Exception exc) {
				exc.printStackTrace();
			}
			
		}

	}
	private void SetStockPrice(String symbol, double price) {
		// TODO Auto-generated method stub
		try {
			String QUERY = "UPDATE Stock SET Current_Price = " + price + " WHERE Stock_Symbol = '" + symbol +"';";
			System.out.println(QUERY);
			statement.executeUpdate(QUERY);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	public void buyStock(String symbol, double price, int shares, String theUser) {
		// TODO Auto-generated method stub
		SetStockPrice(symbol, price);
		int share = getShare(symbol,theUser) + shares;
		double ave_price = getAve_Price(symbol, theUser);
		double new_ave = (getShare(symbol,theUser)*ave_price + shares*price)/share;
		SetShare(symbol,share, theUser, new_ave);
	}
	public void AddRecord(String theUser, int Shares, String Stock_Symbol, String Type, double amount, double balance, double earned) {
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
		try {
			String query = "INSERT INTO Record (Username, Shares, Stock_Symbol, Type, Amount, Balance, Date, Earned) VALUES ("+
					"'"+theUser+"', "+Shares +", '" +Stock_Symbol +"', '" + Type +"', "+ amount +", " + balance +", " +"'"+ Date+ "',"+ earned +");";
			System.out.println(query);
			statement.executeUpdate(query);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	public Boolean getMarketStatus() {
		// TODO Auto-generated method stub
		
		try {
			String Query = "SELECT Market_Status FROM Manager WHERE Username='admin';";
			ResultSet resultSet = statement.executeQuery(Query);
			while(resultSet.next())
				return resultSet.getBoolean("Market_Status");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return false;
	}
}
