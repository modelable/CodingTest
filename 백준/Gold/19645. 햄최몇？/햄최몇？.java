import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        int sum = 0;
        
        for (int i = 0; i < N; i++){
            array[i] = Integer.parseInt(st.nextToken());
            sum += array[i];
        }

        boolean[][] dp = new boolean[sum + 1][sum + 1];
        dp[0][0] = true;
        
        for (int i = 0; i < N; i++){
        	for (int a = sum; a >= 0; a--) { //관우
                for (int b = sum - a; b >= 0; b--) { //철환
                	if (a - array[i] >= 0)
                		dp[a][b] = dp[a - array[i]][b] || dp[a][b];
                	if (b - array[i] >= 0)
                		dp[a][b] = dp[a][b - array[i]] || dp[a][b];
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= sum; i++) { //관우
            for (int j = 0; j <= i; j++) { //철환
                int temp = sum - i - j;
                
                if (temp > i || temp > j) continue;
                if (!dp[i][j]) continue;
                
                answer = Math.max(answer, temp);
            }
        }

        System.out.println(answer);
    }

}