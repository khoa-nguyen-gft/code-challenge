package test.orm;
import java.sql.SQLException;

import model.Person;
import orm.EntityManager;


public class WriteObject {
	public static void main(String[] args) throws SQLException, IllegalArgumentException, IllegalAccessException {
		EntityManager<Person> entityManager = EntityManager.of(Person.class);
		
		Person linsa = new Person("Linsa", 32);		
		Person jamy = new Person("Jamy", 32);
		Person susam = new Person("Susam", 32);
		Person join = new Person("Join", 32);
		Person tom = new Person("Tom", 32);
		
		
		System.out.println(linsa);
		System.out.println(jamy);
		System.out.println(susam);
		System.out.println(join);
		System.out.println(tom);
		
		entityManager.persit(linsa);
		entityManager.persit(jamy);
		entityManager.persit(susam);
		entityManager.persit(join);
		entityManager.persit(tom);
		
		System.out.println(linsa);
		System.out.println(jamy);
		System.out.println(susam);
		System.out.println(join);
		System.out.println(tom);

	}
}
