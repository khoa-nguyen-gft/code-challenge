//package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App{
    public static void main(String[] args) {
        List<String> valueList = new ArrayList<>();
        valueList.add("Ryan");
        valueList.add("Kieran");
        valueList.add("Jason");
        valueList.add("Matt");

        isFourLetters(valueList.toArray(new String[valueList.size()]));// ➞ ["Ryan", "Matt"]
  

    }

    public static String[] isFourLetters(String[] s) {
    	return Stream.of(s).filter(world -> world.length() == 4)
    			.toArray(String[]::mew);
        
    }

    public static String[] isFourLettersV2(String[] s) {
    	return Stream.of(s).filter(world -> world.length() == 4)
    			.toArray(size -> new String[size]);
        
    }
}