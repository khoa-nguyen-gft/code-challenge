package bean;


import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import annotation.Inject;
import annotation.Provides;
import orm.EntityManager;
import provider.H2ConnectionProvider;

public class BeanManager {

	private static BeanManager instance = new BeanManager();

	public static BeanManager getInstance() {
		return instance;
	}

	private Map<Class<?>, Supplier<?>> register = new HashMap<Class<?>, Supplier<?>>();

	/**
	 * Call method BuildConnection() to get instance 'Connection' from Provider class. 
	 */
	private BeanManager() {
		List<Class<?>> classes = List.of(H2ConnectionProvider.class);
		for (Class<?> clss : classes) {
			Method[] declaredMethods = clss.getDeclaredMethods();
			for (Method method : declaredMethods) {
				Provides provides = method.getAnnotation(Provides.class);
				if(provides != null) {
					
					Class<?> returnType = method.getReturnType();
					Supplier<?> supplier = () -> {
						try {
							if (Modifier.isStatic(method.getModifiers())){
								Object obj = clss.getConstructor().newInstance();
								return method.invoke(obj);
							} else {
								return method.invoke(null);
							}

						} catch (Exception e) {
							throw new RuntimeException();
						}
					};
					
					register.put(returnType, supplier);
				}
			}
		}
	}

	public <T> EntityManager<T> getInstance(Class<T> clss) {
		return null;
	}

}
