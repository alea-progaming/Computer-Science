package TPL;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800, 400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton openFile = new JButton("Open File");
        openFile.setBounds(50, 50, 150, 30);
        frame.add(openFile);

        JButton lexical = new JButton("Lexical Analysis");
        lexical.setBounds(50, 100, 150, 30);
        frame.add(lexical);

        JButton syntax = new JButton("Syntax Analysis");
        syntax.setBounds(50, 150, 150, 30);
        frame.add(syntax);

        JButton semantic = new JButton("Semantic Analysis");
        semantic.setBounds(50, 200, 150, 30);
        frame.add(semantic);

        JButton clear = new JButton("Clear");
        clear.setBounds(50, 250, 150, 30);
        frame.add(clear);

        JTextField result = new JTextField("Result: ");
        result.setBounds(250, 50, 500, 30);
        frame.add(result);

        JTextArea code = new JTextArea();
        code.setBounds(250, 120, 500, 200);
        frame.add(code);

        lexical.setEnabled(false);
        syntax.setEnabled(false);
        semantic.setEnabled(false);


        // action listeners
        openFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser fileChooser = new JFileChooser();
                int file = fileChooser.showOpenDialog(null);
                if (file == JFileChooser.APPROVE_OPTION) {
                    try (BufferedReader reader = new BufferedReader(new FileReader(fileChooser.getSelectedFile()))) {
                        StringBuilder content = new StringBuilder();
                        String line;
                        while ((line = reader.readLine()) != null) {
                            content.append(line).append("\n");
                            lexical.setEnabled(true);
                        }
                        code.setText(content.toString());
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });

        lexical.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codeText = code.getText();
                String lexicalResult = lexicalAnalysis(codeText);

                if (lexicalResult.contains("<error>")) {
                    result.setText("Lexical analysis failed. Unexpected token. ");

                } else {
                    result.setText(lexicalResult);
                    syntax.setEnabled(true);
                }
            }
        });

        syntax.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codeText = code.getText();
                String lexicalResult = lexicalAnalysis(codeText);

                if (syntaxAnalysis(lexicalResult)) {
                    result.setText("Syntax analysis passed.");
                    semantic.setEnabled(true);

                } else {
                    result.setText("Syntax analysis failed. Invalid syntax.");
                    //pop up

                }
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lexical.setEnabled(false);
                syntax.setEnabled(false);
                semantic.setEnabled(false);
                result.setText("");
                code.setText("");

            }
        });

        semantic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codeText = code.getText();
                //syntax.setEnabled(false);

            }
        });
    }




    private static String lexicalAnalysis(String code) {
        String dataTypeRegex = "\\b(int|double|char|String)\\b";
        String assignmentOperatorRegex = "=";
        String delimiterRegex = ";";
        String valueRegex = "\\b(\\d+|\"[^\"]*\"|'[^']*')\\b";
        String identifierRegex = "\\b[a-zA-Z_]\\w*\\b";

        // Combine the regular expressions into a single pattern
        String combinedRegex = String.format("(%s)|(%s)|(%s)|(%s)|(%s)", dataTypeRegex, assignmentOperatorRegex,
                delimiterRegex, valueRegex, identifierRegex);
        Pattern pattern = Pattern.compile(combinedRegex);

        // Use a StringBuilder to store the result
        StringBuilder result = new StringBuilder();

        // Use a Matcher to find matches in the input code
        Matcher matcher = pattern.matcher(code);
        int lastMatchEnd = 0; // Track the end of the last match
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();

            // Check for any text between the last match and the current match
            String unmatchedText = code.substring(lastMatchEnd, start).trim();
            if (!unmatchedText.isEmpty()) {
                // If there is text between matches, mark it as an error
                result.append("<error> ");
            }

            String match = matcher.group();

            // Categorize the token based on the matched pattern
            if (match.matches(dataTypeRegex)) {
                result.append("<data_type> ");
            } else if (match.equals("=")) {
                result.append("<assignment_operator> ");
            } else if (match.equals(";")) {
                result.append("<delimiter> ");
            } else if (match.matches(valueRegex)) {
                result.append("<value> ");
            } else if (match.matches(identifierRegex)) {
                result.append("<identifier> ");
            }

            lastMatchEnd = end; // Update the last match end position
        }

        // Check for any text after the last match
        String remainingText = code.substring(lastMatchEnd).trim();
        if (!remainingText.isEmpty()) {
            // If there is text after the last match, mark it as an error
            result.append("<error> ");
        }

        return result.toString().trim();
    }

    private static boolean syntaxAnalysis(String lexicalResult) {
        // Check if lexical analysis passed
        if (lexicalResult.contains("<error>")) {

            return false; // If lexical analysis failed, syntax analysis is not applicable
        }

        // Define a simple syntax rule based on the expected lexical result
        String syntaxRegex = "<data_type> <identifier> <assignment_operator> <value> <delimiter>";
        Pattern pattern = Pattern.compile(syntaxRegex);

        // Use a Matcher to find matches in the input code
        Matcher matcher = pattern.matcher(lexicalResult);

        // Check if there is at least one match
        return matcher.find();
    }


}





