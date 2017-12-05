package MainConnection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class getMovieInformation {
	private Connection connection = null;
	private Statement statement = null;
	
	public getMovieInformation() {
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
			//System.out.println(userExist);
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
	
	public String[] getActorData() {
		// TODO Auto-generated method stub
		int numAct = 0;
		try {
			String FindCount = "SELECT S.Stock_Symbol, S.Current_Price, A.Name, A.Date_of_Birth, M.title, C.Role, M.production_year, C.Total_Value  "
					+ " FROM Actor_Director_Has AS A, moviesDB.Movies AS M, Stock AS S, Contract C"
					+ " WHERE C.M_id = M.id AND A.Sid = S.Sid AND C.AD_id = A.AD_id AND C.M_id = M.id;";
			System.out.println(FindCount);
			ResultSet resultSet = statement.executeQuery(FindCount);
			numAct = resultSet.last() ? resultSet.getRow() : 0;
			System.out.println(numAct);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(numAct ==0 ) return null;
		String[] actInfo = new String[numAct*8+1];
		try {
			String findInfo = "SELECT S.Stock_Symbol, S.Current_Price, A.Name, A.Date_of_Birth, M.title, C.Role, M.production_year, C.Total_Value  "
					+ " FROM Actor_Director_Has AS A, moviesDB.Movies AS M, Stock AS S, Contract C"
					+ " WHERE C.M_id = M.id AND A.Sid = S.Sid AND C.AD_id = A.AD_id AND C.M_id = M.id;";
			ResultSet resultSet = statement.executeQuery(findInfo);
			int i = 0;
			while(resultSet.next()) {
				actInfo[i*8] = resultSet.getString("S.Stock_Symbol");
				actInfo[i*8+1] = Double.toString(resultSet.getDouble("S.Current_Price"));
				actInfo[i*8+2] = resultSet.getString("A.Name");
				actInfo[i*8+3] = resultSet.getString("A.Date_of_Birth");
				actInfo[i*8+4] = resultSet.getString("M.title");
				actInfo[i*8+5] = resultSet.getString("C.Role");
				actInfo[i*8+6] = Integer.toString(resultSet.getInt("M.production_year"));
				actInfo[i*8+7] = resultSet.getString("C.Total_Value");
				i++;
			}
			return actInfo;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String[] getTopMovies(int from, int to) {
		int numMov = 0;
		try {
			String FindCount = "SELECT M.title, M.production_year FROM moviesDB.Movies AS M WHERE M.rating = 5 AND "
					+ from + " <=" +" M.production_year AND M.production_year > " + to +";";;
			System.out.println(FindCount);
			ResultSet resultSet = statement.executeQuery(FindCount);
			numMov = resultSet.last() ? resultSet.getRow() : 0;
			System.out.println(numMov);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(numMov ==0 ) return null;
		String[] movInfo = new String[numMov*2+1];
		
		try {
			String findInfo = "SELECT M.title, M.production_year FROM moviesDB.Movies AS M WHERE M.rating = 5 AND "
					+ from + " <=" +" M.production_year AND M.production_year > " + to +";";
			ResultSet resultSet = statement.executeQuery(findInfo);
			int i = 0;
			while(resultSet.next()) {
				movInfo[i] = resultSet.getString("M.title");
				movInfo[i+1] = Integer.toString(resultSet.getInt("M.production_year"));
				i++;
			}
			return movInfo;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String[] getReviews(String movie) {
		// TODO Auto-generated method stub
		int id = 0;
		try {
			String Findid = "SELECT id FROM moviesDB.Movies WHERE title = '" +movie +"';";;
			ResultSet resultSet = statement.executeQuery(Findid);
			while(resultSet.next()) {
				id = resultSet.getInt("id");
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int numRew = 0;
		try {
			String Findid = "SELECT review FROM moviesDB.Reviews WHERE movie_id = " +id +";";;
			ResultSet resultSet = statement.executeQuery(Findid);
			numRew = resultSet.last() ? resultSet.getRow() : 0;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] Reviews = new String[numRew*2+1];
		try {
			String Findrev = "SELECT author, review FROM moviesDB.Reviews WHERE movie_id = " +id +";";
			ResultSet resultSet = statement.executeQuery(Findrev);
			//int nums = resultSet.last() ? resultSet.getRow() : 0;
			//System.out.println(nums);
			int i = 0;
			while(resultSet.next()) {
				//System.out.println(resultSet.getString("author"));
				Reviews[i*2] = resultSet.getString("author");
				Reviews[i*2+1] = resultSet.getString("review");
				i++;			
			}
			return Reviews;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
}

