import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import oracle.jdbc.pool.OracleDataSource;

public class DAO {
	private static Connection connection=null;
	
	public static Connection getConnection() {
		if(connection !=null)
			return connection;
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin@localhost:1521:ORCL","SYSTEM","SYSTEM");
		
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void close()
	{
		if(connection!=null)
		{
			try {
				connection.close();
				connection=null;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}
