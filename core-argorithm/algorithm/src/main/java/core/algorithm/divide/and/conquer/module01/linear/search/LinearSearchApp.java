package core.algorithm.divide.and.conquer.module01.linear.search;

public class LinearSearchApp {
    public static void main(String[] args) {
        int key = 14;
        int arr[] = {3, 6, 8, 12, 14, 17, 25, 29, 31, 36, 42, 47, 53, 55, 62};
        
        int resultLinear = linearSearch(arr, key);
        System.out.println(resultLinear);
    }

    private static int linearSearch(int[] arr, int key) {
        for(int i = 0; i < arr.length; i ++) {
            if(key == arr[i]) {
                return arr[i];
            }
        }
        return -1;
    }
}
