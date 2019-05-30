public class App{
    private static final Integer DEFAULT_COOLING_TEMP = 90;
    private static final Integer MAX_ALLOWED_TEMP = 50;
    private static FuelInjector fuelInjector = new FuelInjector();
    private static AirFlowController airFlowController = new AirFlowController();
    private static Starter starter = new Starter();
    private static CoolingController coolingController = new CoolingController();
    private static CatalyticConverter catalyticConverter = new CatalyticConverter();
    
    public static void startEngine(){
        System.out.println("<<<START Engine>>>");
        fuelInjector.on();
        airFlowController.takeAir();
        fuelInjector.on();
        fuelInjector.inject();
        starter.start();
        coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
        coolingController.run();
        catalyticConverter.on();
    }

    public static void stopEngine(){
        System.out.println("<<<STOP Engine>>>");

        fuelInjector.off();
        catalyticConverter.off();
        coolingController.cool(MAX_ALLOWED_TEMP);
        coolingController.stop();
        airFlowController.off();
    }
    public static void main(String[] args) {
        startEngine();
        stopEngine();
    }
}


class TemperatureSensor {
    public void getTemperature(){
        System.out.println("Getting temperature from the sensor..");
    }

}

class Starter {
    public void start() {
        System.out.println("Starting..");
    }
}


class Radiator {

    public void on(){
        System.out.println("Radiator switched on!");
    }

    public void off(){
        System.out.println("Radiator switched off!");
    }

    public void setSpeed(Integer speed){
        System.out.println("Setting radiator speed to {}"+speed);
    }
}

class FuelPump {

   public void pump() {
        System.out.println("Fuel Pump is pumping fuel..");
    }
}

class FuelInjector {
    private FuelPump fuelPump = new FuelPump();

    public void on(){
        System.out.println("Fuel injector ready to inject fuel.");
    }

    public void inject() {
        fuelPump.pump();
        System.out.println("Fuel injected.");
    }

    public void off() {
        System.out.println("Stopping Fuel injector..");
    }
}

class CoolingController {
    private static final Integer DEFAULT_RADIATOR_SPEED = 10;

    private Integer temperatureUpperLimit;
    private Radiator radiator = new Radiator();
    private TemperatureSensor temperatureSensor = new TemperatureSensor();

    public void setTemperatureUpperLimit(Integer temperatureUpperLimit) {
        System.out.println("Setting temperature upper limit to {}"+ temperatureUpperLimit);
        this.temperatureUpperLimit = temperatureUpperLimit;
    }

    public void run() {
        System.out.println("Cooling Controller ready!");
        radiator.setSpeed(DEFAULT_RADIATOR_SPEED);
    }

    public void cool(Integer maxAllowedTemp) {
        System.out.println("Scheduled cooling with maximum allowed temperature {}"+ maxAllowedTemp);
        temperatureSensor.getTemperature();
        radiator.on();
    }

    public void stop() {
        System.out.println("Stopping Cooling Controller..");
        radiator.off();
    }
}

class CatalyticConverter {


    public void on() {
        System.out.println("Catalytic Converter switched on!");
    }

    public void off() {
        System.out.println("Catalytic Converter switched off!");
    }
}

class AirFlowMeter {


    public void getMeasurements() {
        System.out.println("Getting air measurements..");
    }
}

class AirFlowController {

    private AirFlowMeter airFlowMeter = new AirFlowMeter();

    public void takeAir() {
        airFlowMeter.getMeasurements();
        System.out.println("Air provided!");
    }

    public void off() {
        System.out.println("Air controller switched off.");
    }
}