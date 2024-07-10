import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] A = new long[N];

		for (int i = 0; i < N; i++) {
			A[i] = sc.nextLong();
		}

		int start_index, end_index;
		int answer = 0;
		long sum = 0;
		Arrays.sort(A);
		
		for (int i = 0; i < N; i++) {
			start_index = 0;
			end_index = N - 1;
			
			while (start_index != end_index) {
				if (start_index == i) { // 자기 자신은 연산에서 제외
					start_index++;
					continue;
				} else if (end_index == i) {
					end_index--;
					continue;
				}
				sum = A[start_index] + A[end_index];
				
				if (sum == A[i]) {
					answer++;
					break;
				} else if (sum > A[i]) {
					end_index--; 
				} else {
					start_index++; 
				}	
			}
		}
		
		System.out.println(answer);
	}
}