import java.lang.reflect.InvocationTargetException;

public class App{
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
    	String strHello = "Hello";
    	Class hello = strHello.getClass();
    	Class hello2 = Class.forName(strHello);
    	hello2.getConstructor().newInstance();

    }
}

class Hello{
	public Hello(){
		System.out.println("Hello constructor");
	}
	public void todo(){
		System.out.println("todo");
	}
}