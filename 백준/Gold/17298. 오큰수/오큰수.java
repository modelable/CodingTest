//package stack_and_queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] NGE = new int[N];
		Stack<Node> s = new Stack<>();
		st = new StringTokenizer(br.readLine());
		s.push(new Node(0, Integer.parseInt(st.nextToken())));
		
		for (int i = 1; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			while (!s.isEmpty() && num > s.peek().value)
				NGE[s.pop().index] = num;
			
			s.push(new Node(i, num));
		}

		for (int x : NGE) {
			if (x == 0)
				x = -1;
			bw.write(x + " ");
		}
		
		bw.flush();
		bw.close();

	}

	public static class Node {
		int index;
		int value;

		public Node(int index, int value) {
			// TODO Auto-generated constructor stub
			this.index = index;
			this.value = value;
		}
	}
}
