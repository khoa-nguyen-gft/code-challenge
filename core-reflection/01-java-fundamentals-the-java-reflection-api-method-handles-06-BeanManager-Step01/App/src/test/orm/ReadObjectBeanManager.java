package test.orm;

import java.sql.SQLException;

import bean.BeanManager;
import model.Person;
import orm.EntityManagerImpl;
import orm.EntityManager;

public class ReadObjectBeanManager {
	public static void main(String[] args) throws SQLException, InstantiationException, IllegalAccessException {

		// EntityManager<Person> entityManager = EntityManager.of(Person.class);

		BeanManager beanManager = BeanManager.getInstance();		
		EntityManager<Person> entityManager = beanManager.getInstance(EntityManagerImpl.class);
		
		Person linsa = entityManager.find(Person.class, 1L);
		Person jamy = entityManager.find(Person.class, 2L);
		Person susam = entityManager.find(Person.class, 3L);
		Person join = entityManager.find(Person.class, 4L);
		
		System.out.println(linsa);
		System.out.println(jamy);
		System.out.println(susam);
		System.out.println(join);

		
	}
}
