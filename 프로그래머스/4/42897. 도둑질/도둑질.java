public class Solution {
    private static boolean check;

    public static void main(String[] args) {
    }

    public static int solution(int[] money) {
        check = false;
        int a = calc(0, money);
        int b = Integer.MIN_VALUE;
        if (check) b = calc(1, money);

        return Math.max(a, b);
    }

    public static int calc(int i, int[] money) {
        int N = money.length;
        int[] dp = new int[N]; //money
        boolean firstElementUsed1 = false;
        boolean firstElementUsed2 = false;

        dp[i] = money[i];
        firstElementUsed1 = true;
        
        if (money[i] > money[i + 1]) {
            dp[i + 1] = money[i];
            firstElementUsed2 = true;
        } else {
            dp[i + 1] = money[i + 1];
        }

        if (i == 1) {
            firstElementUsed1 = false;
            firstElementUsed2 = false;
        }

        for (i = i + 2; i < N - 1; i++) {
            if (dp[i - 2] + money[i] > dp[i - 1]) {
                dp[i] = dp[i - 2] + money[i];
                boolean temp = firstElementUsed1;
                firstElementUsed1 = firstElementUsed2;
                firstElementUsed2 = temp;
            } else {
                dp[i] = dp[i - 1];
            }
        }

        //마지막 원소
        if (firstElementUsed1) {
            int max = Math.max(Math.max(dp[i - 1], dp[i - 2]), dp[i - 2] - money[0] + money[i]);
            dp[i] = max;
            check = true;
        } else {
            if (dp[i - 2] + money[i] > dp[i - 1]) {
                dp[i] = dp[i - 2] + money[i];
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[i];
    }
}