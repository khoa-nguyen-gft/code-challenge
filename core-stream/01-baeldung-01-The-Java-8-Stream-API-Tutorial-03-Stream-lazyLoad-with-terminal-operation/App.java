//package demo;

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
        Stream.of("abc1","abc2", "abc3")
        .filter(element -> {
            wasCalled();
            System.out.println("filter() was called");
            return element.contains("1");
        }).map( element -> {
            System.out.println("map() was called");
            return element.toUpperCase();
        }).findFirst();
    }
}