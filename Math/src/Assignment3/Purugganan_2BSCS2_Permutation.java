package Assignment3;

public class Purugganan_2BSCS2_Permutation {

	/*
	 * Task:
	 * Write a program that lists all permutations of ABCDEF in which A appears before D
	 */
	public static void main(String[] args) {
		String str = "T";
		int n = str.length();
		Purugganan_2BSCS2_Permutation Assignment3 = new Purugganan_2BSCS2_Permutation();
		Assignment3.mutation(str, 0, n - 1);

	}
	// method for swapping to make possible arrangements
	public String swap(String z, int m, int n)
	{
		char temp;
		char[] charArray = z.toCharArray();
		temp = charArray[m];
		charArray[m] = charArray[n];
		charArray[n] = temp;
		
		return String.valueOf(charArray);
	}
	
	// method for the conditions that A appears before D
	// use of the swap method for permutation
	public void mutation(String str, int start, int next)
	{
		if(start == next)
		{
			int index1 = 0, index2 = 0;
			for(int i = 0; i < str.length(); i++)
			{
				if(str.charAt(i) == 'A')
					index1 = i;
			}
			for(int j = 0; j < str.length(); j++)
			{
				if(str.charAt(j) == 'D')
					index2 = j;
			}
			if(index1 < index2)
				System.out.println(str);
		}
		else {
			for(int a = start; a <= next; a++)
			{
				str = swap(str, start, a);
				mutation(str, start + 1, next);
				str = swap(str, start, a);
			}
		}
	}

}
