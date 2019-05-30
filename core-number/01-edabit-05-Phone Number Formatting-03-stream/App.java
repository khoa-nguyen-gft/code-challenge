import java.io.Console;
import java.util.stream.IntStream;

public class App {
	public static void main(String[] args) {
		formatPhoneNumber(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 0});// ➞ 5

		formatPhoneNumber(new int[] {5, 1, 9, 5, 5, 5, 4, 4, 6, 8});// ➞ 10

		formatPhoneNumber(new int[] {3, 4, 5, 5, 0, 1, 2, 5, 2, 7});// ➞ 7
	}
	
    public static String formatPhoneNumber(int[] nums) {
        String result = "(XXX) XXX-XXXX";
        for (int i : nums) {
			result = result.replaceFirst("X", String.valueOf(i));
		}
       
        System.out.println(result);
        return result;
    }
}
