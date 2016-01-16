import java.util.Scanner;

/**
 * @author Allabergen Suleimenov
 *         allromis@gmail.com
 *         allabergen.su@gmail.com
 * @version 1.0
 */
public class Game {
    private int row, col;
    private Scanner in = new Scanner(System.in);
    private char[][] board = new char[3][3];
    private char turn = 'X';

    public void playGame() {
        System.out.println("Welcome to TicTacToe Game\n\'X\' starts");

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }

        printBoard();
        play();
    }

    private void play() {
        boolean playing = true;
        while (playing) {
            row = enterNumber();
            col = enterNumber();
            board[row][col] = turn;

            if (gameOver(row, col)) {
                playing = false;
                System.out.println("Game Over! Player " + turn + " wins!");
            }

            printBoard();

            if (turn == 'X') {
                System.out.println("\"O\'s\" turn");
                turn = 'O';
            }
            else {
                System.out.println("\"X\'s\" turn");
                turn = 'X';
            }
        }
    }

    private void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) System.out.print(" | ");
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
        }
    }

    public void chooseOption() {
        int choice;

        do {
            showMenu();
            choice = enterNumber() + 1;

            switch (choice) {
                case 1:
                    playGame();
                case 0:
                    System.out.println("Bye bye!");
                    break;
            }
        } while (choice != 0);
    }

    private void showMenu() {
        System.out.print("\nEnter to choose: \n" +
                "1 - Play Again\n" +
                "0 - Exit\n");
    }

    private boolean gameOver(int rMove, int cMove) {
        // Check perpendicular
        if (board[0][cMove] == board[1][cMove] && board[0][cMove] == board[2][cMove])
            return true;
        if (board[rMove][0] == board[rMove][1] && board[rMove][0] == board[rMove][2])
            return true;

        // Check diagonal
        if (board[0][0] == board[1][1] && board[0][1] == board[2][2] && board[1][1] != '_')
            return true;
        if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[1][1] != '_')
            return true;

        return false;
    }

    private int enterNumber() {
        int num;
        do {
            try {
                do {
                    num = in.nextInt();
                    if (num >= 0 && num <= 3)
                        break;
                    System.out.println("Enter a Number between [1-3]!");
                    in.next();
                } while (true);
                break;
            } catch (Exception e) {
                System.out.println("Enter a Number between [1-3]!");
                in.next();
            }
        } while (true);

        return num - 1;
    }
}
