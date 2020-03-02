package core.algorithm.chapter01.divide.and.conquer.module03.heap.sort;

import java.util.Arrays;

public class BinarySearchApp {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17 };

        int[] result = heapSort(arr);
        System.out.println(Arrays.toString(result));
    }

    private static int[] heapSort(int[] arr) {
        // build max heap
        buildMaxHeap(arr);

        // Continue heap sorting until we have just one element

        return arr;
    }

    private static void buildMaxHeap(int[] arr) {
        //get parent of last node
        int parent = (int) Math.floor((arr.length)/2 -1);
        for(int i = arr.length -1; i >=0; i --) {
            if(arr[i] > arr[parent]) {
                swap(arr, i, parent);
            } 
        }
        }

    private static void swap(int[] arr, int firstItemIndex, int parent) {
        int temp = arr[firstItemIndex];
        arr[firstItemIndex] = arr[parent];
        arr[parent] = temp;
    }

}
