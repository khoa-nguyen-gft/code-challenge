//package demo;

import java.io.Console;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) {
        AlphabetSoup("Hello World");// ➞ "dlroW olleH"
        AlphabetSoup("The quick brown fox.");// ➞ ".xof nworb kciuq ehT"
        AlphabetSoup("Edabit is really helpful!");// ➞ "!lufpleh yllaer si tibadE"
    }
    
    
    public static String AlphabetSoup(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        String result = new String(chars);
        System.out.println(result);
        return new String(chars);
    }
}