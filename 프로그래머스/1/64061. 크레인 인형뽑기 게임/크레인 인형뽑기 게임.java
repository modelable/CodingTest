import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int N = board.length;
        int answer = 0;
        Stack<Integer> stack = new Stack<>(); // 바구니

        for (int i = 0; i < moves.length; i++) {
            int row = 0;
            int col = moves[i] - 1;

            for (; row < N - 1; row++) {
                if (board[row][col] != 0) break;
            }

            if (board[row][col] == 0) {
                continue;
            }

            if (!stack.isEmpty() && stack.peek() == board[row][col]) {
                stack.pop();
                answer += 2;
            } else {
                stack.push(board[row][col]);
            }

            board[row][col] = 0;
        }

        return answer;
    }
}