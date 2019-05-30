//package demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        reverse("Hello World");// ➞ "dlroW olleH"
        reverse("The quick brown fox.");// ➞ ".xof nworb kciuq ehT"
        reverse("Edabit is really helpful!");// ➞ "!lufpleh yllaer si tibadE"
    }
    
    
    public static String reverse(String s) {
        
        List strs = Arrays.asList(s.split(""));
        Collections.reverse(strs);
        String result = String.join("", strs);
        System.out.println(result);
        return result;
    }
}