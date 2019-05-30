
import java.util.stream.Stream;

public class App{
    public static void main(String[] args){
    	
    	verifySubstrs("Onomatopeia", "on", "mato", "ia");// ➞ "Incomplete."

    	verifySubstrs("Centipede", "Cent", "tip", "pede");//  ➞ "My head, body, and tail."

    	verifySubstrs("apple", "AP", "PPL", "LE");//  ➞ "Incomplete."
    	
    	verifySubstrs("Hey, you, stop that.", "Hey,", "y ou,", "st .");

    }
    
    public static String verifySubstrs(String s1, String s2, String s3, String s4) {
    	System.out.println(s1+"=" + s2 + s3 + s4);

    	String result = s1.startsWith(s2) && s1.contains(s3) && s1.endsWith(s4)? "My head, body, and tail.": "Incomplete.";
    	System.out.println(result);
    	return result;
    	
    	
}
}