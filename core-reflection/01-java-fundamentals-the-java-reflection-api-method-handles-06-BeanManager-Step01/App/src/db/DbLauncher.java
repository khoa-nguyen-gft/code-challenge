package db;

import java.sql.SQLException;

import org.h2.tools.Server;



public class DbLauncher {
	public static void main(String[] args) throws SQLException {
		Server.main();
		System.out.println("DB launcher");
		
		// create file db: 
		// jdbc:h2:file:C:\Users\knguyen97\Dropbox\projects\MyProject\code-challenges\core-reflection\DbLocation\db;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE

		/**
		 * 
		 create table person (
			id number,
			name varchar(40),
			age number
			)
		 */
	}
}
