import java.util.*;

class Solution {
    public static int solution(int[][] maps) {
        return BFS(0, 0, maps);
    }

    public static int BFS(int x, int y, int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Queue<Node> queue = new ArrayDeque<>();

        queue.add(new Node(x, y, 1));
        visited[y][x] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.x == maps[0].length - 1 && node.y == maps.length - 1)
                return node.dist;

            //상
            if (node.y - 1 >= 0 && !visited[node.y - 1][node.x] && maps[node.y - 1][node.x] == 1) {
                queue.add(new Node(node.x, node.y - 1, node.dist + 1));
                visited[node.y - 1][node.x] = true;
            }
            //하
            if (node.y + 1 < maps.length && !visited[node.y + 1][node.x] && maps[node.y + 1][node.x] == 1) {
                queue.add(new Node(node.x, node.y + 1, node.dist + 1));
                visited[node.y + 1][node.x] = true;
            }
            //좌
            if (node.x - 1 >= 0 && !visited[node.y][node.x - 1] && maps[node.y][node.x - 1] == 1) {
                queue.add(new Node(node.x - 1, node.y, node.dist + 1));
                visited[node.y][node.x - 1] = true;
            }
            //우
            if (node.x + 1 < maps[0].length && !visited[node.y][node.x + 1] && maps[node.y][node.x + 1] == 1) {
                queue.add(new Node(node.x + 1, node.y, node.dist + 1));
                visited[node.y][node.x + 1] = true;
            }
        }

        return -1;
    }

    public static class Node {
        int x;
        int y;
        int dist;

        public Node(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}