package CarUpgrade;
import java.util.Scanner;

public class CarUpgrade {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Owner: ");
		String nameOwner = sc.nextLine();
		Car.ownerName = nameOwner;
		
		System.out.print("Year Model: ");
		int yearModel = sc.nextInt();
		Car.yrModel = yearModel;
		
		System.out.print("Available amount before ugrade: ");
		int amount = sc.nextInt();
		Car.balance = amount;
		
		int finBalance = Car.upgradeAccessories(Car.balance);
		
		System.out.println();
		System.out.println("Owner: " + Car.ownerName);
		System.out.println("Year Model: " + Car.yrModel);
		System.out.println("Available Amount Before Upgrade: " + Car.balance);
		System.out.println("Installed AC: " + Car.boolAc);
		System.out.println("Installed Leather Seats: " + Car.boolLeatherSeat);
		System.out.println("Installed Back Wipers: " + Car.boolBackWiper);
		System.out.println("Installed Fog Lights: " + Car.boolFogLight);
		System.out.println("Available Amount After Upgrade: " + finBalance);
		
	}

}
