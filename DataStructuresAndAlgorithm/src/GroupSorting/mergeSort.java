package GroupSorting;
import java.util.Scanner;

public class mergeSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size;
		
		System.out.print("Enter the size of array: ");
		size = sc.nextInt();
		
		int A[] = new int[size];
		
		System.out.print("Enter " + size + " values: ");
		for (int i = 0; i < size; i++) {
			A[i] = sc.nextInt();
		}
		//----UNSORTED----//
		System.out.println("\nUNSORTED:");
		printArray(A);
		System.out.println();
	    
	     
		
		
//---------------------------------                  SORTING                       ----------------------------------------------------------------//
		
		MergeSort(A);
	System.out.print("\n\nSORTED: ");
	   printArray(A);
		
	}
	
	public static void MergeSort(int array[]) {
		int arrayLength = array.length;
		
	    if (arrayLength < 2) {
	    	return;
	    }
	    
	    int mid = arrayLength / 2;
	    int left[] = new int [mid];
	    int right[] = new int [arrayLength - mid];
	    
	    System.out.print("\n");
	      for (int i = 0; i < mid; i++) {
	    	  left[i] = array[i];
	    	  System.out.print(left[i] + " ");
			}
	      System.out.print("| ");
	      for (int i = mid; i < arrayLength; i++) {
	    	  right[i - mid] = array[i];
	    	  System.out.print(right[i- mid] + " ");
	      }
	   
	      MergeSort(left);
	      
	      MergeSort(right);
	   
	      Merge(array, left, right);
	    
	}
	
	
	public static void  Merge(int array[], int left[], int right[]) {
		int leftSize = left.length;
		int rightSize = right.length;
		
		int i = 0, j = 0, k = 0;
		System.out.print("\n");
		while (i < leftSize && j < rightSize) {
			if (left[i] <= right[j]) {
				array[k] = left[i];
				i++;
			} else {
				array[k] = right[j];
				j++;
			} 
			System.out.print(array[k] + " ");
			k++;
			
			
		}
		
		while (i < leftSize) {
			array[k] = left[i];
			System.out.print(array[k] + " ");
			i++;
			k++;
		}
		
		while (j < rightSize) {
			array[k] = right[j];
			System.out.print(array[k] + " ");
			j++;
			k++;
		}
		
		
	}
	
	private static void printArray(int nums[]) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
