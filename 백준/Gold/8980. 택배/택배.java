import java.util.*;
import java.io.*;

public class Main {
	
	public static class Node {
		private int start;
		private int end;
		private int count;
		
		Node(int start, int end, int count) {
			this.start = start;
			this.end = end;
			this.count = count;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // N
		int C = Integer.parseInt(st.nextToken()); // C
		int M = Integer.parseInt(br.readLine());
		
		ArrayList<Node> list = new ArrayList<>(); // M
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());
			list.add(new Node(start, end, count));
		}

		//간격이 짧은 순으로 정렬
		Collections.sort(list, (o1, o2) -> (o1.end - o1.start) - (o2.end - o2.start));
		
		int answer = 0;
		int[] truck = new int[N + 1]; //구간별 박스 무게 
		
		for (int i = 0; i < list.size(); i++) {
			Node box = list.get(i);

			//박스의 최대 적재량 구하기
			for (int j = box.start; j < box.end; j++) {
				
				if (truck[j] + box.count > C)
					box.count = C - truck[j];
			}
			
			//truck[] 배열에 저장
			for (int j = box.start; j < box.end; j++) {
				truck[j] += box.count;
			}
			
			//System.out.println(box.start + " " + box.end + " " + box.count);
			answer += box.count;
		}
		
		System.out.println(answer);
	}
}
