package util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import annotation.Column;
import annotation.PrimaryKey;

public class MetaModel<T> {

	private Class<T> clss;
	

	public MetaModel(Class<T> clss) {
		this.clss = clss;
	}


	public static <T> MetaModel<T> of(Class<T> clss) {
		return new MetaModel<T>(clss);
	}
	
	
	public List<ColumnField> getColumns() {

		 List<ColumnField> listcolumn = new ArrayList<ColumnField>();
		Field[] fields = this.clss.getDeclaredFields();
		for(Field f : fields) {
			Column column = f.getAnnotation(Column.class);
			if (column != null) {
				listcolumn.add(new ColumnField(f));
			}
		}		
		return listcolumn;
		
	}


	public PrimaryKeyField getPrimaryKey() {
		Field[] fields = this.clss.getDeclaredFields();
		for(Field f : fields) {
			if(f.getAnnotation(PrimaryKey.class) != null) {
				return new PrimaryKeyField(f);
			}
		}
		
		throw new IllegalArgumentException("No primary key found in the class: " + clss.getName());
	}


	public String buildInsertRequest() {
		return null;
	}

}
