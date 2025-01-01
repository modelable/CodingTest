import java.util.*;

public class Main {
    private static int N;
    private static int[] dp;

    public static void main(String[] args) {
        N = new Scanner(System.in).nextInt();
        dp = new int[N + 1];
        dp[0] = 1;
        dp[1] = 1;
        tile(N);
        System.out.println(dp[N]);
    }

    public static int tile(int i) {
        if (dp[i] != 0) return dp[i];
        if (i == 1) return 1;
        else if (i == 0) return 0;
        else return dp[i] = (tile(i - 1) + tile(i - 2)) % 10007;
    }
}