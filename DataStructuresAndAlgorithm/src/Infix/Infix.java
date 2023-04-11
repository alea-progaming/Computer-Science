package Infix;
import java.util.Scanner;

public class Infix {
	 static char d[]=new char[100];
	 static int top=-1;
	 //push 
	 static void push (char p) 
	 {
	  top++;
	  d[top]= p;
	 }
	 //pop
	 static char pop()
	 {
	  return d[top--];
	 }
	 //parenthesis
	 static char findClosing(char c)
		{
			if (c == '(')
				return ')';
			return c;
		}
	 
	public static void main(String[] args) {
		 Scanner input = new Scanner (System.in);
		  String infix = "";
		  int choice = 0;
		  
		 
			  System.out.print("Enter infix: ");
			  infix = input.next();
			  
			  int count = infix.length();
			  char counter[] = new char[count];
			  boolean confirmVerification = true;
			 
			  //print this for result
			//isParenthesisBalanced(count, isBalance);
			verifyInfix(count, confirmVerification, counter, infix);
			 
				  while(choice != 3) {
			 
			  System.out.println("\nMENU: ");
			  System.out.println("1. Prefix\n"
			  		+ "2. Postfix\n"
			  		+ "3. Exit");
			  System.out.print("Enter choice[1..3]: ");
			  choice = input.nextInt();
			  
	switch (choice) {
		case 1: // Prefix
			 toPrefix(count, counter, infix);
			 System.out.println();
			 break;
		case 2: // Postfix
			toPostfix(infix);
			System.out.println();
			break;
		case 3:
		System.exit(0);
		break;
		
	default:
        System.out.println();
		System.out.println("--NOT VALID--");
		System.out.println();
		
		 }
			 }
		 
	}
	
	static boolean verifyInfix(int verCount, boolean confirmVerif, char verChar[], String infix) {

		for (int i = 0; i < verCount; i++) {
				verChar[i] = infix.charAt(i);
			System.out.print(verChar[i]);
		}
		System.out.println();
		
		for (int i = 0; i < verCount; i++) {
			if (verChar[i] == '=') {
				System.out.println("\nInvalid infix notation \nThe program has been terminated.");
				System.exit(0);
			}
	}
	System.out.println();
		
		
		for (int i = 0; i < verCount; i++) { //Scan every character
			if(i%2==0 ) { //results will be 0 and 1 until there are no more characters left
				if (verChar[0] == ')') {
					System.out.println("Invalid infix notation \nThe program has been terminated.");
					System.exit(0);
				}
				else if (verChar[i] >= 'a' && verChar[i] <= 'z' || verChar[i] >= 'A' && verChar[i] <= 'Z' || verChar[i] != '=' || verChar[i] == '(' || verChar[i] == ')') { //valid operand
					int open=0, close=0;
					//boolean ifConfirm = confirmVerif;
					
					for (int j = 0; j < verCount; j++) {
						if (verChar[j]=='(' && verChar[j]!='=')
						   {
						    open++;
						    
						   }
						   else if (verChar[j]==')' && verChar[j]!='=')
						   {
						    close++;
						    
						   }
					}
					 if (open!=close)
					  {   
					   //   ifConfirm = false;
							System.out.print("Invalid infix notation \nThe program has been terminated.");
							System.exit(0);
					   
					  }
					 return false;
				}
				 else {//invalid operand
					confirmVerif = false;
					System.out.print("Invalid infix notation \nThe program has been terminated.");
					System.exit(0);
					break;
				}
			} else {
				if (verChar[i] == 42 || verChar[i] == 43 || verChar[i] == 45 || verChar[i] == 47 || verChar[i] == 94 || verChar[i] != '=' || verChar[i] == '(' || verChar[i] == ')') { //valid operator
				} else { //invalid operand
					confirmVerif = false;
					System.out.print("Invalid infix notation \nThe program has been terminated.");
					System.exit(0);
					break;
				}
				
			} 
			if (confirmVerif != false) {
				System.out.println("This is a valid infix notation");
			}
		
		}
		
		return false;
	    
		
	}
		
		static void toPrefix(int finCount, char fin[], String finString) {
			 //reverse
			 char reverse[] = new char[finCount];
			 int rev = 0;
			 System.out.println();
			 System.out.print("Reverse infix string: ");
			 for (int i = finCount-1; i > -1; i--) {		
					reverse[rev] = finString.charAt(i);
					System.out.print(reverse[rev]);
					rev++;
				}
			 StringBuffer sb = new StringBuffer();
			 for (int i = 0; i < finCount; i++) { //1st: index 0
				 sb.append(reverse[i]);
				 }
			 String reversedString = sb.toString(); //reversedString will be used to perform the prefix stacking :> ewan
		      System.out.println();
		      
		   
		      char s; //symbol
			  String prefix = "";

			  for(int i=0;i<reversedString.length();++i)
			   //while there is input to be read
			  {
			   s = reversedString.charAt(i);
			   //if it's an operand, add it to the string
			   if (Character.isLetter(s))
			    prefix += s; // "a"
			   else if (s==')') push(s); // push
			   else if (s=='(') 
			    //push everything back to (
			   
			   {
			    char x = pop();
			    while (x!=')') {
			     prefix+=x;
			     x=pop();
			    }
			   }
			   else if (precedence(s)>0)
			   {
			     if (top==-1 || d[top]=='(') push(s);
			     else {
			       while (top!=-1 && precedence(s)<precedence(d[top]))
			      prefix+=pop();
			       push(s);
			      }
			   }
			  }  while (top!=-1) prefix+=pop();
			  
			  String finPrefix = prefix;
			  System.out.print("Prefix String: " + finPrefix);
			  int cc = finPrefix.length();
			  char rr[] = new char[cc];
			  int dd = 0;
			  System.out.print("\nReversed Prefix String: ");
			  for (int i = cc-1; i > -1; i--) {		
					rr[dd] = finPrefix.charAt(i);
					System.out.print(rr[dd]);
					dd++;
				}
			   
		}
		
		
			
		public static void toPostfix(String infix) //a+b-c
		 //converts an infix expression to postfix
		 {
		  char s; //symbol
		  String postfix = "";

		  for(int i=0;i<infix.length();++i) //i = {a, +, b, -, c}
		   //while there is input to be read
		  {
		   s = infix.charAt(i); //
		   //if it's an operand, add it to the string
		   if (Character.isLetter(s)) //
		    postfix += s;
		   else if (s=='(') push(s); // push
		   else if (s==')') 
		    //push everything back to (
		   
		   {
		    char x = pop();
		    while (x!='(') {
		     postfix+=x;
		     x=pop();
		    }
		   }
		   else if (precedence(s)>0)
		   {
		     if (top==-1 || d[top]=='(') push(s);
		     else {
		       while (top!=-1 && precedence(s)<=precedence(d[top]))
		       postfix+=pop();
		       push(s);
		      }
		   }
		  }  while (top!=-1) postfix+=pop();
		   System.out.println("\nPostfix: " + postfix);
		 }
		
		 public static int precedence (char s) {
		  switch (s)
		  {
		  case '+': return 1; //a=1. b=2 == 1+2=3. infix
		  case '-': return 1;
		  case '*': return 2;
		  case '/': return 2;
		  case '^': return 3;
		//  case '(': return 0;
		// case ')': return 0;
		  }
		  return -1;
		 

		 
	}

}
