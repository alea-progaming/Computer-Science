package Final_Project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class semanticAnalysis {
    private String code;

    public semanticAnalysis(String code) {
        this.code = code;
    }

    public boolean semantic() {
        // Define a regular expression for variable declaration
        String regex = "\"(String|int|double|char)\\s+\\w+\\s*=\\s*\\w+\\s*;";


        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a Matcher object
        Matcher matcher = pattern.matcher(code);

        // Check if any part of the code matches the pattern
        while (matcher.find()) {
            // At least one valid variable declaration found
            return true;
        }

        // No valid variable declaration found
        return false;
    }
}
