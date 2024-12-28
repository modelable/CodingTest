import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int R = scanner.nextInt();
        int[][] matrix = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        int size = Math.min(N, M) / 2;

        for (int r = 0; r < R; r++) {
            int i, j;
            int[][] newMatrix = new int[N][M];

            for (int n = 0; n < size; n++) {
                //1
                j = n;
                for (i = n; i < N - 1 - n; i++) {
                    newMatrix[i + 1][j] = matrix[i][j];
                }

                //2
                i = N - 1 - n;
                for (j = n; j < M - 1 - n; j++) {
                    newMatrix[i][j + 1] = matrix[i][j];
                }

                //3
                j = M - 1 - n;
                for (i = N - 1 - n; i > n; i--) {
                    newMatrix[i - 1][j] = matrix[i][j];
                }

                //4
                i = n;
                for (j = M - 1 - n; j > n; j--) {
                    newMatrix[i][j - 1] = matrix[i][j];
                }
            }

            for (i = 0; i < N; i++) {
                for (j = 0; j < M; j++) {
                    matrix[i][j] = newMatrix[i][j];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}