//package sieve_of_eratosthenes;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long min = sc.nextLong();
		long max = sc.nextLong();
		int sqrt_max = (int) Math.sqrt(max);
		boolean[] A = new boolean[sqrt_max + 1];
		boolean[] B = new boolean[(int) (max - min) + 2];

		for (int i = 2; i < A.length; i++) {
			if (A[i] == false) {
				long num;

				if (min % ((long)i * i) == 0) {
					num = min / ((long) i * i);
				} else {
					num = min / ((long) i * i) + 1;
				}
				
				if (num <= max / (long) i * i) {
					long l = (long) i * i * num;

					while (l <= max) {
						//System.out.println("i = " + i + " num = " + num + " long l = " + l);
						int index = (int) (l - min) + 1;
						B[index] = true;
						if (l > max - (long) i * i)
							break;
						l += i * i;
					}
				}
			}
		}
		int count = 0;
		for (int i = 1; i < B.length; i++) {
			if (B[i] == false) {
				count++;
			}
		}
		System.out.println(count);
	}

}