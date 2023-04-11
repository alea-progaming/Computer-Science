package mainPackage;
import java.util.Scanner;
import java.text.DecimalFormat;
import employeePackage.*;
import studentPackage.*;

public class MainProgram {
	

	public static void main(String[] args) {
		// EMPLOYEE and STUDENTS DETAILS INPUT ONLY
		for (int i = 0; i < 2; i++) {
			Studentinfo dis = new Studentinfo();
			Employeeinfo display = new Employeeinfo();
			Acadinfo dip = new Acadinfo();

			System.out.println(dis.Studentinfo());
			System.out.println(display.display_Employee());
			System.out.println(dip.Acadinfo());
			
			if (i==0) {
				System.out.println("\nNEXT STUDENT\n\n");
			}
		}
		
	}
	
}
