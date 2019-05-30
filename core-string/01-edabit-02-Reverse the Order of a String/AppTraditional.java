//package demo;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AppTraditional {
    public static void main(String[] args) {
        reverse("Hello World");// ➞ "dlroW olleH"
        reverse("The quick brown fox.");// ➞ ".xof nworb kciuq ehT"
        reverse("Edabit is really helpful!");// ➞ "!lufpleh yllaer si tibadE"
    }
    
    
    public static String reverse(String s) {
        StringBuilder result = new StringBuilder();
        String[] inputs = s.split("");
        for (int i = inputs.length -1; i >=0; i --){
            result.append(inputs[i]);
        }
        System.out.println(result.toString());
        return result.toString();
    }
}