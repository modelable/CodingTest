import java.io.*;
import java.util.*;

public class Main {
    
	private static ArrayList<int[]> list;
    private static int[] dx = {0, 1, 1, 0, -1, -1, -1, 0, 1}; //제자리, 동, 동남, 남, 남서, 서, 북서, 북, 동북
    private static int[] dy = {0, 0, 1, 1, 1, 0, -1, -1, -1};
    private static boolean answer;
    
    public static void main(String[] args) throws Exception {
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    	
    	list = new ArrayList<>();
    	
        for (int i = 0; i < 8; i++) {
        	String str = br.readLine();
        			
        	for (int j = 0; j < 8; j++) {
        		if (str.charAt(j) == '#') {
        			list.add(new int[] {i, j});
        		}
        	}
        }
        
        dfs(7, 0, 0);
        
        if (answer) System.out.println(1);
        else System.out.println(0);
    }

    public static void dfs(int a, int b, int round) {
    	
    	if (answer || a < 0 || b < 0 || a >= 8 || b >= 8)
    		return;
    	
    	//System.out.println("a = " + a + ", b = " + b + ", round = " + round);
    	if (round == 8) {
    		answer = true;
    		return;
    	}
    	
    	
    	for (int i = 0; i < 9; i++) {
    		boolean check = false;
    		
    		for (int[] point : list) {
        		if (point[0] + round == a + dx[i] && point[1] == b + dy[i])
        			check = true;
        		if (point[0] + round + 1 == a + dx[i] && point[1] == b + dy[i])
        			check = true;
        	}
    		if (!check)
    			dfs(a + dx[i], b + dy[i], round + 1);
    	}
    }
}