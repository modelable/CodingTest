import java.util.*;
import java.io.*;

public class Main {
	
	private static int[] inorder;
	private static int[] postorder;
	private static BufferedWriter bw;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		inorder = new int[n];
		postorder = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		preorder(0, n - 1, 0, n - 1, n);
		bw.flush();
	}
	
	public static void preorder(int in_s, int in_e, int post_s, int post_e, int n) throws IOException {
		if (in_s < 0 || post_s < 0 || in_e >= n || post_e >= n || post_s > post_e)
			return;
		
		bw.write(postorder[post_e] + " ");
		
		if (post_s == post_e)
			return;
		
		int index = -1;
		for (int i = 0; i < n; i++) {
			if (inorder[i] == postorder[post_e])
				index = i; 
		}
		
		int gap = index - in_s - 1;
		
		preorder(in_s, index - 1, post_s, post_s + gap, n);
		preorder(index + 1, in_e, post_s + gap + 1, post_e - 1, n);
	}

}
