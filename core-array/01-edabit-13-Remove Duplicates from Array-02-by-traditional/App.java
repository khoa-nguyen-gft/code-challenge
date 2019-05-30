import java.util.ArrayList;
import java.util.Arrays;

public class App {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(removeDups(new String[] { "John", "Taylor", "John" })));// ["John", "Taylor"]

		System.out.println(Arrays.toString(removeDups(new int[] { 1, 0, 1, 0 })));// [1, 0]

		System.out.println(Arrays.toString(removeDups(new String[] { "The", "big", "cat" })));// ['The', 'big', 'cat']
	}

    public static int[] removeDups(int[] nums) {
    	ArrayList<Integer> result = new ArrayList<Integer>();
    	
    	for (int i : nums) {
			if (!result.contains(i)) {
				result.add(i);
			}
		}
    	
    	return result.stream().mapToInt(Integer::intValue).toArray();
    	
    }
    public static String[] removeDups(String[] str) {

    	ArrayList<String> result = new ArrayList<String>();
    	
    	for (String i : str) {
			if (!result.contains(i)) {
				result.add(i);
			}
		}
    	
    	return result.toArray(new String[result.size()]);
    
    }
    
}
