import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		
		while (T-- > 0) {
			int N = scanner.nextInt();
			int[] parents = new int[N + 1];
			
			for (int i = 0; i < N - 1; i++) {
				int A = scanner.nextInt();
				int B = scanner.nextInt();
				parents[B] = A;
			}
			
			int n1 = scanner.nextInt();
			int n2 = scanner.nextInt();
			
			HashSet<Integer> set = new HashSet<>();
			while (n1 != 0) {
				set.add(n1);
				n1 = parents[n1];
			}
			
			while (!set.contains(n2)) {
				n2 = parents[n2];
			}
			
			System.out.println(n2);
		}
	}
	
}
