import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] array = new int[N];
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			array[i] = Integer.parseInt(st.nextToken());
			sum += array[i];
		}
		
		if (N == 3) {
			System.out.println(Math.max(Math.max(array[0], array[1]), array[2]) * 2);
			return;
		}
		
		sum -= array[0];
		
		int beeA = sum - array[1];
		int beeB = sum - array[1];
		int max = beeA + beeB;
		
		for (int i = 2; i < N; i++) {
			beeA = beeA + array[i - 1] - array[i];
			beeB -= array[i];
			max = Math.max(max, beeA + beeB);
		}
		
		sum += array[0];
		sum -= array[N - 1];
		
		beeA = sum - array[N - 2];
		beeB = sum - array[N - 2];
		max = Math.max(max, beeA + beeB);
		
		for (int i = N - 3; i >= 0; i--) {
			beeA = beeA + array[i + 1] - array[i];
			beeB -= array[i];
			max = Math.max(max, beeA + beeB);
		}
		
		System.out.println(max);
	}
}
