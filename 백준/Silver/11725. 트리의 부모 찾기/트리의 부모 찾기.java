import java.util.*;

public class Main {

    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;
    private static int[] answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //노드의 개수

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
                adjList[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            adjList[u].add(v);
            adjList[v].add(u);
        }

        visited = new boolean[N + 1];
        answer = new int[N + 1];

        bfs(1);

        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    public static void bfs(int node) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(node);
        visited[node] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : adjList[now]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;

                    answer[next] = now;
                }

            }
        }
    }
}