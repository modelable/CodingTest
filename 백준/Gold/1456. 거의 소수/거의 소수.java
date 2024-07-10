//package sieve_of_eratosthenes;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long A = sc.nextLong();
		long B = sc.nextLong();
		int sqrt_A = (int)Math.sqrt(A);
		int sqrt_B = (int)Math.sqrt(B);
		boolean[] arr = new boolean[sqrt_B + 1];
		int count = 0;

		arr[1] = true;
		for (int i = 1; i <= sqrt_B; i++) {
			if (arr[i] == false) {
				for (int j = 2; i * j <= sqrt_B; j++) {
					arr[i * j] = true;
				}
			}
		}

		for (int i = 2; i <= sqrt_B; i++) {
			if (arr[i] == false) {
				long num = (long)i * i;
				while (num <= B) {
					if (A <= num && num <= B) {
						count++;
					}
                    if (num <= B / i) {
						num *= i;
					} else
						break;
				}
			}
		}

		System.out.println(count);
	}
}
