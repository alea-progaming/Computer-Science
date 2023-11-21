package Final_Project;

import javax.swing.*;

public class Final_Project_App {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(800,400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton openFile = new JButton();
        openFile.setBounds(50, 50, 100, 30);
        frame.add(openFile);

        JTextField result = new JTextField();
        result.setBounds(200, 50, 500, 30);
        frame.add(result);

        JButton lexical = new JButton();
        lexical.setBounds(50, 120, 100, 30);
        frame.add(lexical);

        JTextArea code = new JTextArea();
        code.setBounds(200, 120, 500, 200);
        frame.add(code);

        JButton syntax = new JButton();
        syntax.setBounds(50, 190, 100, 30);
        frame.add(syntax);

        JButton clear = new JButton();
        clear.setBounds(50, 260, 100, 30);
        frame.add(clear);
    }
}
