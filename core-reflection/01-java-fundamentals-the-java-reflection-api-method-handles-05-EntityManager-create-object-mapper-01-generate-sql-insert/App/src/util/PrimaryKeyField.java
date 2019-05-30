package util;

import java.lang.reflect.Field;

public class PrimaryKeyField {

	private Field f;

	public PrimaryKeyField(Field f) {
		this.f = f;
	}

	public Class<?> getType() {
		return f.getType();
	}

	public String getName() {
		return f.getName();
	}

}
