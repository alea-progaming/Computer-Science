package string_occurences;

import java.util.Scanner;

public class lab002 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Boolean cont = true;
        

        while(cont) {
                System.out.print("Enter sentence: ");
            String sentence = sc.nextLine().toLowerCase();
            System.out.print("Enter letter: ");
            char letter = sc.nextLine().toLowerCase().charAt(0);
            
            int occur = 0, i = 0;

            while(i < sentence.length()) {
                    if (sentence.charAt(i) == letter) {
                        occur += 1;
                        i++;
                    } else {
                        i++;
                    }

                    if (i == sentence.length() && occur == 0) {
                        System.out.println("No occurences.\n");
                    } else if (i == sentence.length() && occur > 0){
                        System.out.println("The letter '" + letter + "' occured " + occur + " time/s.\n");
                    }
            }
            System.out.print("Do you want to continue? [Y/N]: ");
                char answer = sc.nextLine().charAt(0);
                    if (answer == 'y') {
                        cont = true;
                    } else {
                        System.out.println("Program is terminated.");
                        System.exit(0);
                    }
        }
        

        
        
        }
    }
