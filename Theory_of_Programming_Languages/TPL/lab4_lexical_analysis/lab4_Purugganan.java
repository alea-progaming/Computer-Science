package lab4_lexical_analysis;
import java.util.Scanner;

public class lab4_Purugganan {

    public static boolean isdataType(String element) {
            // data types
        return element.equals("String") || element.equals("int") || element.equals("char") || element.equals("double");
    }

        // first bracket starting from the first character. second bracket following the first bracket which then can include integer in identifier
    public static boolean isIdentifier(String element) {
        return element.matches("[a-zA-Z_][a-zA-Z0-9_]*");
    }

        // everything that is surrounded by double and single quotes, integers and integers with decimal
    public static boolean isValue(String element) {
        return element.matches("\"[^\"]*\"|'[^']*'|\\d+(\\.\\d+)?");
    }

    public static boolean isassignmentOperator(String element) {
        return element.equals("=");
    }

    public static boolean isDelimiter(String element) {
        return element.equals(";");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Source Language: ");
        String userIn = sc.nextLine();
        String[] elements = userIn.split("\\s+"); //white space

            System.out.print("Output is: ");
        for(String splitElement : elements) {
            
            if (isdataType(splitElement)) {
                System.out.print("<data_type> ");
            } else if (isIdentifier(splitElement)) {
                System.out.print("<identifier> ");
            } else if (isassignmentOperator(splitElement)) {
                System.out.print("<assignment_operator> ");
          //  } else if (isValue(splitElement)) {
           //      System.out.print("<value>");
            } else if (splitElement.endsWith(";")) {
                String iden = splitElement.substring(0, splitElement.length() - 1);
                if (isIdentifier(iden)) {
                    System.out.print("<identifier> ");
                } else if (isValue(iden)) {
                    System.out.print("<value>");
                }
                    System.out.print("<delimiter>");
                
                
            }
        }
    }
}
