//package euler_phi;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		long n = new Scanner(System.in).nextLong();
		long answer = n;
		boolean[] p = new boolean[(int) Math.sqrt(n) + 1];

		p[1] = true;
		for (int i = 2; i <= Math.sqrt(p.length); i++) {
			if (p[i] == false) {
				for (int j = 2; i * j < p.length; j++) {
					p[i * j] = true;
				}
			}
		}

		// 자기 자신이 소수이면 답은 n - 1
		int check;
		for (check = 1; check < p.length; check++) {
			if (p[check] == false) {
				if (n % check == 0) { // 소수가 아님
					break;
				}
			}
		}

		if (n != 1 && check == p.length) {
			System.out.println(n - 1);
			return;
		}
		
		for (long i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				boolean iIsPrime = true;

				for (int j = 1; j < i; j++) {
					if (p[j] == false) {
						if (i % j == 0) { // 소수가 아님
							iIsPrime = false;
							break;
						}
					}
				}
				if (iIsPrime == true) {
					answer -= answer / i;
				}

				long num = n / i; // 몫
				for (int j = 1; j < p.length; j++) {
					if (p[j] == false) {
						if (num % j == 0) { // 소수가 아님
							break;
						}
					}
					if (j + 1 == p.length) { // 소수임
						answer -= answer / num;
					}
				}
			}
		}

		System.out.println(answer);
	}
}