package test.orm;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

import beanManger.BeanManager;
import model.Person;
import ormManger.EntityManager;
import ormManger.EntityManagerImpl;

public class ReadObject {
	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		BeanManager beanManager = BeanManager.getInstance();		
		EntityManager<Person> entityManager = beanManager.getInstance(EntityManagerImpl.class);
		
		Person linsa = entityManager.find(Person.class, 1L);
		Person jamy = entityManager.find(Person.class, 2L);
		Person susam = entityManager.find(Person.class, 3L);
		Person join = entityManager.find(Person.class, 4L);
		
		
		entityManager.find(Person.class, 4L);
		
		System.out.println(linsa);
		System.out.println(jamy);
		System.out.println(susam);
		System.out.println(join);

		
	}
}
