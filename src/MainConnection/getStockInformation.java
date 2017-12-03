package MainConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class getStockInformation {
	private Connection connection = null;
	private Statement statement = null;
	
	public getStockInformation() {
		
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
	public int getNum() {
		// TODO Auto-generated method stub
		try {
			String count = "SELECT * FROM Stock";
			ResultSet resultSet = statement.executeQuery(count);
			int rowcount = resultSet.last() ? resultSet.getRow() : 0;
			//System.out.println(rowcount);
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
				Information[i] = resultSet.getString("Stock_Symbol") + "       "+resultSet.getString("Number_Shares") + "       " ;
				//System.out.println(Stocks[i]);
				i++;
			}
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		for(int i=0; i<num;i++) {
			double price = getPrice(Symbol[i]);
			Information[i] +=  price;
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
	public void sellStock(String symbol, double price, int shares, String theUser) {
		// TODO Auto-generated method stub
		SetStockPrice(symbol, price);
		int share = getShare(symbol,theUser) - shares;
		SetShare(symbol,share, theUser);
	}
	private void SetShare(String symbol, int shares, String theUser) {
		// TODO Auto-generated method stub
		int TaxId = 0;
		int num = getyoutStockNum(theUser);
		int userExist1 = 0;
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
			userExist1 = resultSet.last() ? resultSet.getRow() : 0;
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
		if(userExist1 == 1) {
			try {
				String QUERY = "UPDATE Stock_Transaction SET Number_Shares = " + shares + " WHERE Stock_Symbol = '" + symbol +"' AND TaxID = '"+ 
					TaxId +"';";
				//System.out.println(QUERY);
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
						"'" + rowcount + "', " + TaxId  + ", " + shares + ", '" + symbol +"');";
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
			//System.out.println(QUERY);
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
		SetShare(symbol,share, theUser);
	}
	public void AddRecord(String theUser, int Shares, String Stock_Symbol, String Type, double balance) {
		String Date = null;
		try {
			String Query = "SELECT Date AS Date FROM Manager WHERE Username='admin'";
			ResultSet resultSet = statement.executeQuery(Query);
			Date = resultSet.getString("Date");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		try {
			String query = "INSERT INTO Record (Username, Shares, Stock_Symbol, Type, Balance, Date) VALUES ("+
					"'"+theUser+"', "+Shares +", '" +Stock_Symbol +"', '" + Type +"', " + balance +", " + Date + ");";
			statement.executeUpdate(query);
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
