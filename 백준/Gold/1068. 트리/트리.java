import java.util.*;

public class Main {
	private static ArrayList<Node> list;
	
	public static class Node {
		int index;
		int parent;
		boolean isLeaf;
		
		Node(int index, int parent) {
			this.index = index;
			this.parent = parent;
			this.isLeaf = true;
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			list.add(new Node(i, -1));	
		}
		
		for (int i = 0; i < N; i++) {
			int parent = scanner.nextInt();
			list.get(i).parent = parent;
			if (parent != -1)
				list.get(parent).isLeaf = false;
		}
		
		int deleted = scanner.nextInt();
		list.get(deleted).isLeaf = false;
		int p = list.get(deleted).parent;
		if (p != -1) {
			list.get(p).isLeaf = true;
			
			for (int i = 0; i < N; i++) {
				if (list.get(i).index != deleted && list.get(i).parent == p) {
					list.get(p).isLeaf = false;
					break;
				}
			}
		}
		delete(deleted);
		
		int answer = 0;
		for (int i = 0; i < N; i++) {
			if (list.get(i).isLeaf == true) {
				answer++;
			}
		}
		System.out.println(answer);
	}
	
	public static void delete(int deleted) {
		
		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			if (node.parent == deleted) {
				node.isLeaf = false;
				delete(node.index);
			}
		}
	}

}
