import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class App{
    public static void main(String[] args)  {
    	MetaModel<Person> metaModel = MetaModel.of(Person.class);
    	PrimaryKeyField primaryKey = metaModel.getPrimaryKey();    	
    	List<ColumnField> columnFields = metaModel.getColumns();
    	
    	System.out.println("primary key name: \"" + primaryKey.getName() + "\" And primary key type: \"" + primaryKey.getType().getSimpleName() + "\"") ;
    	for (ColumnField columnField : columnFields) {
        	System.out.println("primary key name: \"" + columnField.getName() + "\" And primary key type: \"" + columnField.getType().getSimpleName() + "\"") ;

		}
    }
}

class MetaModel<T> {

	private Class<T> clss;
	

	public MetaModel(Class<T> clss) {
		this.clss = clss;
	}


	public static <T> MetaModel<T> of(Class<T> clss) {
		return new MetaModel<T>(clss);
	}
	
	
	public List<ColumnField> getColumns() {

		 List<ColumnField> listcolumn = new ArrayList<ColumnField>();
		Field[] fields = this.clss.getDeclaredFields();
		for(Field f : fields) {
			Column column = f.getAnnotation(Column.class);
			if (column != null) {
				listcolumn.add(new ColumnField(f));
			}
		}		
		return listcolumn;
		
	}


	public PrimaryKeyField getPrimaryKey() {
		Field[] fields = this.clss.getDeclaredFields();
		for(Field f : fields) {
			if(f.getAnnotation(PrimaryKey.class) != null) {
				return new PrimaryKeyField(f);
			}
		}
		
		throw new IllegalArgumentException("No primary key found in the class: " + clss.getName());
	}

}

class PrimaryKeyField {

	private Field f;

	public PrimaryKeyField(Field f) {
		this.f = f;
	}

	public Class<?> getType() {
		return f.getType();
	}

	public String getName() {
		return f.getName();
	}

}


class ColumnField{

	private Field field;

	public ColumnField(Field field) {
		this.field = field;
	}

	public Class<?> getType() {
		return field.getType();
	}

	public String getName() {
		return field.getName();
	}
}


@Retention(RetentionPolicy.RUNTIME)
@interface PrimaryKey{
	
}

@Retention(RetentionPolicy.RUNTIME)
@interface Column {
	
}


class Person {
	
	@PrimaryKey
	private int id;
	
	@Column
	private int age;
	
	@Column
	private String name;
	
	public Person() {
		super();
	}
	
	public Person(String name) {
		super();
		this.name = name;
	}
	


	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}