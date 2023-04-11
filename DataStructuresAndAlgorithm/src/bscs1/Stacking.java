package bscs1;
import java.util.Scanner;

public class Stacking {
		public static void main(String[] args) {
			Scanner userIn = new Scanner(System.in);
			int elements, index = -1;
			int stack[];
			int c;
			
			System.out.print("How many elements will the stack have: ");
			elements = userIn.nextInt();
			System.out.println("Stack Created!");
			System.out.println();
			
			stack = new int[elements];
			
			//do while
			do {
			System.out.println("Menu"
					+ "\n1. PUSH\n2. POP\n3. TOP\n4. SIZE\n5. EMPTY\n6. DISPLAY STACK\n7. EXIT\n\n"
					+ "Choose options from above[1...7]: ");
			c = userIn.nextInt();

	switch (c) {
	case 1:
			//PUSH
			index++;
			if (index < elements) {
				System.out.print("Enter number to add to the stack: ");
				int num = userIn.nextInt();
				stack[index] = num;
				
				System.out.println(num + " succesfully pushed");
				System.out.println();
			} else if(index==elements){
				System.out.println("Stack Overflow");
				System.out.println();
			}
			break;
	case 2:
			//POP UPDATE: (April 11, 2023) Needs to fix POP function
			index--;
			
			if (index < 0) {
				System.out.println("Stack Empty");
			} else if (index == -1) {
				System.out.print(stack[index]);
				System.out.println();
			}
			break;
	case 3:
			//TOP
			System.out.println("Top of the stack is " + stack[index]);
			break;
	case 4:
			//SIZE
			 int[] len = new int[index+1];
		int inLength = len.length;
			System.out.println("Size of the stack: " + inLength);
			break;
	case 5:
			//EMPTY
			if (stack[0] == 0) {
				System.out.println("TRUE");
			} else {
				System.out.println("FALSE");
			}
			break;
	case 6:
			//DISPLAY STACK
			for(int i = 0; i < elements; i++) {
				System.out.print(stack[i] + " ");
			}
			System.out.println();
			break;
	}
			} while(c!=7);
			//EXIT
			System.out.println("PROGRAMMER'S NAME: PURUGGANAN,Mikaela_ASIS,Steven_CARABEO,Meldrick");
		}

	}
