import java.util.*;

class Solution {
    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    public static int solution(int n, int[][] computers) {
        adjList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjList[i] = new ArrayList<>();
        }
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computers[i][j] == 1 && i != j) {
                    adjList[i].add(j);
                    adjList[j].add(i);
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == false) {
                answer++;
                DFS(i);
            }
        }

        return answer;
    }

    public static void DFS(int n) {
        visited[n] = true;

        for (int i : adjList[n]) {
            if (!visited[i]) {
                DFS(i);
            }
        }
    }
}