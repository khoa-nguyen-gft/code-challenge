package provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import annotation.Provides;

public class  H2ConnectionProvider {
	
	private static String url = "jdbc:h2:file:C:\\Users\\knguyen97\\Dropbox\\projects\\MyProject\\code-challenges\\core-reflection\\DbLocation\\db;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE";
	private static String user = "sa";
	private static String password = "";
	
	
	@Provides
	public Connection BuildConnection() throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}
}
