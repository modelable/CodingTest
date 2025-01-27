import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int C = scanner.nextInt();
        int N = scanner.nextInt();
        int[] array = new int[101];

        for (int i = 0; i < N; i++) {
            int cost = scanner.nextInt();
            int user = scanner.nextInt();
            if (array[user] != 0)
                array[user] = Math.min(array[user], cost);
            else array[user] = cost;
        }

        int[] dp = new int[C + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 1; i <= C; i++) {
            for (int j = 0; j < 101; j++) {
                if (array[j] == 0)
                    continue;
                else {
                    if (i - j < 0) dp[i] = Math.min(dp[i], array[j]);
                    else dp[i] = Math.min(dp[i], dp[i - j] + array[j]);
                }
            }
        }

        System.out.println(dp[C]);
    }
}