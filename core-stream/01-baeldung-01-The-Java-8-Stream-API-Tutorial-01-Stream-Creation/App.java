//package demo;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class App{
    public static void main(String[] args) throws IOException {
        //******************************************
    	//2.1. Empty Stream
        //******************************************

        Stream<String> streamEmpty = Stream.empty();
        
        //******************************************
        //2.2. Stream of Collection
        //******************************************

        Stream<String> arrStream = Arrays.asList("a", "b", "c").stream();
        
        //******************************************
        //2.3. Stream of Array
        //******************************************

        Stream<String> arrStreamOf = Stream.of("a", "b", "c");
        String[] arr = new String[] {"a", "b", "c"} ;
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfPartOf = Arrays.stream(arr, 1,2);
        
        //******************************************
        // /2.5. Stream.generate()
        //******************************************

        Stream.generate(()->10).limit(10)
        .forEach(System.out::println);
        //******************************************
        //2.6. Stream.iterate()
        //******************************************

        //******************************************
        //2.7. Stream of Primitives
        //******************************************
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);
        
        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);
        //random.ints().forEach(System.out::print);
        
        //******************************************
        //2.8. Stream of String
        //******************************************

        String listOfInt = "abc"
        // convert to list of int
        .chars()
        // convert from int to Integer
        .boxed()
        // convert from Integer to String
        .map(x -> x.toString())
        // concat the string
        .reduce((x, y) ->x + "; " + y)
        .get();
        //System.out.println(listOfInt);
        
        
        Stream<String> abc = Pattern.compile(", ")
        .splitAsStream("a, b, c");
        
        //abc.forEach(System.out::print);
                
        //******************************************
        //2.9. Stream of File
        //******************************************
        
        Path path = Paths.get("src/demo/text.txt");
        
        Stream<String> fileLine = Files.lines(path);
        //fileLine.forEach(System.out::println);
        
        Stream<String> fileLineWithCharset = Files.lines(path, Charset.forName("UTF-8"));
        //fileLineWithCharset.forEach(System.out::println);
        
    }
}