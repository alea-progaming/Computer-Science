package Final_Project;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class semanticAnalysis {
    public static boolean performSemanticAnalysis(String lexicalResult) {
        // Add your semantic analysis logic here using the extracted tokens
        // For example, you can use extractToken method to get specific tokens
        String dataType = extractToken(lexicalResult, "<data_type>");
        String identifier = extractToken(lexicalResult, "<identifier>");
        String assignmentOperator = extractToken(lexicalResult, "<assignment_operator>");
        String value = extractToken(lexicalResult, "<value>");

        // Check if the assigned value has the correct data type
        return isValueCompatibleWithDataType(value, dataType);
    }

    // Helper method to extract a token from the lexical result
    private static String extractToken(String lexicalResult, String token) {
        String regex = token.replace("<", "\\<").replace(">", "\\>") + "\\s*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(lexicalResult);

        if (matcher.find()) {
            return matcher.group().trim();
        }

        return null; // Token not found
    }

    // Updated semantic analysis logic for type checking
    private static boolean isValueCompatibleWithDataType(String value, String dataType) {
        return "<String>".equals(dataType) && value.matches("\"[^\"]*\"") ? true : false;
    }
}
