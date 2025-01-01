class Solution {
    private static long[] dp;

    public int solution(int n) {
        dp = new long[n];
        dp[0] = 1;
        dp[1] = 1;
        
        fibo(n - 1);
        return (int) (dp[n - 1] % (long)1234567);
    }

    public static long fibo(int n) {
        if (dp[n] != 0) return dp[n];
        return dp[n] = (fibo(n - 1) + fibo(n - 2)) % 1234567;
    }
}