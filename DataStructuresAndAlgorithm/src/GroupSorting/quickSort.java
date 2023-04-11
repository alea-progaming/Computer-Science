package GroupSorting;
import java.util.Scanner;

public class quickSort {

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
	
	printArray(A);
	
	}
	
	private static void printArray(int A[]) {
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
	}

}
