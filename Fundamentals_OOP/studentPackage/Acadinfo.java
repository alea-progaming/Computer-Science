package studentPackage;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Acadinfo {
		
	public String Acadinfo()
	{	
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("##.00");
		int qui1, qui2, mid, fin, studNumber, atten, sum;
		double  ave = 0;
		//STUDENT EDUCATIONAL DETAILS
		System.out.println("STUDENT EDUCATIONAL DETAILS: ");
		System.out.print("Student Number ");
		studNumber = sc.nextInt();
		
		
		//computation
		
		
		System.out.println("Student Grade Average: " + df.format(displayEducDetails(ave)));
		
		System.out.print("Student Attendance: ");
		atten = sc.nextInt();
		System.out.println(atten + "%");
		
		//int summ = displayEducDetails(int qui1, int qui2, int mid, int fin);
		return "";		
		
	}	
	
	public static double displayEducDetails(double ave) {
		Scanner sc = new Scanner(System.in);
		int q1, q2, mi, fi, sum;
		
		System.out.print("Quiz 1: ");
		q1 = sc.nextInt();
		System.out.print("Quiz 2: ");
		q2 = sc.nextInt();
		System.out.print("Midterm Grade: ");
		mi = sc.nextInt();
		System.out.print("Final Grade: ");
		fi = sc.nextInt();
		sum = q1 + q2 + mi + fi;
		ave = sum/4;
		return ave;
	}
	
	/*public int displayEducDetails(int n1, int n2, int n3, int n4, int n5, int n6, int n7) {
		System.out.println("STUDENT EDUCATIONAL DETAILS: ");
		System.out.print("Student Number " + Acadinfo());
		System.out.print("Quiz 1: " + n2);
		System.out.print("Quiz 2: "  + n3);
		System.out.print("Midterm Grade: " + n4);
		System.out.print("Final Grade: " + n5);
		System.out.println("Student Grade Average: " + n6);
		
		System.out.print("Student Attendance: " + n7);
		return displayEducDetails(int n1);
	}*/
}
