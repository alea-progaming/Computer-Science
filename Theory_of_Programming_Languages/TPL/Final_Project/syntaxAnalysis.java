package Final_Project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class syntaxAnalysis {
    public static boolean syntaxAnalysis(String lexicalResult) {
        if (lexicalResult.contains("<error>")) {
            return false;
        }

        String syntaxRegex = "<data_type> <identifier> <assignment_operator> <value> <delimiter>";
        Pattern pattern = Pattern.compile(syntaxRegex);

        Matcher matcher = pattern.matcher(lexicalResult);

        return matcher.find();
    }
}