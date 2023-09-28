import java.util.Scanner;

public class scanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a single line assignment statement (e.g., int x = 1;):");

        if (scanner.hasNextLine()) {
            String input = scanner.nextLine();
            
            // Split the input by spaces
            String[] tokens = input.split(" ");
            
            if (tokens.length >= 3) {
                String type = tokens[0];
                String variableName = tokens[1];
                String value = tokens[3].replace(";", ""); // Remove the semicolon
                
                System.out.println("Type: " + type);
                System.out.println("Variable Name: " + variableName);
                System.out.println("Value: " + value);
            } else {
                System.out.println("Invalid input. Please provide a valid assignment statement.");
            }
        }

        scanner.close();
    }
}
