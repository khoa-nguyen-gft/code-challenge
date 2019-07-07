public class AppBefore {
    public static void main(String[] arg) {
        Employee manager = new Employee("E2", "ROBOSE");
        Project daito = new Project("DE", "Daito", manager);

        System.out.println(getManagerAddressbyProject(daito));

    }

    public static String getManagerAddressbyProject(Project project) {
        Address address = null;
        String strAddress = "No address specified";

        if (project != null) {
            Employee manager = project.getManager();

            if(manager != null) {
                address = manager.getAddress();
            }
        }


        if (address != null) {
            strAddress = address.toString();
        }

        return strAddress;
    }
}


class Project {


    private String id;
    private String name;
    private Employee manager;

    public Project(String id, String name, Employee manager) {
        super();
        this.id = id;
        this.name = name;
        this.manager = manager;
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
    public Employee getManager() {
        return manager;
    }
    public void setManager(Employee manager) {
        this.manager = manager;
    }
}

class Employee{
    private String id;
    private String name;
    private Address address;


    public Employee(String id, String name) {
        super();
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
    public Address getAddress() {
        return address;
    }
    public void setAddress(Address address) {
        this.address = address;
    }


}

class Address {
    private String city;
    private String state;
    private String country;
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