import java.util.Random;
import java.util.Scanner;

public class Tic_Tac_Toe {
	public static void main(String[] args) {

		char[][] gameBoard = {
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '},
				{'-', '+', '-', '+', '-'},
				{' ', '|', ' ', '|', ' '}
				};
		
		
		printGameBoard(gameBoard);
		
		
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter your placement (1-9)");
			int playerPosition = scanner.nextInt();

			
			placePiece(gameBoard,playerPosition,"player");
			
			Random random  = new Random();
			int cpuPosition = random.nextInt(9) + 1;
			
			
			placePiece(gameBoard, cpuPosition, "cpu");
			printGameBoard(gameBoard);
		}
		
		
	}
	
	public static void printGameBoard(char[][] gameBoard) {
		for (char[] row : gameBoard) {
			for (char c : row) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
		public static void placePiece(char[][] gameBoard, int position, String user) {
			char symbol = ' ';
			if (user.equals("player")) {
				symbol = 'X';
			}else if (user.equals("cpu")) {
				symbol = 'O';
			}
			
			
			
			switch (position) {
			case 1:
				gameBoard[0][0] = symbol;
				break;
			case 2:
				gameBoard[0][2] = symbol;
				break;
			case 3:
				gameBoard[0][4] = symbol;
				break;
			case 4:
				gameBoard[2][0] = symbol;
				break;
			case 5:
				gameBoard[2][2] = symbol;
				break;
			case 6:
				gameBoard[2][4] = symbol;
				break;
			case 7:
				gameBoard[4][0] = 'X';
				break;
			case 8:
				gameBoard[4][2] = symbol;
				break;
			case 9:
				gameBoard[4][4] = symbol;
				break;
			default:
				break;
			}
			
			//System.out.println(position);
			//printGameBoard(gameBoard);
		}
}


























