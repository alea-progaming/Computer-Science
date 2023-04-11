package Assignment3;

public class Purugganan_2BSCS2_RCombinations {

	
	/*
	 * Task:
	 * Write a program that generates all r-combinations of the elements {1, ..., n}
	 */
	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4};
		int r = 10;
		int num = arr.length;
		print(arr, num, r);

	}
	 
	/*
	 * Parameter explained:
	 * arr[] the input arrays, the elements in a set
	 * num is from the length of the array
	 * r is the number of arrangements of possible combinations
	 * inx is the starting index
	 * temp[] is where we store temporary data for combinations
	 * int i is used for each element of the array
	 */
	
	public static void combine(int arr[], int num, int r, int inx, int temp[], int i)
	{
		// if inx is equal to the value of r, return the value of k from the temp array
		if(inx == r) {
			for (int k = 0; k < r; k++)
				System.out.print(temp[k] + " ");
				System.out.println();
				return;
		}
		
		if(i >= num)
			return;
		
		temp[inx] = arr[i];
		combine(arr, num, r, inx+1, temp, i+1);
		combine(arr, num, r, inx, temp, i+1);
	}
	// method for printing the combinations
	static void print(int arr[], int num, int r) {
		int temp[] = new int[r];
		
		combine(arr, num, r, 0, temp, 0);
	}
}