import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.OptionalInt;


public class _0104StreamReduceIntegerMax{
    public static void main(String[] args) {
        int[] input = new int[] {4, 5, 1, 3};
        Program.findLargestNum(input);// ➞ 5

        input = new int[] {300, 200, 600, 150};
        Program.findLargestNum(input);// ➞ 600

        input = new int[] {1000, 1001, 857, 1};
        Program.findLargestNum(input);// ➞ 1001
    }
}

class Program {
    public static int findLargestNum(int[] nums) {
        OptionalInt result = Arrays.stream(nums).reduce(Integer::max);
        System.out.println(result.getAsInt());
        return result.getAsInt();
    }
}