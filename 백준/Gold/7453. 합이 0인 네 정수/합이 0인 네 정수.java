import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];
        
        StringTokenizer st;
        for (int i = 0; i < n; i++) { //O(4,000)
        	st = new StringTokenizer(br.readLine());
        	A[i] = Integer.parseInt(st.nextToken());
        	B[i] = Integer.parseInt(st.nextToken());
        	C[i] = Integer.parseInt(st.nextToken());
        	D[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] sumAB = new int[n * n];
        int[] sumCD = new int[n * n];
//        HashMap<Integer, Integer> sumAB = new HashMap<>();
//        HashMap<Integer, Integer> sumCD = new HashMap<>();
        int x = 0;
        for (int i = 0; i < n; i++) { //O(4,000)
        	
        	for (int j = 0; j < n; j++) { //O(16,000,000)
        		sumAB[x] = A[i] + B[j];
        		sumCD[x++] = C[i] + D[j];
        		
//        		int AB = A[i] + B[j];
//        		int CD = C[i] + D[j];
        		
//        		sumAB.put(AB, sumAB.getOrDefault(AB, 0) + 1);
//        		sumCD.put(CD, sumCD.getOrDefault(CD, 0) + 1);
        	}
        }
        
        Arrays.sort(sumAB);
        Arrays.sort(sumCD);
        
        long answer = 0;
        int s = 0, e = n * n - 1;
        
        while (s < n * n && e >= 0) {
        	int sum = sumAB[s] + sumCD[e];
        	
			if (sum < 0) s++;
			else if (sum > 0) e--;
			else {
				int countS = 1, countE = 1;
				
				while (s < n * n - 1 && sumAB[s] == sumAB[s + 1]) {
					countS++;
					s++;
				}
				
				while (e > 0 && sumCD[e] == sumCD[e - 1]) {
					countE++;
					e--;
				}
				answer += (long)countS * countE;
				s++;
			}
		}
//        for (Integer i : sumAB.keySet()) { //O(16,000,000)
//        	if (sumCD.containsKey(i * -1)) {
//        		answer += sumAB.get(i) * sumCD.get(i * -1);
//        	}
//        }
        
        System.out.println(answer);
    }

}