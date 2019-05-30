//package demo;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        MultiplyByLength(new int[] {2, 3, 1, 0});// //➞ [8, 12, 4, 0]
    }
    
    
    public static String MultiplyByLength(int[] ints) {
        List<Integer> result = IntStream
        .of(ints)
        .map(x ->  x* ints.length)
        //IntStream.boxed turns an IntStream into a Stream<Integer>, which you can then collect into a list
        .boxed()
        .collect(Collectors.toList());
        
        
        System.out.println(result);
        return "";
    }
}