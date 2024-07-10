//package sieve_of_eratosthenes;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean[] arr = new boolean[2000000];
		
		arr[1] = true;
		for (int i = 1; i <= Math.sqrt(arr.length); i++) {
			if (arr[i] == false) {
				for (int j = i + i; j < arr.length; j += i) {
					arr[j] = true;
				}
			}
		}

		for (int i = N; i < arr.length; i++) {
			if (arr[i] == false) { // 소수 
				if (isPalindrome(i)) {
					System.out.println(i);
					break;
				}
			}
		}
	}
	
	static boolean isPalindrome(int n) {
		String str = Integer.toString(n);
		
		for (int i = 0; i < str.length() / 2; i++) {
			if (str.charAt(i) != str.charAt(str.length() - i - 1)) 
				return false;
		}
		
		return true;
	}
}
