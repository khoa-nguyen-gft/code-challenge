import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        nameShuffle("Donald Trump");// ➞ "Trump Donald"
        nameShuffle("Rosie O'Donnell");// ➞ "O'Donnell Rosie"
        nameShuffle("Seymour Butts"); //➞ "Butts Seymour"
    }
    
    
    public static String nameShuffle(String s) {
        String[] strArr = s.split(" ");
        List<String> listStr = Arrays.asList(strArr);
        Collections.reverse(listStr);
        String result = String.join(" ", listStr);
        System.out.println(result);
        return result;
    }
}