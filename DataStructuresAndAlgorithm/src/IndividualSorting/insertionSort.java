package IndividualSorting;
import java.util.Scanner;

public class insertionSort {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		
		System.out.print("Enter size of an array: ");
		var size = sc.nextInt();
		
		int nums[] = new int[size];
		int i, j, temp;
		
		System.out.print("Enter " + size + " values: ");
		for (i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		//UNSORTED
		printArray(nums);
		
		for ( i = 1; i < nums.length; i++) {
			int currentValue = nums[i];
			
		j = i - 1;
		while(j >= 0 && nums[j] > currentValue) {
			nums[j + 1] = nums[j];
			
			j--;
		}
		nums[j + 1] = currentValue;
		//SORTED
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
