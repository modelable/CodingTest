import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
                if (arr[i][j] == 1)
                    max = 1;
            }
        }

        int[][] dp = new int[n][m];

        for (int i = 0; i < n; i++) {
            dp[i][0] = arr[i][0];
        }

        for (int i = 0; i < m; i++) {
            dp[0][i] = arr[0][i];
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (arr[i][j] == 1) {
                    int min = Integer.MAX_VALUE;
                    min = Math.min(min, dp[i - 1][j - 1]);
                    min = Math.min(min, dp[i - 1][j]);
                    min = Math.min(min, dp[i][j - 1]);

                    dp[i][j] = min + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max * max);
    }
}