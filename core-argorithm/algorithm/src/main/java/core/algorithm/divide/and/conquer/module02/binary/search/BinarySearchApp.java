package core.algorithm.divide.and.conquer.module02.binary.search;

public class BinarySearchApp {
    public static void main(String[] args) {
        int key = 48;
        int arr[] = {3, 6, 8, 12, 14, 17, 25, 29, 31, 36, 42, 47, 53, 55, 62};

        int result = binarySearch(arr, key, 0, arr.length);
        System.out.println(result);
    }

    private static int binarySearch(int[] arr, int key, int small, int hight) {
        int mid = Math.round((small + hight)/2);
        
            if (small > hight) {
                return -1;
            }
            if (arr[mid] == key) {
                return arr[mid];
            } else if (arr[mid] > key ){
                 return binarySearch(arr, key, small, mid -1);
            } else if (arr[mid] < key) {
                 return binarySearch(arr, key, mid +1, hight);
            } 
        return -1;
    }

}
