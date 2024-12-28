import java.util.*;

public class Main {
    private static int findX, findY;
    private static int[] dx = {0, 1, 0, -1}; //상, 우, 하, 좌
    private static int[] dy = {-1, 0, 1, 0}; //상, 우, 하, 좌

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int find = scanner.nextInt();

        int[][] array = snail(N, find);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println(findY + " " + findX);
    }

    public static int[][] snail(int N, int find) {
        int[][] array = new int[N][N];
        int move = 0;
        int num = 1;
        int x = N/2;
        int y = N/2;

        array[x][y] = num;
        if (find == 1) {
            findX = x + 1;
            findY = y + 1;
        }
        
        while (num < N * N) {
            for (int i = 0; i < 4; i++) {
                if (i == 0 || i == 2) move++;

                for (int j = 0; j < move; j++) {
                    x += dx[i];
                    y += dy[i];
                    array[y][x] = ++num;

                    if (num == find) {
                        findX = x + 1;
                        findY = y + 1;
                    }
                    if (num == N * N) return array;
                }
            }
        }

        return null;
    }
}