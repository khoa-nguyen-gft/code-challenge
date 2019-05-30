import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.LinkedList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;


public class AppWithStream {
    public static void main(String[] args) {
        nameShuffle("Donald Trump");// ➞ "Trump Donald"
        nameShuffle("Rosie O'Donnell");// ➞ "O'Donnell Rosie"
        nameShuffle("Seymour Butts"); //➞ "Butts Seymour"
    }
    
    
    public static String nameShuffle(String s) {
        String[] arr = s.split(" ");

        Iterator<String> reversedStream = Stream
        .of(arr)
        .collect(Collectors.toCollection(LinkedList::new))
        .descendingIterator();


        List<String> listReversedOrder = StreamSupport
            .stream(Spliterators.spliteratorUnknownSize(reversedStream,Spliterator.ORDERED), false)
            .collect(Collectors.<String> toList());
        

        String result = String.join(" ", listReversedOrder);
    	System.out.println(result);
        return result;
    }

}