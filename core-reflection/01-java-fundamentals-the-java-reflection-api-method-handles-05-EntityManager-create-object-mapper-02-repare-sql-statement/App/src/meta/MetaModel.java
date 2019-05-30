package meta;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import annotation.Column;
import annotation.PrimaryKey;
import util.ColumnField;
import util.PrimaryKeyField;

public class MetaModel<T> {

	private Class<T> clss;
	
	//change public to private scope
	private MetaModel(Class<T> clss) {
		this.clss = clss;
	}

	/**
	 * Init meta model method
	 * @param clss
	 * @return
	 */
	public static <T> MetaModel<T> of(Class<T> clss) {
		return new MetaModel<T>(clss);
	}
	
	/**
	 * Build insert request.
	 * @return
	 */
	public String buildInsertRequest() {
		//insert into Person(id, name, age) values (?, ?, ?)
		StringBuilder sql = new StringBuilder();
		
		String columnKeyNames = getColumnNames();
				
		String listQuestionMarks = getListQuestionMarks();
				
		sql.append("insert into ");
		sql.append(clss.getSimpleName());
		sql.append("(");
		sql.append(columnKeyNames);
		sql.append(")");
		sql.append("values ");
		sql.append(listQuestionMarks);


		return sql.toString();
	}

	/**
	 * 
	 * @return
	 */
	private String getListQuestionMarks() {
		return IntStream.range(0, getColumns().size() + 1)
				.mapToObj(index -> "?")
				.collect(Collectors.joining(",", "(", ")"));
	}

	/**
	 * 
	 * @return
	 */
	private String getColumnNames() {
		String primaryKeyName = getPrimaryKey().getName();
		String columnKeyNames = getColumns()
				.stream()
				.map(ColumnField::getName)
				.reduce(primaryKeyName, (x, y) -> {return x + ", " + y;});
		return columnKeyNames;
	}

	
	
	/**
	 * get list columns
	 * @return
	 */
	public List<ColumnField> getColumns() {
		List<ColumnField> listcolumn = new ArrayList<ColumnField>();
		Field[] fields = this.clss.getDeclaredFields();
		for (Field f : fields) {
			Column column = f.getAnnotation(Column.class);
			if (column != null) {
				listcolumn.add(new ColumnField(f));
			}
		}
		return listcolumn;

	}

	/**
	 * get primary key
	 * @return
	 */
	public PrimaryKeyField getPrimaryKey() {
		Field[] fields = this.clss.getDeclaredFields();
		for(Field f : fields) {
			if(f.getAnnotation(PrimaryKey.class) != null) {
				return new PrimaryKeyField(f);
			}
		}
		
		throw new IllegalArgumentException("No primary key found in the class: " + clss.getName());
	}
}
