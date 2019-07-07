import java.util.Optional;

public class AppAfter {
    public static void main(String[] arg) {
        EmployeeAfter manager = new EmployeeAfter("E2", "ROBOSE");
        ProjectAfter daito = new ProjectAfter("DE", "Daito", manager);

        System.out.println(getManagerAddressbyProject(daito));

    }

    public static String getManagerAddressbyProject(ProjectAfter project) {
        return project.getManager()
            .flatMap(EmployeeAfter::getAddress)
            .map(AddressAfter::toString)
        .orElse("No address specified");
    }
}


class ProjectAfter {

    public ProjectAfter(String id, String name, EmployeeAfter manager) {
        super();
        this.id = id;
        this.name = name;
        this.manager = Optional.of(manager);
    }

    private String id;
    private String name;
    private Optional<EmployeeAfter> manager = Optional.empty();
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
    public Optional<EmployeeAfter> getManager() {
        return manager;
    }
    public void setManager(EmployeeAfter manager) {
        this.manager = Optional.of(manager);
    }


}

class EmployeeAfter {
    private String id;
    private String name;
    private Optional<AddressAfter> address = Optional.empty();


    public EmployeeAfter(String id, String name) {
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
    public Optional<AddressAfter> getAddress() {
        return address;
    }
    public void setAddress(AddressAfter address) {
        this.address = Optional.of(address);
    }


}

class AddressAfter {
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