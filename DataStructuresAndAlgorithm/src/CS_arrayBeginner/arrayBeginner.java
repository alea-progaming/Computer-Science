package CS_arrayBeginner;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class arrayBeginner {

	public static void main(String[] args) {
		Scanner userIn = new Scanner(System.in);
		int sum = 0; int y; int x[];
		int c;
		
		do {
		System.out.println(	"1. Sum of numbers in an array\n" +
							"2. Maximum and minimum numbers in an array\n" +
							"3. Grade Book\n" +
							"4. Delete duplicate values in an array\n" +
							"5. Exit");
		System.out.print("Pick a number from 1-4: ");
		c = userIn.nextInt();
		
		
		
switch (c) {
	case 1: //Sum of numbers in an array
		Scanner user = new Scanner(System.in);
		System.out.print("Enter the length of n: ");
		y = user.nextInt();
		
		x = new int[y];
		
		System.out.print("Enter " + y + " numbers... ");
		for (int i = 0; i < y; i++) {
			x[i] = user.nextInt();
			sum += x[i];
		}
		
		System.out.println("Sum is " + sum);
		System.out.println();
		break;
			
		
	case 2: //Maximum and minimum numbers in an array
		Scanner input = new Scanner(System.in);
		
		int size;
		System.out.print("Input array size: ");
		size = input.nextInt();
		System.out.print("Input " + size + " value: ");

		int[] inputArray = new int[size ];

		for(int i = 0; i < size  ; i++) {
			inputArray[i] = input.nextInt();
			
		}
		int maxV, minV;
		maxV = minV = inputArray[0];

		for(int i = 1; i <size  ; i++) {
			if(inputArray[i] > maxV)//20
				maxV = inputArray[i];
			else if (inputArray[i] < minV)//-1
				minV = inputArray[i];      
		}  
		System.out.println("Maximum value: " + maxV);
		System.out.println("Minimum value: " + minV);
		System.out.println();
		break;
		
	case 3: //Grade Book
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("##.##");
		int numStudent, numQuiz, studentNum, quizScore, sumQuiz = 0, failed = 0, passed = 0, stud = 1, qui = 1;
		int students[]; double scores[][], quizzes[];
		double quiz, average, aveQuiz[]; String[] remarks;
		
		//initial array variables
		students = new int[1000];
		scores = new double[1000][1000];
		aveQuiz = new double[1000];
		remarks = new String [10000];
		
		System.out.print("Number of students: ");
		numStudent = sc.nextInt();
		System.out.print("Number of quizzes: ");
		numQuiz = sc.nextInt();
		
		
		System.out.println();//clear space
		
		for (int i = 0; i < numStudent; i++) {
			System.out.print("Enter student number: ");
			studentNum = sc.nextInt();
			students[i] = studentNum;
			int quizCap = 1;
			for (int j = 0; j < numQuiz; j++) {
				System.out.print("Enter score for Quiz " + quizCap + ": ");
				quizScore = sc.nextInt();
				scores[i][j] = quizScore;
				quizCap++;
			}
			System.out.println();//clear space
		}
		
		for (int m = 0; m < numStudent; m++) {
			
			for (int n = 0; n < numQuiz; n++) {
				
				sumQuiz += scores[m][n];
			}
			average = sumQuiz/numQuiz;
			aveQuiz[m] = average;
			
			if (aveQuiz[m] >= 75) {
				remarks[m] = "PASSED";
				passed++;
			} else {
				remarks[m] = "FAILED";
				failed++;
			}
			
			System.out.println("Student " + students[m] + "\t\t Average is " + df.format(aveQuiz[m]) + "\t\t" + remarks[m]);
			sumQuiz=0;
		}
		 System.out.println();
		   System.out.println("Number of student(s) passed: "+ passed);
		   System.out.println("Number of student(s) failed: "+ failed);
		   System.out.println();
		   System.out.println();
		
		   for (int p = 0; p < numStudent; p++) {
			   System.out.println("Student number " + students[p]);
			   int r1 = 1;
			   for (int r = 0; r < numQuiz; r++) {
				   System.out.println("Quiz " + r1 + ": " + scores[p][r]);
				   r1++;
			   }
			   System.out.println("Average:  " +df.format(aveQuiz[p]));
			   System.out.println("Remarks:"+ remarks[p]);
			   System.out.println();
		   }
		   System.out.println();
		   break;
		
	case 4: //Delete duplicate values in an array
		 Scanner input1 = new Scanner(System.in);

	       int size1;

	        System.out.print("Input array size: ");  
	        size1 = input1.nextInt();  
	        int arr[] = new int[size1]; 
	        System.out.print("\nInput " + size1 + " values: ");  
	        for(int i = 0; i < size1; i++)
	        {  
	            arr[i]=input1.nextInt();
	        }
	        
	        removeDuplicateElements(arr, size1);
	        System.out.println();
	        break;
	case 5: //System exit
			System.out.println("PROGRAMMERS' NAME: PURUGGANAN,Mikaela_ASIS,Steven_CARABEO,Meldrick");
			System.exit(0);
	default:
			if(c < 1 || c > 5) {
				System.out.println();
				System.out.println("--NOT VALID--");
				System.out.println();
			}
	    }
		

		}while(c != 5);
		
		
		
	}
	 public static void removeDuplicateElements(int arr[], int n)
	    {  
	        Arrays.sort(arr);
	 
	        int len = arr.length;
	        int j = 0;
	 
	        for (int i = 0; i < len - 1; i++) 
	        {
	            if (arr[i] != arr[i + 1]) 
	            {
	                arr[j++] = arr[i];
	            }
	        }
	 
	        arr[j++] = arr[len - 1];

	        System.out.print ("Distinct values: ");
	 
	        for (int k = 0; k < j; k++) 
	        {
	           System.out.print(arr[k] + " ");        
	        }       
	        System.out.println();
	}

}
