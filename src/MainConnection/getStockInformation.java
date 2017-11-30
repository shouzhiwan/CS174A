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
			String HOST = "jdbc:mysql://localhost:3306/ShouzhiwanDB?autoReconnect=true&useSSL=false";
			String USER = "root";
			String PWD  = "81822188";
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
	
}
