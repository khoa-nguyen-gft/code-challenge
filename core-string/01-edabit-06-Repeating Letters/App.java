import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App{
    public static void main(String[] args) {
    	doubleChar("String");// ➞ "SSttrriinngg"

    	doubleChar("Hello World!");// ➞ "HHeelllloo  WWoorrlldd!!"

    	doubleChar("1234!_ ");// ➞ "11223344!!__  "
    }

    public static String doubleChar(String s) {
        String result = Stream.of(s.split(""))
        		.map(x -> x.concat(x))
        		.collect(Collectors.joining(""));
        
        System.out.println(result);
        
        return result;
    }
}