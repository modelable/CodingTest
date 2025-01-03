import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    public static void main(String[] args) {
        String[] strs = {"app","ap","p","l","e","ple","pp"};
        int answer = solution(strs, "apple");
        System.out.println(answer);
    }

    public static int solution(String[] strs, String t) {
        int N = t.length();

        HashSet<String> set = new HashSet<>();
        int[] dp = new int[N + 1];

        for (int i = 0; i < strs.length; i++) {
            set.add(strs[i]);
        }

        dp[0] = 0;
//        if (set.contains(t.substring(0, 1))) dp[0] = 1;
//        else dp[0] = 0;

        for (int i = 1; i <= N; i++) {
            int min = 100000;

            for (int j = 5; j >= 0; j--) {
                if (i - j >= 0) {

                    if (set.contains(t.substring(i - j, i))) {
                        min = Math.min(min, dp[i - j] + 1);
                    }
                }
            }
            dp[i] = min;
            //System.out.println("dp[" + i + "] = " + dp[i]);
        }
        if (dp[N] == 100000) return -1;
        else return dp[N];
    }
}