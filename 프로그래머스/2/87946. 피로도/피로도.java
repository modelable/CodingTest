public class Solution {

    private static boolean[] visited;
    private static int answer, N;

    public static void main(String[] args) {
        int k = 80;
        int[][] dungeons = {{80,20}, {50,40}, {30,10}};
        System.out.println(solution(k, dungeons));
    }

    public static int solution(int k, int[][] dungeons) {
        answer = -1;
        N = dungeons.length;
        visited = new boolean[N];

        //현재 피로도,
        backtracking(dungeons, k, 0);

        return answer;
    }

    public static int availableDungeons(int[][] dungeons, int piro) {
        int sum = 0;

        for (int i = 0; i < N; i++) {
            if (!visited[i] && dungeons[i][0] < piro) sum++;
        }

        return sum;
    }

    public static void backtracking(int[][] dungeons, int piro, int numOfDungeons) {
        if (answer < numOfDungeons)
            answer = numOfDungeons;

        for (int i = 0; i < N; i++) {
            if (!visited[i] && dungeons[i][0] <= piro) {
                if (numOfDungeons + availableDungeons(dungeons, piro) >= answer) {
                    visited[i] = true;
                    backtracking(dungeons, piro - dungeons[i][1], numOfDungeons + 1);
                    visited[i] = false;
                }
            }
        }
    }
}