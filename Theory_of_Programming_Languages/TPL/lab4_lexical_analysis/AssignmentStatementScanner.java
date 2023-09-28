package lab4_lexical_analysis;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AssignmentStatementScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Java assignment statement: ");
        String inputStatement = scanner.nextLine().trim();
        scanner.close();

        // Regular expression pattern to match Java assignment statements
        String pattern = "^\\s*([a-zA-Z_][a-zA-Z0-9_]*)\\s*=\\s*([\\d\\w]+)\\s*;\\s*$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(inputStatement);

        if (matcher.matches()) {
            String dataType = "int"; // Default data type for this example
            String identifier = matcher.group(1);
            String value = matcher.group(2);

            System.out.println("Output is: " + dataType + " " + identifier + " = " + value + ";");
        } else {
            System.out.println("Invalid Java assignment statement.");
        }
    }
}
