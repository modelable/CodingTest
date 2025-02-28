import java.io.*;
import java.util.*;

public class Main {
    
	private static int n, m;
	private static boolean check;
	private static int[] dx = {0, 1, 0, -1}; //우, 하, 좌, 상
	private static int[] dy = {1, 0, -1, 0};
	private static char[][] graph;
	private static boolean[][] visited;
	
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	n = Integer.parseInt(st.nextToken());
    	m = Integer.parseInt(st.nextToken());
    	graph = new char[n][m];
    	visited = new boolean[n][m];
    	
    	for (int i = 0; i < n; i++) {
    		st = new StringTokenizer(br.readLine());
    		
    		for (int j = 0; j < m; j++) {
    			graph[i][j] = st.nextToken().charAt(0);
    		}
    	}
    	
    	int answer = 0;
    	int count = 0;
    	while (true) {
    		answer++;
    	
    		int temp = func(); 
    		
    		if (temp == 0) {
    			System.out.println(answer - 1);
    			System.out.println(count);
    			return;
    		} else {
    			count = temp;
    		}
    			
//    		// debugging
//    		System.out.println("debugging - answer: " + answer + ", temp: " + temp);
//    		for (int i = 0; i < n; i++) {
//        		for (int j = 0; j < m; j++) {
//        			System.out.print(graph[i][j] + " ");
//        		}
//        		System.out.println();
//    		}
//    		System.out.println();
    	}
    }

    public static int func() {
    	
    	int count = 0;
    	// 1. 마지막 라운드인지 판단
    	for (int i = 0; i < n; i++) {
    		
    		for (int j = 0; j < m; j++) {
    			if (graph[i][j] != '0')
   					count++;
    		}
    	}
    	
    	if (count == 0)
    		return 0;
    	
    	// 2. 공기에 닿는 부분을 'c'로 변경
    	bfs(0, 0);
    	
    	// 3. 'c'를 제거
    	for (int i = 0; i < n; i++) {
    		for (int j = 0; j < m; j++) {
    			if (graph[i][j] == 'c')
    				graph[i][j] = '0';
    		}
    	}
    	
    	return count;
    }

    public static void bfs(int a, int b) {
    	
    	Queue<int[]> queue = new LinkedList<>();
    	queue.add(new int[] {a, b});
    	visited = new boolean[n][m];
    	
    	while (!queue.isEmpty()) {
    		int[] temp = queue.poll();
    		a = temp[0];
    		b = temp[1];
    		
    		if (a >= 0 && b >= 0 && a < n && b < m) {
    			if (!visited[a][b]) {
    				visited[a][b] = true;
		    		
		    		if (graph[a][b] == '1') {
		    			graph[a][b] = 'c';
		    			continue;
		    		} else if (graph[a][b] == 'c')
		    			continue;
		    		else {
		    			
		    			for (int i = 0; i < 4; i++) {
		    				queue.add(new int[] {a + dx[i], b + dy[i]});
		    			}
		    		}
    			}
    		}
    	}
    }
}