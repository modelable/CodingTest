import java.io.*;
import java.util.*;

public class Main {
	static int[] parent;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int G = Integer.parseInt(br.readLine());
		int P = Integer.parseInt(br.readLine());

		parent = new int[G + 1];
		for (int i = 1; i <= G; i++) {
			parent[i] = i;
		}

		int answer = 0;
        
		for (int i = 0; i < P; i++) {
			int g = Integer.parseInt(br.readLine());
			int gate = find(g);

			if (gate == 0) break;
			
			answer++;
			union(gate, gate - 1);
		}

		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
    
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
}