//package demo;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class App{
    public static void main(String[] args) {
    	//reduced = 6 (1 + 2 + 3)
    	int result = 
        IntStream.range(1,4)
        .reduce((x,y)-> {return (x + y);})
        .getAsInt();
    	System.out.println(result);
    	
    	//reducedTwoParams = 16 (10 + 1 + 2 + 3)
    	int reduceTwhoParams = Stream.of(1, 2, 3)
    	.reduce(10, 
    			(a, b) -> a + b, 
    			// combiner wasn’t called. To make a combiner work, a stream should be parallel
    			(a, b) -> {
    				System.out.println("combiner was called");
    				return a + b;
				}
    			);
    	System.out.println("reduceTwhoParams: " + reduceTwhoParams);
    	
    	// combiner wasn’t called. To make a combiner work, a stream should be parallel
    	reduceTwhoParams = Arrays.asList(1, 2, 3).parallelStream()
    	.reduce(10, 
    			(a, b) -> a + b, 
    			// combiner wasn’t called. To make a combiner work, a stream should be parallel
    			(a, b) -> {
    				System.out.println("combiner was called");
    				return a + b;
				}
    			);
    	// First
    	// 10 + 1 = 11
    	// 10 + 2 = 12
    	// 10 + 3 = 13
    	//
    	// Second:
    	// 11 + 12 = 23
    	// 23 + 13 = 26
    	System.out.println("reduceTwhoParams in second: " + reduceTwhoParams);

    }
    
    
}