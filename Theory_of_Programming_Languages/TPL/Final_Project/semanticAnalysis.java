package Final_Project;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class semanticAnalysis {
    private String code;

    public semanticAnalysis(String code) {
        this.code = code;
    }

    public boolean semantic() {
        String regex = "(String|int|double|char)\\s+\\w+\\s*=\\s*\"?\\w+\"?\\s*;";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(code);

        while (matcher.find()) {
            return true;
        }

        return false;
    }
}