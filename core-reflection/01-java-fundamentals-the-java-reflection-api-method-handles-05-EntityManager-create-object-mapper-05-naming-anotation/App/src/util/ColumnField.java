package util;

import java.lang.reflect.Field;

import annotation.Column;

public class ColumnField{

	private Field field;
	private Column column;

	public ColumnField(Field field) {
		this.field = field;
		column = field.getAnnotation(Column.class);
	}

//	public String getName() {
//		return field.getName();
//	}
	
	public String getName() {
		return column.name();
	}
	
	public Field getField() {
		return field;
	}


	public Class<?> getType() {
		return field.getType();
	}



}
