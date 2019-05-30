import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;


public class _0102StreamReduce{
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
        //first paramter: `0` to identity as start value.
        int result = Arrays.stream(nums).reduce(Integer.MAX_VALUE, (first, second) -> {
            return (first < second) ? first:  second;
        });
        System.out.println(result);
        return result;
    }
}