import java.util.*;

class Solution {

    public static int solution(int N, int[][] road, int K) {
        
        //인접 리스트 초기화
        ArrayList<Node>[] adjList = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < road.length; i++) {
            int u = road[i][0];
            int v = road[i][1];
            int w = road[i][2];

            adjList[u].add(new Node(v, w));
            adjList[v].add(new Node(u, w));
        }

        //방문 배열
        boolean[] visited = new boolean[N + 1];
        
        //최소 거리
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
            
        //우선순위 큐
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.cost - o2.cost);
        pq.add(new Node(1, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            if (visited[node.dest]) continue;
            visited[node.dest] = true;

            for (Node next : adjList[node.dest]) {
                if (node.cost + next.cost < dist[next.dest]) {
                    dist[next.dest] = node.cost + next.cost;
                    pq.add(new Node(next.dest, dist[next.dest]));
                }
            }
        }
        
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K)
                answer++;
        }

        return answer;
    }

    public static class Node {
        private int dest;
        private int cost;

        public Node(int dest, int cost) {
            this.dest = dest;
            this.cost = cost;
        }
    }
}