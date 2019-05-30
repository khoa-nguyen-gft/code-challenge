package ormManger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import annotation.Inject;
import meta.MetaModel;
import util.ColumnField;
import util.PrimaryKeyField;

public class EntityManagerImpl<T> implements EntityManager<T> {
	 
	//public abstract Connection BuildConnection() throws SQLException;
	
	@Inject
	private Connection connection;


	/**
	 * get persit entity
	 */
	@Override
	public void persit(T t) throws SQLException, IllegalArgumentException, IllegalAccessException {
		MetaModel<? extends Object> metaModel = MetaModel.of(t.getClass());

		// build sql statement
		String sql = metaModel.buildInsertRequest();

		// build statement
		try (PreparedStatement statement = preparedStatementwithSql(sql).addParameter(t);) {
			statement.executeUpdate();
		}
	}
	
	/**
	 * find entity
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 */
	@Override
	public T find(Class<T> clss, Object keyId) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		MetaModel<T> metaModel = MetaModel.of(clss);

		// build sql select statement
		String sql = metaModel.buildSelectRequest();

		// build statement
		try (PreparedStatement statement = preparedStatementwithSql(sql).addPrimaryKey(keyId);
				ResultSet resultSet = statement.executeQuery();) {

			return buildInstanceOf(clss, resultSet);

		}

	}
	

	private T buildInstanceOf(Class<T> clss, ResultSet resultSet) throws InstantiationException, IllegalAccessException, SQLException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		MetaModel<T> meta = MetaModel.of(clss);
		T t = clss.getConstructor().newInstance();
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
		//Connection connection = BuildConnection();
		PreparedStatement statement = connection.prepareStatement(sql);

		return new PreparedStatementWrapper(statement);
	}


}
