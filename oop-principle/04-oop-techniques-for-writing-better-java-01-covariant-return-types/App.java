public class App {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("Corvette");
        Vehicle cloneVehicle = v1.customClone();
        System.out.println(cloneVehicle.getModel());

    }
}

interface CustomCloneable {
    public Object customClone();
}

class Vehicle implements CustomCloneable {
    private final String model;

    public Vehicle(String model) {
        this.model = model;
    }

    @Override
    public Vehicle customClone() {
        return new Vehicle(this.model);
    }

    /**
     * @return the model
     */
    public String getModel() {
        return model;
    }
}