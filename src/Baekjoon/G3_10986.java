package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G3_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] A = new long[N]; // 1 2 3 1 2
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }

        long[] S = new long[N]; // 1 3 6 7 9
        S[0] = A[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i - 1] + A[i];
        }

        // S[] = {1, 0, 0, 1, 0}
        long[] remainder = new long[M];
        for (int i = 0; i < N; i++) {
            S[i] %= M;
            remainder[(int) S[i]]++;
        }

        long answer = 0;
        for (int i = 0; i < N; i++) {
            if (S[i] == 0)
                answer++;
        }
        for (int i = 0; i < M; i++) {
            answer += remainder[i] * (remainder[i] - 1) / 2;
        }

        System.out.println(answer);
    }
}
