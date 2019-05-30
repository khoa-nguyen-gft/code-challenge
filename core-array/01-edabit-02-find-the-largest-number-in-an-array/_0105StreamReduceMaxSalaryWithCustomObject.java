import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class _0105StreamReduceMaxSalaryWithCustomObject{

    static List<Employee> employeeList = Arrays.asList(
      new Employee("Tom Jones", 45, 7000.00),
      new Employee("Harry Major", 25, 10000.00),
      new Employee("Ethan Hardy", 65, 8000.00),
      new Employee("Nancy Smith", 22, 12000.00),
      new Employee("Deborah Sprightly", 29, 9000.00));

    public static void main(String[] args) {
        Program.findLargestNum(employeeList);// 12000

    }
}


class Program {
    public static int findLargestNum(List<Employee> employees) {
        //first paramter: `0` to identity as start value.
        Double result = employees.stream()
        		.map(emp -> emp.getSalary())
        		.reduce(0.0, (salary1, salary2)->{
        	return (salary1 > salary2)? salary1: salary2;
        });

        System.out.println(result);
        return result.intValue();
    }
}

class Employee{
    private String name;
    private Integer age;
    private Double salary;
    public Employee(String name, Integer age, Double salary){
      this.name=name;
      this.age=age;
      this.salary=salary;
    } 
    
    public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	//getters and setters for name and age attributes go here
    //overridden equals() and hashcode() go here
    public String toString(){
      return "Employee Name: "+this.name
        +"  Age: "+this.age
        +"  Salary: "+this.salary;
    }
  }