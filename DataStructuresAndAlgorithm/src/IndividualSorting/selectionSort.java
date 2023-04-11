package IndividualSorting;
import java.util.Scanner;

public class selectionSort {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.print("Enter size of an array: ");
		int size = sc.nextInt();
		
		int i , j , temp, min, index;
		int nums[] = new int[size];
		
		System.out.print("Enter " + size + " vlaues: ");
		for (i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		
		printArray(nums);
		
		for (i = 0; i < size-1; i++) {
			min = i;
			for (j = i + 1; j < size; j++) {
				if (nums[j] < nums[min]) {
					min = j;
				}
			}
			temp = nums[min];
			nums[min] = nums[i];
			nums[i] = temp; 
			System.out.println();
			printArray(nums);
		}
		
	}
	
	private static void printArray(int nums[]) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
