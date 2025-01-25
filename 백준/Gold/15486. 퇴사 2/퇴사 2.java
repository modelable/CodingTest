import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int start;
        int end;
        int pay;

        Node(int start, int end, int pay) {
            this.start = start;
            this.end = end;
            this.pay = pay;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.end - o2.end);

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            pq.add(new Node(i, i + T - 1, P));
        }

        int[] dp = new int[N + 1];

        Node pop = pq.poll();
        for (int i = 1; i <= N; i++) {
            if (pop.end != i) dp[i] = dp[i - 1];
            if (pop.end > N) {
                System.out.println(dp[i - 1]);
                return;
            }
            while (pop.end == i) {
                dp[i] = Math.max(dp[i], dp[pop.start - 1] + pop.pay);
                if (!pq.isEmpty())
                    pop = pq.poll();
                else break;
            }
            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[N]);
    }
}