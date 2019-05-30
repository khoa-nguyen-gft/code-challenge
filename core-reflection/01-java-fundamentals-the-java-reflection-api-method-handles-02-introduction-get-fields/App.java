import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class App{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	
    	Class<Person> person = Person.class;
    	Class<? super Person> superclass = person.getSuperclass();
    	System.out.println(superclass.getName());
    	
    	Field[] fields = person.getFields();
    	System.out.println(Arrays.toString(fields));
    	
    	Field[] declaredFields = person.getDeclaredFields();
    	System.out.println(Arrays.toString(declaredFields));
    	
    	Method[] declaredMethods = person.getDeclaredMethods();
    	System.out.println(Arrays.toString(declaredMethods));
    }
}

class Hello{
	public Hello(){
		System.out.println("Hello constructor");
	}
	public void todo(){
		System.out.println("todo");
	}
}

class Person {
	private int age;
	private String name;
	
	
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
	
	public Person(String name) {
		super();
		this.name = name;
	}
	
	public Person() {
		super();
	}

	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	
	
	
}