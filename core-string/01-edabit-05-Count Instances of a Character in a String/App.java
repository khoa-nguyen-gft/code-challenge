import java.util.stream.Stream;

public class App{
    public static void main(String[] args) {
    	charCount("a", "edabit");// ➞ 1

    	charCount("c", "Chamber of secrets");// ➞ 1

    	charCount("f", "frank and his friends have offered five foxes for sale");// ➞ 7
    }

    public static long charCount(String c, String str) {
    	long result = 0; 
    	result = Stream.of(str.split("")).filter(s -> s.equals(c)).count();
    	System.out.println(result);
    	return result;
    }
}