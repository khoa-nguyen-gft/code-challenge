//package demo;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class AppCollection{
    public static void main(String[] args) {
        minMax(Arrays.asList(-54, -210));
        minMax(Arrays.asList(1, 2, 3, 4, 5));// ➞ [1, 5]
        minMax(Arrays.asList(2334454, 5));// ➞ [5, 2334454]
        minMax(Arrays.asList(1));// ➞ [1, 1]
    }

    public static int[] minMax(List<Integer> input){
        int[] result = new int[2];
        result[0]=Collections.min(input);
        result[1]=Collections.max(input);
        System.out.println(Arrays.toString(result));
        return result;
    }
}