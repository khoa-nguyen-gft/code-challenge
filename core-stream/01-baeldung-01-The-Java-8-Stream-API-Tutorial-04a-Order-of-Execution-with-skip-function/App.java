//package demo;

import java.util.stream.Stream;

public class App{
    private static long counter;

    public static void wasCalled(){
        counter ++;
        System.out.println("the counter is: "+ counter);
    }
    
    public static void main(String[] args) {
        //If we change the order of the skip() and the map() methods, the counter will increase only by one. 
        // So, the method map() will be called just once.



       long result = Stream.of("abc1","abc2", "abc3")
            .skip(2)
            .map(element -> {
           wasCalled();
           System.out.println();
           return element.substring(0, 3);
       }).count();

       
        //This brings us up to the rule: intermediate operations which reduce the size of the stream should 
        // be placed before operations which are applying to each element. 
        // So, keep such methods as skip(), filter(), distinct() at the top of your stream pipeline.
        
       System.out.println(result);
    }
}