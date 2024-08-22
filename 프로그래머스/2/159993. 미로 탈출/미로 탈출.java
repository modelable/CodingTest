import java.util.*;

class Solution {
    
    private static boolean[][] visited;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};

    public static int solution(String[] maps) {
        int answer = 0;
        int row = maps.length;
        int col = maps[0].length();
        visited = new boolean[row][col];

        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (maps[i].charAt(j) == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        //레버를 당긴다
        answer += BFS(start[0], start[1], lever, maps);
        if (answer == -1) return -1;

        visited = new boolean[row][col];

        //출구로 이동한다
        int temp = answer;
        answer += BFS(lever[0], lever[1], end, maps);
        if (temp - answer == 1) return -1;

        return answer;
    }

    public static int BFS(int row, int col, int[] dest, String[] maps) {
        int n = maps.length;
        int m = maps[0].length();
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col, 0}); //행, 열, 이동거리

        visited[row][col] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == dest[0] && now[1] == dest[1]) {
                return now[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (!visited[nx][ny] && maps[nx].charAt(ny) != 'X') {
                        queue.add(new int[]{nx, ny, now[2] + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return -1;
    }
}