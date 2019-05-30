package demo;

import java.util.stream.Stream;

public class App{
    private static long counter;

    public static void wasCalled(){
        counter ++;
        System.out.println("the counter is: "+ counter);
    }
    
    public static void main(String[] args) {
    	//But running this code doesn’t change counter at all, it is still zero, so
    	//, the filter() method wasn’t called even once
    	//. The reason why – is missing of the terminal operation.
        Stream.of("abc1","abc", "abc3")
        .filter(element -> {
            wasCalled();
            return element.contains("abc1");
        });
    }
}