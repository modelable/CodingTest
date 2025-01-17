import java.util.*;
import java.io.*;

public class Main {
	
	public static class Node {
		int value;
		ArrayList<Node> children;
		double water;
		
		Node(int value) {
			this.value = value;
			children = new ArrayList<>();
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); //노드의 수
		int W = Integer.parseInt(st.nextToken()); //1번 노드에 고인 물의 양
	
		HashMap<Integer, ArrayList<Node>> map = new HashMap<>();
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			ArrayList<Node> list1 = map.getOrDefault(u, new ArrayList<>());
			list1.add(new Node(v));
			map.put(u, list1);
			ArrayList<Node> list2 = map.getOrDefault(v, new ArrayList<>());
			list2.add(new Node(u));
			map.put(v, list2);
		}
		
		Queue<Node> queue = new LinkedList<>();
		Node root = new Node(1);
		queue.add(root);
		
		boolean[] visited = new boolean[N + 1];
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			
			//ArrayList<Node> list = map.get(node.value);
			ArrayList<Node> list = map.getOrDefault(node.value, new ArrayList<>());
			visited[node.value] = true;
			
			for (int i = 0; i < list.size(); i++) {
				if (visited[list.get(i).value] != true) {
					node.children.add(list.get(i));
					queue.add(list.get(i));
				}
			}	
		}
		
		root.water = W;
		queue.add(root);
		double answer = 0.0;
		int count = 0;
		
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int size = node.children.size();
			
			if (size == 0 && node.water > 0) {
				answer += node.water;
				count++;
				continue;
			}
			
			for (int i = 0; i < size; i++) {
				node.children.get(i).water = node.water / (double)size;
				queue.add(node.children.get(i));
			}
		}
		
		System.out.println(answer / count);
	}

}
