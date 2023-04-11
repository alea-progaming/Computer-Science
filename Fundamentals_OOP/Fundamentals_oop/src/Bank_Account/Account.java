package Bank_Account;
import java.text.DecimalFormat;
public class Account {

DecimalFormat df = new DecimalFormat("##.00");
      int balance;
      int withdraw;

     void debit()
     {
        double calculateBalance;
        calculateBalance = balance - withdraw;
        System.out.println("$" + df.format(calculateBalance));
     }
}
