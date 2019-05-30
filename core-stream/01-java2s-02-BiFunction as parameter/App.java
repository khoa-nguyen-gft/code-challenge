import java.util.function.BiFunction;


public class App {
	public static void main(String[] args) {
		BiFunction<Integer, Integer, String> bi = (a, b) -> {return ":" + (a + b);};

		
		System.out.println(Calculator.calc(bi, 10, 50));
	}
}


class Calculator {
	public static String calc(BiFunction<Integer, Integer, String> bi, Integer i1, Integer i2){
		return bi.apply(i1, i2);
	}
}