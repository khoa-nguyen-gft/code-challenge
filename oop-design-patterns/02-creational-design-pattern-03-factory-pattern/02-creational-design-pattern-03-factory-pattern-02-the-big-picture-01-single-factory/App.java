public class App {
    public static void main(String[] args) {
        VehicleFactory.create("car");
        VehicleFactory.create("Motorcycle");

    }
}

class VehicleFactory{
    public static Vehicle create(String type) {
        Vehicle verhicle = null;
        
        if(type.equalsIgnoreCase("car")) {
            verhicle = new Car();

        } else if (type.equalsIgnoreCase("Motorcycle")){
            verhicle = new Motorcycle();
        }

        return verhicle;
    }
}

interface Vehicle{

}
class Car implements Vehicle{
    public Car(){
        System.out.println("car");
    }
}

class Motorcycle implements Vehicle{
    public Motorcycle(){
        System.out.println("Motorcycle");
    }
}