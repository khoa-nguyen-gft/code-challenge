package orm;

import java.sql.SQLException;

public interface EntityManager<T> {

	public static <T> EntityManager<T> of(Class<T> clss) {
		return new EntityManagerImpl<T>();
	}

	public void persit(T t) throws SQLException, IllegalArgumentException, IllegalAccessException;

	public T find(Class<T> clss, Object keyId) throws SQLException, InstantiationException, IllegalAccessException;

}
