package IndividualSorting;
import java.util.Scanner;

public class bubbleSort {
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
		
		boolean isSwapped = true;
		
		System.out.println();
		while (isSwapped) {
			//isSwapped = false;
			int count=0;
		for (j = 0; j < size; j++) {
			
			for (i = 1; i < size; i++) {
					if (nums[i] <= nums[i - 1]) {
						if (count==size)
						isSwapped = true;
						//System.out.println("\n");
						//printArray(nums);
						temp = nums[i];
						nums[i] = nums[i - 1];
						nums[i - 1] = temp;
						System.out.println();
						printArray(nums);
						count++;
						if (count==size) {
							System.exit(0);
						}
				} else {
					isSwapped = false;
					nums[i] = nums[i];
					nums[i - 1] = nums[i - 1];
					System.out.println();
					printArray(nums);
				}
				
			}
			
		}
	}
}
	
	private static void printArray(int nums[]) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
}

