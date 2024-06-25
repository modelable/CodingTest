package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

public class G5_13023 {
    static ArrayList<Integer>[] A;
    static int answer = 0;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 사람의 수
        int M = Integer.parseInt(st.nextToken()); // 친구 관계의 수
        A = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < A.length; i++) {
            A[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            A[a].add(b);
            A[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];

            if (!A[i].isEmpty()) {
                visited[i] = true;
                DFS(i, 1);
            }

            if (answer == 1)
                break;
        }

        System.out.println(answer);
    }

    static void DFS(int i, int chon) {
        if (chon == 5 || answer == 1) {
            answer = 1;
            return;
        }

        Iterator<Integer> e = A[i].iterator();
        int n;
        while (e.hasNext()) {
            n = e.next();
            if (visited[n] == false) {
                visited[n] = true;
                DFS(n, chon + 1);
                visited[n] = false; // 복구
            }
        }
    }
}

