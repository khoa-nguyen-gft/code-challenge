package util;

import java.lang.reflect.Field;

import annotation.PrimaryKey;

public class PrimaryKeyField {

	private Field field;
	private PrimaryKey primaryKey;

	public PrimaryKeyField(Field f) {
		this.field = f;
		primaryKey = this.field.getAnnotation(PrimaryKey.class);
	}
	
	public String getName() {
		return primaryKey.name();
	}
	
//	public String getName() {
//		return field.getName();
//	}
	
	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}



	public Class<?> getType() {
		return field.getType();
	}



}
