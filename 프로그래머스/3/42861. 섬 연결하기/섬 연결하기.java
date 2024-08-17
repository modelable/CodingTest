import java.util.*;

public class Solution {

    private static int[] parent;

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]); //경로 압축
        return parent[x];
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        parent[rootX] = rootY;
    }

    public static int solution(int n, int[][] costs) {
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        int answer = 0;

        Arrays.sort(costs, ((o1, o2) -> o1[2] - o2[2]));

        union(costs[0][0], costs[0][1]);
        answer += costs[0][2];

        union(costs[1][0], costs[1][1]);
        answer += costs[1][2];

        for (int i = 2; i < costs.length; i++) {
            //cycle이 발생하는 경우
            if (find(costs[i][0]) == find(costs[i][1])) {
                continue;
            } else {
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }

        return answer;
    }
}