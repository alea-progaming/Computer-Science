package Bank_Account;
import java.text.DecimalFormat;
import java.util.Scanner;

public class AccountRun { //need some revisions

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("##.00");


        Account account1 = new Account();
        Account account2 = new Account();

        account1.balance=150;
        account2.balance=500;

        System.out.println("Account 1 Balance: " + "$" + (df.format(account1.balance)));
        System.out.println("Account 2 Balance: " + "$" + (df.format(account2.balance)));
        
        // Account 1 Withdraw
        System.out.print("\nEnter withdrawal amount for Account 1: ");
        account1.withdraw = input.nextInt();

        System.out.println("\nSubtracting " + account1.withdraw + " from Account 1 Balance");

        if(account1.balance>account1.withdraw)
        {
        	System.out.print("\nAccount 1 Balance: ");
        	account1.debit();
        	 System.out.println("Account 2 Balance: $" + (df.format(account2.balance)));
        } else
            {
                System.out.println("Debit amount exceeded account balance!");
                System.out.println("Account 1 Balance: $" + (df.format(account1.balance)));

                System.out.println("Account 2 Balance: $" + (df.format(account2.balance)));
            }

        // Account 2 Withdraw
        System.out.print("\nEnter withdrawal amount for Account 2: ");
        account2.withdraw = input.nextInt();

        System.out.println("\nSubtracting " + account2.withdraw + " from Account 2 Balance");

        if(account2.balance>account2.withdraw)
        {
        	System.out.print("\nAccount 1 Balance: ");
            account1.debit();
        	System.out.print("Account 2 Balance: " );
        	account2.debit();
        } else
            {
                System.out.println("Debit amount exceeded account balance!");
                System.out.println("Account 1 Balance: $" + (df.format(account1.balance)));
                System.out.println("Account 2 Balance: $" + (df.format(account2.balance)));
            }



    }

}