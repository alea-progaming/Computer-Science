package selectionSort;

import java.util.Arrays;

public class selectionSort{
    
    public static void selectionSort(String[] arr) {
        int n = arr.length;
        
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++) {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j].compareTo(arr[min_idx]) < 0) {
                    min_idx = j;
                }
            }
            // Swap the found minimum element with the first element
            String temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
            
            System.out.println();
        }
    }

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "orange", "pear", "kiwi", "grape"};
        System.out.println("Original array: " + Arrays.toString(words));
        selectionSort(words);
        System.out.println("Sorted array: " + Arrays.toString(words));
    }
}