//package depth_first_search;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if (N == 1) {
			System.out.println(2);
			System.out.println(3);
			System.out.println(5);
			System.out.println(7);
		} else {
			DFS(N, 1, 2);
			DFS(N, 1, 3);
			DFS(N, 1, 5);
			DFS(N, 1, 7);
		}
	}

	static void DFS(int N, int jarisu, int num) {
		jarisu++;

		if (jarisu > N) {
			return;
		}

		int[] numArr = new int[4];

		numArr[0] = num * 10 + 1;
		numArr[1] = num * 10 + 3;
		numArr[2] = num * 10 + 7;
		numArr[3] = num * 10 + 9;

		for (int i = 0; i < numArr.length; i++) {
			if (isPrime(numArr[i])) {
				DFS(N, jarisu, numArr[i]);
				if (jarisu == N) {
					System.out.println(numArr[i]);
				}
			}
		}
	}

	static boolean isPrime(int num) {
		for (int i = 2; i <= (num / 2); i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}
