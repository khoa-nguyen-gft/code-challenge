import java.util.function.Supplier;

public class App {
    public static void main(String[] args) {
        Supplier<Person> supplier = ()-> {
        	return new Person("Varun", 10, "programming");
        };
        
        Person person = supplier.get();
        System.out.println(person);
        
        Person person02 = supplier.get();
        System.out.println(person02);
    }
}

class Person {
    private String name;
    private int age;
    private String address;

    public Person(String name, int age, String address) {
        System.out.println("construct Person");
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setDesignation(String address) {
        this.address = address;
    }
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", address=" + address + "]";
	}
    
    
    
    
} 