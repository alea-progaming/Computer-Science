package tictactoeUserVsAI;
import java.util.Random;
import java.util.Scanner;

public class BSCS1_Purugganan {

	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		char[][] board = {{' ', ' ', ' '},
						  {' ', ' ', ' '},
						  {' ', ' ', ' '}};
		printBoard(board);
		
		while(true) {
			playerTurn(board, user);
			if (isGameFinished(board)) {
				break;
			}
			printBoard(board);
			
			aiTurn(board);
			if(isGameFinished(board)) {
				break;
			}
			printBoard(board);
		}
		user.close();
	}
	
	private static boolean isGameFinished(char[][] board) {
		if(hasContestantWon(board, 'X')) {
			printBoard(board);
			System.out.println("Player wins!");
			return true;
		}
		if(hasContestantWon(board, 'O')) {
			System.out.println("Computer wins");
			return true;
		}
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board[i].length; j++) {
				if(board[i][j] == ' ') {
					return false;
				}
			}
		}
		printBoard(board);
		System.out.println("It's a draw!");
		return true;
	}
	
	private static boolean hasContestantWon(char[][]board, char symbol) {
		if	   ((board[0][0] == symbol && board[0][1] == symbol && board[0][2] ==symbol) ||
				(board[1][0] == symbol && board[1][1] == symbol && board[1][2] ==symbol) ||
				(board[2][0] == symbol && board[2][1] == symbol && board[2][2] ==symbol) ||
				(board[0][0] == symbol && board[1][0] == symbol && board[2][0] ==symbol) ||
				(board[0][1] == symbol && board[1][1] == symbol && board[2][1] ==symbol) ||
				(board[0][2] == symbol && board[1][2] == symbol && board[2][2] ==symbol) ||
				(board[0][0] == symbol && board[1][1] == symbol && board[2][2] ==symbol) ||
				(board[0][2] == symbol && board[1][1] == symbol && board[2][0] ==symbol)) {
				return true;
		}
		return false;
	}
	
	private static void aiTurn(char[][]  board) {
		Random ran = new Random();
		int compMove;
		while(true) {
			compMove = ran.nextInt(9) + 1;
			if(isValidMove(board, Integer.toString(compMove))) {
				break;
			}
		}
		System.out.println("Computer chose " + compMove);
		placeMove(board, Integer.toString(compMove), 'O');
	}
	
	private static boolean isValidMove(char[][] board, String position) {
		switch(position) {
		case "1":
				return (board[0][0] == ' ');
		case "2":
				return (board[0][1] == ' ');
		case "3":
				return (board[0][2] == ' ');
		case "4":
				return (board[1][0] == ' ');
		case "5":
				return (board[1][1] == ' ');
		case "6":
				return (board[1][2] == ' ');
		case "7":
				return (board[2][0] == ' ');
		case "8":
				return (board[2][1] == ' ');
		case "9":
				return (board[2][2] == ' ');
		default:
			return false;
		}
	}
	
	private static void playerTurn(char[][] board, Scanner user) {
		String userIn;
		while(true) {
			System.out.println("Choose your place (1-9)");
			userIn = user.nextLine();
			if (isValidMove(board, userIn)) {
				break;
			} else {
				System.out.println(userIn + " is not a valid move");
			}
		}
		placeMove(board, userIn, 'X');
	}
	
	private static void placeMove(char[][] board, String position, char symbol) {
		switch(position) {
		case "1":
				board[0][0] = symbol;
				break;
		case "2":
				board[0][1] = symbol;
				break;
		case "3":
				board[0][2] = symbol;
				break;
		case "4":
				board[1][0] = symbol;
				break;
		case "5":
				board[1][1] = symbol;
				break;
		case "6":
				board[1][2] = symbol;
				break;
		case "7":
				board[2][0] = symbol;
				break;
		case "8":
				board[2][1] = symbol;
				break;
		case "9":
				board[2][2] = symbol;
				break;
		default:
				System.out.println(":(");
		}
	}
	
	private static void printBoard(char[][] board) {
		System.out.println(board[0][0] + "|" + board[0][1] + "|" + board[0][2]);
		System.out.println("-+-+-");
		System.out.println(board[1][0] + "|" + board[1][1] + "|" + board[1][2]);
		System.out.println("-+-+-");
		System.out.println(board[2][0] + "|" + board[2][1] + "|" + board[2][2]);
	}
}
