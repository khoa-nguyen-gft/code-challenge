package util;

import java.lang.reflect.Field;

public class PrimaryKeyField {

	private Field field;

	
	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
	}

	public PrimaryKeyField(Field f) {
		this.field = f;
	}

	public Class<?> getType() {
		return field.getType();
	}

	public String getName() {
		return field.getName();
	}

}
