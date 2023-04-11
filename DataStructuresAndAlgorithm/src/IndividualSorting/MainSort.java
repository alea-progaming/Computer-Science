package IndividualSorting;
import java.util.Scanner;

public class MainSort {
	static Scanner sc = new Scanner(System.in);
	
	
	
	public static void main(String[] args) {
		
		int ch;
		int i , j , temp, min, index, size;
		System.out.print("Enter size of an array: ");
		size = sc.nextInt();
		int nums[] = new int[size];
		System.out.print("Enter " + size + " values: ");
		for (i = 0; i < nums.length; i++) {
			nums[i] = sc.nextInt();
		}
		//UNSORTED
		printArray(nums);
		
		while(true) {
			System.out.println();
		System.out.println("\nMENU: ");
		System.out.println("1. Bubble");
		System.out.println("2. Insertion");
		System.out.println("3. Selection");
		System.out.println("4. Exit");
		System.out.println("\nEnter choice [1..4]: ");
		ch = sc.nextInt();
		
		
		
		switch (ch) {
		//BUBBLE SORT
		case 1: 
			bubbleSort(nums);
			break;
			
			//INSERTION SORT
		case 2:
			insertionSort(nums);
			break;
			
			//SELECTION SORT
		case 3:
			selectionSort(nums);
			break;
		case 4:
			System.out.println("\n\nPROGRAMMERS' NAME: Mikaela Q. Purugganan");
			System.exit(0);
			break;
		default:
	        System.out.println();
			System.out.println("--NOT VALID--");
			System.out.println();

		    }

			}
}
	
	public static void bubbleSort(int nums[]) {
		System.out.println();
		System.out.println("-----BUBBLE SORT-----");
		printArray(nums);
		int size = nums.length;;
		boolean isSwapped = true;
		
		while (isSwapped) {
			
		for (int j = 0; j < size; j++) {
			for (int q = 1; q < nums.length; q++) {
			int currentValue = q;
			int k = q - 1;
			if(nums[k] > currentValue) {
				
			
			
			for (int i = 1; i < size; i++) {
					if (nums[i] <= nums[i - 1]) {
						isSwapped = true;
						int temp = nums[i];
						nums[i] = nums[i - 1];
						nums[i - 1] = temp;
						System.out.println();
						printArray(nums);
						
						
				} else {
					isSwapped = false;
					nums[i] = nums[i];
					nums[i - 1] = nums[i - 1];
					System.out.println();
					printArray(nums);
				}
				
			}
			k--;
			}
			}
		}
	}
		
	}
	
	public static void insertionSort(int nums[]) {
		System.out.println();
		System.out.println("-----INSERTION SORT-----");
		printArray(nums);
		for (int i = 1; i < nums.length; i++) {
			int currentValue = nums[i];
			
		int j = i - 1;
		while(j >= 0 && nums[j] > currentValue) {
			nums[j + 1] = nums[j];
			
			j--;
		}
		nums[j + 1] = currentValue;
		System.out.println();
		printArray(nums);		
		}
		System.out.println("\n\nPROGRAMMERS' NAME: Mikaela Q. Purugganan");
		System.exit(0);	
		
		return;
	}
	
	public static void selectionSort(int nums[]) {
		System.out.println();
		System.out.println("-----SELECTION SORT-----");
		printArray(nums);
		int size = nums.length;
		for (int i = 0; i < size-1; i++) {
			int min = i;
			for (int j = i + 1; j < size; j++) {
				if (nums[j] < nums[min]) {
					min = j;
				}
			}
			int temp = nums[min];
			nums[min] = nums[i];
			nums[i] = temp; 
			System.out.println();
			printArray(nums);
			
		}
		System.out.println("\n\nPROGRAMMERS' NAME: Mikaela Q. Purugganan");
		System.exit(0);	
		return;
	}
	public static void printArray(int nums[]) {
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}

}
