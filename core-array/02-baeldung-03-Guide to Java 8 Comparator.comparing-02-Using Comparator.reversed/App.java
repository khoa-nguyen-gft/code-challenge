import java.util.Arrays;
import java.util.Comparator;

public class App {
	public static void main(String[] args) {
		Employee[] employees = new Employee[] {new Employee("Ace", 22, 2000.0, 5924001),
				new Employee("John", 25, 3000.0, 9922001), new Employee("Keith", 35, 4000.0, 3924401)};
		
		Comparator<Employee> ageComparator = Comparator.comparing(Employee::getAge, (s1, s2) -> {
			return s1.compareTo(s2);
		});
		
		
		System.out.println("Before: " + Arrays.toString(employees));

		Arrays.sort(employees, ageComparator.reversed());
		
		System.out.println("After: " + Arrays.toString(employees));
		

		
	}

}

class Employee {
	String name;
	int age;
	double salary;
	long mobile;

	public Employee(String name, int age, double salary, long mobile) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.mobile = mobile;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + ", mobile=" + mobile + "]";
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

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

}