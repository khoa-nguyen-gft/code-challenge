
public class App{
    public static void main(String[] args) {
        Calculator cal = Calculator.INSTANCE.getInstance();
        cal.add(5, 8);
    }
}

enum Calculator {
    INSTANCE;

    public Calculator getInstance(){
        return INSTANCE;
    }

   public int add(int a, int b) {
       System.out.println(a + b);
        return a + b;
    }
}