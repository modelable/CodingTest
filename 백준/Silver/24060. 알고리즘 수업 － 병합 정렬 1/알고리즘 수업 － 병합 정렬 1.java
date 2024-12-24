import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    private static int count = 0;
    private static int K, answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); //배열 A의 크기
        K = scanner.nextInt(); //저장 횟수
        answer = -1;
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        merge_sort(A, 0, N - 1);
        System.out.println(answer);
    }

    public static void merge_sort(int[] A, int p, int r) {
        if (answer != -1) return;
        if (p < r) {
            int q = (p + r) / 2;
            merge_sort(A, p, q);        //전반부 정렬
            merge_sort(A, q + 1, r); //후반부 정렬
            merge(A, p, q, r);          //병합
        }
    }

    public static void merge(int[] A, int p, int q, int r) {
        int i = p, j = q + 1, t = 0;
        int[] B = new int[r - p + 1];

        while (i <= q && j <= r) {
            if (A[i] <= A[j]) B[t++] = A[i++];
            else B[t++] = A[j++];

            count++;
            if (count == K) {
                answer = B[t - 1];
                return;
            }
        }

        while (i <= q) {
            B[t++] = A[i++];

            count++;
            if (count == K) {
                answer = B[t - 1];
                return;
            }
        }
        while (j <= r) {
            B[t++] = A[j++];

            count++;
            if (count == K) {
                answer = B[t - 1];
                return;
            }
        }

        i = p;
        t = 0;
        while (i <= r) {
            A[i++] = B[t++];
        }
    }
}