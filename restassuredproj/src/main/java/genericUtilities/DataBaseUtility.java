package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DataBaseUtility {
	static Driver driverRef;
	static Connection connection;
	static ResultSet result;

	/**
	 * This method is used to connect to DB
	 * @param DBname
	 */
	public void connectToDB(String DBname) {
		try {
			driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			DriverManager.getConnection(IConstants.DBUrl+DBname,IConstants.DBUsername,IConstants.DBPassword);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method is used to close the DB connection
	 */

	public void closeDB() {
		try {
			connection.close();

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * This method is used to execute the query
	 * @param query
	 * @return
	 * @throws SQLException 
	 */
	public boolean executeQuery(String query,int columnNum,String expectedData ) throws SQLException
	{
		result=connection.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			if (result.getString(columnNum).equals(expectedData)) {
				flag=true;
				break;

			}
		}
		if (flag) {
			System.out.println("Data is present");
			return flag;
		}
		else {
			System.out.println("data is not present");
			return flag;
		}
	}

	/**
	 * This method is used to perform execute Updates
	 * @param query
	 * @throws SQLException
	 */
	public void executeUpdate(String query) throws SQLException
	{
		int res = connection.createStatement().executeUpdate(query);
		if (res==1) {
			System.out.println("Data is Updated");
		}
		else {
			System.out.println("Data is not Updated");
		}
	}
}