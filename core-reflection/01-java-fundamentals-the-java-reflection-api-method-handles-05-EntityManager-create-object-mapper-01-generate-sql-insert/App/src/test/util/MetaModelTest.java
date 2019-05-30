package test.util;

import model.Person;
import util.MetaModel;

public class MetaModelTest {
	public static void main(String[] args) {
		MetaModel<Person> meta = MetaModel.of(Person.class);
		String sql = meta.buildInsertRequest();
		System.out.println(sql);
	}
}
