import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.OptionalInt;
import java.util.stream.Stream;
import static java.util.Arrays.stream;


public class _0103StreamMin{
    public static void main(String[] args) {
        int[] input = new int[] {4, 5, 1, 3};
        Program.findSmallestNum(input);// ➞ 5

        input = new int[] {300, 200, 600, 150};
        Program.findSmallestNum(input);// ➞ 600

        input = new int[] {1000, 1001, 857, 1};
        Program.findSmallestNum(input);// ➞ 1001
    }
}

class Program {
    public static int findSmallestNum(int[] nums) {
        int result = stream(nums).min().getAsInt();
        System.out.println(result);
        return result;
    }
}