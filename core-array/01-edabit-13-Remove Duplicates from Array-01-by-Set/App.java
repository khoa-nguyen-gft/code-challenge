import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class App {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(removeDups(new String[] { "John", "Taylor", "John" })));// ["John", "Taylor"]

		//System.out.println(removeDups(new Integer[] { 1, 0, 1, 0 }, int[].class));// [1, 0]

		System.out.println(Arrays.toString(removeDups(new String[] { "The", "big", "cat" })));// ['The', 'big', 'cat']
	}

	private static <T> String[] removeDups(T[] arr) {		
		Set<T> hashSet = new HashSet<T>(Arrays.asList(arr));
		return hashSet.toArray(new String[hashSet.size()]);
	}

}
