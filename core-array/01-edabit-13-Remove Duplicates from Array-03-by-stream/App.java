import java.util.Arrays;
import java.util.stream.IntStream;

public class App {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(removeDups(new String[] { "John", "Taylor", "John" })));// ["John", "Taylor"]

		System.out.println(Arrays.toString(removeDups(new int[] { 1, 0, 1, 0 })));// [1, 0]

		System.out.println(Arrays.toString(removeDups(new String[] { "The", "big", "cat" })));// ['The', 'big', 'cat']
	}

	/**
	 * use distinct method
	 * @param nums
	 * @return
	 */
	public static int[] removeDups(int[] nums) {
		int[] result = IntStream.of(nums).distinct().toArray();
		return result;
	}

	/**
	 * filter method
	 * @param nums
	 * @return
	 */
	public static String[] removeDups(String[] str) {
		String[] result = IntStream.range(0, str.length - 1).filter(i -> Arrays.asList(str).indexOf(str[i]) == i)
				.mapToObj(i -> str[i]).toArray(size -> new String[size]);
		return result;
	}
}
