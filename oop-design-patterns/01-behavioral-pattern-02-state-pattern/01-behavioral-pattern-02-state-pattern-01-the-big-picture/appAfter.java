public class appAfter {
    public static void main(String[] args) {
        Packages pack = new Packages();
        pack.printStatus();
     }
}

interface PackageState {
    public void next(Packages pkg);
    public void prev(Packages pkg);
    public void printStatus();
}

class Packages {

    private PackageState state = new OrderedState();

    public void previousState(){
        state.prev(this);
    }

    public void nextState(){
        state.next(this);
    }

    public void printStatus(){
        state.printStatus();
    }

    public void setState(PackageState state){
        this.state = state;
    }

    public PackageState getState(){
        return state;
    }
}



class OrderedState implements PackageState{

    @Override
    public void next(Packages pkg){
        pkg.setState(new DeliveredState());
    }
    @Override
    public void prev(Packages pkg){
        System.out.println("The package is in its root state.");
    }
    @Override
    public void printStatus(){
        System.out.println("Package ordered, not delivered to the office yet.");
    }
}


class DeliveredState implements PackageState{

    @Override
    public void next(Packages pkg){
        pkg.setState(new ReceivedState());
    }
    @Override
    public void prev(Packages pkg){
        pkg.setState(new OrderedState());
    }
    @Override
    public void printStatus(){
        System.out.println("Package delivered to post office, not received yet.");
    }
}

class ReceivedState implements PackageState{

    @Override
    public void next(Packages pkg){
        System.out.println("This package is already received by a client.");
    }
    @Override
    public void prev(Packages pkg){
        pkg.setState(new DeliveredState());
    }
    @Override
    public void printStatus(){
        System.out.println("Package received to post office!");
    }
}

