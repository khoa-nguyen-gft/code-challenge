package test.util;

import meta.MetaModel;
import model.Person;

public class MetaModelTest {
	public static void main(String[] args) {
		MetaModel<Person> meta = MetaModel.of(Person.class);
		String sql = meta.buildInsertRequest();
		System.out.println(sql);
	}
}
