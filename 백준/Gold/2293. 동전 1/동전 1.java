import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //동전의 종류
        int k = Integer.parseInt(st.nextToken()); //가치의 합
        int[] dp = new int[k + 1];
        dp[0] = 1;
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            list.add(coin);
        }
        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            //System.out.println("num = " + num);
            for (int j = 1; j <= k; j++) {
                if (j - num < 0) continue;
                dp[j] += dp[j - num];
            }
        }
//
//        for (int i : dp) {
//            System.out.print(i + " ");
//        }
//        System.out.println();

        System.out.println(dp[k]);
    }
}