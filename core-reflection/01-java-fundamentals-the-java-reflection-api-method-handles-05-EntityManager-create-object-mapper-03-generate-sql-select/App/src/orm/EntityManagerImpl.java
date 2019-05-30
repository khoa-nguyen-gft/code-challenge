package orm;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.h2.Driver;

import meta.MetaModel;
import util.ColumnField;
import util.PrimaryKeyField;

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
		PreparedStatement statement = preparedStatementwithSql(sql).addParameter(t);
		statement.executeUpdate();
	}
	
	@Override
	public T find(Class<T> clss, Object keyId) throws SQLException, InstantiationException, IllegalAccessException {
		MetaModel metaModel = MetaModel.of(clss);
		
		// build sql select statement
		String sql = metaModel.buildSelectRequest();
		
		// build statement
		PreparedStatement statement = preparedStatementwithSql(sql).addPrimaryKey(keyId);
		ResultSet resultSet = statement.executeQuery();
		
		return buildInstanceOf(clss, resultSet);
		
	}
	

	private T buildInstanceOf(Class<T> clss, ResultSet resultSet) throws InstantiationException, IllegalAccessException, SQLException {
		MetaModel<T> meta = MetaModel.of(clss);
		T t = clss.newInstance();
		PrimaryKeyField primaryKey = meta.getPrimaryKey();

		// set primary key value
		Field primaryField = primaryKey.getField();
		String primaryName = primaryKey.getName();
		Class<?> primaryType = primaryKey.getType();
		
		resultSet.next();
		if(primaryType == int.class) {
			int primaryValue = resultSet.getInt(primaryName);
			primaryField.setAccessible(true);
			primaryField.set(t, primaryValue);
			
		}		
		
		List<ColumnField> columnFields = meta.getColumns();
		for (ColumnField columnField : columnFields) {
			Field field = columnField.getField();
			Class<?> type = columnField.getType();
			field.setAccessible(true);
			
			if(type == int.class) {
				field.set(t, resultSet.getInt(columnField.getName()));
			} else if (type == String.class) {
				field.set(t, resultSet.getString(columnField.getName()));
			}
		}
		
		return t;
	}

	private PreparedStatementWrapper preparedStatementwithSql(String sql) throws SQLException {
		Connection connection = DriverManager.getConnection(url, user, password);
		PreparedStatement statement = connection.prepareStatement(sql);

		return new PreparedStatementWrapper(statement);
	}



}
