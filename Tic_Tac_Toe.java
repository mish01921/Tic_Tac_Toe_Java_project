import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tic_Tac_Toe {

	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		while (true) { // Առաջին հիմնական ցիկլը
			char[][] gameBoard = {
					{' ', '|', ' ', '|', ' '},
					{'-', '+', '-', '+', '-'},
					{' ', '|', ' ', '|', ' '},
					{'-', '+', '-', '+', '-'},
					{' ', '|', ' ', '|', ' '}
			};

			playerPositions.clear();
			cpuPositions.clear();

			printGameBoard(gameBoard);

			while (true) {
				System.out.println("Enter your placement (1-9):");
				int playerPosition = scanner.nextInt();
				while (playerPositions.contains(playerPosition) || cpuPositions.contains(playerPosition)) {
					System.out.println("Position taken! Enter a correct Position");
					playerPosition = scanner.nextInt();
				}

				placePiece(gameBoard, playerPosition, "player");
				String result = checkWinner();
				if (result.length() > 0) {
					System.out.println(result);
					break;
				}

				Random random = new Random();
				int cpuPosition = random.nextInt(9) + 1;

				while (playerPositions.contains(cpuPosition) || cpuPositions.contains(cpuPosition)) {
					cpuPosition = random.nextInt(9) + 1;
				}

				placePiece(gameBoard, cpuPosition, "cpu");
				printGameBoard(gameBoard);

				result = checkWinner();
				if (result.length() > 0) {
					System.out.println(result);
					break;
				}
			}

			// Հարցում օգտատիրոջը՝ արդյոք ցանկանում է խաղալ կրկին
			System.out.println("Do you want to play again? (x/n)");
			char response = scanner.next().charAt(0);
			if (response == 'n' || response == 'N') {
				System.out.println("Thanks for playing!");
				break; // Կրկին չխաղալու դեպքում դուրս է գալիս հիմնական ցիկլից
			}
		}

		scanner.close(); // Ապահով փակել սկաները
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
			playerPositions.add(position);
		} else if (user.equals("cpu")) {
			symbol = 'O';
			cpuPositions.add(position);
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
				gameBoard[4][0] = symbol;
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
	}

	public static String checkWinner() {
		List<Integer> topRow = Arrays.asList(1, 2, 3);
		List<Integer> midRow = Arrays.asList(4, 5, 6);
		List<Integer> botRow = Arrays.asList(7, 8, 9);
		List<Integer> leftCol = Arrays.asList(1, 4, 7);
		List<Integer> midCol = Arrays.asList(2, 5, 8);
		List<Integer> rightCol = Arrays.asList(3, 6, 9);
		List<Integer> cross1 = Arrays.asList(1, 5, 9);
		List<Integer> cross2 = Arrays.asList(7, 5, 3);

		List<List<Integer>> winning = new ArrayList<List<Integer>>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(leftCol);
		winning.add(midCol);
		winning.add(rightCol);
		winning.add(cross1);
		winning.add(cross2);

		for (List<Integer> l : winning) {
			if (playerPositions.containsAll(l)) {
				return "Congratulations, you won!";
			} else if (cpuPositions.containsAll(l)) {
				return "CPU wins! You lose :(";
			} else if (playerPositions.size() + cpuPositions.size() == 9) {
				return "CAT!";
			}
		}

		return "";
	}
}
