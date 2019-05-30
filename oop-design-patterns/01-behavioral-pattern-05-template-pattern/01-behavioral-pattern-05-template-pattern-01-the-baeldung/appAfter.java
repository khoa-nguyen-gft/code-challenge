import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Observable;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class appAfter {
    public static void main(String[] args) {
    	(new StandardComputerBuilder()).buildComputer();
    	(new HighEndComputerBuilder()).buildComputer();

     }
}


abstract class ComputerBuilder {
    public final void buildComputer(){
        addMother();
        setupMotherboard();
        addProcess();
        
    }

    public abstract void addMother() ;
    public abstract void setupMotherboard();
    public abstract void addProcess();
}

class StandardComputerBuilder  extends ComputerBuilder {

	@Override
	public void addMother() {
		System.out.println("StandardComputerBuilder: addMother");
	}

	@Override
	public void setupMotherboard() {
		System.out.println("StandardComputerBuilder: setupMotherboard");
		
	}

	@Override
	public void addProcess() {
		System.out.println("StandardComputerBuilder: addProcess");		
	}

}

class HighEndComputerBuilder  extends ComputerBuilder {
	@Override
	public void addMother() {
		System.out.println("HighEndComputerBuilder: addMother");
	}

	@Override
	public void setupMotherboard() {
		System.out.println("HighEndComputerBuilder: setupMotherboard");
		
	}

	@Override
	public void addProcess() {
		System.out.println("HighEndComputerBuilder: addProcess");		
	} 
}