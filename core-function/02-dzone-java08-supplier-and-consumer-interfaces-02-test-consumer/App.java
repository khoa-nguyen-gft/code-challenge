import java.util.function.Consumer;

public class App {
    public static void main(String[] args) {
    	Consumer<String> consumer01 = (arg)->{
            System.out.println(arg + " OK with consumer01");
    	};
    	
    	consumer01.accept("TestConsumerAccept - ");
    	
    	Consumer<String> consummer02 = (arg) -> {
            System.out.println(arg + " OK  with consumer02");
    	};
    	
    	consumer01.andThen(consummer02).accept("TestConsumerAfterThen - ");
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