
public class App{
    public static void main(String[] args) {
        Calculator cal = Calculator.getInstance();
        cal.add(5, 8);
    }
}

class Calculator {
    private static Calculator instance;

    private Calculator(){}


    public synchronized static Calculator getInstance(){
        if (instance == null)
            instance = new Calculator();
        return instance;        
    }


    public int add(int a, int b) {
        return a + b;
    }
}