public class Solution {

    private static int answer = 0, N;

    public int solution(int n) {
        N = n;
        backtrack(0, new boolean[N][N]);

        return answer;
    }

    public static void backtrack(int row, boolean[][] board) {
        if (row == N) {
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            // 유망 함수
            if (!board[row][i]) {
                boolean[][] newBoard = new boolean[N][N];

                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < N; k++) {
                        newBoard[j][k] = board[j][k];
                    }
                }

                place(row, i, newBoard);

                backtrack(row + 1, newBoard);
            }
        }
    }

    public static void place(int row, int col, boolean[][] board) {
        //하
        for (int i = row; i < N; i++) {
            board[i][col] = true;
        }

        //좌우
        for (int i = 0; i < N; i++) {
            board[row][i] = true;
        }

        //대각선
        for (int i = 1; i < N - row; i++) {
            if (col + i < N) board[row + i][col + i] = true;
            if (col - i >= 0) board[row + i][col - i] = true;
        }
    }
}
