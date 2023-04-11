package queue;
import java.util.Scanner;

public class CircularQueue {
	static Scanner sc = new Scanner(System.in);
	static int q[], size, front=-1,rear=-1;
	static {
		CircularQueue.qSize();
	}

	public static void main(String[] args) {
		
		int ch, endq;
		while (true) {
		System.out.println("\nMENU\n"+ "1. Enqueue\n" + "2. Dequeue\n" + "3. Display Queue\n" + "4. Exit");
		System.out.print("Enter choice[1..4]: ");
		ch = CircularQueue.sc.nextInt();

		switch (ch) {
		// ENQUEUE
		case 1: 
				System.out.print("\nEnter number to add to queue: ");
				endq = sc.nextInt();
				CircularQueue.enq(endq);
				break;
		// DEQUEUE
		case 2:
				endq = CircularQueue.deq();
				if (endq == 0) 
					System.out.println("Queue is empty");
					break;
				
		// DISPLAY QUEUE
		case 3:
				CircularQueue.disQueue();
				break;
		// EXIT
		case 4:
				System.out.println("[TERMINATED] Purugganan, Mikaela");
				System.exit(0);
				break;
		default:
				System.out.println("Invalid option");
		}
	}
}
	
	static void qSize() {
		System.out.print("Enter size of the Queue: ");
		size = CircularQueue.sc.nextInt();
		CircularQueue.q = new int[size];
	}
	
	static void enq(int dt) {
		if (CircularQueue.isFull()) {
			System.out.println("Overflow!");
		} else {
			if (front == -1) {
				front = 0;
			}
			rear = (rear + 1 ) % size;
			q[rear] = dt;
			System.out.println("Queue: " + dt + "\nFront: " + front + "\nRear: " + rear);
			}
	}
	
	static int deq() {
		int dt;
		if (isEmpty()) {
			System.out.println("EMPTY!");
			return (-1);
		} else {
			dt = q[front];
			if (front == rear) {
				front = -1;
				rear = -1;
			} else {
				front = (front + 1) % size;
			}
			System.out.print("Queue: ");
			
				for (int i = front; i <= rear; i++) 
					System.out.print(q[i] + " - ");
					System.out.println("\nFront: " + front + "\nRear: " + rear);
				
			return (dt);
		}
	}
	
	static boolean isEmpty() {
		if (front == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	static boolean isFull() {
		if (front == 0 && rear == size - 1) {
			return true;
		}
		if (front == rear + 1) {
			return true;
		} else
			return false;
	}
	
	static void disQueue() {
		if (isEmpty()) {
			System.out.println("Queue empty");
		} else {
			System.out.print("Queue: ");
			for (int i = front; i <= rear; i++) 
				System.out.print(q[i] + "  ");
				System.out.println("\nFront: " + front + "\nRear: " + rear);
			
		}
	}
}
