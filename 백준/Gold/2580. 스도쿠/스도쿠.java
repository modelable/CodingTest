import java.util.Scanner;

public class Main {
    private static int[][] board = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        sudoku();
    }

    public static int[] findZero() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == 0) {
                    return new int[]{i, j};
                }
            }
        }

        return null;
    }

    public static boolean check(int row, int col, int n) {
        //가로줄
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == n)
                return false;
        }

        //세로줄
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == n)
                return false;
        }

        //정사각형
        int r = row - row % 3;
        int c = col - col % 3;
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == n)
                    return false;
            }
        }

        return true;
    }

    public static void printBoard() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void sudoku() {
        int[] point = findZero();

        if (point == null) {
            printBoard();
            System.exit(0);
        }

        int row = point[0], col = point[1];

        for (int i = 1; i <= 9; i++) {
            if (check(row, col, i)) {
                board[row][col] = i;
                sudoku();
                board[row][col] = 0;
            }
        }
    }
}