import java.util.*;

public class Solution {

    private static boolean[] visited;
    private static ArrayList<Integer>[] adjList;
    private static int answer, N;
    
    public int solution(int n, int[][] wires) {
        answer = n;
        N = n;
        
        visited = new boolean[n + 1];

        adjList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            adjList[wire[0]].add(wire[1]);
            adjList[wire[1]].add(wire[0]);
        }

        DFS(1);
        
        return answer;
    }

    public static int DFS(int node) {
        visited[node] = true;

        int sum = 0;

        for (int next : adjList[node]) {
            if (!visited[next]) {
                int count = DFS(next);
                if (answer > Math.abs(N - count * 2))
                    answer = Math.abs(N - count * 2);
                sum += count;
            }
        }
        
        return sum + 1;
    }
}
