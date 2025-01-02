public class Solution {

    public static int solution(int[] money) {
        int a = calc(0, money);
        int b = calc(1, money);

        return Math.max(a, b);
    }

    public static int calc(int n, int[] money) {
        int N = money.length;
        int[] dp = new int[N]; //money

        dp[n] = money[n];

        if (money[n] > money[n + 1]) dp[n + 1] = money[n];
        else dp[n + 1] = money[n + 1];

        for (int i = n + 2; i < N - 1 + n; i++) {
            dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
        }

        return dp[N - 2 + n];
    }
}