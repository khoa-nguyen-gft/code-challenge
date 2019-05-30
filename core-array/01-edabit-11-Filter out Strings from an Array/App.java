import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.stream.Stream;

public class App{
    public static void main(String[] args) {
    	filterArray(new String[] {"1", "2", "a", "b"});// ➞ [1, 2]

		filterArray(new String[] {"1", "a", "b", "0", "15"});// ➞ [1, 0, 15]

		filterArray(new String[] {"1", "2", "aasf", "1", "123", "123"});// ➞ [1, 2, 123]
    }

    // \d :     Any digit, short for [0-9]
    public static String[] filterArray(String[] str) {
    	String [] result = Stream.of(str)
    			.distinct()
					//.filter(e -> e.matches("[0-9]+"))
					.filter(e -> e.matches("\\d+"))
    			.toArray(String[]::new);
    	System.out.println(Arrays.toString(result));
    	return result;
    }
}