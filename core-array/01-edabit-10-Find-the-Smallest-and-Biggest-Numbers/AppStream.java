//package demo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

public class AppStream{
    public static void main(String[] args) {
        minMax(Arrays.asList(-54, -210));
        minMax(Arrays.asList(1, 2, 3, 4, 5));// ➞ [1, 5]
        minMax(Arrays.asList(2334454, 5));// ➞ [5, 2334454]
        minMax(Arrays.asList(1));// ➞ [1, 1]
    }

    public static int[] minMax(List<Integer> input){
        int[] result = new int[2];
        result[0] = input.stream().reduce(Math::max).get();
        result[1] = input.stream().reduce(Math::min).get();
        
        System.out.println(Arrays.toString(result));
        return result;
    }
}