package studentPackage;
import java.util.Scanner;

public class Studentinfo {
	
	public String Studentinfo(){
		Scanner sc = new Scanner(System.in);
		String studName="", studGender="", studAddress="", studContact="";
		String studFather="", studMother="", studAge="";
		
		
		
		//Student details input
		System.out.println("STUDENT DETAILS");
		System.out.print("Student Name: ");
		studName = sc.nextLine();
		System.out.print("Age: ");
		studAge = sc.nextLine();
		System.out.print("Student Gender: ");
		studGender = sc.nextLine();
		System.out.print("Student Address: ");
		studAddress = sc.nextLine();
		System.out.print("Contact Number: ");
		studContact = sc.nextLine();
		System.out.print("Father's Name: ");
		studFather = sc.nextLine();
		System.out.print("Mother's Name: ");
		studMother = sc.nextLine();
		
		return "";
		//public static String display_student; {
			/*System.out.println("STUDENT DETAILS");
			System.out.println("Student Name: " + studName);
			System.out.println("Student Gender: " + studGender);
			System.out.println("Student Address: " + studAddress);
			System.out.println("Contact Number: " + studContact);
			System.out.println("Father's Name: " + studFather);
			System.out.println("Mother's Name: " + studMother);*/
		//}
		
		
	}
	
	
	
}