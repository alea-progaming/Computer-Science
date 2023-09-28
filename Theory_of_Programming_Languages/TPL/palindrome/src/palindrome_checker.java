import java.util.Scanner;

public class palindrome_checker {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Boolean wantToContinue = true;

        while (wantToContinue) {
            System.out.print("Enter word/phrase: "); // madam - We panic in a pew.
                String s = sc.nextLine();
                String str = s.replaceAll("[^a-zA-Z0-9]","").toLowerCase();
                
                int i = 0, j = str.length() - 1;

                    while (i<str.length() & j>=0) {
                        if(i > j) {
                            System.out.println(s + " is a palindrome.\n");
                            break;
                        } else if(str.charAt(i)==str.charAt(j)) {
                            i++;
                            j--;
                        } else{
                            System.out.println(s + " is NOT a palindrome.\n");
                            break;
                        }
                    }
                System.out.print("Do you want to continue? [Y/N]: ");
                char answer = sc.nextLine().charAt(0);
                    if (answer == 'y') {
                        wantToContinue = true;
                    } else {
                        System.out.println("Program is terminated.");
                        System.exit(0);
                    }
            }
                
            
        }
    }
