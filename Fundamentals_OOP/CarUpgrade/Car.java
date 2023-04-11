package CarUpgrade;

public class Car
{
		// attributes //
		static int balance;
		static int ac = 21500;
		static int leatherSeats = 14400;
		static int backWipers = 6250;
		static int fogLights = 3300;
		
		// owner //
		static String ownerName;
		static int yrModel;
		
		// boolean //
		static boolean boolAc;
		static boolean boolLeatherSeat;
		static boolean boolBackWiper;
		static boolean boolFogLight;
		
		 void owner()
		{
			ownerName = "";
			yrModel = 0;
		}
		
		static int upgradeAccessories(int availAmount)
		{
			if (balance >= ac && balance < ac + leatherSeats)
			{
				System.out.println("Only AC installed");
				System.out.print("Remaining Amount = (" + balance + " - " + ac + ") = ");
				availAmount = balance - ac;
				System.out.println(availAmount);
				boolAc = true;
			}
			else if (balance >= ac + leatherSeats && balance < ac + leatherSeats + backWipers)
			{
				System.out.println("AC and Leather Seats Installed");
				System.out.print("Remaining Amount = (" + balance + " - " + ac + " - " + leatherSeats + ") = ");
				availAmount = balance - ac - leatherSeats;
				System.out.println(availAmount);
				boolAc = true;
				boolLeatherSeat = true;
			} else if (balance >= ac + leatherSeats + backWipers && balance < ac + leatherSeats + backWipers + fogLights)
			{
				System.out.println("AC and Leather Seats Installed");
				System.out.print("Remaining Amount = (" + balance + " - " + ac + " - " + leatherSeats + ") = ");
				availAmount = balance - ac - leatherSeats - backWipers;
				System.out.println(availAmount);
				boolAc = true;
				boolLeatherSeat = true;
				boolBackWiper = true;
			}else if (balance >= ac + leatherSeats + backWipers + fogLights)
			{
				System.out.println("AC, Leather Seats, Back Wipers and Fog Lights Installed");
				System.out.print("Remaining Amount = (" + balance + " - " + ac + " - " + leatherSeats + " - " + backWipers + " - " + fogLights + ") = ");
				availAmount = balance - ac - leatherSeats - backWipers - fogLights;
				System.out.println(availAmount);
				boolAc = true;
				boolLeatherSeat = true;
				boolBackWiper = true;
				boolFogLight = true;
			}
			return availAmount;
		}
}
