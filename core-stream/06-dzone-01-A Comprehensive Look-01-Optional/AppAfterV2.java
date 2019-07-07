import java.util.Optional;

public class AppAfter {
    public static void main(String[] arg) {
        Employee manager = new Employee("E2", "ROBOSE");
        Project projectWithoutAddress = new Project("DE", "Daito", manager);

        Address address = new Address("Lucknow", "UP", "India");
        Employee managerWithAddress = new Employee("E1", "Robin", address);
        Project projectWithAddress = new Project("DE", "Daito", managerWithAddress);

        System.out.println(getManagerAddressbyProject(projectWithoutAddress));
        System.out.println(getManagerAddressbyProject(projectWithAddress));


    }

    public static String getManagerAddressbyProject(Project project) {

        return project.getManager()
            .flatMap(Employee::getAddress)
            .map(Address::toString)
        .orElse("No address specified");
    }
}


class Project {

    public Project(String id, String name, Employee manager) {
        super();
        this.id = id;
        this.name = name;
        this.manager = Optional.of(manager);
    }

    private String id;
    private String name;
    private Optional<Employee> manager = Optional.empty();
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Optional<Employee> getManager() {
        return manager;
    }
    public void setManager(Employee manager) {
        this.manager = Optional.of(manager);
    }
}

class Employee {
    private String id;
    private String name;
    private Optional<Address> address = Optional.empty();


    public Employee(String id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = Optional.of(address);
    }


    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Optional<Address> getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = Optional.of(address);
    }


}

class Address {
    private String city;
    private String state;
    private String country;


    @Override
    public String toString() {
        return "Address [city=" + city + ", state=" + state + ", country=" + country + "]";
    }
    public Address(String city, String state, String country) {
        super();
        this.city = city;
        this.state = state;
        this.country = country;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }

}