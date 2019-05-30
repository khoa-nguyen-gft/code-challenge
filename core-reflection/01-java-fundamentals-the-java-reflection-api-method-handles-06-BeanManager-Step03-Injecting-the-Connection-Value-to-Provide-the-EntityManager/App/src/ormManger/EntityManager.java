package ormManger;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;


public interface EntityManager<T> {

//	public static <T> EntityManager<T> of(Class<T> clss) {
//		return new H2ConnectionProvider<T>();
//	}

	public void persit(T t) throws SQLException, IllegalArgumentException, IllegalAccessException;

	public T find(Class<T> clss, Object keyId) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException;

}
