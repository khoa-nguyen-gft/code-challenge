import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App{
    public static void main(String[] args) {
        partiallyHide("skies were pretty");// "s---s w--e p----y"

        partiallyHide("red is not my color");// "r-d is n-t my c---r"
        
        partiallyHide("She rolled her eyes"); // "S-e r----d h-r e--s"
        
        partiallyHide("Harry went to fight the basilisk"); // "H---y w--t to f---t t-e b------k"
    }


    public static String partiallyHide(String input) {
        String[] split = input.split(" ");        
        List<String> collect = Stream.of(split).map(str -> {
        	if (str.length() > 2) {
            	return str.charAt(0) + String.join("", Collections.nCopies(str.length()-2, "-")) + str.charAt(str.length() -2);
        	} else {
        		return str;
        	}
        }).collect(Collectors.toList());
               
        System.out.println(String.join(" ", collect));
        return String.join(" ", collect);
    
    }
}