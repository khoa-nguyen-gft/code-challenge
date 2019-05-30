package orm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.h2.Driver;

import meta.MetaModel;

public class EntityManagerImpl<T> implements EntityManager<T> {
	 

	private static String url = "jdbc:h2:file:C:\\Users\\knguyen97\\Dropbox\\projects\\MyProject\\code-challenges\\core-reflection\\DbLocation\\db;DB_CLOSE_ON_EXIT=FALSE;AUTO_SERVER=TRUE";
	private static String user = "sa";
	private static String password = "";
	@Override
	public void persit(T t) throws SQLException, IllegalArgumentException, IllegalAccessException {
		MetaModel metaModel = MetaModel.of(t.getClass());
		
		// build sql statement
		String sql = metaModel.buildInsertRequest();
		
		// build statement
		PreparedStatement statement = prepparedStatementwithSql(sql).addParameter(t);
		statement.executeUpdate();
	}

	private PreparedStatementWrapper prepparedStatementwithSql(String sql) throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		PreparedStatement statement = connection.prepareStatement(sql);

		return new PreparedStatementWrapper(statement);
	}

}
