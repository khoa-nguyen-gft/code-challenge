package orm;

public interface EntityManager<T> {

	public static <T> EntityManager<T> of(Class<T> clss) {
		return new EntityManagerImpl<T>();
	}

	public void persit(T t);

}
