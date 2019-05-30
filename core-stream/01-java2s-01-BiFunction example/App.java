import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;


public class App {
	public static void main(String[] args) {
		BiFunction<String, String, String> function = (f1, f2) -> {
			return f1 + f2;
		};


		System.out.println(function.apply("hello ", "world"));
	}
}
