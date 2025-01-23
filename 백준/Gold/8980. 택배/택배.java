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
		Collections.sort(list, (o1, o2) -> {
			if (o1.end == o2.end)
				return o1.start - o2.start;
			return o1.end - o2.end;
		}); 
		
		int answer = 0;
		int[] truck = new int[N + 1]; //구간별 박스 무게 
		
		for (int i = 0; i < list.size(); i++) { //O(M) (10,000)
			Node box = list.get(i);

			//박스의 최대 적재량 구하기
			for (int j = box.start; j < box.end; j++) { //O(N) (2,000)
				if (truck[j] + box.count > C) { //용량 부족
					if (C - truck[j] < box.count) //무게를 더 줄여야 하는 경우
						box.count = C - truck[j];
				}
			}
			
			//truck[] 배열에 저장
			for (int j = box.start; j < box.end; j++) { //O(N) (2,000)
				truck[j] += box.count;
			}
			
			//System.out.println(box.start + " " + box.end + " " + box.count);
			answer += box.count;
		}
		
		System.out.println(answer);
	}
}
