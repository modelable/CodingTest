package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class G2_1167 {
    static ArrayList<Node>[] A;
    static boolean[] visited;
    static long[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken()); // 정점의 개수(입력)
        A = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        distance = new long[V + 1];

        for (int i = 1; i <= V; i++) {
            A[i] = new ArrayList<Node>();
        }

        for (int i = 1; i <= V; i++) {
            st = new StringTokenizer(br.readLine());
            int line = Integer.parseInt(st.nextToken());

            int vertex = Integer.parseInt(st.nextToken());
            while (vertex != -1) {
                long distance = Long.parseLong(st.nextToken());

                A[line].add(new Node(vertex, distance));
                vertex = Integer.parseInt(st.nextToken());
            }
        }

        DFS(1, 0);
        int maxIndex = 1;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] > distance[maxIndex]) {
                maxIndex = i;
            }
        }

        visited = new boolean[V + 1]; // 초기화
        DFS(maxIndex, 0);
        long answer = 0;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] > answer) {
                answer = distance[i];
            }
        }
        System.out.println(answer);
    }

    static void DFS(int vertex, long d) {
        visited[vertex] = true;

        for (Node n : A[vertex]) {
            int v = n.vertex; // 노드 번호

            if (visited[v] == false) {
                distance[v] = d + n.distance;
                DFS(v, distance[v]);
            }
        }
    }

    static class Node {
        int vertex;
        long distance;

        Node(int vertex, long distance) {
            this.vertex = vertex;
            this.distance = distance;
        }
    }
}

