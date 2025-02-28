import java.io.*;
import java.util.*;

public class Main {
    
	private static int[][] graph, array;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        graph = new int[n][m];
        visited = new boolean[n][m];
        array = new int[n][m];
        
        int a = -1, b = -1;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                
                if (graph[i][j] == 2) {
                    a = i;
                    b = j;
                }
                
                if (graph[i][j] == 0) visited[i][j] = true;
            }
        }
        
        bfs(a, b);

        for (int i = 0; i < n; i++) {
        	
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    array[i][j] = -1;
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int x, int y) {
    	
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        
        visited[x][y] = true;

        int n = graph.length;
        int m = graph[0].length;
        
        while (!queue.isEmpty()) {
            int temp[] = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int a = temp[0] + dx[i];
                int b = temp[1] + dy[i];
                
                if (a >= 0 && a < n && b >= 0 && b < m) {
                    if (!visited[a][b] && graph[a][b] == 1) {
                        visited[a][b] = true;
                        array[a][b] = array[temp[0]][temp[1]] + 1;
                        queue.add(new int[]{a, b});
                    }
                }
            }
        }
    }
}