//package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		
		for (int i = 0; i < A.length; i++) {
			A[i] = sc.nextInt();
		}
		
		Arrays.sort(A);
		
		Stack<Integer> plus = new Stack<>();
		Queue<Integer> minus = new LinkedList<>();
		
		for (int i = 0; i < A.length; i++) {
			if (A[i] > 0) {
				plus.push(A[i]);
			} else {
				minus.add(A[i]);
			}
		}
		
		int answer = 0;
		
		while (!plus.isEmpty()) {
			int a = plus.pop();
			if (plus.isEmpty()) {
				answer += a;
				break;
			}
			int b = plus.pop();
			if (b == 1) {
				answer += a + b;
			} else {
				answer += a * b;
			}
		}
		
		while (!minus.isEmpty()) {
			int c = minus.poll();
			if (minus.isEmpty()) {
				answer += c;
				break;
			}
			int d = minus.poll();
			
			answer += c * d;
		}
		
		System.out.println(answer);
	}
}
