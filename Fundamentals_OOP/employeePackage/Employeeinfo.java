package employeePackage;
import java.util.Scanner;


public class Employeeinfo {
	
	public static String display_Employee() {	
			//Employee details input
		Scanner sc = new Scanner(System.in);
		String empName = "", designation = "", acadPos = "";
			System.out.println("EMPLOYEE'S DETAILS");
			System.out.print("Employee Name: ");
			empName = sc.nextLine();
			System.out.print("Designation: ");
			designation = sc.nextLine();
			System.out.print("Academic Position: ");
			acadPos = sc.nextLine();
			return "";
		
/*			String name = disp(empName);
			String des = dip(designation);
			String acad = disp(acadPos);
*/			
			
	}
	/*
	static String disp(String name) {
		System.out.println("EMPLOYEE'S DETAILS");
		System.out.println("Employee Name: " + name);
		return name;
		
	}
	
	static String dip(String des) {
		System.out.println("Designation: " + des);
		return des;
	}
	
	static String dis(String acad) {
		System.out.println("Academic Position: " + acad);
		return acad;
	}*/
}
