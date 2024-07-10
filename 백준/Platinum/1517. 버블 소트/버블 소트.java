//package merge_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] A;
	static int[] tmp;
	static long counter = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		A = new int[N + 1];
		tmp = new int[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		merge_sort(1, N);
		
		System.out.println(counter);
	}

	private static void merge_sort(int s, int e) {
		if (e - s < 1)
			return; // 재귀함수 탈출, 집합의 크기가 1 이하
		int m = s + (e - s) / 2; // 중간점

		merge_sort(s, m);
		merge_sort(m + 1, e);

		for (int i = s; i <= e; i++) {
			tmp[i] = A[i];
		}

		int k = s;
		int index1 = s;
		int index2 = m + 1;

		while (index1 <= m && index2 <= e) {
			if (tmp[index1] > tmp[index2]) { // 우측 집합의 원소가 좌측에 끼어듦
				counter += index2 - k;
				A[k++] = tmp[index2++];
			} else { // 이미 정렬된 좌측 집합의 원소를 그대로 사용함
				A[k++] = tmp[index1++];
			}
		}

		while (index1 <= m) { // 남아 있는 값 정리
			A[k++] = tmp[index1++];
		}

		while (index2 <= e) {
			A[k++] = tmp[index2++];
		}
	}
}
