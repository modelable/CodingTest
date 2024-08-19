import java.util.*;

public class Main {

    private static ArrayList<Integer>[] adjList;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 컴퓨터의 수
        int M = sc.nextInt(); // 컴퓨터 쌍의 수

        adjList = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
                adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            adjList[x].add(y);
            adjList[y].add(x);
        }

        visited = new boolean[N + 1];
        dfs(1);

        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (visited[i]) answer++;
        }

        System.out.println(answer - 1);
    }

    public static void dfs(int node) {
        visited[node] = true;

        for (int next : adjList[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}