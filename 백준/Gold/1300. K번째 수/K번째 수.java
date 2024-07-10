import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        long start = 1, end = K;
        long ans = 0;
        
        while (start <= end) {
            long median = (start + end) / 2;
            long count = 0;
            
            for (int i = 1; i <= N; i++) {
                count += Math.min(median / i, N);
            }
            
            if (count < K) {
                start = median + 1;
            } else {
                ans = median;
                end = median - 1;
            }
        }
        
        System.out.println(ans);
    }
}