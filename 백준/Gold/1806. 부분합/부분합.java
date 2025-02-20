import java.io.*;
import java.util.*;

public class Main {
	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int sum = 0;
        
        int[] array = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
        	array[i] = Integer.parseInt(st.nextToken());
        	sum += array[i];
        }
        
        if (sum < S) {
        	System.out.println("0");
        	return;
        }
        
        int s = 0, e = N - 1;
        
        while (sum >= S) {
        	sum -= array[e];
        	e--;
        }
        
        e++;
        sum += array[e];
        int answer = e - s + 1;
        
        while (s < N - 1) {
        	//System.out.println("s = " + s + ", e = " + e);
        	sum -= array[s];
        	s++;
        	
        	while (sum < S && e < N - 1) {
        		e++;
        		sum += array[e];
        	}
        	
        	if (sum >= S && e - s + 1 < answer)
        		answer = e - s + 1;
        }
        
        System.out.println(answer);
    }

}