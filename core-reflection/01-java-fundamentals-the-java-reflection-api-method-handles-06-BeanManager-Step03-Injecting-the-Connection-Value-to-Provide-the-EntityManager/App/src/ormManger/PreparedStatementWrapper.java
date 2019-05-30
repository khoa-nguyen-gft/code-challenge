package ormManger;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import meta.MetaModel;
import util.ColumnField;
import util.PrimaryKeyField;

public class PreparedStatementWrapper {
	private PreparedStatement statement;
	private static AtomicInteger idGenerator = new AtomicInteger(0);
	
	public PreparedStatementWrapper(PreparedStatement statement) {
		this.statement = statement;
	}

	/**
	 * 
	 * @param <T>
	 * @param t
	 * @return
	 * @throws SQLException 
	 * @throws IllegalAccessException 
	 * @throws IllegalArgumentException 
	 */
	public <T> PreparedStatement addParameter(T t)
			throws SQLException, IllegalArgumentException, IllegalAccessException {
		MetaModel<? extends Object> metaModel = MetaModel.of(t.getClass());

		PrimaryKeyField primaryKey = metaModel.getPrimaryKey();
		List<ColumnField> columns = metaModel.getColumns();

		if (primaryKey.getType() == int.class) {
			int incrementAndGet = idGenerator.incrementAndGet();
			Field fieldKey = primaryKey.getField();
			fieldKey.setAccessible(true);
			// set incresementAndGet value into id field of object t.
			fieldKey.set(t, incrementAndGet);
			statement.setInt(1, incrementAndGet);
		}

		for (int i = 0; i < columns.size(); i++) {
			Field field = columns.get(i).getField();
			field.setAccessible(true);

			Object valueColumn = field.get(t);
			Class<?> typeColumn = field.getType();

			if (typeColumn == String.class) {
				statement.setString(i + 2, (String) valueColumn);
			} else if (typeColumn == int.class) {
				statement.setInt(i + 2, (int) valueColumn);
			}

		}

		return statement;
	}

	public PreparedStatement addPrimaryKey(Object primaryKey) throws SQLException {
		if(primaryKey.getClass() == Long.class) {
			statement.setLong(1, (Long) primaryKey);
		}
		return statement;
	}
	
}
