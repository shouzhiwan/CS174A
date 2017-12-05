package MainConnection;
import java.time.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public boolean AddInterests(Double Interest) {
		// TODO Auto-generated method stub
		int numUser = 0;
		try {
			String FindCount = "SELECT * FROM Market_Account_Have;";
			ResultSet resultSet = statement.executeQuery(FindCount);
			numUser = resultSet.last() ? resultSet.getRow() : 0;
			System.out.println(numUser);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double[] interests = new Double[numUser];
		String[] theUsers = new String[numUser];
		int numDays = 0;
		try {
			String FindCount = "SELECT Date FROM Daily_Balance GROUP BY Date;";
			ResultSet resultSet = statement.executeQuery(FindCount);
			numDays = resultSet.last() ? resultSet.getRow() : 0;
			System.out.println(numDays);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Double MonthlyInterest = Interest/12;
		try {
			String Query = "SELECT SUM(Balance) AS Total, Username FROM Daily_Balance GROUP BY Username;";
			ResultSet resultSet = statement.executeQuery(Query);
			System.out.println(numDays);
			int i = 0;
			while(resultSet.next()) {
				interests[i] = resultSet.getDouble("Total") * MonthlyInterest / numDays;
				theUsers[i] = resultSet.getString("Username");
				//System.out.println(theUsers[i] + " " + interests[i]);
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i<numUser; i++) {
			System.out.println(theUsers[i] + " " + interests[i]);
			try {
				String Query = "UPDATE Market_Account_Have SET Interest = " + interests[i] + "WHERE Username = '" +theUsers[i] + "';";	
				statement.executeUpdate(Query);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		getMyAccount myAcc = new getMyAccount();
		for(int i = 0; i<numUser; i++) {
			myAcc.addRequests(interests[i], theUsers[i]);
		}
		return false;
	}

	public void setMarketStatus(boolean b) {
		// TODO Auto-generated method stub
		try {
			String Query = "UPDATE Manager SET Market_Status = " +b + " WHERE Username = 'admin';";	
			statement.executeUpdate(Query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String[] getCustomerReport() {
		// TODO Auto-generated method stub
		String [] result;
		int num=0;
		try {
			String findnum = "SELECT * FROM Market_Account_Have;";
			ResultSet resultSet = statement.executeQuery(findnum);
			num = resultSet.last() ? resultSet.getRow() : 0;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = new String[num*2+1];
		try {
			String Query = "SELECT * FROM Market_Account_Have;";
			System.out.println(Query);
			ResultSet resultSet = statement.executeQuery(Query);
			int i=0;
			while(resultSet.next()) {
				result[i*2] = resultSet.getString("Username");
				result[i*2+1] = Double.toString(resultSet.getDouble("Balance"));
				//System.out.println(result[i*7]);
				i++;
			}
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void deleteMonthlyRecord() {
		// TODO Auto-generated method stub
		int month = getMonth();
		try {
			String Query = "DELETE FROM Daily_Balance WHERE MONTH(Date) = " +(month -1)+";";
			statement.executeUpdate(Query);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			String Query = "DELETE FROM Record WHERE MONTH(Date) = " +(month -1)+";";
			statement.executeUpdate(Query);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private int getMonth() {
		// TODO Auto-generated method stub
		String Query = "SELECT MONTH(Date) AS theMonth FROM Manager WHERE Username = 'admin';";
		try {
			ResultSet resultSet = statement.executeQuery(Query);
			while(resultSet.next()) {
				int month = resultSet.getInt("theMonth");
				System.out.println(month);
				return month;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	public String[] getMonthStatement(String customer) {
		String [] result;
		int Month = getMonth();
		int num=0;
		try {
			String findnum = "SELECT * FROM Record WHERE Username = (SELECT Username FROM Customers WHERE Name = '" + customer +
					"'  AND MONTH(Date) = " + Month +");";
			ResultSet resultSet = statement.executeQuery(findnum);
			num = resultSet.last() ? resultSet.getRow() : 0;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = new String[num*8+1];
		try {
			String Query = "SELECT * FROM Record WHERE Username = (SELECT Username FROM Customers WHERE Name = '" + customer +
					"'  AND MONTH(Date) = " + Month +");";
			System.out.println(Query);
			ResultSet resultSet = statement.executeQuery(Query);
			int i=0;
			while(resultSet.next()) {
				result[i*8] = Integer.toString(resultSet.getInt("R_id"));
				result[i*8+1] = resultSet.getString("Username");
				result[i*8+2] = Integer.toString(resultSet.getInt("Shares"));
				result[i*8+3] = resultSet.getString("Stock_Symbol");
				result[i*8+4] = resultSet.getString("Type");
				result[i*8+5] = Double.toString(resultSet.getDouble("Amount"));
				result[i*8+6] = Double.toString(resultSet.getDouble("Balance"));
				result[i*8+7] = resultSet.getDate("Date").toString();
				System.out.println(result[i*8]);
				i++;
			}
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String getUserNEmail(String customer) {
		String information = "";
		try {
			String Query = "SELECT * FROM Customers WHERE Name = '"+ customer +"';";
			ResultSet resultSet = statement.executeQuery(Query);
			int userExist = resultSet.last() ? resultSet.getRow() : 0;
			if(userExist == 1) {
				information += resultSet.getString("Username") + "          " + resultSet.getString("Email") + "\n";
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return information;
		
	}

	public String[] getActiveUser() {
		// TODO Auto-generated method stub
		String [] result;
		int num=0;
		int Month= getMonth();
		try {
			String findnum = "SELECT Username, SUM(Shares) FROM Record WHERE MONTH(Date) ="+ Month+"  GROUP BY Username HAVING SUM(Shares)>1000";
			ResultSet resultSet = statement.executeQuery(findnum);
			num = resultSet.last() ? resultSet.getRow() : 0;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		result = new String[num*2+1];
		try {
			String Query = "SELECT Username, SUM(Shares) FROM Record WHERE MONTH(Date) ="+ Month+"  GROUP BY Username HAVING SUM(Shares)>1000";
			System.out.println(Query);
			ResultSet resultSet = statement.executeQuery(Query);
			int i=0;
			while(resultSet.next()) {
				result[i*2] = resultSet.getString("Username");
				result[i*2+1] = Integer.toString(resultSet.getInt("SUM(Shares)"));
				//System.out.println(result[i*7]);
				i++;
			}
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String[] getTaxReport() {
		int Month = getMonth();
		int num=0;
		try {
			String findnum = "SELECT A.Username "
							+ "FROM (SELECT Username, SUM(Earned) AS E FROM Record WHERE MONTH(Date) = "+ Month +" GROUP BY Username) AS A, Market_Account_Have AS M"
							+" WHERE A.username = M.username AND A.E+M.Interest>10000	;";
			ResultSet resultSet = statement.executeQuery(findnum);
			num = resultSet.last() ? resultSet.getRow() : 0;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] result = new String[4*num+1];
		try {
			String findUser = "SELECT A.Username AS Username,  (A.E+M.Interest) AS Earned, C.State, C.TaxID"
					+ " FROM (SELECT Username, SUM(Earned) AS E FROM Record WHERE MONTH(Date) = "+ Month +" GROUP BY Username) AS A, Market_Account_Have AS M, Customers AS C"
					+" WHERE A.username = M.username AND A.E+M.Interest>10000	 AND C.username=A.username;";
			System.out.println(findUser);
			ResultSet resultSet = statement.executeQuery(findUser);
			int i = 0;
			while(resultSet.next()){
				result[i*4] = resultSet.getString("Username");
				result[i*4+1] = Double.toString(resultSet.getDouble("Earned"));
				result[i*4+2] = resultSet.getString("C.State");
				result[i*4+3] = Integer.toString(resultSet.getInt("C.TaxID"));
				i++;
			}
			return result;
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private String getResidence(String Username) {
		try {
			String findUser = "SELECT State FROM Customers WHERE Username = '"+ Username +"';";
			ResultSet resultSet = statement.executeQuery(findUser);
			return resultSet.getString("State");
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return null;
	}

	private String getTaxID(String Username) {
		try {
			String findUser = "SELECT TaxID FROM Customers WHERE Username = '"+ Username +"';";
			ResultSet resultSet = statement.executeQuery(findUser);
			return Integer.toString(resultSet.getInt("TaxID"));
			
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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

	public void SetStockPrice() {
		try {
			String FindPrice = "UPDATE Stock SET Closing_Price = Current_Price";
			statement.executeUpdate(FindPrice);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
