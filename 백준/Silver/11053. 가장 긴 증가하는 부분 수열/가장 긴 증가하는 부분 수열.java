import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
            dp[i] = 1;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[j] < A[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}