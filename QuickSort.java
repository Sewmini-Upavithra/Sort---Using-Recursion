package Recursion;

import java.util.Arrays;

public class QuickSort {

	public static void main(String args[]) {

        int[] input = { 25, 30, 10, 12, 35, 78};
        System.out.println("Before sorting : " + Arrays.toString(input));
        quickSort(input); // sort the integer array using quick sort algorithm
        System.out.println("After sorting : " + Arrays.toString(input));
     
        // input with duplicates
        int[] withDuplicates = { 11, 13, 16, 13, 11, 14};
        System.out.println("Before sorting : " 
                              + Arrays.toString(withDuplicates));
        quickSort(withDuplicates); // sort the array using quick sort algorithm
        System.out.println("After sorting : " 
                              + Arrays.toString(withDuplicates));
    }

   
    public static void quickSort(int[] array) {
        recursiveQuickSort(array, 0, array.length - 1);
    }

  
    public static void recursiveQuickSort(int[] array, int startIdx, 
                                                        int endIdx) {
     
        int idx = partition(array, startIdx, endIdx);

        // Recursively call sort with left part of the partitioned array
        if (startIdx < idx - 1) {
            recursiveQuickSort(array, startIdx, idx - 1);
        }

        // Recursively call quick sort with right part of the partitioned array
        if (endIdx > idx) {
            recursiveQuickSort(array, idx, endIdx);
        }
    }

   
    public static int partition(int[] array, int left, int right) {
        int pivot = array[left]; // taking first element as pivot

        while (left <= right) {
            //searching number which is greater than pivot, bottom up
            while (array[left] < pivot) {
                left++;
            }
            //searching number which is less than pivot, top down
            while (array[right] > pivot) {
                right--;
            }

            // swap the values
            if (left <= right) {
                int tmp = array[left];
                array[left] = array[right];
                array[right] = tmp;

                //increment left index and decrement right index
                left++;
                right--;
            }
        }
        return left;
    }
}
