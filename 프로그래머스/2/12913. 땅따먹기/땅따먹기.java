import java.util.*;

class Solution {
    int solution(int[][] land) {
        
        int N = land.length;
        int[][] dp = new int[N][4];
        dp[0][0] = land[0][0]; dp[0][1] = land[0][1];
        dp[0][2] = land[0][2]; dp[0][3] = land[0][3];
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = Math.max(Math.max(dp[i - 1][(j + 1) % 4], dp[i - 1][(j + 2) % 4]), dp[i - 1][(j + 3) % 4]) + land[i][j];
            }
        }
        
        return Arrays.stream(dp[N - 1]).max().getAsInt();
    }
}