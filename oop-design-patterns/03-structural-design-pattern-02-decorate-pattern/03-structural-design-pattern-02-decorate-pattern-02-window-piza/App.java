//package demo;

public class App{
    public static void main(String[] args) {
    	Pizza pizza = new PizzaExtraCheese(new PizzaWithBBQSauce(new HawaiianPizza()));
    	
    	String result = pizza.getDescription();
    	System.out.println(result);
    }
}

/**
 * 
 * @author knguyen97
 *
 */
interface Pizza {
	String getDescription();
}

/**
 * 
 * @author knguyen97
 *
 */
class HawaiianPizza implements Pizza{

	@Override
	public String getDescription() {
		return "HawaiianPizza: ";
	}
	
}

/**
 * 
 * @author knguyen97
 *
 */
abstract class PizzaWithTopping implements Pizza{
	protected Pizza pizza;

	public abstract String getDescription();
}

/**
 * 
 * @author knguyen97
 *
 */
class PizzaWithBBQSauce extends PizzaWithTopping {
    
	public PizzaWithBBQSauce(Pizza pizza) {
		this.pizza = pizza;
	}
	
	@Override
	public String getDescription() {
		return pizza.getDescription() + "Plus BBQ Sauce ";
	}
	
} 


class PizzaExtraCheese extends PizzaWithTopping {

	public PizzaExtraCheese(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getDescription() {
		return pizza.getDescription() + "Plus Extra Cheese";
	}
	
}