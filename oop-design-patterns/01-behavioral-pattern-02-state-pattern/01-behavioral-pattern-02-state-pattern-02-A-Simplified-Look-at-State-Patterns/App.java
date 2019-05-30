public class App{
    public static void main(String[] args) {
        Bike bike = new Bike();
        bike.grearDown();
        bike.grearUp();
        bike.grearUp();
        bike.grearUp();
        bike.grearUp();
        bike.grearUp();
        bike.grearUp();
        bike.grearDown();
        bike.grearDown();
        bike.grearDown();
        bike.grearDown();


    }
}

class Bike {

    protected GrearState grearState;


    public Bike() {
        this.grearState = new FirstState(this);
    }

    public void grearDown() {
        grearState.grearDown();
    }

    public void grearUp() {
        grearState.grearUp();
    }
}


abstract class GrearState {
    protected Bike bike;

    public GrearState(Bike bike) {
        this.bike = bike;
    }

    public abstract void grearDown();

    public abstract void grearUp();
}

class FirstState extends GrearState {

    public FirstState(Bike bike) {
        super(bike);
    }

    @Override
    public void grearDown() {
        System.out.println("Already in the FirstGear - cannot go lower");
    }

    @Override
    public void grearUp() {
        System.out.println("Moving Up from FirstGear to SecondGear");
        bike.grearState = new SecondState(bike);
    }

}

class SecondState extends GrearState {

    public SecondState(Bike bike) {
        super(bike);
    }

    @Override
    public void grearDown() {
        System.out.println("Moving Down from SecondGear to FirstGear");
        bike.grearState = new FirstState(bike);
    }

    @Override
    public void grearUp() {
        System.out.println("Moving Up  from SecondGear to ThirdGear");
        bike.grearState = new SecondState(bike);
    }

}


class ThirdState extends GrearState {

    public ThirdState(Bike bike) {
        super(bike);
    }

    @Override
    public void grearDown() {
        System.out.println("Moving Down from ThirdGear to SecondGear");
        bike.grearState = new SecondState(bike);
    }

    @Override
    public void grearUp() {
        System.out.println("Already in the ThirdGear - cannot go higher");
    }

}
