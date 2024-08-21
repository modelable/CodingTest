import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt(); //정점의 개수
        int E = sc.nextInt(); //간선의 개수
        int K = sc.nextInt(); //시작 정점의 번호

        ArrayList<Node>[] adjList = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adjList[u].add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(K, 0));
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[K] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.cost > dist[node.dest]) continue;

            for (Node next : adjList[node.dest]) {
                if (dist[next.dest] > node.cost + next.cost) {
                    dist[next.dest] = node.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dist[i]);
        }
    }

    public static class Node {
        int dest, cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}
