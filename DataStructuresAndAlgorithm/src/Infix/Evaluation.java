package Infix;
import java.util.Scanner;
import java.lang.Math;

public class Evaluation
{
    static int top =-1;
        static int A[] = new int[100]; 
       
        static String given = "";

        static void push(int pu)
        {       
            top++;
             A[top] = pu;
        }

        static int pop()
        {
            return A[top--];
        }
        
        static boolean isDigit(char x) 
        {
            return (x >= '0' && x <= '9');
        }
        
        static int op(int n1, int n2, char o) 
        {
            switch(o)
            {
                case '+': return n1 + n2;//3
                    
                case '-': return n1 - n2;

                case '*': return n1 * n2;

                case '/': return n1 / n2;

                case '^': return (int) (Math.pow(n2, n1));
            }
            return 1;    
        }

        static int op2(int n1, int n2, char p)
        {
            switch(p)
            {
                case '+': return n1 + n2;//3
                    
                case '-': return n1 - n2;

                case '*': return n1 * n2;

                case '/': return n1 / n2;

                case '^': return (int) (Math.pow(n1, n2));
            }
            return 1;
        }

        static int evaluatePost(char x[]) 
        {
            int n1, n2, n;
            
            for (int i = 0; i < given.length(); i++) 
            {
                if (isDigit(x[i]))
                {
                    push((int)x[i]-48);
                } 
                else
                {
                    n2 = pop();
                    n1 = pop();
                    n = op(n1, n2, x[i]);
                    push(n);

                    if (x[i] == '+') 
                    {
                        System.out.println(n1 + " + " + n2 + " = " + n);
                    } else if 
                        (x[i] == '-') 
                            System.out.println(n1 + " - " + n2 + " = " + n);
                        else if
                        (x[i] == '/') 
                            System.out.println(n1 + " / " + n2 + " = " + n);
                        else if
                        (x[i] == '*') 
                            System.out.println(n1 + " * " + n2 + " = " + n);
                        else if
                        (x[i] == '^') 
                            System.out.println(n1 + " ^ " + n2 + " = " + n);
                    
                }   
            }
            return pop();
        }

    
    public static void main(String[] args) 
    {
        Evaluation t = new Evaluation();
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.print("Enter Prefix or Postfix: ");
        given = sc.nextLine();
        // int counter = given.length();
        //char giveChar[] = given.length();
     
        //System.out.print("\nValue of the expression is: "+t.evaluate(b));

       
		{
			 
			System.out.println("\nMENU: ");
			System.out.println("1. Prefix\n"
			  		+ "2. Postfix\n"
			  		+ "3. Exit");
			System.out.print("Enter choice[1..3]: ");
			choice = sc.nextInt();
    
        switch (choice)
        {
            case 1: //prefix
            	char b[] = reverse(given).toCharArray();
                //evaluatePre(b);
                System.out.print("Value of expression: " + Evaluation.evaluatePre(b));
                break;

            case 2:    
                //evaluate(b);
            	char x[] = given.toCharArray();
                System.out.print("Value of expression: " + Evaluation.evaluatePost(x));
                break;

            case 3:
                System.exit(0);
        }
        }
    }

static String reverse(String preFix) 
    {
        int rev = 0;
        int countPrefix = preFix.length();
        char reverse[] = new char[countPrefix];
        
        System.out.print("Reverse infix string: ");
        for (int i = countPrefix-1; i > -1; i--) 
        {        
            reverse[rev] = preFix.charAt(i);
            System.out.print(reverse[rev]);
            rev++;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < countPrefix; i++) 
        {
            sb.append(reverse[i]);
        }
        String reversedString = sb.toString();
        System.out.println();
        return reversedString;
    }

static int evaluatePre(char b[]) 
    { 
        int n1, n2, n;
           
        for (int i = 0; i < given.length(); i++) 
        { 
            if (isDigit(b[i]))
            {
                push((int)b[i]-48); 
            } 
            else                
            {
                n1 = pop();
                n2 = pop();
                n = op2(n1, n2, b[i]); 
                push(n);      

                if (b[i] == '+') 
                {
                    System.out.println(n1+ " + " + n2 + " = " + n);
                } else if 
                    (b[i] == '-') 
                        System.out.println(n1 + " - " + n2 + " = " + n);
                    else if
                    (b[i] == '/') 
                        System.out.println(n1 + " / " + n2 + " = " + n);
                    else if
                    (b[i] == '*') 
                        System.out.println(n1 + " * " + n2 + " = " + n);
                    else if
                    (b[i] == '^') 
                        System.out.println(n1 + " ^ " + n2 + " = " + n);
            }
        }
       return pop();
    }
}
