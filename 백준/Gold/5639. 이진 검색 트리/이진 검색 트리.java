import java.util.*;
import java.io.*;

public class Main {
	
	private static ArrayList<Integer> list;
	private static Stack<Integer> answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		answer = new Stack<>();
		
		String str = br.readLine();
		do {			
			int num = Integer.parseInt(str);
			list.add(num);
			str = br.readLine();
		} while(str != null && !str.equals(""));
		
		postorder(0, list.size() - 1);
		
		while (!answer.isEmpty())
			System.out.println(answer.pop());
	}
	
	public static void postorder(int s, int e) {
		if (s < 0 || s >= list.size() || e < 0 || e >= list.size() || s > e)
			return;
		
		answer.push(list.get(s));
		
		if (s == e)
			return;
		
		int index = list.size();
		for (int i = s + 1; i < list.size(); i++) {
			if (list.get(i) > list.get(s)) {
				index = i;
				break;
			}
		}
		
		postorder(index, e); //R
		postorder(s + 1, index - 1); //L
	}
	
}
