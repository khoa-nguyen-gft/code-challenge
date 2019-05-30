public class App {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.create(VehicleType.CAR);
        car.startEngine();

        Vehicle truck = VehicleFactory.create(VehicleType.TRUNK);
        truck.startEngine();
    }
}

class VehicleFactory{
    public static Vehicle create(VehicleType type) {
        return type.getVehicle();
    }
}

interface Vehicle{
	public void startEngine();
}

class Car implements Vehicle{
	public void startEngine(){
        System.out.println("started simple engine of car...");
    }

}

class ElectricCar  implements Vehicle{
	public void startEngine(){
		System.out.println("pushed button started electric car's engine...");
    }
}

class Truck implements Vehicle{

	@Override
	public void startEngine() {
		System.out.println("started a large engine of truck ...");
	}

}

enum VehicleType{
    TRUNK{
        public Vehicle getVehicle(){
            return new Truck();
        }
    },
    CAR{
        public Vehicle getVehicle() {
            return new Car();
        }
    },
    ELECTRIC{
        public Vehicle getVehicle(){
            return new ElectricCar();
        }

    };
    public abstract Vehicle getVehicle();
}
