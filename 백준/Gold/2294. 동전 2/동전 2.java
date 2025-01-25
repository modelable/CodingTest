import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        HashSet<Integer> set = new HashSet<>();
        int[] dp = new int[k + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 100001;
        }

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num <= k) dp[num] = 1;
            set.add(num);
        }

        for (int i = 1; i <= k; i++) {
            if (dp[i] == 1) continue;
            else {
                for (int j = i / 2; j < i; j++) {
                    if (dp[i - j] == 1) {
                        if (dp[i] > dp[j] + 1)
                            dp[i] = dp[j] + 1;
                    }
                }
            }
        }

        if (dp[k] == 100001) System.out.println("-1");
        else System.out.println(dp[k]);
    }
}