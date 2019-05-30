//package demo;

import java.util.ArrayList;
import java.util.List;

public class App{
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<Employee>();
        
        Employee employeedb = new EmployeeDb("1234", "Join", "Wick", "join@Wick.com");
        EmployeeLdap employeeldap = new EmployeeLdap("chewie", "Solo", "Han", "Solo@Han.com");

        
        employees.add(employeedb);
        employees.add(new EmployeeAdapterLdap(employeeldap));
        employees.forEach(System.out::println);
    }
}


interface Employee{
    public String getId();
    public String getFirstName();
    public String getLastName();
    public String getEmail(); 
}

class EmployeeAdapterLdap implements Employee {
	
	private EmployeeLdap ldap;
		
	
	@Override
	public String toString() {
		return "EmployeeDb [id=" + ldap.getCn()
		+ ", firstName=" + ldap.getSurname() 
		+ ", lastName=" + ldap.getGivenName() 
		+ ", email=" + ldap.getMail()
				+ "]";
	}

	
	EmployeeAdapterLdap(EmployeeLdap ldap){
		this.ldap = ldap;
	}
	@Override
	public String getId() {
		return ldap.getCn();
	}

	@Override
	public String getFirstName() {
		return ldap.getSurname();
	}

	@Override
	public String getLastName() {
		return ldap.getGivenName();

	}

	@Override
	public String getEmail() {
		return ldap.getMail();

	}

}


class EmployeeLdap{
	
    private String cn;
    private String surname;
    private String givenName;
    private String mail;
    
    
	public EmployeeLdap(String cn, String surname, String givenName, String mail) {
		super();
		this.cn = cn;
		this.surname = surname;
		this.givenName = givenName;
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "EmployeeLdap [cn=" + cn + ", surname=" + surname + ", givenName=" + givenName + ", mail=" + mail + "]";
	}
	
	public String getCn() {
		return cn;
	}

	public void setCn(String cn) {
		this.cn = cn;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getGivenName() {
		return givenName;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	} 
    

}

class EmployeeDb implements Employee{
    private String id;
    private String firstName;
    private String lastName;
    private String email; 
    
    
	@Override
	public String toString() {
		return "EmployeeDb [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ "]";
	}

	public EmployeeDb(String id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	@Override
	public String getId() {
		return null;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
    
	
}