import model.Person;
import orm.EntityManager;

public class WriteObject {
	public static void main(String[] args) {
		EntityManager<Person> entityManager = EntityManager.of(Person.class);
		
		Person linsa = new Person("Linsa", 32);		
		Person jamy = new Person("Jamy", 32);
		Person susam = new Person("Susam", 32);
		Person join = new Person("Join", 32);
		Person tom = new Person("Tom", 32);
		
		entityManager.persit(linsa);
		entityManager.persit(jamy);
		entityManager.persit(susam);
		entityManager.persit(join);
		entityManager.persit(tom);

	}
}
