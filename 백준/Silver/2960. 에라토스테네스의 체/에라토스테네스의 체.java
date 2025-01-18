import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		boolean[] array = new boolean[N + 1];
		int K = scanner.nextInt();
		int count = 0;
		while (count < K) {
			int P = 0;
			
			for (int i = 2; i <= N; i++) {
				if (array[i] == false) {
					count++;

					if (count == K) {
						System.out.println(i);
						return;
					}	
					array[i] = true;
					P = i;
					break;
				}
			}
			
			for (int i = 2; P * i <= N; i++) {
				if (array[P * i] == false) {
					array[P * i] = true;
					count++;
				
					if (count == K) {
						System.out.println(P * i);
						return;
					}
				}
			}
		}
	}
	
}
